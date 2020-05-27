import Vue from 'vue'
import App from './App.vue'
import 'ant-design-vue/dist/antd.css';
import Antd from 'ant-design-vue';
import {blogRouters} from './router/index'
import Router from 'vue-router';

Vue.use(Router)
Vue.config.productionTip = false
Vue.use(Antd);

new Vue({
    render: h => h(App),
    router: blogRouters,
}).$mount('#app')
