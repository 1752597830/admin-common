<template>
    <div>
        <div class="up-1">
            <el-avatar :size="70" :src="userStore.user.avatar" />
            <div>
                <div style="padding-left: 20px">
                    <span
                        style="
                            font-size: 16px;
                            color: rgb(17, 1, 1);
                            font-weight: 900;
                        "
                        >{{ greetings }}</span
                    >
                    <br />
                    <div style="padding-top: 8px">
                        <span style="font-size: 14px; color: rgb(168, 161, 161)"
                            >今日天气晴朗，气温在15℃至25℃之间，东南风。</span
                        >
                    </div>
                </div>
            </div>
        </div>
        <div class="down-1">下</div>
    </div>
</template>
<script setup lang="ts">
import { useUserStore } from "@/store/modules/user";
const userStore = useUserStore();
const date: Date = new Date();
const greetings = computed(() => {
    const hours = date.getHours();
    if (hours >= 6 && hours < 8) {
        return "晨起披衣出草堂，轩窗已自喜微凉🌅！";
    } else if (hours >= 8 && hours < 12) {
        return "上午好，" + userStore.user.nickname + "！";
    } else if (hours >= 12 && hours < 18) {
        return "下午好，" + userStore.user.nickname + "！";
    } else if (hours >= 18 && hours < 24) {
        return "晚上好，" + userStore.user.nickname + "！";
    } else if (hours >= 0 && hours < 6) {
        return "偷偷向银河要了一把碎星，只等你闭上眼睛撒入你的梦中，晚安🌛！";
    }
});
</script>
<style lang="scss" scoped>
.up-1 {
    background-color: white;
    padding: 20px 20px 20px 30px;
    margin-bottom: 10px;
    border-radius: 6px;
    flex-direction: row;
    display: flex;
    align-items: center;
}
.down-1 {
    border-radius: 6px;
    background-color: white;
    height: 60px;
    padding: 20px 20px 20px 10px;
}
</style>
