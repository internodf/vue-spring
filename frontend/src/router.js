import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

// ===================== Pages Components ======================
import Navbar from './components/Navbar'
import MainPanel from './components/Main-panel'

// ==================== Router registration ====================
export default new Router({
  mode: 'hash',
  routes: [
    { path: '/', component: MainPanel },
  ]
})
