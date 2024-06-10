<template>
    <!--    单级菜单-->
    <div v-if="!data.meta.hidden">
        <el-menu-item
            v-if="data.children == null || data.children.length == 0"
            :key="data.path"
            :index="data.path"
        >
            <el-icon>
                <!-- <component :is="getString(data.meta.icon)"></component> -->
                <svg-icon :icon-class="data.meta.icon" />
            </el-icon>

            <!-- 文字过长，显示省略号，鼠标悬停显示全文 -->
            <span
                style="
                    display: block;
                    width: 90%;
                    overflow: hidden;
                    white-space: nowrap;
                    text-overflow: ellipsis;
                "
                :title="data.meta.title"
                >{{ data.meta.title }}</span
            >
        </el-menu-item>

        <!-- 多级-->
        <el-sub-menu
            v-else
            :index="data.redirect != null ? data.path : data.redirect"
        >
            <template #title>
                <el-icon>
                    <!-- <component :is="getString(data.meta.icon)"></component> -->
                    <svg-icon :icon-class="data.meta.icon" />
                </el-icon>
                <span
                    style="
                        display: block;
                        width: 90%;
                        overflow: hidden;
                        white-space: nowrap;
                        text-overflow: ellipsis;
                    "
                    :title="data.meta.title"
                    >{{ data.meta.title }}</span
                >
            </template>
            <menus
                v-for="(item, index) in data.children"
                :key="index"
                :data="item"
            ></menus>
        </el-sub-menu>
    </div>
</template>
<script setup lang="ts">
const dataList = defineProps(["data"]);
let data = dataList.data;

// function getString(icon: string): MenuIcon {
//     console.log("icon是:", icon);
//     return MenuIcon[icon];
// }
</script>
<style scoped lang="scss">
/*
设置item高度
*/
.el-menu-item {
    height: 40px !important;
    line-height: 40px !important;
}
/*
设置菜单处背景色
*/
.el-menu--inline .el-menu-item {
    background-color: #000c17 !important;
}
.el-menu-item .el-icon {
    /* 选中背景色图标两边加间距 */
}
/* 父菜单鼠标悬浮颜色设置 */
:deep(.el-sub-menu__title:hover) {
    color: #fff !important;
    font-weight: bold;
}

/*
子菜单鼠标悬浮颜色设置
*/
.el-menu .el-menu-item:hover {
    color: #fff;
    font-weight: bold;
}
/*
设置选中背景色和字体颜色
*/
.el-menu-item.is-active {
    background-color: #40a9ff !important;
    border-radius: 5px !important;
    /* 选中背景色图标两边加间距 */
    color: #fff;
}
/* 修改选中菜单背景色图标左间距 */
.el-menu-item.is-active .el-icon {
    margin-left: 0px;
}
.el-sub-menu .el-icon {
    /* 选中背景色图标两边加间距 */
}
</style>
