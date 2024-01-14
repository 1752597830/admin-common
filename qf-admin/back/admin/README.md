vo: 返回数据给前端
dto: 从前端获取数据
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
