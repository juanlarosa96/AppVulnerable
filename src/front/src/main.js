import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import BootstrapVue from 'bootstrap-vue'

import SideBar from './components/SidebarPlugin'

// app.js
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// Cosmo them from https://bootswatch.com/
import './assets/css/bootstrap.min.css'

import './assets/sass/light-bootstrap-dashboard.scss'
import './assets/css/demo.css'

// router setup
import routes from './routes/routes'

Vue.use(BootstrapVue)
Vue.use(VueRouter)
Vue.use(SideBar)
Vue.config.productionTip = false

// configure router
const router = new VueRouter({
  routes, // short for routes: routes
  linkActiveClass: 'nav-item active',
  scrollBehavior: (to) => {
    if (to.hash) {
      return {selector: to.hash}
    } else {
      return { x: 0, y: 0 }
    }
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router
})
