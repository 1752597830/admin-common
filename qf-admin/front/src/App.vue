<script setup lang="ts">
import { ElConfigProvider } from "element-plus";
import zhCn from "element-plus/es/locale/lang/zh-cn";
let locale = zhCn;
</script>
<template>
    <ElConfigProvider :locale="locale">
        <router-view></router-view>
    </ElConfigProvider>
</template>
<style scoped></style>
