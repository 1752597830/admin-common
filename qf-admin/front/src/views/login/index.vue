<template>
    <div class="login-container">
        <!-- 登录表单 -->
        <el-card>
            <div>
                <h2>qf-admin</h2>
                <el-tag>1.0</el-tag>
            </div>
            <el-form ref="loginFormRef" :model="loginData" :rules="loginRules">
                <el-form-item prop="username">
                    <div>
                        <svg-icon />
                    </div>
                    <el-input
                        ref="username"
                        v-model="loginData.username"
                        size="large"
                        placeholder="用户名"
                        name="username"
                    />
                </el-form-item>

                <el-tooltip
                    :disabled="isCapslock === false"
                    content="大写锁定处于开启状态"
                    placement="right"
                >
                    <el-form-item prop="password">
                        <span>
                            <svg-icon />
                        </span>
                        <el-input
                            v-model="loginData.password"
                            class="flex-1"
                            placeholder="密码"
                            :type="
                                passwordVisible === false ? 'password' : 'input'
                            "
                            size="large"
                            name="password"
                            @keyup="checkCapslock"
                            @keyup.enter="handleLogin"
                        />
                        <span
                            class="mr-2"
                            @click="passwordVisible = !passwordVisible"
                        >
                            <svg-icon
                                :icon-class="
                                    passwordVisible === false
                                        ? 'eye'
                                        : 'eye-open'
                                "
                            />
                        </span>
                    </el-form-item>
                </el-tooltip>

                <!-- 验证码 -->
                <el-form-item prop="captchaCode">
                    <span>
                        <svg-icon />
                    </span>

                    <el-input
                        v-model="loginData.captchaCode"
                        auto-complete="off"
                        placeholder="验证码"
                        @keyup.enter="handleLogin"
                    />

                    <div class="captcha">
                        <el-image :src="captchaBase64" @click="getCaptcha">
                            <template #error>
                                <div>
                                    <i-ep-picture />
                                </div>
                            </template>
                        </el-image>
                    </div>
                </el-form-item>

                <el-button
                    :loading="loading"
                    type="primary"
                    @click.prevent="handleLogin"
                    >登录
                </el-button>
            </el-form>
        </el-card>
    </div>
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
<style lang="scss" scoped></style>
