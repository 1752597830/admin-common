<template>
    <el-container>
        <!-- 折叠菜单并调整宽度 -->
        <el-aside :width="isCollapse ? '64px' : '210px'">
            <div class="logo" style="width='iscollapse'?'64px': '210px'">
                <img
                    src="../assets/Code.svg"
                    style="width: 30px; height: 30px"
                />
                <span v-show="!isCollapse">&nbsp;&nbsp;清风漫笔</span>
            </div>
            <el-scrollbar :style="isCollapse ? 'padding: 10px 0 10px 0' : 'padding: 10px;'" >
                <el-menu
                    :unique-opened="true"
                    background-color="#001529"
                    text-color="rgba(255,255,255,0.65)"
                    :collapse="isCollapse"
                    :collapse-transition="false"
                    :default-active="currRoute.path"
                    :router="true"
                >
                    <el-menu-item key="/dashboard" index="/dashboard">
                        <el-icon>
                            <i-ep-house />
                        </el-icon>
                        <!-- 文字过长，显示省略号，鼠标悬停显示全文 -->
                        <span>首页</span>
                    </el-menu-item>
                    <my-menu
                        v-for="item in permissionStore.routes"
                        :data="item"
                    ></my-menu>
                </el-menu>
            </el-scrollbar>
            <div class="container">
                <div @click="expond" style="padding-left: 20px">
                    <img
                        v-show="isCollapse"
                        src="../assets/unfold.svg"
                        class="image"
                    />
                    <img
                        v-show="!isCollapse"
                        src="../assets/fold.svg"
                        class="image"
                    />
                </div>
            </div>
        </el-aside>
        <el-container style="background-color: #f2f3f5;">
            <el-header>
                <Header />
            </el-header>
            <el-scrollbar  class="container-scrollbar">
                <el-main style="background-color: white">
                    <RouterView />
                </el-main>
            </el-scrollbar>
        </el-container>
    </el-container>
</template>
<script setup lang="ts">
import { ref } from "vue";
import { usePermissionStore } from "@/store/modules/permission";
import Header from "./header/header.vue";
// 获取url上当前的路由信息
const currRoute = useRoute();
const isCollapse = ref(false);
const permissionStore = usePermissionStore();
console.log(permissionStore.routes);
import MyMenu from "./aside/menus.vue";
function expond() {
    isCollapse.value = !isCollapse.value;
}
</script>
<style scoped>
.logo {
    height: 58px;
    background-color: #002140;
    color: white;
    align-items: center;
    justify-content: center;
    display: flex;
    margin-bottom: 3px;
}
.header {
    flex-direction: row;
    height: 50px;
    margin-top: 10px;
}
/* 固定logo,只滑动menu */

.el-scrollbar {
    height: calc(100vh - 131px);
    box-shadow: 0 0 6px -2px var(--el-color-primary);
}
.container-scrollbar {
    height: calc(100vh - 112px);
    box-shadow: 0 0 0 0 var(--el-color-primary);
    padding: 10px 10px 0 10px;
}
.el-aside {
    background-color: #001529;
    /* 折叠动画淡出淡入效果 */
    transition: width 0.3s;
    -webkit-transition: width 0.3s;
    -moz-transition: width 0.3s;
    -webkit-transition: width 0.3s;
    -o-transition: width 0.3s;
    border-top-left-radius: 14px;
    padding-bottom: 50px;
    /*
    当选择一级菜单时，子菜单项右侧边有点对不齐的现象
    */
    .el-menu {
        border-right: none;
    }
}
.el-header {
    padding: 0;
    height: auto;
    background-color: white;
}
/*
去掉el-menu的滚动条
*/
.el-aside::-webkit-scrollbar {
    display: none;
}
.container {
    bottom: 0;
    height: 40px;
    line-height: 40px;
    position: absolute;
    .image {
        width: 26px;
        height: 26px;
    }
}
/* .el-container is-vertical {
    padding-bottom: 0 !important;
} */
/*
设置item高度
*/
.el-menu-item {
    height: 40px !important;
    line-height: 40px !important;
}
/*
设置菜单处背景色
*/
.el-menu--inline .el-menu-item {
    background-color: #000c17 !important;
}
.el-menu-item .el-icon {
    /* 选中背景色图标两边加间距 */
    margin-left: 4px;
    margin-right: 4px;
}
/* 父菜单鼠标悬浮颜色设置 */
:deep(.el-sub-menu__title:hover) {
    color: #fff !important;
    font-weight: bold;
}

/*
子菜单鼠标悬浮颜色设置
*/
.el-menu .el-menu-item:hover {
    color: #fff;
    font-weight: bold;
}
/*
设置选中背景色和字体颜色
*/
.el-menu-item.is-active {
    background-color: #40a9ff !important;
    border-radius: 5px !important;
    /* 选中背景色图标两边加间距 */
    margin-left: 4px;
    margin-right: 4px;
    color: #fff;
}
/* 修改选中菜单背景色图标左间距 */
.el-menu-item.is-active .el-icon {
    margin-left: 0px;
}
.el-sub-menu .el-icon {
    /* 选中背景色图标两边加间距 */
    margin-left: 4px;
    margin-right: 4px;
}
</style>
