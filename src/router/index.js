import Vue from 'vue'
import Router from 'vue-router';

Vue.use(Router)

export const blogRouters = new Router({
    routes: [
        {
            path: '/',
            component: () => import('@/views/home/index')
        }
    ]
})

