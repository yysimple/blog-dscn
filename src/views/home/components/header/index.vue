<template>
    <a-layout-header class="dscn-toolbar" :style="{ position: 'fixed', zIndex: 1, width: '100%', background: '#fff' }">
        <div class="dscn-container">
            <div class="header-logo">
                <span class="header-logo-D"><i>D</i></span><i>SCN</i>
            </div>
            <div class="ul-div">
                <ul class="dscn-toolbar-list">
                    <li>博客</li>
                    <li>下载</li>
                    <li>论坛</li>
                    <li>问答</li>
                    <li>APP</li>
                </ul>
            </div>
            <div class="search-div">
                <a-input-search class="input-search" placeholder="search blog" style="width: 200px" @search="onSearch"/>
                <a-button class="search-create-btn" type="danger">创作中心</a-button>
                <a-icon class="icon-star" type="star" theme="filled"/>
                <a-icon type="bell" class="icon-message" theme="filled"/>
                <div class="avatar">
                    <img src="">
                </div>
            </div>
        </div>
    </a-layout-header>
</template>

<script>
    export default {
        name: "my-header",
        data() {
            return {};
        },
        methods: {
            onSearch() {

            }
        }
    }
</script>

<style scoped>
    .dscn-toolbar {
        font-size: .75em;
        color: #333;
        line-height: 1.5em;
        background: #fff;
        box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .05);
        min-width: 1200px;
        width: 100%;
        padding: 0;
        box-sizing: border-box;
        -moz-box-sizing: border-box;
        -webkit-box-sizing: border-box;
    }

    .dscn-container {
        width: 62%;
        margin: auto;
    }

    .header-logo {
        color: black;
        float: left;
        margin-left: 10px;
        line-height: 64px;
        font-size: 24px;
        font-weight: bold;
        font-family: 隶书;

    }

    .header-logo-D {
        color: red;
    }

    .dscn-toolbar-list {
        height: 64px;
        padding: 0;
        float: left;
        display: inline-block;
        font-size: 14px;
        margin-left: 50px;
    }

    .dscn-toolbar-list li {
        display: inline-block;
        margin-left: 10px;
        width: 64px;
        height: 64px;
        line-height: 64px;
    }

    li:hover {
        background: darkgrey;
    }

    .search-div {
        float: right;
    }

    .input-search {
        margin-left: 0;
        margin-top: 15px;
    }

    .search-create-btn {
        margin-top: 15px;
        margin-left: 10px;
    }

    .icon-star {
        font-size: 18px;
        margin-left: 15px;
        color: darkgrey;
    }

    .icon-message {
        font-size: 18px;
        margin-left: 20px;
        color: darkgrey;
    }

    .avatar {
        float: right;
        margin-top: 10px;
        width: 40px;
        height: 40px;
        background: #2c3e50;
        margin-left: 15px;
        border-radius: 50%;
    }
</style>
