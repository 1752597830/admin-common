<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-card style="height: calc(100vh - 160px)">
                    <template #header>
                        <div class="m-1-1">
                            <svg-icon icon-class="list" />
                            <div class="m-2">缓存列表</div>
                            <div class="div-right">
                                <i-ep-refresh-right />
                            </div>
                        </div>
                    </template>
                    <el-table
                        v-loading="loading"
                        :data="cacheNames"
                        highlight-current-row
                        @row-click="getCacheKeys"
                        style="width: 100%"
                        height="calc(100vh - 170px)"
                        :header-cell-style="{
                            color: '#333333',
                            fontWeight: 900,
                            backgroundColor: 'var(--el-fill-color-light)',
                        }"
                    >
                        <el-table-column
                            label="序号"
                            width="60"
                            type="index"
                        ></el-table-column>

                        <el-table-column
                            label="缓存名称"
                            align="center"
                            prop="cacheName"
                            :show-overflow-tooltip="true"
                            :formatter="getValue"
                        ></el-table-column>

                        <el-table-column
                            label="备注"
                            align="center"
                            prop="remark"
                            :show-overflow-tooltip="true"
                        />
                        <el-table-column
                            label="操作"
                            width="60"
                            align="center"
                            class-name="small-padding fixed-width"
                        >
                            <template #default="scope">
                                <el-popconfirm
                                    :title="
                                        '是否确认清空缓存名称为' +
                                        getValue(scope.row) +
                                        '的数据'
                                    "
                                    @confirm="handleClearCacheName(scope.row)"
                                >
                                    <template #reference>
                                        <el-icon>
                                            <i-ep-delete />
                                        </el-icon>
                                    </template>
                                </el-popconfirm>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-card>
            </el-col>
            <el-col :span="8">
                <el-card style="height: calc(100vh - 160px)">
                    <template #header>
                        <div class="m-1-1">
                            <svg-icon icon-class="key" />
                            <div class="m-2">键名列表</div>
                            <div class="div-right" @click="refreshCacheKeys">
                                <i-ep-RefreshRight />
                            </div>
                        </div>
                    </template>
                    <el-table
                        v-loading="subLoading"
                        :data="cacheKeys"
                        highlight-current-row
                        @row-click="handleCacheValue"
                        style="width: 100%"
                        height="calc(100vh - 170px)"
                        :header-cell-style="{
                            color: '#333333',
                            fontWeight: 900,
                            backgroundColor: 'var(--el-fill-color-light)',
                        }"
                    >
                        <el-table-column
                            label="序号"
                            width="60"
                            type="index"
                        ></el-table-column>
                        <el-table-column
                            label="缓存键名"
                            align="center"
                            :show-overflow-tooltip="true"
                            prop="v"
                            :formatter="keyValue"
                        >
                        </el-table-column>
                        <el-table-column
                            label="操作"
                            width="60"
                            align="center"
                            class-name="small-padding fixed-width"
                        >
                            <template #default="scope">
                                <el-popconfirm
                                    :title="
                                        '是否确认删除键名为' +
                                        keyValue(scope.row) +
                                        '的数据'
                                    "
                                    @confirm="handleClearCacheKey(scope.row)"
                                >
                                    <template #reference>
                                        <el-icon>
                                            <i-ep-delete />
                                        </el-icon>
                                    </template>
                                </el-popconfirm>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-card>
            </el-col>
            <el-col :span="8">
                <el-card style="height: calc(100vh - 160px)">
                    <template #header>
                        <div class="m-1-1">
                            <svg-icon icon-class="context" />
                            <div class="m-2">缓存内容</div>
                            <div class="div-right">
                                <div style="align-items: center; display: flex" @click="handleClearCacheAll">
                                    <i-ep-RefreshRight />
                                    <span>清理全部</span>
                                </div>
                            </div>
                        </div>
                    </template>
                    <el-row :gutter="32">
                        <el-col :offset="1" :span="22">
                            <div style="padding-top: 10px">
                                <span class="form-label">缓存名称</span>
                                <div style="padding-top: 10px">
                                    <el-input
                                        v-model="cacheForm.cacheName"
                                        :readonly="true"
                                    />
                                </div>
                            </div>

                            <div style="padding-top: 10px">
                                <span class="form-label">缓存键名:</span>
                                <div style="padding-top: 10px">
                                    <el-input
                                        v-model="cacheForm.cacheKey"
                                        :readonly="true"
                                    />
                                </div>
                            </div>
                            <div style="padding-top: 10px">
                                <span class="form-label">缓存内容:</span>
                                <div style="padding-top: 10px">
                                    <el-input
                                        v-model="cacheForm.cacheValue"
                                        type="textarea"
                                        :rows="5"
                                        :readonly="true"
                                    />
                                </div>
                            </div>
                        </el-col>
                    </el-row>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>
