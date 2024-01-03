<template>
    <el-row :gutter="12">
        <el-col :span="10">
            <el-card shadow="always">
                <template #header>
                    <div class="card-header">
                        <span>个人信息</span>
                    </div>
                </template>
                <div>
                    <div
                        style="
                            display: flex;
                            justify-content: center;
                            margin-bottom: 30px;
                        "
                    >
                        <img
                            class="img"
                            :src="
                                userStore.user.avatar +
                                '?imageView2/1/w/80/h/80'
                            "
                        />
                    </div>
                    <div
                        class="card-context"
                        style="border-top: 1px solid #d0dae2"
                    >
                        用户昵称:&nbsp;&nbsp;
                        <span class="card-text">
                            {{ userStore.user.nickname }}
                        </span>
                    </div>
                    <div class="card-context">
                        手机号码:&nbsp;&nbsp;
                        <span class="card-text">
                            {{ userStore.user.mobile }}
                        </span>
                    </div>
                    <div class="card-context">
                        用户邮箱:&nbsp;&nbsp;
                        <span class="card-text">
                            {{ userStore.user.email }}
                        </span>
                    </div>
                    <div class="card-context">
                        创建日期:&nbsp;&nbsp;
                        <span class="card-text">{{
                            userStore.user.createTime
                        }}</span>
                    </div>
                    <div class="card-context">
                        个人简介:&nbsp;&nbsp;
                        <span class="card-text"
                            >请问十大十大权威阿三大苏打撒旦请问大师</span
                        >
                    </div>
                </div>
            </el-card>
        </el-col>
        <el-col :span="14">
            <el-card shadow="always">
                <template #header>
                    <div class="card-header">
                        <span>基本资料</span>
                    </div>
                </template>
                <el-tabs>
                    <el-tab-pane label="基本资料">
                        <el-form
                            label-width="100px"
                            :model="formUserInfo"
                            style="max-width: 460px"
                            :rules="InfoRules"
                        >
                            <el-form-item label="用户id" v-show="false">
                                <el-input
                                    v-model="formUserInfo.userId"
                                    ref="userId"
                                    placeholder="用户id"
                                />
                            </el-form-item>
                            <el-form-item label="用户昵称:" prop="nickname">
                                <el-input v-model="formUserInfo.nickname" />
                            </el-form-item>
                            <el-form-item label="手机号:" prop="mobile">
                                <el-input v-model="formUserInfo.mobile" />
                            </el-form-item>
                            <el-form-item label="邮箱:" prop="email">
                                <el-input v-model="formUserInfo.email" />
                            </el-form-item>
                        </el-form>
                    </el-tab-pane>
                    <el-tab-pane label="修改密码"> 密码修改 </el-tab-pane>
                </el-tabs>
            </el-card>
        </el-col>
    </el-row>
</template>
<script setup lang="ts">
import { UserInfoForm } from "@/api/user/types";
import { useUserStore } from "@/store/modules/user";
const userStore = useUserStore();
console.log("userStore.userStore: ", userStore.user);
const formUserInfo = ref<UserInfoForm>({
    nickname: userStore.user.nickname,
    mobile: userStore.user.mobile,
    email: userStore.user.email,
});
const validate_email = (rule, value, callback) => {
    var emailRegExp = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
    var emailRegExp1 =
        /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    if (
        (!emailRegExp.test(value) && value != "") ||
        (!emailRegExp1.test(value) && value != "")
    ) {
        callback(new Error("请输入有效邮箱格式！"));
    } else {
        callback();
    }
};
const InfoRules = computed(() => {
    const prefix = "请输入";
    return {
        nickname: [
            {
                required: true,
                trigger: "blur",
                message: `${prefix}你的用户名`,
            },
        ],
        mobile: [
            { required: true, message: `${prefix}你的手机号`, trigger: "blur" },
            {
                pattern: /^1[3456789]\d{9}$/,
                message: "手机号码格式不正确",
                trigger: "blur",
            },
        ],
        email: [
            { required: true, message: "请输入你的邮箱", trigger: "blur" },
            {
                validator: validate_email,
                min: 9,
                max: 18,
                message: "邮箱格式错误",
                trigger: "blur",
            },
        ],
    };
});
</script>
<style lang="scss" scoped>
.card-header {
    font-size: 12px;
    height: 10px;
    font-weight: bold;
}
.img {
    width: 80px;
    height: 80px;
    border-radius: 50%;
}
.card-context {
    font-size: 14px;
    height: 40px;
    font-weight: bold;
    border-bottom: 1px solid #d0dae2;
    display: flex;
    align-items: center;
}
.card-text {
    font-size: 14px;
    padding-left: 20px;
    font-weight: normal;
}
::v-deep .el-form-item__label {
    font-size: 14px;
    font-weight: bold;
}
</style>
