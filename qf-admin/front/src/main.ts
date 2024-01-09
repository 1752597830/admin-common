import { createApp } from "vue";
import App from "./App.vue";
import router from "@/router";
import { setupStore } from "@/store";
import './font-style/font.scss';
import './style.css';
import { setupDirective } from '@/directive';
import "@/permission";
// 本地SVG图标
import "virtual:svg-icons-register";
// 解决样式丢失问题
import 'element-plus/theme-chalk/src/message-box.scss';
import 'element-plus/theme-chalk/src/message.scss';

const app = createApp(App);
// 全局注册 自定义指令(directive)
setupDirective(app);
// 全局注册 状态管理(store)
setupStore(app);
app.use(router).mount('#app')