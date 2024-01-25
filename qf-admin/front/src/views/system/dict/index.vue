<template>
    <div>
        <div style="display: flex; flex-direction: row">
            <div class="m-1" style="width: 280px">
                <div class="m-1-1">
                    <div class="m-2">字典列表</div>
                    <div class="div-right">
                        <el-button
                            type="primary"
                            size="small"
                            @click="addDictList"
                            >新增</el-button
                        >
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
            <div class="m-1" style="margin-left: 10px; width: 97%">
                <div class="m-1-1">
                    <div class="m-2">字典详细内容</div>
                    {{}}
                    <div
                        class="div-right"
                        style="padding-right: 30px"
                        v-show="DictList?.length > 0"
                    >
                        <el-button
                            type="primary"
                            size="small"
                            @click="addDictValue"
                            >新增字典项</el-button
                        >
                    </div>
                </div>
                <el-table
                    :data="DictPage"
                    ref="tableRef"
                    style="width: 97%; padding-top: 20px"
                    :header-cell-style="{
                        color: '#333333',
                        fontWeight: 900,
                        backgroundColor: 'var(--el-fill-color-light)',
                    }"
                >
                    <el-table-column
                        key="id"
                        label="字典编号"
                        align="center"
                        prop="id"
                        width="80"
                    />
                    <el-table-column
                        label="字典名称"
                        align="center"
                        prop="name"
                        mix-width="100"
                    />
                    <el-table-column
                        label="字典标识"
                        align="center"
                        prop="typeCode"
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
                        label="字典值"
                        align="center"
                        prop="value"
                        mix-width="100"
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
                                v-hasPerm="['sys:dict:edit']"
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
                                        v-hasPerm="['sys:dict:delete']"
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
                <!-- <div
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
            </div>
        </div>
        <el-dialog v-model="dialog.visible" :title="dialog.title" width="400px">
            <el-form
                v-show="dialog.show"
                ref="dictRef"
                :label-position="labelPosition"
                label-width="100px"
                :model="dictValueform"
                style="max-width: 460px"
            >
                <el-form-item label="字典名称" prop="name">
                    <el-input v-model="dictValueform.name" />
                </el-form-item>
                <el-form-item label="字典标识" prop="typeCode">
                    <el-input v-model="dictValueform.typeCode" readonly />
                </el-form-item>
                <el-form-item label="字典值" prop="value">
                    <el-input v-model="dictValueform.value" />
                </el-form-item>
                <el-form-item label="字典状态" class="form-label" prop="status">
                    <el-radio-group v-model="dictValueform.status">
                        <el-radio :label="1">正常</el-radio>
                        <el-radio :label="0">禁用</el-radio>
                    </el-radio-group>
                </el-form-item>
                <div style="text-align: right">
                    <el-button type="primary" @click="submitDict">
                        确认
                    </el-button>
                </div>
            </el-form>
            <el-form
                ref="dictRef"
                v-show="!dialog.show"
                :label-position="labelPosition"
                label-width="100px"
                :model="dictListForm"
                style="max-width: 460px"
            >
                <el-form-item label="字典名称" prop="name">
                    <el-input v-model="dictListForm.name" />
                </el-form-item>
                <el-form-item label="字典标识" prop="code">
                    <el-input v-model="dictListForm.code" />
                </el-form-item>
                <el-form-item label="字典状态" class="form-label" prop="status">
                    <el-radio-group v-model="dictListForm.status">
                        <el-radio :label="1">正常</el-radio>
                        <el-radio :label="0">禁用</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="字典描述" prop="remark">
                    <el-input v-model="dictListForm.remark" />
                </el-form-item>
                <div style="text-align: right">
                    <el-button type="primary" @click="submitDict">
                        确认
                    </el-button>
                </div>
            </el-form>
        </el-dialog>
    </div>
</template>
<script setup lang="ts">
const labelPosition = ref<FormProps["labelPosition"]>("right");
import {
    DictTypeVo,
    DictPageVO,
    DictTypeForm,
    DictForm,
} from "@/api/dict/types";
import {
    addDict,
    addDictType,
    getDictTypeList,
    getDictValueQuery,
} from "@/api/dict/index";
import { FormProps } from "element-plus";
const dictRef = ref<InstanceType<typeof ElForm>>();
const currentCode = ref<string>("");
const DictList = ref<DictTypeVo[]>();
const DictPage = ref<DictPageVO[]>();
const activeIndex = ref(1);
function toCategory(item: DictTypeVo) {
    activeIndex.value = item.id;
    dictvalueQuery(item.code);
}
/** 字典列表新增表单 */
const dictListForm = reactive<DictTypeForm>({
    name: "",
    code: "",
    status: 1,
    remark: "",
});
/** 字典值新增表单 */
const dictValueform = reactive<DictForm>({
    name: "",
    status: 1,
    value: "",
    typeCode: "",
});
/** 新增字典模态框 */
const dialog = reactive({
    title: "",
    visible: true,
    show: false,
});
/** 查询字典类型 */
function handleQuery() {
    getDictTypeList()
        .then(({ data }) => {
            if (data === undefined || data.length === 0) return;
            DictList.value = data;
            console.log("DictList.value[0].code: ", DictList.value[0].code);
            currentCode.value = DictList.value[0].code;
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
    currentCode.value = code;
    getDictValueQuery(queryParams).then(({ data }) => {
        DictPage.value = data.list;
    });
}
/** 新增字典值 */
function addDictValue() {
    dictRef.value?.resetFields();
    dialog.visible = true;
    dialog.show = true;
    dialog.title = "新增字典值";
    dictValueform.typeCode = currentCode.value;
}
/** 新增字典列表 */
function addDictList() {
    dictRef.value?.resetFields();
    dialog.visible = true;
    dialog.show = false;
    dialog.title = "新增列表";
}
function submitDict() {
    /** false是列表新增 true是值新增 */
    if (dialog.show) {
        addDict(dictValueform).then(({ data }) => {
            if (data > 0) {
                ElMessage.success("新增字典值成功");
                closeDialog();
                handleQuery();
            } else {
                // 失败
            }
        });
    } else {
        addDictType(dictListForm).then(({ data }) => {
            if (data > 0) {
                ElMessage.success("新增字典列表成功");
                closeDialog();
                handleQuery();
            } else {
                // 失败
            }
        });
    }
}
function closeDialog() {
    dialog.visible = false;
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
