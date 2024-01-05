<template>
    <div class="flex justify-between">
        <div
            style="background-color: white; padding: 20px; margin-bottom: 10px"
        >
            <el-form ref="queryFormRef" :inline="true" :model="queryParams">
                <el-form-item
                    label="用户名称："
                    class="form-label"
                    prop="username"
                >
                    <el-input
                        v-model="queryParams.username"
                        placeholder="请输入用户名称"
                        clearable
                        style="width: 160px"
                    />
                </el-form-item>
                <el-form-item
                    label="手机号码："
                    class="form-label"
                    prop="phone"
                >
                    <el-input
                        v-model="queryParams.phone"
                        placeholder="请输入手机号码"
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
                    >
                        搜索
                    </el-button>
                    <el-button @click="resetQuery"> 重置 </el-button>
                </el-form-item>
            </el-form>
        </div>
        <div style="background-color: white; padding: 20px">
            <div style="padding-bottom: 20px;">
                <el-button type="primary" v-hasPerm="['sys:user:add']">新增用户</el-button>
            </div>
            <div
                v-if="selectedNum > 0"
                v-motion-fade
                style="
                    background-color: var(--el-fill-color-light);
                    width: calc(100%-60px);
                    height: 46px;
                    display: flex;
                    align-items: center;
                    padding-left: 20px;
                "
            >
                <div>
                    <span
                        style="
                            font-size: var(--el-font-size-base);
                            color: rgba(42, 46, 54, 0.5);
                        "
                    >
                        已选 {{ selectedNum }} 项
                    </span>
                    <el-button type="primary" text @click="onSelectionCancel">
                        取消选择
                    </el-button>
                </div>
                <el-popconfirm title="是否确认删除?" @confirm="onbatchDel">
                    <template #reference>
                        <el-button
                            type="danger"
                            text
                            style="position: absolute; right: 40px"
                            v-hasPerm="['sys:user:add']"
                        >
                            批量删除
                        </el-button>
                    </template>
                </el-popconfirm>
            </div>
            <el-table
                v-loading="loading"
                :data="pageData"
                ref="tableRef"
                :header-cell-style="{
                    color: '#333333',
                    fontWeight: 900,
                    backgroundColor: 'var(--el-fill-color-light)',
                }"
                @selection-change="handleSelectionChange"
            >
                <el-table-column
                    type="selection"
                    fixed="left"
                    width="50"
                    align="center"
                />
                <el-table-column
                    key="id"
                    label="编号"
                    align="center"
                    prop="id"
                    width="80"
                />
                <el-table-column
                    key="avatar"
                    label="头像"
                    align="center"
                    width="120"
                >
                    <template #default="scope">
                        <el-avatar :size="40" :src="scope.row.avatar" />
                    </template>
                </el-table-column>
                <el-table-column
                    key="username"
                    label="用户名"
                    align="center"
                    prop="username"
                    mix-width="100"
                />
                <el-table-column
                    label="用户昵称"
                    min-width="100"
                    align="center"
                    prop="nickname"
                />

                <el-table-column label="性别" align="center" prop="gender">
                    <template #default="scope">
                        <el-tag v-if="scope.row.gender === '男'" color="white"
                            >{{ scope.row.gender }}
                        </el-tag>
                        <el-tag v-else type="danger" color="white"
                            >{{ scope.row.gender }}
                        </el-tag>
                    </template>
                </el-table-column>
                <el-table-column
                    label="手机号码"
                    align="center"
                    prop="mobile"
                    mix-width="120"
                />
                <el-table-column
                    label="邮箱"
                    align="center"
                    prop="mobile"
                    mix-width="120"
                />

                <el-table-column label="状态" align="center" prop="status">
                    <template #default="scope">
                        <el-switch
                            v-model="scope.row.status"
                            active-value="1"
                            inactive-value="2"
                            inline-prompt
                            active-text="已启用"
                            inactive-text="已禁用"
                        />
                    </template>
                </el-table-column>
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
                            v-hasPerm="['sys:user:reset_pwd']"
                            type="primary"
                            size="small"
                            link
                            @click="resetPassword(scope.row)"
                            ><i-ep-refresh-left />重置密码</el-button
                        >
                        <el-button
                            v-hasPerm="['sys:user:edit']"
                            type="primary"
                            link
                            size="small"
                            @click="openDialog('user-form', scope.row.id)"
                            ><i-ep-edit />编辑</el-button
                        >
                        <el-button
                            v-hasPerm="['sys:user:delete']"
                            type="primary"
                            link
                            size="small"
                            @click="handleDelete(scope.row.id)"
                            ><i-ep-delete />删除</el-button
                        >
                    </template>
                </el-table-column>
            </el-table>
            <div style="padding-top: 30px;display: flex;justify-content: center;">
                <el-pagination
                v-if="total > 0"
                v-model:total="total"
                v-model:page="queryParams.pageNum"
                v-model:limit="queryParams.pageSize"
                layout="total,prev,pager,next,jumper"
                @pagination="handleQuery"
            />
            </div>
        </div>
    </div>
