import Login from "./../layout/Login.vue"
import Dashboard from "./../layout/Dashboard.vue"
import UserList from "./../layout/UserList.vue"

// GeneralViews
import NotFound from './../pages/NotFound.vue'

const routes = [
  {
    path: '/',
    name: 'login',
    component: Login
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: { 
      guest: true
    }
  },
  {
    path: '/admin',
    component: Dashboard,
    redirect: '/admin/users',
    children: [
      {
        path: 'users',
        name: 'UserList',
        component: UserList
      }
    ]
  },
  {
    path: '/logout',
    name: 'logout',
    component: Login,
    meta: { 
      guest: true
    }
  },
// {
//     path: '/admin',
//     name: 'admin',
//     component: Admin,
//     meta: { 
//         requiresAuth: true,
//         is_admin : true
//     }
// },
  { path: '*', component: NotFound }
]

export default routes