<script setup lang="ts">
import {
    listCacheName,
    listCacheKey,
    getCacheValue,
    clearCacheName,
    clearCacheKey,
    clearCacheAll
} from "@/api/sever/coach/index";
const cacheNames = ref<object>([]);
const cacheKeys = ref<object>([]);
const cacheForm = ref({});
const loading = ref(true);
const subLoading = ref(false);
const nowCacheName = ref("");
function getCacheNames() {
    loading.value = true;
    listCacheName().then(({ data }) => {
        cacheNames.value = data;
        loading.value = false;
    });
}
/** 查询缓存键名列表 */
function getCacheKeys(row) {
    const cacheName = row !== undefined ? row.cacheName : nowCacheName;
    if (cacheName.value === "") {
        return;
    }
    subLoading.value = true;
    listCacheKey(row !== undefined ? cacheName : cacheName.value).then(
        ({ data }) => {
            cacheKeys.value = data;
            subLoading.value = false;
            nowCacheName.value =
                row !== undefined ? cacheName : cacheName.value;
        }
    );
}
/** 查询缓存内容详细 */
function handleCacheValue(cacheKey: string) {
    console.log("cacheKey:", nowCacheName.value);
    getCacheValue(nowCacheName.value, cacheKey.v).then(({ data }) => {
        cacheForm.value = data;
    });
}
/** 刷新缓存键名列表 */
function refreshCacheKeys() {
    getCacheKeys(undefined);
    ElMessage.success("刷新键名列表成功");
}
/**列表去掉前缀 */
function getValue(row: cacheForm): string {
    return row.cacheName.replace(":", "");
}
function keyValue(row): string {
    return row.v.slice(row.v.indexOf(":") + 1);
}
/** 清理指定名称缓存 */
function handleClearCacheName(row) {
    clearCacheName(row.cacheName).then(({ data }) => {
        ElMessage.success("清理缓存名称[" + row.cacheName + "]成功");
        getCacheKeys(undefined);
    });
}
/** 清理指定键名缓存 */
function handleClearCacheKey(row) {
    clearCacheKey(row.v).then(({ data }) => {
        ElMessage.success("清理缓存键名[" + row.v + "]成功");
        getCacheKeys(undefined);
    });
}
/** 清理全部缓存 */
function handleClearCacheAll() {
    clearCacheAll().then(({data}) => {
        ElMessage.success("清理全部缓存成功");
    });
}
onMounted(() => {
    getCacheNames();
});
</script>
<style lang="scss" scoped>
.m-1-1 {
    display: flex;
    flex-direction: row;
    align-items: center;
    .m-2 {
        padding-left: 6px;
        font-size: 16px;
        font-weight: bold;
    }
    .div-right {
        margin: 0px 10px 0px auto;
        color: rgb(27, 157, 237);
        font-size: 14px;
    }
}
.form-label {
    font-weight: bold;
    max-width: 250px;
    font-size: 14px;
}
</style>
