<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="12">
                <el-card>
                    <template #header>
                        <div class="m-1">
                            <el-icon>
                                <svg-icon icon-class="cpu" />
                            </el-icon>
                            <span class="m-2">CPU</span>
                        </div>
                    </template>
                    <el-table
                        :data="dataList"
                        :header-cell-style="{
                            color: '#333333',
                            fontWeight: 900,
                            backgroundColor: 'var(--el-fill-color-light)',
                        }"
                    >
                        <el-table-column prop="name" label="属性" />
                        <el-table-column prop="value" label="值" />
                    </el-table>
                </el-card>
            </el-col>
            <el-col :span="12">
                <el-card>
                    <template #header>
                        <div class="m-1">
                            <el-icon>
                                <svg-icon icon-class="mem" />
                            </el-icon>
                            <span class="m-2">内存</span>
                        </div>
                    </template>
                    <el-table
                        :data="dataList"
                        :header-cell-style="{
                            color: '#333333',
                            fontWeight: 900,
                            backgroundColor: 'var(--el-fill-color-light)',
                        }"
                    >
                        <el-table-column prop="name" label="属性" />
                        <el-table-column prop="value" label="值" />
                    </el-table>
                </el-card>
            </el-col>
        </el-row>
        <el-card style="margin-top: 20px">
            <template #header>
                <div class="m-1">
                    <el-icon>
                        <svg-icon icon-class="sever" />
                    </el-icon>
                    <span class="m-2">服务器信息</span>
                </div>
            </template>
        </el-card>
    </div>
</template>
<script setup lang="ts">
const dataList = [
    {
        name: "核心数",
        value: "24核",
    },
];
</script>
<style lang="scss" scoped>
.m-1 {
    display: flex;
    align-items: center;
    .m-2 {
        padding-left: 6px;
        font-size: 18px;
    }
}
</style>