</template>
<script setup lang="ts">
import {
    getUserPage,
    getUserForm,
    deleteUsers,
    addUser,
    updateUser,
    updateUserPassword,
} from "@/api/user";
import { UserForm, UserQuery, UserPageVO } from "@/api/user/types";
const queryFormRef = ref(ElForm); // 查询表单
const userFormRef = ref(ElForm); // 用户表单
const removeIds = ref([]); // 删除用户ID集合 用于批量删除
const queryParams = reactive<UserQuery>({
    pageNum: 1,
    pageSize: 10,
});
const dateTimeRange = ref("");
const total = ref(0); // 数据总数
const pageData = ref<UserPageVO[]>(); // 用户分页数据
const roleList = ref<OptionType[]>(); // 角色下拉数据源

watch(dateTimeRange, (newVal) => {
    if (newVal) {
        queryParams.startTime = newVal[0];
        queryParams.endTime = newVal[1];
    }
});
const loading = ref(false);
const tableRef = ref();
const selectedNum = ref(0);
/** 查询 */
function handleQuery() {
    loading.value = true;
    getUserPage(queryParams)
        .then(({ data }) => {
            pageData.value = data.list;
            total.value = data.total;
        })
        .finally(() => {
            loading.value = false;
        });
}
function onSearch() {
    loading.value = true;
}
/** 重置查询 */
function resetQuery() {
    queryFormRef.value.resetFields();
    dateTimeRange.value = "";
    queryParams.pageNum = 1;
    queryParams.startTime = undefined;
    queryParams.endTime = undefined;
    handleQuery();
}
/** 取消选择 */
function onSelectionCancel() {
    selectedNum.value = 0;
    // 用于多选表格，清空用户的选择
    // queryFormRef.value
    tableRef.value.clearSelection();
}
/** 当CheckBox选择项发生变化时会触发该事件 val是表格属性 */
function handleSelectionChange(val: UserPageVO[]) {
    console.log("val: ", val);
    selectedNum.value = val.length;
    // 给选中数据赋值
    tableRef.value = val;
}
/** 批量删除 */
function onbatchDel() {
    // 返回当前选中的行
    console.log("清空之前：", tableRef.value.getSelectionRows());
    // const curSelected = tableRef.value.getTableRef().getSelectionRows();
    // 接下来根据实际业务，通过选中行的某项数据，比如下面的id，调用接口进行批量删除
    // ElMessage(`已删除用户编号为 ${getKeyList(curSelected, "id")} 的数据`)
    // tableRef.value.clearSelection();
}
/** 删除用户 */
function handleDelete(id?: number) {
    const userIds = [id || removeIds.value].join(",");
    if (!userIds) {
        ElMessage.warning("请勾选删除项");
        return;
    }
    ElMessageBox.confirm("确认删除用户?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
    }).then(function () {
        deleteUsers(userIds).then(() => {
            ElMessage.success("删除成功");
            resetQuery();
        });
    });
}
declare function getKeyList(arr: any, key: string): any[];
onMounted(() => {
    handleQuery();
});
</script>
<style lang="scss" scoped>
.form-label {
    font-weight: 900;
    color: #333333;
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
</style>
