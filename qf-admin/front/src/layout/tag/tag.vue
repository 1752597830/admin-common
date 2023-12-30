<template>
    <div style="border-bottom: 2px solid rgb(244, 239, 239); padding: 5px">
        <el-tag
            v-for="(tag, index) in dynamicTags"
            :key="tag"
            class="mx-1"
            :closable="index == 0 ? false : true"
            @close="handleClose(tag)"
            @click=""
        >
            {{ tag }}
        </el-tag>
    </div>
</template>

<script lang="ts" setup>
import { ref } from "vue";
const dynamicTags = ref(["Tag 1", "Tag 2", "Tag 3"]);
const handleClose = (tag: string) => {
    
    dynamicTags.value.splice(dynamicTags.value.indexOf(tag), 1);
    console.log("dynamicTags:",dynamicTags.value.length)
};
</script>
<style scoped lang="scss">
.mx-1 {
    margin: 5px;
}
</style>
