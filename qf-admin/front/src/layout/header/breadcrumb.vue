<template>
    <el-icon :size="20">
        <i-ep-HomeFilled />
    </el-icon>
    &nbsp;
    <el-breadcrumb class="h-[50px] flex items-center">
        <transition-group name="breadcrumb">
            <el-breadcrumb-item
                v-for="(item, index) in breadcrumbs"
                :key="item.path"
            >
                <span
                    v-if="
                        item.redirect === 'noredirect' ||
                        index === breadcrumbs.length - 1
                    "
                    class="text-[var(--el-disabled-text-color)]"
                    >{{ item.meta.title }}</span
                >
                <a v-else @click.prevent="handleLink(item)">
                    {{ item.meta.title }}
                </a>
            </el-breadcrumb-item>
        </transition-group>
    </el-breadcrumb>
</template>
<script setup lang="ts">
import { onBeforeMount, ref, watch } from "vue";
import { useRoute, RouteLocationMatched } from "vue-router";
//一个对URL进行解析的模块，支持正则表达式验证、匹配、反向解析，可用于增加 koa 框架对于 koa-router 对 path 的解析工作。
import { compile } from "path-to-regexp";
import router from "@/router";
const currentRoute = useRoute();
const pathCompile = (path: string) => {
    const { params } = currentRoute;
    const toPath = compile(path);
    return toPath(params);
};

const breadcrumbs = ref([] as Array<RouteLocationMatched>);
function isDashboard(route: RouteLocationMatched) {
    const name = route && route.name;
    if (!name) {
        return false;
    }
    return (
        name.toString().trim().toLocaleLowerCase() ===
        "Dashboard".toLocaleLowerCase()
    );
}
function getBreadcrumb() {
    let matched = currentRoute.matched.filter(
        (item) => item.meta && item.meta.title
    );
    const first = matched[0];
    if (!isDashboard(first)) {
        matched = [
            { path: "/", meta: { title: "首页" } } as any,
        ].concat(matched);
    }
    breadcrumbs.value = matched.filter((item) => {
        return item.meta && item.meta.title && item.meta.breadcrumb !== false;
    });
}
function handleLink(item: any) {
    const { redirect, path } = item;
    if (redirect) {
        router.push(redirect).catch((err) => {
            console.warn(err);
        });
        return;
    }
    router.push(pathCompile(path)).catch((err) => {
        console.warn(err);
    });
}
watch(
    () => currentRoute.path,
    (path) => {
        if (path.startsWith("/redirect/")) {
            return;
        }
        getBreadcrumb();
    }
);

onBeforeMount(() => {
    getBreadcrumb();
});
</script>

<style lang="scss" scoped>
.root {
    color: #666;
    font-weight: 600;
}
</style>
