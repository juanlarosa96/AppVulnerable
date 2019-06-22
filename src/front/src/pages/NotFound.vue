<template>
  <div class="contact-us">
    <nav class="navbar navbar-ct-default" role="navigation-demo">
      <div class="">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <img :src="`${publicPath}images/logo.png`" width="20px">
          <router-link :to="{path:'/'}" class="navbar-brand">DEMO-APP</router-link>
        </div>
      </div>
      <!-- /.container-->
    </nav>
    <div class="section content">
      <div class="">
        <div class="container">
          <div class="row">
            <div class="col-md-12 col-md-offset-2 text-center">
              <h2 class="title text-danger">404 Not Found</h2>
              <h2 class="title">Oops! It seems that this page does not exist.</h2>
              <b-button variant="primary" class="active mt-3">
                <router-link :to="{path:'/'}">Ir al Inicio</router-link>
              </b-button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <footer class="footer">
      <div class="container-fluid">
        <div class="copyright col-md-12 text-center ">
          &copy; 
          Grupo 2 - Seguridad en aplicaciones web 1C2019, UTN FRBA
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
  export default { 
    data() {
      return {
        publicPath: process.env.BASE_URL
      }
    }
  }

</script>

<style type="scss">
  .container {
    height: 83vh;
    padding-top: 25vh;
  }
  .active a {
    color: white;
  }
  .navbar-header img {
    margin-right: 10px;
    margin-top: -7px;
  }
  a.navbar-brand {
    color: black !important;
  }
</style>
