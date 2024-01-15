vo: 返回数据给前端
dto: 从前端获取数据
# Spring Security + vue3 前后端分离项目
后端：
> 采用技术栈: Spring Security + SpringBoot + JWT + MybatisPlus + MybatisX + Redis 
## Spring Security前后端分离自定义登录
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
+ UserForm(获取用户信息响应对象)
