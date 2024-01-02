import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";

export const Layout = () => import("@/layout/index.vue");

// 静态路由
export const constantRoutes: RouteRecordRaw[] = [
    {
        path: "/redirect",
        component: Layout,
        meta: { hidden: true },
        children: [
            {
                path: "/redirect/:path(.*)",
                component: () => import("@/views/redirect/index.vue")
            },
        ],
    },

    {
        path: "/login",
        component: () => import("@/views/login/index.vue"),
        meta: { hidden: true },
    },

    {
        path: "/",
        name: "/",
        component: Layout,
        redirect: "/dashboard",
        meta: { hidden: true },
        children: [
            {
                path: "dashboard",
                component: () => import("@/views/index.vue"),
                name: "Dashboard", // 用于 keep-alive, 必须与SFC自动推导或者显示声明的组件name一致
                // https://cn.vuejs.org/guide/built-ins/keep-alive.html#include-exclude
                meta: {
                    title: "首页",
                    icon: "homepage",
                    affix: true,   // 是否显示关闭
                    keepAlive: true
                },
            }, {
                path: "/userCenter",
                name: "个人中心", 
                component: () => import("@/views/user/index.vue"),
            },
            {
                path: "401",
                component: () => import("@/views/error/401.vue"),
            },
            {
                path: "404",
                component: () => import("@/views/error/404.vue"),
            }
        ],
    }
];

/**
 * 创建路由
 */
const router = createRouter({
    history: createWebHistory(),
    routes: constantRoutes as RouteRecordRaw[],
    // 刷新时，滚动条位置还原
    scrollBehavior: () => ({ left: 0, top: 0 }),
});

/**
 * 重置路由
 */
export function resetRouter() {
    router.replace({ path: "/login" });
}

export default router;
