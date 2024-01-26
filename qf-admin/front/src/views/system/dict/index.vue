<template>
    <div style="display: grid; grid-template-columns: 240px 1fr; gap: 10px">
        <div class="m-1">
            <div class="m-1-1">
                <div class="m-2">字典列表</div>
                <div class="div-right">
                    <el-button
                        type="primary"
                        size="small"
                        @click="openDialog('dict-list-form')"
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
                        <el-icon
                            color="#5692f6"
                            @click="openDialog('dict-list-form', item.id)"
                        >
                            <i-ep-edit />
                        </el-icon>
                        <el-popconfirm
                            :title="'是否确认删除字典名为' + item.name + '?'"
                            @confirm="handleDelete('type', item.id)"
                        >
                            <template #reference>
                                <el-icon
                                    color="#ef4444"
                                    style="padding-left: 10px"
                                >
                                    <i-ep-delete />
                                </el-icon>
                            </template>
                        </el-popconfirm>
                    </div>
                </div>
            </el-scrollbar>
        </div>
        <div class="m-1">
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
                        @click="openDialog('dict-value-form')"
                        >新增字典项</el-button
                    >
                </div>
            </div>
            <el-table
                :data="DictPage"
                ref="tableRef"
                style="padding-top: 20px; width: 100%; overflow-x: auto"
                :header-cell-style="{
                    color: '#333333',
                    fontWeight: 900,
                    backgroundColor: 'var(--el-fill-color-light)',
                }"
            >
                <el-table-column
                    label="字典名称"
                    align="center"
                    prop="name"
                    mix-width="100"
                    fixed
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
                    width="100"
                />
                <el-table-column
                    label="创建时间"
                    align="center"
                    prop="createTime"
                    min-width="180"
                />
                <el-table-column
                    label="操作"
                    fixed="right"
                    align="center"
                    width="200"
                >
                    <template #default="scope">
                        <el-button
                            type="primary"
                            link
                            size="small"
                            @click="openDialog('dict-value-form', scope.row.id)"
                            ><i-ep-edit />编辑</el-button
                        >
                        <el-popconfirm
                            :title="
                                '是否确认删除字典项名为' +
                                scope.row.name +
                                '的这条数据'
                            "
                            @confirm="handleDelete('value', scope.row.id)"
                        >
                            <template #reference>
                                <el-button type="primary" link size="small"
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
        <el-dialog v-model="dialog.visible" :title="dialog.title" width="400px">
            <el-form
                v-if="dialog.type === 'dict-value-form'"
                ref="dictRef"
                :label-position="labelPosition"
                label-width="100px"
                :model="dictValueform"
                style="max-width: 460px"
            >
                <el-form-item label="字典名称" prop="id" v-show="false">
                    <el-input v-model="dictValueform.id" />
                </el-form-item>
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
                    <el-button
                        type="primary"
                        @click="submitDict('dict-value-form')"
                    >
                        确认
                    </el-button>
                </div>
            </el-form>
            <el-form
                v-else
                ref="dictRef"
                :label-position="labelPosition"
                label-width="100px"
                :model="dictTypeForm"
                style="max-width: 460px"
            >
                <el-form-item label="字典名称" prop="id" v-show="false">
                    <el-input v-model="dictTypeForm.id" />
                </el-form-item>
                <el-form-item label="字典名称" prop="name">
                    <el-input v-model="dictTypeForm.name" />
                </el-form-item>
                <el-form-item label="字典标识" prop="code">
                    <el-input v-model="dictTypeForm.code" />
                </el-form-item>
                <el-form-item label="字典状态" class="form-label" prop="status">
                    <el-radio-group v-model="dictTypeForm.status">
                        <el-radio :label="1">正常</el-radio>
                        <el-radio :label="0">禁用</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="字典描述" prop="remark">
                    <el-input v-model="dictTypeForm.remark" />
                </el-form-item>
                <div style="text-align: right">
                    <el-button
                        type="primary"
                        @click="submitDict('dict-list-form')"
                    >
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
    deleteDict,
    deleteDictTypes,
    getDictFormData,
    getDictTypeForm,
    getDictTypeList,
    getDictValueQuery,
    updateDict,
    updateDictType,
} from "@/api/dict/index";
import { FormProps } from "element-plus";
const dictRef = ref<InstanceType<typeof ElForm>>();
const currentCode = ref<string>("");
const DictList = ref<DictTypeVo[]>();
const DictPage = ref<DictPageVO[]>();
const activeIndex = ref(-1);
function toCategory(item: DictTypeVo) {
    activeIndex.value = item.id;
    dictvalueQuery(item.code);
}
/** 字典列表新增表单 */
const dictTypeForm = reactive<DictTypeForm>({
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
    visible: false,
    type: "",
});
/** 查询字典类型 */
function handleQuery() {
    getDictTypeList()
        .then(({ data }) => {
            if (data === undefined || data.length === 0) return;
            DictList.value = data;
            if (activeIndex.value == -1 || DictList.value.find(item => item.id === activeIndex.value)===undefined) {
                currentCode.value = DictList.value[0].code;
                dictvalueQuery(DictList.value[0].code);
                activeIndex.value = DictList.value[0].id;
            } else {
                const currentDict = DictList.value.find(item => item.id === activeIndex.value)
                currentCode.value = currentDict.code;
                dictvalueQuery(currentDict.code);
            }
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
/** 新增/编辑字典 */
function openDialog(type: string, id?: number) {
    dialog.visible = true;
    dialog.type = type;
    console.log("id", id);
    if (dialog.type === "dict-value-form") {
        // 字典值表单弹窗
        if (id) {
            dialog.title = "修改字典值";
            // 根据id获取data
            getDictFormData(id).then(({ data }) => {
                console.log(data);
                Object.assign(dictValueform, { ...data });
                dictValueform.id = id;
            });
        } else {
            dialog.title = "新增字典值";
            dictRef.value?.resetFields();
            dictValueform.typeCode = currentCode.value;
        }
    } else if (dialog.type === "dict-list-form") {
        //
        if (id) {
            dialog.title = "修改列表";
            getDictTypeForm(id).then(({ data }) => {
                Object.assign(dictTypeForm, { ...data });
                dictTypeForm.id = id;
            });
        } else {
            dictRef.value?.resetFields();
            dialog.title = "新增列表";
        }
    }
}
function submitDict(type: string) {
    /** false是列表新增 true是值新增 */
    dialog.type = type;
    if (dialog.type === "dict-value-form") {
        if (dictValueform.id === undefined) {
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
            const id = dictValueform.id;
            updateDict(id, dictValueform).then(({ data }) => {
                if (data > 0) {
                    ElMessage.success("修改成功");
                    closeDialog();
                    handleQuery();
                }
            });
        }
    } else {
        if (dictTypeForm.id === undefined) {
            console.log("新增");
            addDictType(dictTypeForm).then(({ data }) => {
                if (data > 0) {
                    ElMessage.success("新增字典列表成功");
                    closeDialog();
                    handleQuery();
                } else {
                    // 失败
                }
            });
        } else {
            const id = dictTypeForm.id;
            updateDictType(id, dictTypeForm).then(({ data }) => {
                if (data > 0) {
                    ElMessage.success("修改成功");
                    closeDialog();
                    handleQuery();
                } else {
                    ElMessage.error(data);
                }
            });
        }
    }
}
/** 删除字典/字典值 */
function handleDelete(type: string, id: string) {
    if (type === "type") {
        deleteDictTypes(id).then(({ data }) => {
            if (data > 0) {
                ElMessage.success("删除成功");
                handleQuery();
            }
        });
    } else {
        deleteDict(id).then(({ data }) => {
            if (data > 0) {
                ElMessage.success("删除成功");
                handleQuery();
            }
        });
    }
}
function closeDialog() {
    dialog.visible = false;
    dictRef.value?.resetFields();
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
