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
                    @click="openDialog('user-form')"
                    >新增用户</el-button
                >
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
                    prop="email"
                    mix-width="120"
                />

                <el-table-column label="状态" align="center" prop="status">
                    <template #default="scope">
                        <el-switch
                            disabled="false"
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
                            v-hasPerm="['sys:user:edit']"
                            type="primary"
                            link
                            size="small"
                            @click="openDialog('user-form', scope.row.id)"
                            ><i-ep-edit />编辑</el-button
                        >

                        <el-popconfirm
                            :title="
                                '是否确认删除用户编号为' +
                                scope.row.id +
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
                        <el-dropdown style="padding-left: 12px">
                            <el-button link type="primary">
                                <svg-icon icon-class="more" size="20px" />
                            </el-button>
                            <template #dropdown>
                                <el-dropdown-menu>
                                    <el-dropdown-item>
                                        <el-button
                                            class="buttonClass"
                                            link
                                            type="primary"
                                            @click="handleUpload(scope.row.id)"
                                        >
                                            <i-ep-upload />上传头像
                                        </el-button>
                                    </el-dropdown-item>
                                    <el-dropdown-item>
                                        <el-button
                                            class="buttonClass"
                                            link
                                            type="primary"
                                            @click="handleReset(scope.row)"
                                        >
                                            <i-ep-refresh-left />重置密码
                                        </el-button>
                                    </el-dropdown-item>
                                    <!-- <el-dropdown-item>
                                        <el-button
                                            class="buttonClass"
                                            link
                                            type="primary"
                                            @click="handleRole(scope.row.id)"
                                        >
                                            <i-ep-user />分配角色
                                        </el-button>
                                    </el-dropdown-item> -->
                                </el-dropdown-menu>
                            </template>
                        </el-dropdown>
                        <!-- <el-popconfirm
                            title="是否确认重置?"
                            @confirm="resetPassword(scope.row)"
                        >
                            <template #reference>
                                <el-button
                                    v-hasPerm="['sys:user:edit']"
                                    type="primary"
                                    size="small"
                                    link
                                    ><i-ep-refresh-left />重置密码</el-button
                                >
                            </template>
                        </el-popconfirm> -->
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
                width="600px"
            >
                <!-- 用户新增/编辑表单 -->
                <el-form
                    v-if="dialog.type === 'user-form'"
                    ref="userFormRef"
                    :model="formData"
                    :rules="rules"
                    label-width="80px"
                    label-position="right"
                >
                    <el-row>
                        <el-col :span="12">
                            <el-form-item
                                label="用户名称"
                                class="form-label"
                                prop="username"
                            >
                                <el-input
                                    v-model="formData.username"
                                    :readonly="!!formData.id"
                                    placeholder="请输入用户名"
                                />
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item
                                label="用户昵称"
                                class="form-label"
                                prop="nickname"
                            >
                                <el-input
                                    v-model="formData.nickname"
                                    placeholder="请输入用户昵称"
                                />
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item
                                label="性别"
                                class="form-label"
                                prop="gender"
                            >
                                <dictionary
                                    v-model="formData.gender"
                                    type-code="gender"
                                />
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item
                                label="角色"
                                class="form-label"
                                prop="roleIds"
                            >
                                <el-select
                                    v-model="formData.roleIds"
                                    multiple
                                    placeholder="请选择"
                                >
                                    <el-option
                                        v-for="item in roleList"
                                        :key="item.value"
                                        :label="item.label"
                                        :value="item.value"
                                    />
                                </el-select>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item
                                label="手机号码"
                                class="form-label"
                                prop="mobile"
                            >
                                <el-input
                                    v-model="formData.mobile"
                                    placeholder="请输入手机号码"
                                    maxlength="11"
                                />
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item
                                label="邮箱"
                                class="form-label"
                                prop="email"
                            >
                                <el-input
                                    v-model="formData.email"
                                    placeholder="请输入邮箱"
                                    maxlength="50"
                                />
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-form-item label="状态" class="form-label" prop="status">
                        <el-radio-group v-model="formData.status">
                            <el-radio :label="1">正常</el-radio>
                            <el-radio :label="0">禁用</el-radio>
                        </el-radio-group>
                    </el-form-item>
                </el-form>
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
import {
    getUserPage,
    getUserForm,
    deleteUsers,
    addUser,
    updateUser,
    updateUserPassword,
} from "@/api/user";
import { useThrottleFn } from "@vueuse/core";
import { getRoleOptions } from "@/api/role";
import { UserForm, UserQuery, UserPageVO } from "@/api/user/types";
const queryFormRef = ref(ElForm); // 查询表单
const userFormRef = ref(ElForm); // 用户表单
const removeIds = ref([]); // 删除用户ID集合 用于批量删除
const queryParams = reactive<UserQuery>({
    pageNum: 1,
    pageSize: 10,
});

