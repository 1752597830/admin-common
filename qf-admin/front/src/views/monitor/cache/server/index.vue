<template>
    <div>
        <el-card>
            <template #header>
                <div class="m-1">
                    <el-icon>
                        <svg-icon icon-class="sever" />
                    </el-icon>
                    <span class="m-2">基本信息</span>
                </div>
            </template>
            <table style="width: 100%; text-align: left; padding-left: 20px">
                <tbody>
                    <tr style="height: 30px">
                        <th>
                            <div>Redis版本</div>
                        </th>
                        <td>123</td>
                        <th>
                            <div>运行模式</div>
                        </th>
                        <td>123</td>
                        <th>
                            <div>端口</div>
                        </th>
                        <td>123</td>
                        <th>
                            <div>客户端数</div>
                        </th>
                        <td>123</td>
                    </tr>
                    <tr style="height: 30px">
                        <th>
                            <div>运行时间(天)</div>
                        </th>
                        <td>123</td>
                        <th>
                            <div>使用内存</div>
                        </th>
                        <td>123</td>
                        <th>
                            <div>使用CPU</div>
                        </th>
                        <td>123</td>
                        <th>
                            <div>内存配置</div>
                        </th>
                        <td>123</td>
                    </tr>
                    <tr style="height: 30px">
                        <th>
                            <div>AOF是否开启</div>
                        </th>
                        <td>123</td>
                        <th>
                            <div>RDB是否成功</div>
                        </th>
                        <td>123</td>
                        <th>
                            <div>Key数量</div>
                        </th>
                        <td>123</td>
                        <th>
                            <div>网络入口/出口</div>
                        </th>
                        <td>123</td>
                    </tr>
                </tbody>
            </table>
        </el-card>

        <div style="padding-top: 20px">
            <el-row :gutter="20">
                <el-col :span="12">
                    <el-card>
                        <template #header>
                            <div class="m-1">
                                <el-icon>
                                    <svg-icon icon-class="chart" />
                                </el-icon>
                                <span class="m-2">命令统计</span>
                            </div>
                        </template>
                    </el-card>
                </el-col>
                <el-col :span="12">
                    <el-card>
                        <template #header>
                            <div class="m-1">
                                <el-icon>
                                    <svg-icon icon-class="threshold" />
                                </el-icon>
                                <span class="m-2">内存信息</span>
                            </div>
                        </template>
                    </el-card>
                </el-col>
            </el-row>
        </div>
    </div>
</template>
<script setup lang="ts">
import {} from "vue";
</script>
<style lang="scss" scoped>
.m-1 {
    display: flex;
    align-items: center;
    .m-2 {
        padding-left: 6px;
        font-size: 18px;
        font-weight: bold;
    }
}
</style>
