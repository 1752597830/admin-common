import { useUserStoreHook } from '@/store/modules/user';
import axios, { InternalAxiosRequestConfig, AxiosResponse } from 'axios'
import { ElMessage, ElMessageBox } from 'element-plus'
// 创建axios实例
const service = axios.create({
    // axios中请求配置有baseURL选项，表示请求URL公共部分
    baseURL: '/api/v1',
    // 超时
    timeout: 50000,
    headers: { "Content-Type": "application/json;charset=utf-8" },
})
// 请求拦截器
service.interceptors.request.use(
    (config: InternalAxiosRequestConfig) => {
        const userStore = useUserStoreHook();
        console.log("userStore: ", config)
        if (userStore.token) {
            config.headers.Authorization = userStore.token;
        }
        return config;
    },
    (error: any) => {
        return Promise.reject(error);
    }
);
// 响应拦截器
service.interceptors.response.use(
    (response: AxiosResponse) => {
        const { code, msg } = response.data;
        if (code === 200) {
            return response.data;
        }
        // 响应数据为二进制流处理(Excel导出)
        if (response.data instanceof ArrayBuffer) {
            return response;
        }

        ElMessage.error(msg || "系统出错");
        return Promise.reject(new Error(msg || "Error"));
    },
    (error: any) => {
        if (error.response.data) {
            const { code, msg } = error.response.data;
            // token 过期,重新登录
            if (code === 40001) {
                ElMessageBox.confirm("当前页面已失效，请重新登录", "提示", {
                    confirmButtonText: "确定",
                    type: "warning",
                }).then(() => {
                    const userStore = useUserStoreHook();
                    userStore.resetToken().then(() => {
                        location.reload();
                    });
                });
            } else {
                ElMessage.error(msg || "系统出错");
            }
        }
        return Promise.reject(error.message);
    }
);
export default service