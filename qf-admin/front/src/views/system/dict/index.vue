<template>
    <div>
        <!-- <div
            style="
                background-color: white;
                padding: 20px 20px 10px 20px;
                margin-bottom: 10px;
            "
        >
            <el-form ref="queryFormRef" :model="queryParams" :inline="true">
                <el-form-item label="关键字" prop="keywords">
                    <el-input
                        v-model="queryParams.keywords"
                        placeholder="分类名称"
                        clearable
                        @keyup.enter="handleQuery"
                    />
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleQuery"
                        ><template #icon><i-ep-search /></template
                        >搜索</el-button
                    >
                    <el-button @click="resetQuery">
                        <template #icon><i-ep-refresh /></template>
                        重置</el-button
                    >
                </el-form-item>
            </el-form>
        </div> -->
        <div style="display: flex; flex-direction: row">
            <div class="m-1" style="width: 280px">
                <div class="m-1-1">
                    <div class="m-2">字典列表</div>
                    <div class="div-right">
                        <el-button type="primary" size="small">新增</el-button>
                    </div>
                </div>
                <el-scrollbar>
                    <div
                        v-for="item in DictList"
                        class="item"
                        :style="{
                            backgroundColor:
                                activeIndex === item.id
                                    ? '#409eff'
                                    : 'rgba(224, 219, 219, 0.984)',
                        }"
                    >
                        <div class="m-3" @click="toCategory(item)">
                            <span>{{ item.name }}</span>
                        </div>
                        <div style="display: flex; flex-direction: row">
                            <el-icon color="#5692f6">
                                <i-ep-edit />
                            </el-icon>
                            <el-icon color="#ef4444" style="padding-left: 8px">
                                <i-ep-delete />
                            </el-icon>
                        </div>
                    </div>
                </el-scrollbar>
            </div>
            <div class="m-1" style="margin-left: 10px; width: 100%">
                <div class="m-1-1">
                    <div class="m-2">字典详细内容</div>
                    <div class="div-right">
                        <el-button type="primary" size="small"
                            >新增字典项</el-button
                        >
                    </div>
                </div>
                <!-- <el-table
                v-loading="loading"
                :data="roleList"
                ref="tableRef"
                :header-cell-style="{
                    color: '#333333',
                    fontWeight: 900,
                    backgroundColor: 'var(--el-fill-color-light)',
                }"
            >
                <el-table-column
                    key="id"
                    label="角色编号"
                    align="center"
                    prop="id"
                    width="80"
                />
                <el-table-column
                    label="角色名称"
                    align="center"
                    prop="name"
                    mix-width="100"
                />
                <el-table-column
                    label="角色标识"
                    min-width="100"
                    align="center"
                    prop="code"
                />
                <el-table-column label="状态" align="center" width="100">
                    <template #default="scope">
                        <el-tag v-if="scope.row.status === 1" type="success"
                            >正常</el-tag
                        >
                        <el-tag v-else type="info">禁用</el-tag>
                    </template>
                </el-table-column>
                <el-table-column
                    key="remark"
                    label="备注"
                    align="center"
                    prop="remark"
                    mix-width="180"
                />
                <el-table-column
                    label="创建时间"
                    align="center"
                    prop="createTime"
                    width="180"
                />
                <el-table-column
                    label="操作"
                    fixed="right"
                    align="center"
                    width="220"
                >
                    <template #default="scope">
                        <el-button
                            v-hasPerm="['sys:user:edit']"
                            type="primary"
                            link
                            size="small"
                            @click="openDialog(scope.row.id)"
                            ><i-ep-edit />编辑</el-button
                        >
                        <el-popconfirm
                            :title="
                                '是否确认删除字典项名为' +
                                scope.row.nickname +
                                '的这条数据'
                            "
                            @confirm="handleDelete(scope.row.id)"
                        >
                            <template #reference>
                                <el-button
                                    v-hasPerm="['sys:user:delete']"
                                    type="primary"
                                    link
                                    size="small"
                                    ><i-ep-delete />删除</el-button
                                >
                            </template>
                        </el-popconfirm>
                    </template>
                </el-table-column>
            </el-table>
            <div
                style="
                    padding-top: 30px;
                    display: flex;
                    justify-content: center;
                "
            >
                <el-pagination
                    v-if="total > 0"
                    v-model:total="total"
                    v-model:page="queryParams.pageNum"
                    v-model:limit="queryParams.pageSize"
                    layout="total,prev,pager,next,jumper"
                    @pagination="handleQuery"
                />
            </div> -->
                {{ DictPage }}
            </div>
        </div>
    </div>
