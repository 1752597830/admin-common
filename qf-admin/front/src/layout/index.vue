<template>
    <el-container>
        <!-- 折叠菜单并调整宽度 -->
        <el-aside :width="isCollapse ? '64px' : '210px'">
            <div class="logo" style="width='iscollapse'?'64px': '210px'">
                <img src="../assets/Code.svg" style="width: 30px;height: 30px;" />
                <span v-show="!isCollapse">&nbsp;&nbsp;清风漫笔</span>
            </div>
            <el-scrollbar>
                <el-menu
                    :unique-opened="true"
                    background-color="#001529"
                    text-color="rgba(255,255,255,0.65)"
                    :collapse="isCollapse"
                    :collapse-transition="false"
                    :default-active="currRoute.path"
                    :router="true"
                >
                    <my-menu
                        v-for="(item, index) in permissionStore.routes"
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
        <el-container style="background-color: #f2f3f5">
            <el-header>
                <Header />
            </el-header>
            <el-main style="margin: 10px; background-color: white">
                <RouterView />
            </el-main>
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
}
.header {
    flex-direction: row;
    height: 50px;
    margin-top: 10px;
}
/* 固定logo,只滑动menu */
.el-scrollbar {
    height: calc(100vh - 108px);
    box-shadow: 0 0 6px -2px var(--el-color-primary);
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
</style>
