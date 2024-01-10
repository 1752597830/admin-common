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
                    <table
                        style="
                            width: 100%;
                            text-align: left;
                            padding-left: 20px;
                        "
                    >
                        <thead>
                            <tr>
                                <th>
                                    <div>属性</div>
                                </th>
                                <th>
                                    <div>值</div>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <div>核心数</div>
                                </td>
                                <td>
                                    <div v-if="server.cpu">
                                        {{ server.cpu.cpuNum }}
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>用户使用率</div>
                                </td>
                                <td>
                                    <div v-if="server.cpu">
                                        {{ server.cpu.used }}%
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>系统使用率</div>
                                </td>
                                <td>
                                    <div v-if="server.cpu">
                                        {{ server.cpu.sys }}%
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>当前空闲率</div>
                                </td>
                                <td>
                                    <div v-if="server.cpu">
                                        {{ server.cpu.free }}%
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
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
                    <table
                        style="
                            width: 100%;
                            padding-left: 20px;
                            text-align: left;
                        "
                    >
                        <thead>
                            <tr>
                                <th>
                                    <div>属性</div>
                                </th>
                                <th>
                                    <div>内存</div>
                                </th>
                                <th>
                                    <div>JVM</div>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <div>总内存</div>
                                </td>
                                <td>
                                    <div v-if="server.mem">
                                        {{ server.mem.total }}G
                                    </div>
                                </td>
                                <td>
                                    <div v-if="server.jvm">
                                        {{ server.jvm.total }}M
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>已用内存</div>
                                </td>
                                <td>
                                    <div v-if="server.mem">
                                        {{ server.mem.used }}G
                                    </div>
                                </td>
                                <td>
                                    <div v-if="server.jvm">
                                        {{ server.jvm.used }}M
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>剩余内存</div>
                                </td>
                                <td>
                                    <div v-if="server.mem">
                                        {{ server.mem.free }}G
                                    </div>
                                </td>
                                <td>
                                    <div v-if="server.jvm">
                                        {{ server.jvm.free }}M
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>使用率</div>
                                </td>
                                <td>
                                    <div
                                        v-if="server.mem"
                                        :class="
                                            server.mem.usage > 80
                                                ? 'text-danger'
                                                : ''
                                        "
                                    >
                                        {{ server.mem.usage }}%
                                    </div>
                                </td>
                                <td>
                                    <div
                                        v-if="server.jvm"
                                        :class="
                                            server.jvm.usage > 80
                                                ? 'text-danger'
                                                : ''
                                        "
                                    >
                                        {{ server.jvm.usage }}%
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
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
            <table style="width: 100%; text-align: left; padding-left: 20px">
                <tbody>
                    <tr>
                        <td>
                            <div class="cell">服务器名称</div>
                        </td>
                        <td>
                            <div v-if="server.sys">
                                {{ server.sys.computerName }}
                            </div>
                        </td>
                        <td>
                            <div class="cell">操作系统</div>
                        </td>
                        <td>
                            <div v-if="server.sys">
                                {{ server.sys.osName }}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="cell">服务器IP</div>
                        </td>
                        <td>
                            <div v-if="server.sys">
                                {{ server.sys.computerIp }}
                            </div>
                        </td>
                        <td>
                            <div class="cell">系统架构</div>
                        </td>
                        <td>
                            <div v-if="server.sys">
                                {{ server.sys.osArch }}
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </el-card>
        <el-card style="margin-top: 20px">
            <template #header>
                <div class="m-1">
                    <el-icon>
                        <svg-icon icon-class="coffee-cup" />
                    </el-icon>
                    <span class="m-2">Java虚拟机信息</span>
                </div>
            </template>
            <table style="width: 100%; text-align: left; padding-left: 20px">
                <tbody>
                    <tr>
                        <td>
                            <div class="cell">Java名称</div>
                        </td>
                        <td>
                            <div v-if="server.jvm">
                                {{ server.jvm.name }}
                            </div>
                        </td>
                        <td>
                            <div class="cell">Java版本</div>
                        </td>
                        <td>
                            <div v-if="server.jvm">
                                {{ server.jvm.version }}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="cell">启动时间</div>
                        </td>
                        <td>
                            <div v-if="server.jvm">
                                {{ server.jvm.startTime }}
                            </div>
                        </td>
                        <td>
                            <div class="cell">运行时长</div>
                        </td>
                        <td>
                            <div v-if="server.jvm">
                                {{ server.jvm.runTime }}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="1">
                            <div class="cell">安装路径</div>
                        </td>
                        <td colspan="3">
                            <div v-if="server.jvm">
                                {{ server.jvm.home }}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="1">
                            <div class="cell">项目路径</div>
                        </td>
                        <td colspan="3">
                            <div v-if="server.sys">
                                {{ server.sys.userDir }}
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="1">
                            <div class="cell">运行参数</div>
                        </td>
                        <td colspan="3">
                            <div v-if="server.jvm">
                                {{ server.jvm.inputArgs }}
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </el-card>
        <el-card style="margin-top: 20px">
            <template #header>
                <div class="m-1">
                    <el-icon>
                        <svg-icon icon-class="receiving" />
                    </el-icon>
                    <span class="m-2">磁盘状态</span>
                </div>
            </template>
            <table
                style="width: 100%; text-align: left; padding-left: 20px"
                cellspacing="0"
            >
                <thead>
                    <tr>
                        <th><div class="cell">盘符路径</div></th>
                        <th><div class="cell">文件系统</div></th>
                        <th><div class="cell">盘符类型</div></th>
                        <th><div class="cell">总大小</div></th>
                        <th><div class="cell">可用大小</div></th>
                        <th><div class="cell">已用大小</div></th>
                        <th><div class="cell">已用百分比</div></th>
                    </tr>
                </thead>
                <tbody v-if="server.sysFiles">
                    <tr
                        v-for="(sysFile, index) in server.sysFiles"
                        :key="index"
                    >
                        <td>
                            <div>{{ sysFile.dirName }}</div>
                        </td>
                        <td>
                            <div>{{ sysFile.sysTypeName }}</div>
                        </td>
                        <td>
                            <div>{{ sysFile.typeName }}</div>
                        </td>
                        <td>
                            <div>{{ sysFile.total }}</div>
                        </td>
                        <td>
                            <div>{{ sysFile.free }}</div>
                        </td>
                        <td>
                            <div>{{ sysFile.used }}</div>
                        </td>
                        <td>
                            <div
                                :class="sysFile.usage > 80 ? 'text-danger' : ''"
                            >
                                {{ sysFile.usage }}%
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </el-card>
    </div>
</template>
<script setup lang="ts">
import { getSever } from "@/api/sever/index";
import { severData } from "@/api/sever/types";
const server = ref<severData>({});
function initSever() {
    getSever().then(({ data }) => {
        console.log("data,,,", data);
        server.value = data;
    });
}
onMounted(() => {
    initSever();
});
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
.text-danger {
    color: red;
    font-weight: bold;
}
.cell {
    width: 80px;
    font-weight: 900;
}
</style>