// 弹窗对象
const dialog = reactive({
    visible: false,
    type: "user-form",
    width: 800,
    title: "",
});
// 用户表单数据
const formData = reactive<UserForm>({
    status: 1,
});
// 校验规则
const rules = reactive({
    username: [{ required: true, message: "用户名不能为空", trigger: "blur" }],
    nickname: [
        { required: true, message: "用户昵称不能为空", trigger: "blur" },
    ],
    roleIds: [{ required: true, message: "用户角色不能为空", trigger: "blur" }],
    email: [
        {
            pattern: /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/,
            message: "请输入正确的邮箱地址",
            trigger: "blur",
        },
    ],
    mobile: [
        {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur",
        },
    ],
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
/** 表单提交 */
const handleSubmit = useThrottleFn(() => {
    if (dialog.type === "user-form") {
        userFormRef.value.validate((valid: any) => {
            if (valid) {
                const userId = formData.id;
                loading.value = true;
                if (userId) {
                    updateUser(userId, formData)
                        .then(() => {
                            ElMessage.success("修改用户成功");
                            closeDialog();
                            resetQuery();
                        })
                        .finally(() => (loading.value = false));
                } else {
                    addUser(formData)
                        .then(() => {
                            ElMessage.success("新增用户成功");
                            closeDialog();
                            resetQuery();
                        })
                        .finally(() => (loading.value = false));
                }
            }
        });
    }
}, 3000);
/** 删除用户 */
function handleDelete(id?: number) {
    const userIds = [id || removeIds.value].join(",");
    if (!userIds) {
        ElMessage.warning("请勾选删除项");
        return;
    }
    deleteUsers(userIds).then(() => {
        ElMessage.success("删除成功");
        resetQuery();
    });
}
/** 加载角色下拉数据源 */
async function loadRoleOptions() {
    getRoleOptions().then((response) => {
        console.log("响应数据时：", response.data);
        roleList.value = response.data;
    });
}

/**
 * 打开弹窗
 *
 * @param type 弹窗类型  用户表单：user-form | 用户导入：user-import
 * @param id 用户ID
 */
async function openDialog(type: string, id?: number) {
    dialog.visible = true;
    dialog.type = type;

    if (dialog.type === "user-form") {
        // 用户表单弹窗
        await loadRoleOptions();
        if (id) {
            dialog.title = "修改用户";
            getUserForm(id).then(({ data }) => {
                Object.assign(formData, { ...data });
            });
        } else {
            dialog.title = "新增用户";
        }
    } else if (dialog.type === "user-import") {
        // 用户导入弹窗
        dialog.title = "导入用户";
        dialog.width = 600;
    }
}
/**
 * 关闭弹窗
 *
 * @param type 弹窗类型  用户表单：user-form | 用户导入：user-import
 */
function closeDialog() {
    dialog.visible = false;
    if (dialog.type === "user-form") {
        userFormRef.value.resetFields();
        userFormRef.value.clearValidate();
        formData.id = undefined;
        formData.status = 1;
    }
}
/** 上传头像 */
function handleUpload(id:number) {
    console.log('row数据时',id)
    // addDialog({
    //     title: "裁剪、上传头像",
    //     width: "40%",
    //     draggable: true,
    //     closeOnClickModal: false,
    //     contentRenderer: () =>
    //         h(croppingUpload, {
    //             imgSrc: row.avatar,
    //             onCropper: (info) => (avatarInfo.value = info),
    //         }),
    //     beforeSure: (done) => {
    //         console.log("裁剪后的图片信息：", avatarInfo.value);
    //         // 根据实际业务使用avatarInfo.value和row里的某些字段去调用上传头像接口即可
    //         done(); // 关闭弹框
    //         onSearch(); // 刷新表格数据
    //     },
    // });
}
/** 重置密码 */
function handleReset(row: { [key: string]: any }) {
  ElMessageBox.prompt(
    "请输入用户「" + row.username + "」的新密码",
    "重置密码",
    {
      confirmButtonText: "确定",
      cancelButtonText: "取消",
    }
  ).then(({ value }) => {
    if (!value) {
      ElMessage.warning("请输入新密码");
      return false;
    }
    updateUserPassword(row.id, value).then(() => {
      ElMessage.success("密码重置成功，新密码是：" + value);
    });
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
    max-width: 250px;
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
