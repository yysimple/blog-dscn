<template>
    <a-layout-sider class="slider-container" v-model="collapsed" :trigger="null" collapsible style="
  flex: 0 0 100px; max-width: 100px; min-width: 100px; margin-top: 74px;">
        <!--<a-menu class="tag-menu" theme="white" mode="inline" :default-selected-keys="['1']" v-for="blogTag in blogTags" :key="blogTag.id">
            <a-menu-item class="tag-menu-item" :key="blogTag.id">
                <span>{{ blogTag.tagName }}</span>
            </a-menu-item>
        </a-menu>-->
        <div class="blog-tag-container">
            <ul v-for="blogTag in blogTags" :key="blogTag.id">
                <li>{{blogTag.tagName}}</li>
            </ul>
        </div>
    </a-layout-sider>
</template>

<script>
    import {findAllBlogTags} from '@/api/blog/blogTag'

    export default {
        name: "my-slider",
        data() {
            return {
                blogTags: []
            }
        },
        methods: {
            async initBlogTags() {
                const data = await findAllBlogTags();
                this.blogTags = data
            }
        },
        created() {
            this.initBlogTags();
        }
    }
</script>

<style scoped>
    .slider-container {
        margin: 8px;
        width: 100px;
    }

    .ant-layout-sider {
        width: 100px;
        background: white;
    }

    .ant-layout-sider-children {
        margin-top: 10px;
    }

    .blog-tag-container ul li {

    }

    ul{
        width: 100px;
        display: inline-block;
        padding: 0;
        margin-top:5px;
        margin-bottom: 0;
    }
    li {
        width: 100px;
        height: 32px;
        list-style: none;
        text-align: center;
        line-height: 32px;
    }
    li:hover{
        background: red;
    }
</style>
