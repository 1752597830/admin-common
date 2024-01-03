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
                    <div style="display: flex; justify-content: center;margin-bottom: 30px;">
                        <img
                            class="img"
                            :src="
                                userStore.user.avatar +
                                '?imageView2/1/w/80/h/80'
                            "
                        />
                    </div>
                    <div class="card-context" style="border-top: 1px solid #d0dae2;">
                        用户昵称:
                        <span> {{ userStore.user.nickname }} </span>
                    </div>
                    <div class="card-context">
                        <span> 手机号码: </span>
                    </div>
                    <div class="card-context">
                        <span> 用户邮箱: </span>
                    </div>
                    <div class="card-context">
                        <span> 创建日期: </span>
                    </div>
                    <div class="card-context">
                        <span> 个人简介: </span>
                    </div>
                </div>
            </el-card>
        </el-col>
        <el-col :span="14">
            <el-card shadow="hover"> Hover </el-card>
        </el-col>
    </el-row>
</template>
<script setup lang="ts">
import { useUserStore } from "@/store/modules/user";
const userStore = useUserStore();
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
    font-size: 12px;
    height: 140px;
    font-weight: bold;
    border-bottom: 1px solid #d0dae2;
    display: flex; 
    align-items: center;
}
</style>
