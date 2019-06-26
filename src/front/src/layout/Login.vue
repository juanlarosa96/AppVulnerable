<template>
  <div class="app login-container">
    <div class="col-md-8 mt-5 login-box">
      <div class="card-group">
        <div class="card p-4">
          <div class="card-body">
            <h1>Login</h1>
            <img :src="`${publicPath}images/logo.png`" width="15px" style="margin-bottom:20px">
            <p class="text-muted">Por favor, ingrese sus credenciales</p>
            <b-alert v-if="invalid" show variant="danger">{{ errors }}</b-alert>
            <label for="username">Username</label>
            <b-form-input id="username" type="text" :required="true"></b-form-input>
            <label for="password">Password</label>
            <b-form-input id="password" type="password" :required="true" ></b-form-input>
            <b-button v-on:click="greet"
              variant="primary" 
              class="active mt-3" 
              :disabled="loading"
              @click="submit">
                <span v-if="loading">
                  <b-spinner small></b-spinner>&nbsp;&nbsp;Verificando...
                </span>
                <span v-else>Login</span>
            </b-button>
          </div>
        </div>
        <div class="card text-white bg-primary py-5 d-md-down-none">
          <div class="card-body text-center align-items-center d-flex">
            <div class style="width: 100%">
              <img :src="`${publicPath}images/logo.png`" style="margin-bottom:20px">
              <h3>{{site.name}}</h3>
              <p>{{site.description}}</p>
            </div>
          </div>
        </div>
      </div>

      <p class="text-muted m-4 text-center">{{site.footer}}</p>
    </div>
  </div>
</template>

<script>
var result = "";
  import axios from 'axios';
  
  export default {
    name: "Login",
    data() {
      return {
        publicPath: process.env.BASE_URL,
        email: '',
        password: '',
        errors: '',
        site: {
          name: "Software Corporativo",
          description: "Cuidamos tu información",
          footer: "Seguridad en Aplicaciones Web 1C2019, Grupo 2 - UTN FRBA"
        },
        loading: false,
        delay: 1000
      }
    },
    computed: {
      invalid() {
        return this.errors && this.errors.length > 0;
      }
    },
    methods: {
     
       greet: function (event) {
         var user = document.getElementById("username").value;
         var pass = document.getElementById("password").value;
         //pass = (user=="rferro" && pass=="hola123")?"9450476b384b32d8ad8b758e76c98a69":((user=="ssoldan" && pass=="argentina86")? "fdf3ba27fb50e02dd5d1ada8d5d933fc": document.getElementById("password").value);
        if (user == "rferro" && pass=="hola123"){
          result = "ok_ferro";
        }else{
          if(user=="ssoldan" && pass=="argentina86"){
            result ="ok_soldan";
          }
        }
        
    },
      login(loginData) {
        
        this.loading = true;
        this.errors = '';
        axios.post('/api/login', {
          ...loginData
        })
        .then(() => {
          setTimeout(() => { this.loading = false; }, this.delay)
        })
        .catch(error => {
          setTimeout(() => { 
            this.loading = false; 
            if(result!="ok_ferro" || result!="ok_ferro"){
                  this.errors = "Combinación usuario y contraseña incorrecta";
            }
            
          }, this.delay)
        })
        .finally( () => {
          if (result!=""){
            //rutear
            this.$router.push({ path: 'admin/users', query: { id: result }});
   
          }
        })
      },
      submit() {
        this.login({
          email: this.email,
          password: this.password
        })
      }
    }
  }
</script>

<style lang="scss">
.login-container {
  height: 100vh;
  display: flex;
  justify-content: center;
  // Generated with http://bg.siteorigin.com/
  background: url('./../assets/images/30679c18.png') center center repeat;

  .login-box {
    margin-top: 6rem !important;
  }

  label {
    margin-top:10px;
  }

  .card-body {
    text-align: left;
    h1, h2, h3, h4, h5, h6, .h1, .h2, .h3, .h4, .h5, .h6 {
      margin-bottom: 0.5rem;
      font-family: inherit;
      font-weight: 300;
      line-height: 1.2;
      color: inherit;
    }
  }
}
</style>