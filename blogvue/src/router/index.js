import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/Login'
import Home from '@/components/Home'
import Register from '@/components/Register'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: '登录',
      component: login
    },
    {
      path:'/register',
      name: '注册',
      component: Register
    },
    {
      path: '/home',
      name: '',
      component: Home,
      // hidden: true
    },
  ]
})
