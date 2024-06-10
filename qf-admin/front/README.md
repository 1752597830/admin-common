## 目前已经实现的功能

node版本 18+
基于前后端分离的后台管理平台
登录
动态路由
左侧动态菜单
pinia存储
头像
引入图标的方式
```vue
<el-icon :size="20">
    <i-ep-setting />
</el-icon>
```
引入svg方式 插槽方式
```vue
<template #suffix>
    <div @click="closeaaa">
        <svg-icon v-show="!passwordVisible" icon-class="eye" />
        <svg-icon v-show="passwordVisible" icon-class="eye-open" />
    </div>
</template>
```
div快速靠边布局
margin:0px 10px 0px auto;