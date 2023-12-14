import {createRouter, createWebHistory} from 'vue-router'
import LoginView from "@/views/LoginView.vue";
import IndexView from "@/views/IndexView.vue";
import {useUserStore} from "@/stores/user";
import {getUserBySession} from "@/apis/user";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            redirect: '/home'
        },
        {
            path: '/login',
            name: 'Login',
            component: LoginView,
            meta: {
                title: '登录',
                requireAuth: false
            }
        },
        {
            path: '/index',
            name: 'Index',
            component: IndexView,
            children: [
                {
                    path: '/home',
                    name: 'Home',
                    component: () => import('@/views/HomeView.vue'),
                    meta: {
                        title: '主页',
                        requireAuth: true
                    }
                },
            ]
        },
    ]
})

router.beforeEach((to, from) => {
    const user = useUserStore()

    getUserBySession().then(data => {
        console.log(data)
        user.$patch({
            name: data.name,
            permissions: data.permissions
        })
    })
})

export default router
