<template>
    <div class="flex justify-between">
        <div
            style="background-color: white; padding: 20px; margin-bottom: 10px"
        >
            <el-form ref="queryFormRef" :inline="true" :model="queryParams">
                <el-form-item
                    label="角色名称："
                    class="form-label"
                    prop="username"
                >
                    <el-input
                        v-model="queryParams.name"
                        placeholder="请输入角色名称"
                        clearable
                        style="width: 160px"
                    />
                </el-form-item>
                <el-form-item
                    label="角色标识："
                    class="form-label"
                    prop="username"
                >
                    <el-input
                        v-model="queryParams.code"
                        placeholder="请输入角色标识"
                        clearable
                        style="width: 160px"
                    />
                </el-form-item>
                <el-form-item label="状态：" class="form-label" prop="status">
                    <el-select
                        v-model="queryParams.status"
                        placeholder="请选择"
                        clearable
                        style="width: 160px"
                    >
                        <el-option label="已开启" value="1" />
                        <el-option label="已关闭" value="0" />
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button
                        type="primary"
                        :loading="loading"
                        @click="onSearch"
                        v-hasPerm="['sys:user:list']"
                    >
                        搜索
                    </el-button>
                    <el-button @click="resetQuery"> 重置 </el-button>
                </el-form-item>
            </el-form>
        </div>
        <div style="background-color: white; padding: 20px">
            <div style="padding-bottom: 20px">
                <el-button
                    type="primary"
                    v-hasPerm="['sys:user:add']"
                    @click="openDialog()"
                    >新增角色</el-button
                >
            </div>
            <el-table
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

                        <el-button
                            v-hasPerm="['sys:user:edit']"
                            type="primary"
                            link
                            size="small"
                            @click="openDialog(scope.row.id)"
                            ><i-ep-menu />菜单权限</el-button
                        >
                        <el-popconfirm
                            :title="
                                '是否确认删除角色名称为' +
                                scope.row.name +
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
            </div>
            <!-- 弹窗 -->
            <el-dialog
                v-model="dialog.visible"
                :title="dialog.title"
                append-to-body
                @close="closeDialog"
                align-center
                style="border-radius: 8px"
                width="400px"
            >
                <div style="display: flex; justify-content: center">
                    <!-- 角色新增/编辑表单 -->
                    <el-form
                        ref="roleFormRef"
                        :model="formData"
                        :rules="rules"
                        label-width="80px"
                        label-position="right"
                    >
                        <el-form-item
                            label="角色名称"
                            class="form-label"
                            prop="name"
                        >
                            <el-input
                                v-model="formData.name"
                                placeholder="请输入角色名称"
                            />
                        </el-form-item>
                        <el-form-item
                            label="用户标识"
                            class="form-label"
                            prop="code"
                        >
                            <el-input
                                v-model="formData.code"
                                placeholder="请输入角色标识"
                            />
                        </el-form-item>
                        <el-form-item
                            label="备注"
                            class="form-label"
                            prop="remark"
                        >
                            <el-input
                                v-model="formData.remark"
                                type="textarea"
                                placeholder="请输入备注信息"
                                autosize
                                maxlength="60"
                            />
                        </el-form-item>
                    </el-form>
                </div>
                <!-- 弹窗底部操作按钮 -->
                <template #footer>
                    <div class="dialog-footer">
                        <el-button type="primary" @click="handleSubmit"
                            >确 定</el-button
                        >
                        <el-button @click="closeDialog">取 消</el-button>
                    </div>
                </template>
            </el-dialog>
        </div>
    </div>
</template>
<script setup lang="ts">
import { getRolePage, getRoleForm, deleteRoles,updateRole,addRole } from "@/api/role";
import { RolePageVO, RoleForm, RoleQuery } from "@/api/role/types";

defineOptions({
    name: "Role",
    inheritAttrs: false,
});
const queryFormRef = ref(ElForm); // 查询表单
const roleFormRef = ref(ElForm); // 用户表单
const loading = ref(false);
const total = ref(0);
const queryParams = reactive<RoleQuery>({
    pageNum: 1,
    pageSize: 10,
});
const roleList = ref<RolePageVO[]>(); // 角色下拉数据源
// 弹窗对象
const dialog = reactive({
    title: "",
    visible: false,
});

const formData = reactive<RoleForm>({
    sort: 1,
    status: 1,
    code: "",
    name: "",
    remark: "",
});
// 校验规则
const rules = reactive({
    name: [{ required: true, message: "请输入角色名称", trigger: "blur" }],
    code: [{ required: true, message: "请输入角色编码", trigger: "blur" }],
    status: [{ required: true, message: "请选择状态", trigger: "blur" }],
});
/** 查询 */
function handleQuery() {
    loading.value = true;
    getRolePage(queryParams)
        .then(({ data }) => {
            roleList.value = data.list;
            total.value = data.total;
        })
        .finally(() => {
            loading.value = false;
        });
}
function onSearch() {
    handleQuery();
}
/** 重置查询 */
function resetQuery() {
    queryFormRef.value.resetFields();
    queryParams.pageNum = 1;
    handleQuery();
}

/** 打开角色表单弹窗 */
function openDialog(roleId?: number) {
    dialog.visible = true;
    if (roleId) {
        dialog.title = "修改角色";
        getRoleForm(roleId).then(({ data }) => {
            Object.assign(formData, data);
        });
    } else {
        dialog.title = "新增角色";
    }
}
/** 关闭表单弹窗 */
function closeDialog() {
    dialog.visible = false;
    resetForm();
}

/** 重置表单 */
function resetForm() {
    roleFormRef.value.resetFields();
    roleFormRef.value.clearValidate();

    formData.id = undefined;
    formData.sort = 1;
    formData.status = 1;
}
/** 删除角色 */
function handleDelete(id: string) {
    deleteRoles(id).then(() => {
        ElMessage(`已成功删除角色编号为 ${id} 的数据`);
        resetQuery();
    });
}
/** 提交表单 */
function handleSubmit() {
    roleFormRef.value.validate((valid: any) => {
            if (valid) {
                const roleId = formData.id;
                loading.value = true;
                if (roleId) {
                    updateRole(roleId, formData)
                        .then(() => {
                            ElMessage.success("修改角色成功");
                            closeDialog();
                            resetQuery();
                        })
                        .finally(() => (loading.value = false));
                } else {
                    addRole(formData)
                        .then(() => {
                            ElMessage.success("新增角色成功");
                            closeDialog();
                            resetQuery();
                        })
                        .finally(() => (loading.value = false));
                }
            }
        });
}
onMounted(() => {
    handleQuery();
});
</script>
<style lang="scss" scoped>
.form-label {
    font-weight: 900;
    color: #333333;
    max-width: 300px;
}

:deep(.el-dropdown-menu__item i) {
    margin: 0;
}

:deep(.el-button:focus-visible) {
    outline: none;
}

.search-form {
    :deep(.el-form-item) {
        margin-bottom: 12px;
    }
}
.buttonClass {
    color: gray;
}
</style>
