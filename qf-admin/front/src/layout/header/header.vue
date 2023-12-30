<template>
    <div>
        <div style="border-bottom: 1px solid rgb(194, 191, 191);">
            <div class="navbar">
                <!-- 左侧面包屑 -->
                <Breadcrumb />
                <div class="navbar-right">
                    <!-- 头像信息 -->
                    <Avatar />
                </div>
            </div>
        </div>
        <Tag />
    </div>
</template>
<script setup lang="ts">
import Breadcrumb from "./breadcrumb.vue";
import Avatar from "./avatar.vue";
import Tag from "../tag/tag.vue";
</script>
<style lang="scss" scoped>
.navbar {
    width: 100%;
    height: 58px;
    overflow: hidden;
    display: flex;
    align-items: center;
    box-sizing: border-box;
    position: relative;
    padding: 20px;
    .navbar-right {
        flex: 1;
        display: flex;
        align-items: center;
        justify-content: flex-end;
        :deep(.navbar-item) {
            display: inline-block;
            margin-left: 18px;
            font-size: 22px;
            box-sizing: border-box;
            cursor: pointer;
        }
    }
}
</style>
