import { defineConfig } from "vite";
import AutoImport from "unplugin-auto-import/vite";
import Components from "unplugin-vue-components/vite";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";
import vue from "@vitejs/plugin-vue";
import Icons from 'unplugin-icons/vite'
import IconsResolver from 'unplugin-icons/resolver'
import path from 'path'
// https://vitejs.dev/config/
export default defineConfig({
    server: {
        cors: true,
        open: true,
        host: '0.0.0.0',
        port: 5555,
        proxy: {
            '/api': {
                target: 'http://127.0.0.1:8082',   //代理接口
                changeOrigin: true,
                ws: false,
                rewrite: (path) => path.replace(/^\/api/, '')
            }
        }
    },
    resolve: {
        // 配置路径别名
        alias: [
            // @代替src
            {
                find: '@',
                replacement: path.resolve('./src'),
            },
        ],
    },
    plugins: [
        vue(),
        AutoImport({
            resolvers: [
                ElementPlusResolver(),
                // 自动导入图标组件
                IconsResolver({
                    prefix: 'Icon',
                }),],
            imports: ['vue', 'vue-router'],
        }),
        Components({
            resolvers: [ElementPlusResolver(),// 自动注册图标组件
            IconsResolver({
                enabledCollections: ['ep'],
            }),],
        }),
        Icons({
            autoInstall: true,
        }),
    ],
})