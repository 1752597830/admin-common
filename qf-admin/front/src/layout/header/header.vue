<template>
    <div>
        <div class="navbar">
            <Breadcrumb />
            <div class="navbar-right">
                <Avatar />
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
    height: 50px;
    overflow: hidden;
    display: flex;
    align-items: center;
    box-sizing: border-box;
    position: relative;
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
