import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)
import Layout from '../views/layout/Layout'

Vue.use(Router)

export const constantRouterMap = [
  {path: '/login', component: () => import('@/views/login/index'), hidden: true},
  {path: '/404', component: () => import('@/views/404'), hidden: true},
  {
    path: '',
    component: Layout,
    redirect: '/home',
    children: [{
      path: 'home',
      name: 'home',
      component: () => import('@/views/home/index'),
      meta: {title: '首页', icon: 'home'}
    }]
  }
]

export const asyncRouterMap = [
  {
    path:'/admin',
    component: Layout,
    redirect: '/admin/user',
    name: 'admin',
    meta: {title: '用户中心', icon: 'admin'},
    children: [
      {
        path: 'user',
        name: 'user',
        component: () => import('@/views/admin/user/index'),
        meta: {title: '用户管理', icon: 'admin-user'}
      },
      {
        path: 'role',
        name: 'role',
        component: () => import('@/views/admin/role/index'),
        meta: {title: '角色管理', icon: 'admin-role'}
      }
    ]
  },
  {path: '*', redirect: '/404', hidden: true}
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})

