<template>
    <div class="tags-container">
        <scroll-pane ref="scrollPaneRef" @scroll="handleScroll">
            <router-link
                ref="tagRef"
                v-for="tag in visitedViews"
                :key="tag.path"
                :class="'tags-item ' + (isActive(tag) ? 'active' : '')"
                :data-path="tag.path"
                :to="{ path: tag.path, query: tag.query }"
                @click.middle="!isAffix(tag) ? closeSelectedTag(tag) : ''"
                @contextmenu.prevent="openTagMenu(tag)"
            >
                {{ tag.title }}
                <span
                    v-if="!isAffix(tag)"
                    @click.prevent.stop="closeSelectedTag(tag)"
                >
                    <el-icon :size="12">
                        <i-ep-close />
                    </el-icon>
                </span>
            </router-link>
        </scroll-pane>
    </div>
</template>

<script setup lang="ts">
import { storeToRefs } from "pinia";
import { useRoute, useRouter, RouteRecordRaw } from "vue-router";
import { usePermissionStore } from "@/store/modules/permission";
import { useTagsViewStore } from "@/store/modules/tagsView";
import ScrollPane from "./ScrollPane.vue";
const router = useRouter();
const route = useRoute();
const permissionStore = usePermissionStore();
const tagsViewStore = useTagsViewStore();
const { visitedViews } = storeToRefs(tagsViewStore);
import { resolve } from "path-browserify";
const selectedTag = ref<TagView>({
    path: "",
    fullPath: "",
    name: "",
    title: "",
});

const affixTags = ref<TagView[]>([]);
const scrollPaneRef = ref();

watch(
    route,
    () => {
        addTags();
        moveToCurrentTag();
    },
    {
        immediate: true, //初始化立即执行
    }
);

const tagMenuVisible = ref(false); // 标签操作菜单显示状态
watch(tagMenuVisible, (value) => {
    if (value) {
        document.body.addEventListener("click", closeTagMenu);
    } else {
        document.body.removeEventListener("click", closeTagMenu);
    }
});

function filterAffixTags(routes: RouteRecordRaw[], basePath = "/") {
    const processRoute = (route: RouteRecordRaw) => {
        const fullPath = resolve(basePath, route.path);

        const tag: TagView = {
            path: route.path,
            fullPath,
            name: String(route.name),
            title: route.meta?.title || "no-name",
            affix: route.meta?.affix,
            keepAlive: route.meta?.keepAlive,
        };

        if (tag.affix) {
            tags.push(tag);
        }

        if (route.children) {
            route.children.forEach(processRoute);
        }
    };

    let tags: TagView[] = [];
    routes.forEach(processRoute);

    return tags;
}

function initTags() {
    const tags: TagView[] = filterAffixTags(permissionStore.routes);
    affixTags.value = tags;
    for (const tag of tags) {
        // Must have tag name
        if (tag.name) {
            tagsViewStore.addVisitedView(tag);
        }
    }
}

function addTags() {
    console.log("addTags", visitedViews);
    if (route.meta.title) {
        tagsViewStore.addView({
            name: route.name as string,
            title: route.meta.title,
            path: route.path,
            fullPath: route.fullPath,
            affix: route.meta?.affix,
            keepAlive: route.meta?.keepAlive,
        });
    }
}

function moveToCurrentTag() {
    console.log("moveToCurrentTag", visitedViews);
    // 使用 nextTick() 的目的是确保在更新 tagsView 组件之前，scrollPaneRef 对象已经滚动到了正确的位置。
    nextTick(() => {
        for (const tag of visitedViews.value) {
            if (tag.path === route.path) {
                scrollPaneRef.value.moveToTarget(tag);
                // when query is different then update
                // route.query = { ...route.query, ...tag.query };
                if (tag.fullPath !== route.fullPath) {
                    tagsViewStore.updateVisitedView({
                        name: route.name as string,
                        title: route.meta.title || "",
                        path: route.path,
                        fullPath: route.fullPath,
                        affix: route.meta?.affix, // 是否显示关闭
                        keepAlive: route.meta?.keepAlive,
                    });
                }
            }
        }
    });
}

function isActive(tag: TagView) {
    return tag.fullPath === route.fullPath;
}

function isAffix(tag: TagView) {
    return tag?.affix;
}

function toLastView(visitedViews: TagView[], view?: TagView) {
    const latestView = visitedViews.slice(-1)[0];
    if (latestView && latestView.fullPath) {
        router.push(latestView.fullPath);
    } else {
        if (view?.name === "首页") {
            // to reload home page
            router.replace({ path: "/redirect" + view.fullPath });
        } else {
            router.push("/");
        }
    }
}

function closeSelectedTag(view: TagView) {
    tagsViewStore.delView(view).then((res: any) => {
        if (isActive(view)) {
            toLastView(res.visitedViews, view);
        }
    });
}

function openTagMenu(tag: TagView) {
    console.log("进行了跳转");
    tagMenuVisible.value = true;
    selectedTag.value = tag;
}

function closeTagMenu() {
    tagMenuVisible.value = false;
}

function handleScroll() {
    closeTagMenu();
}

// 如果是混合模式，更改selectedTag，需要对应高亮的activeTop
watch(
    () => route.name,
    (newVal) => {
        if (newVal) {
        }
    },
    {
        deep: true,
    }
);
onMounted(() => {
    initTags();
});
</script>

<style lang="scss" scoped>
.tags-container {
    width: auto;
    height: 34px;
    background-color: var(--el-bg-color);
    border: 1px solid var(--el-border-color-light);
    box-shadow: 0 1px 1px var(--el-box-shadow-light);

    .tags-item {
        display: inline-block;
        border-radius: 3px;
        padding: 3px 8px;
        margin: 4px 0 0 5px;
        font-size: 12px;
        cursor: pointer;
        border: 1px solid var(--el-border-color-light);
        color: black;
        &:first-of-type {
            margin-left: 15px;
        }

        &:last-of-type {
            margin-right: 15px;
        }

        &:hover {
            color: var(--el-color-primary);
        }

        &.active {
            color: #fff;
            background-color: #000000d4;
            border-color: var(--el-color-primary);

            &::before {
                display: inline-block;
                width: 8px;
                height: 8px;
                margin-right: 5px;
                content: "";
                background: #fff;
                border-radius: 50%;
            }
        }

        &-close {
            border-radius: 100%;

            &:hover {
                color: #fff;
                background: rgb(0 0 0 / 16%);
            }
        }
    }
}
a {
    text-decoration: none;
}
.tag-menu {
    position: absolute;
    z-index: 99;
    font-size: 12px;
    background: var(--el-bg-color-overlay);
    border-radius: 4px;
    box-shadow: var(--el-box-shadow-light);

    li {
        padding: 8px 16px;
        cursor: pointer;

        &:hover {
            background: var(--el-fill-color-light);
        }
    }
}
</style>