</template>
<script setup lang="ts">
import { DictTypeVo, DictPageVO } from "@/api/dict/types";
import { getDictTypeList, getDictValueQuery } from "@/api/dict/index";

// const DictTypeResult = [
//     {
//         id: 1,
//         name: "性别性性别性性别性adasd",
//         code: "gender",
//     },
//     {
//         id: 2,
//         name: "年龄",
//         code: "gende1r",
//     },
//     {
//         id: 3,
//         name: "掌声",
//         code: "gender2",
//     },
//     {
//         id: 4,
//         name: "李四",
//         code: "gender3",
//     },
//     {
//         id: 5,
//         name: "王五",
//         code: "gender4",
//     },
//     {
//         id: 6,
//         name: "性别",
//         code: "gender11",
//     },
//     {
//         id: 7,
//         name: "性别",
//         code: "g1ender",
//     },
//     {
//         id: 8,
//         name: "性别",
//         code: "gen12der",
//     },
//     {
//         id: 9,
//         name: "性别",
//         code: "gend123er",
//     },
//     {
//         id: 10,
//         name: "性别",
//         code: "gend3232er",
//     },
//     {
//         id: 11,
//         name: "年龄",
//         code: "genwwder",
//     },
//     {
//         id: 12,
//         name: "掌声",
//         code: "gesssnder",
//     },
// ];
const DictList = ref<DictTypeVo[]>();
const DictPage = ref<DictPageVO[]>();
const activeIndex = ref(1);
function toCategory(item: DictTypeVo) {
    activeIndex.value = item.id;
    dictvalueQuery(item.code);
}
/** 查询字典类型 */
function handleQuery() {
    getDictTypeList()
        .then(({ data }) => {
            if (data === undefined || data.length === 0) return;
            DictList.value = data;
            console.log("DictList.value[0].code: ", DictList.value[0].code);
            dictvalueQuery(DictList.value[0].code);
        })
        .finally(() => {});
}
/** 查询字典值 */
function dictvalueQuery(code: string) {
    let queryParams = {
        pageNum: 1,
        pageSize: 10,
        code: code,
    };
    getDictValueQuery(queryParams).then(({ data }) => {
        DictPage.value = data.list;
    });
}
onMounted(() => {
    handleQuery();
});
</script>
<style lang="scss" scoped>
.el-scrollbar {
    height: 79vh;
    background-color: white;
    padding-top: 10px;
}
.m-1 {
    background-color: white;
    padding: 10px;
    border-radius: 3px;
    .m-1-1 {
        display: flex;
        flex-direction: row;
        align-items: center;
        .div-right {
            margin: 0px 10px 0px auto;
        }
    }
    .m-2 {
        font-size: 16px;
        font-weight: bold;
    }
    .m-3 {
        font-size: 14px;
        width: 140px;
        overflow: hidden;
        text-overflow: ellipsis;
        -o-text-overflow: ellipsis;
        white-space: nowrap;
    }
    .item {
        border-radius: 3px;
        margin-top: 10px;
        height: 40px;
        display: flex;
        align-items: center;
        padding-left: 10px;
        padding-right: 10px;
    }
}
</style>
