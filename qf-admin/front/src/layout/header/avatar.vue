<template>
    <!-- 用户头像 -->
    <el-dropdown trigger="click">
        <div class="avatar-container">
            <img :src="userStore.user.avatar + '?imageView2/1/w/80/h/80'" />
            <i-ep-caret-bottom class="w-3 h-3" />
        </div>
        <template #dropdown>
            <el-dropdown-menu>
                <router-link to="/">
                    <el-dropdown-item>首页</el-dropdown-item>
                </router-link>
                <router-link to="/userCenter">
                    <el-dropdown-item>个人中心</el-dropdown-item>
                </router-link>
                <a target="_blank" href="https://github.com/1752597830">
                    <el-dropdown-item>Github</el-dropdown-item>
                </a>
                <el-dropdown-item divided @click="logout">
                    注销
                </el-dropdown-item>
            </el-dropdown-menu>
        </template>
    </el-dropdown>
</template>

<script setup lang="ts">
import { useUserStore } from "@/store/modules/user";
import { ElMessageBox } from "element-plus";
import { useRoute, useRouter } from "vue-router";
const userStore = useUserStore();

const route = useRoute();
const router = useRouter();
/**
 * 注销
 */
function logout() {
    ElMessageBox.confirm("确定注销并退出系统吗？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
    }).then(() => {
        userStore.logout().then(() => {
            router.push(`/login?redirect=${route.fullPath}`);
        });
    });
}
</script>

<style lang="scss" scoped>
.avatar-container {
    display: flex;
    place-items: center center;
    margin: 0 5px;
    cursor: pointer;

    img {
        width: 40px;
        height: 40px;
        border-radius: 5px;
    }
}
/* 去掉a标签以及router-link下划线 */
a {
    text-decoration: none;
}

.router-link-active {
    text-decoration: none;
}
</style>
