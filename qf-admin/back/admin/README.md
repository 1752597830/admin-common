vo: 返回数据给前端
dto: 从前端获取数据
> 如果多个修改或删除操作构成一个逻辑上的完整工作单元，它们必须保证原子性（即要么全部成功，要么全部失败）。在这种情况下，如果其中一个操作失败导致数据不一致，则整个事务应通过回滚恢复到事务开始前的状态。
# Spring Security + vue3 前后端分离项目
+ api接口: https://apifox.com/apidoc/shared-2963bc24-5f7a-47e4-a099-97f93c632282
后端：
> 采用技术栈: Spring Security + SpringBoot + JWT + MybatisPlus + MybatisX + Redis 
# Spring Security前后端分离自定义登录
### 初始化项目
+ 创建项目
+ 配置maven
+ 编写工具类(BaseResponse响应类，封装了响应成功和失败。ResponseCode状态码枚举。ServletUtils 封装了响应流处理数据)
+ 抽取出有共同字段的属性 BaseEntity(创建时间、创建人、更新时间、更新人)
+ 配置MySQL
+ 使用MybatisX生成代码
+ 配置MybatisPlus
### 登录
+ 引入相关依赖
+ 配置跨域请求WebMvcConfig
+ 配置SpringSecurity
+ 配置自定义登录成功(LoginSuccessHandler)
+ 配置自定义登录失败(LoginFailureHandler)
### 封装JWT拦截器
+ 引入相关依赖
+ 在application.yml中配置token信息 方便管理
+ 封装JWT拦截器 JwtAuthenticationTokenFilter
+ 封装JWT工具类 JwtUtil 生成和解析token
+ 自定义JwtAuthentication用于解析token中获取到的用户信息 (Authentication及其实现类的大部分属性没有提供setter方法)
+ 添加拦截器到SpringSecurity配置类中，拦截器拦截到请求，判断是否登录，未登录则拦截，登录则放行(放在UsernamePasswordAuthenticationFilter前面)
### 验证码拦截器
+ 引入相关依赖
+ 封装验证码生成工具(放在通用工具类中)
+ 封装常量池存放验证码需要的数据(位数、长度、宽度)
+ 封装验证码拦截器 VerifyCodeFilter
+ 添加拦截器到SpringSecurity配置类中，拦截器拦截到请求，判断是否登录，未登录则拦截，登录则放行(放在UsernamePasswordAuthenticationFilter前面)
### 配置Redis
+ 引入相关依赖
+ 配置端口等信息
+ 自定义Redis配置类
+ 封装RedisCache
### 异常处理
+ BaseException 自定义异常类
+ globalException 全局异常处理类
+ NoAuthenticationEntryPoint Security异常处理类
## 用户接口
### 获取用户信息
+ 根据之前登录存放在Spring Security中的用户信息来获取
+ 封装SecurityUtils工具类来实现用户信息和权限的获取
+ 封装返回对象Vo
> 需要授权操作才能访问 自定义处理时需要实现权限校验
### Spring Security权限
+ 通过拦截器方式动态封装权限校验 MyauthorizationManager
+ 在config配置中添加权限校验
### 新增用户
+ UserForm表单获取数据
+ 插入时使用事务进行处理(@Transactional)，防止数据插入失败
+ 用自定义异常进行处理插入失败的状态 
> 封装增删改异常或失败处理
+ ToolUtils中自定义处理方法isOk
+ 判断结构抛出异常，全局捕获处理
### 获取当前用户信息
+ 封装UserInfoVo(获取用户信息响应对象)
+ 解析Security中存储的数据 封装SecurityUtils获取登录时存储的用户信息
### 修改用户
+ UserForm表单获取数据
+ 修改时使用事务进行处理(@Transactional)，防止数据修改失败
+ 判断结构抛出异常，全局捕获处理
```java
public class UserForm {
    @Schema(description = "用户账号")
    private String username;

    @Schema(description = "用户昵称")
    private String nickname;

    @Schema(description = "用户邮箱")
    private String email;

    @Schema(description = "用户手机号")
    private String mobile;

    @Schema(description = "用户性别")
    private Integer gender;

    @Schema(description = "用户头像")
    private String avatar;

    @Schema(description="用户状态(0:正常;1:禁用)")
    private Integer status;

    @Schema(description = "角色ID集合")
    @NotEmpty(message = "用户角色不能为空")
    private List<Long> roleIds;
}
```
### 删除用户
+ 根据uid删除用户
+ 进行逻辑删除 修改字段is_deleted为1
### 分页用户
+ 封装分页对象 UserPageVo
+ BaseController中获取分页的pageSize和pageNum,封装PageHelp的startPage方法
+ 分页查询用户信息
### 重置用户密码
+ 根据用户id重置用户密码
+ 修改时使用事务进行处理(@Transactional)，防止数据修改失败
### 根据uid获取用户信息
+ UserForm(获取用户信息响应对象,见上面UserForm)
### 修改密码
+ 封装修改密码对象
+ 修改密码时使用事务进行处理(@Transactional)，防止数据修改失败
+ 修改密码时需要验证旧密码是否正确

