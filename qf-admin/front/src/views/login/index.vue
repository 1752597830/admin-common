<template>
    <el-row style="min-height: 100vh;background-color: #509eee;">
        <el-col :lg="16" :md="12" class="my-center">
            <div style="font-size: 30px;font-weight: 900;">
                欢迎访问清风管理后台
            </div>

        </el-col>
        <el-col :lg="8" :md="12" class="my-center" style="background-color: white;">
            <div style="width: 64%">
                <div class="my-center" style="flex-direction: row;">
                    <h2>qf-admin</h2>
                    <div style="padding-left: 10px">
                        <el-tag>1.0</el-tag>
                    </div>
                </div>
                <el-form ref="loginFormRef" :model="loginData" :rules="loginRules">
                    <el-form-item prop="username">
                        <el-input ref="username" v-model="loginData.username" class="flex-1" size="large"
                            placeholder="用户名" name="username">
                            <template #prefix>
                                <el-icon>
                                    <i-ep-user />
                                </el-icon>
                            </template>
                        </el-input>
                    </el-form-item>

                    <el-tooltip :disabled="isCapslock === false" content="大写锁定处于开启状态" placement="right">
                        <el-form-item prop="password">
                            <el-input v-model="loginData.password" placeholder="密码" :type="passwordVisible === false
                                ? 'password'
                                : 'input'
                                " size="large" name="password" @keyup="checkCapslock" @keyup.enter="handleLogin">
                                <template #prefix>
                                    <el-icon>
                                        <i-ep-lock />
                                    </el-icon>
                                </template>
                                <template #suffix>
                                    <div @click="closeaaa">
                                        <svg-icon v-show="!passwordVisible" icon-class="eye" />
                                        <svg-icon v-show="passwordVisible" icon-class="eye-open" />
                                    </div>
                                </template>
                            </el-input>
                        </el-form-item>
                    </el-tooltip>

                    <!-- 验证码 -->
                    <el-form-item prop="captchaCode">
                        <el-input v-model="loginData.captchaCode" auto-complete="off" placeholder="验证码"
                            @keyup.enter="handleLogin">
                            <template #prefix>
                                <el-icon>
                                    <svg-icon icon-class="captcha" />
                                </el-icon>
                            </template>
                            <template #suffix>
                                <el-image :src="captchaBase64" @click="getCaptcha" class="w-[100px] h-[40px]">
                                    <template #error>
                                        <el-icon size="20">
                                            <i-ep-picture />
                                        </el-icon>
                                    </template>
                                </el-image>
                            </template>
                        </el-input>
                    </el-form-item>
                    <el-button style="width: 100%" :loading="loading" type="primary" @click.prevent="handleLogin">登录
                    </el-button>
                </el-form>
            </div>
        </el-col>
    </el-row>

</template>
<script setup lang="ts">
import { ref } from "vue";
import router from "@/router";

// 状态管理依赖
import { useUserStore } from "@/store/modules/user";

// API依赖
import { LocationQuery, LocationQueryValue, useRoute } from "vue-router";
import { getCaptchaApi } from "@/api/auth";
import { LoginData } from "@/api/auth/types";

const loading = ref(false); // 按钮loading
const isCapslock = ref(false); // 是否大写锁定
const passwordVisible = ref(false); // 密码是否可见
const captchaBase64 = ref(); // 验证码图片Base64字符串
const loginFormRef = ref(ElForm); // 登录表单ref
const loginData = ref<LoginData>({
    username: "admin",
    password: "123456",
});
function closeaaa() {
    console.log("点击率研究啊实打实");
    passwordVisible.value = !passwordVisible.value;
}
const loginRules = computed(() => {
    const prefix = "请输入";
    return {
        username: [
            {
                required: true,
                trigger: "blur",
                message: `${prefix}用户名`,
            },
        ],
        password: [
            {
                required: true,
                trigger: "blur",
                validator: (rule: any, value: any, callback: any) => {
                    if (value.length < 6) {
                        callback(new Error("密码长度不少于6位"));
                    } else {
                        callback();
                    }
                },
                message: `${prefix}密码`,
            },
        ],
        captchaCode: [
            {
                required: true,
                trigger: "blur",
                message: `${prefix}验证码`,
            },
        ],
    };
});

/**
 * 检查输入大小写状态
 */
function checkCapslock(e: any) {
    const { key } = e;
    isCapslock.value = key && key.length === 1 && key >= "A" && key <= "Z";
}

/**
 * 获取验证码
 */
function getCaptcha() {
    getCaptchaApi().then(({ data }) => {
        loginData.value.captchaKey = data.captchaKey;
        captchaBase64.value = data.captchaBase64;
    });
}

/**
 * 登录
 */
const route = useRoute();
const userStore = useUserStore();
function handleLogin() {
    loginFormRef.value.validate((valid: boolean) => {
        if (valid) {
            loading.value = true;
            userStore
                .login(loginData.value)
                .then(() => {
                    const query: LocationQuery = route.query;

                    const redirect =
                        (query.redirect as LocationQueryValue) ?? "/";

                    const otherQueryParams = Object.keys(query).reduce(
                        (acc: any, cur: string) => {
                            if (cur !== "redirect") {
                                acc[cur] = query[cur];
                            }
                            return acc;
                        },
                        {}
                    );

                    router.push({ path: redirect, query: otherQueryParams });
                })
                .catch(() => {
                    // 验证失败，重新生成验证码
                    getCaptcha();
                })
                .finally(() => {
                    loading.value = false;
                });
        }
    });
}
onMounted(() => {
    // 获取验证码
    getCaptcha();
});
</script>
<style lang="scss" scoped>
.el-input {
    height: 50px;
}

.my-center {
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
