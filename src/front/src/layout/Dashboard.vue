<template>
  <div class="wrapper">
    <side-bar>
      <sidebar-link to="/admin/users">
        <i class="nc-icon nc-chart-pie-35"></i>
        <p>Users</p>
      </sidebar-link>
      <sidebar-link to="/entities">
        <i class="nc-icon nc-chart-pie-35"></i>
        <p>Entidades</p>
      </sidebar-link>
    </side-bar>
    <div class="main-panel">
      <top-navbar></top-navbar>
      <dashboard-content @click="toggleSidebar"></dashboard-content>
      <content-footer></content-footer>
    </div>
  </div>
</template>
<style lang="scss">

</style>
<script>
  import TopNavbar from './TopNavbar.vue'
  import ContentFooter from './ContentFooter.vue'
   import DashboardContent from './Content.vue'
  // import MobileMenu from './MobileMenu.vue'
  export default {
    components: {
      TopNavbar,
      ContentFooter,
      DashboardContent,
      // MobileMenu
    },
    methods: {
      toggleSidebar () {
        if (this.$sidebar.showSidebar) {
          this.$sidebar.displaySidebar(false)
        }
      }
    }
  }

</script>
