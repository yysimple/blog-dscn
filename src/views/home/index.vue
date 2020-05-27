<template>

    <a-layout>
        <my-header></my-header>
        <div class="home-container">
            <a-layout>
                <my-slider></my-slider>
                <a-layout-content>
                    <router-view></router-view>
                </a-layout-content>
            </a-layout>
        </div>
        <my-footer></my-footer>

    </a-layout>

</template>

<script>

    import MyFooter from "@/views/home/components/footer/index";
    import MySlider from "@/views/home/components/slider/index";
    import MyHeader from "@/views/home/components/header/index";

    export default {
        name: "index",
        components: {
            MyHeader,
            MySlider,
            MyFooter
        }
    }
</script>

<style scoped>
    .home-container {
        width: 60%;
        height: 100%;
        margin: auto;
    }
</style>