> 上述修改操作后需要更新用户信息
## 菜单接口
### 获取路由
+ 封装路由对象RouteVo
+ 根据用户uid获取路由
+ 路由对象通过menu表,role表,role_menu表,user_role表,user表关联构建
```java
public class RouteVo {
    /**
     * id
     */
    private Long id;
    /**
     * 封装路径信息的类
     */
    private String path; // 路径

    /**
     * 组件信息
     */
    private String component; // 组件

    /**
     * 重定向信息
     */
    private String redirect; // 重定向

    /**
     * 名称信息
     */
    private String name; // 名称

    @Data
    @ToString
    @AllArgsConstructor
    public static class Meta {

        // 标题
        @Schema(description = "路由名称")
        private String title;

        // 图标
        @Schema(description = "路由图标")
        private String icon;

        // 是否隐藏
        @Schema(description = "是否隐藏")
        private boolean hidden;

        // 用户角色列表
        @Schema(description = "用户角色列表")
        private List<String> roles;

        // 是否保持常驻
        @Schema(description = "是否保持常驻")
        private boolean keepAlive;
    }

    @Schema(description = "路由元数据")
    private Meta meta;

    // 子路由
    @Schema(description = "子路由")
    private List<RouteVo> children;
}
```
### 获取下拉菜单
+ 封装权限树MenuOptionsVo
```java
@Schema(description ="菜单下拉选项响应对象")
public class MenuOptionsVo {
    /**
     * 选项值
     */
    private Long value;

    /**
     * 选项名称
     */
    private String label;

    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<MenuOptionsVo> children;
}
```
+ 获取菜单树
```java
public class MenuTreeVo {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "父级id")
    private Long parentId;

    @Schema(description = "菜单名称")
    private String name;

    @Schema(description = "菜单类型")
    private String type;

    @Schema(description = "菜单路径")
    private String path;

    @Schema(description = "菜单组件")
    private String component;

    @Schema(description = "菜单图标")
    private String icon;

    @Schema(description = "菜单排序")
    private Integer sort;

    @Schema(description = "菜单状态：0-隐藏，1-显示")
    private Integer visible;

    @Schema(description = "菜单权限")
    // sys:user:add
    private String perm;

    @Schema(description = "重定向")
    private String redirect;

    @Schema(description = "子菜单")
    private List<MenuTreeVo> children;
}
```
## 角色接口
### 获取角色分页列表
+ 继承BaseController, 获取分页的pageSize和pageNum,封装PageHelp的startPage方法
+ 封装角色分页请求对象 RolePageDto
+ 封装角色分页列表响应对象 RolePageVo
+ 角色对象通过角色表,用户表,用户角色表关联构建
```java
public class RolePageDto {

    @Schema(description = "角色名称")
    private String name;

    @Schema(description = "角色标识,code")
    private String code;

    @Schema(description = "角色状态")
    private Integer status;
}
```
```java
public class RolePageVo {

    @Schema(description = "角色ID")
    private Long id;

    @Schema(description = "角色名称")
    private String name;

    @Schema(description = "角色编码")
    private String code;

    @Schema(description = "显示顺序")
    private Integer sort;

    @Schema(description = "状态：0-正常，1-停用")
    private Integer status;

    @Schema(description = "逻辑删除标识(0-未删除；1-已删除)")
    private Integer deleted;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @Schema(description = "更新时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
}
```
### 获取角色下拉选项表
+ 封装角色下拉选项对象 OptionsVo
### 根据roleId获取角色信息
+ 封装RoleForm响应对象
### 根据roleId获取用户拥有的权限id集合
### 根据roleId修改角色信息
### 根据roleId删除角色信息 
+ (逻辑删除,修改字段is_deleted为1)
### 修改角色权限


```java
@Schema(description ="性别、角色下拉选项响应对象")
public class OptionsVo {

    @Schema(description = "选项值")
    private Long value;

    @Schema(description = "选项名称")
    private String label;
}
```
```java
@Schema(description = "角色表单对象")
@Data
public class RoleForm {

    @Schema(description="角色ID")
    private Long id;

    @Schema(description="角色名称")
    private String name;

    @Schema(description="角色编码")
    private String code;

    @Schema(description="排序")
    private Integer sort;

    @Schema(description="角色状态(1-正常；0-停用)")
    private Integer status;

    @Schema(description = "备注信息")
    private String remark;
}
```

## 动态权限校验
### 实现逻辑
+ 从Security中取出用户信息,获取用户的perms
+ 获取所有的权限集合
+ 判断进入的URL和请求方式是否在权限集合中
+ 若存在则对比获取到的权限与请求中URL以及请求方式来和用户的perms做字符串判断
+ 校验通过

## 缓存监控接口
+ 获取缓存名称
+ 获取指定name下的所有缓存key
+ 获取指定name下的指定key的缓存信息
+ 清除指定name下的所有缓存信息
+ 清除指定key的缓存
+ 清除整个redis的所有缓存

## 服务监控接口
+ CPU信息
+ Mem内存信息
+ File磁盘信息
+ JVM信息

## 字典管理接口
### 根据typeCode获取字典下拉列表
+ 封装响应对象 OptionsVo
### 根据code编码获取字典值分页数据
+ 封装响应对象 DictPageVo
+ 封装请求对象 DictPage(继承分页类)
### 获取所有字典类型列表
+ 封装响应对象 DictTypeVo
### 新增字典类型
### 新增字典类型对应的值
### 修改字典类型
### 修改字典类型对应的值
### 删除字典类型
### 根据code编码删除字典值列表

Swagger部分注解
> @TableField: 数据库对应类映射字段注解(entity包)

> @Schema: 用于类或属性级别，用于定义数据模型或JSON对象结构。它用于描述类的字段，包括字段名、类型、是否必填、默认值、枚举值、格式限制等

> @Operation: 用于方法上的注解