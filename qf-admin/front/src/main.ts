import { createApp } from 'vue'
import { setupStore } from "@/store";
import './font-style/font.scss';
import './style.css'
import App from './App.vue'
import router from './router';
import "@/permission";
// 解决样式丢失问题
import 'element-plus/theme-chalk/src/message-box.scss';
import 'element-plus/theme-chalk/src/message.scss';
const app = createApp(App);
setupStore(app);
app.use(router).mount('#app')