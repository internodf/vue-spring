<template>
  <div>
    <div v-if="!loggedIn" class="card card-container">
      <p v-if="authFailed">Invalid Username and Password</p>
      <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
      <p id="profile-name" class="profile-name-card"></p>
      <form class="form-signin">{{user.username}} {{user.password}}
        <input v-model="user.username" type="text" name="username" class="form-control" placeholder="Username" required autofocus>
        <input v-model="user.password" type="password" name="password" class="form-control" placeholder="Password" required>
        <div id="remember" class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <a class="btn btn-primary btn-block" @click="login">Sign in</a>
        <a class="btn btn-danger btn-block" @click="googleUrl">Google +</a>

      </form><!-- /form -->
    </div>
    <div v-if="loggedIn">
      <h3>Welcome Back, {{user.username}}!</h3>
      <a class="btn btn-warning" @click="logout">Logout</a>
      <br><br>
      <div>
        <post-message></post-message>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
  import PostMessage from './Post-message'

  export default {
    components: {PostMessage},
    name: 'login',
    data() {
      return {
        logged: false,
        authFailed : false,
        user : {
          username : '',
          password : ''
        }
      }
    } ,
    created : function () {
      if (localStorage.getItem('loggedIn') && localStorage.getItem('username')) {
        this.user.username=localStorage.getItem('username');
        this.loggedIn=true;
      } else {
        this.loggedIn=false;
      }
    } ,
    methods : {
      login () {
        let url = "http://localhost:8081/login";
        let params = 'username='+this.user.username+'&password='+this.user.password;
        // let headers = new Headers(
        // {
        //   'Content-Type': 'application/x-www-form-urlencoded'
        // }); 
        // this.$http.options.xhr = {withCredentials : true};

          // send post request
          this.$http.post(url, params, {credentials: true, headers: {'Content-Type': 'application/x-www-form-urlencoded'}}).then((res) => {
          // success callback
          this.loggedIn=true;
          localStorage.setItem('loggedIn', 'true');
          localStorage.setItem('username', this.user.username);
          this.authFailed=false;
          console.log('success')
          location.reload();

        }, (err) => {
          console.log(err);
          this.authFailed=true;
          // error callback
        });
        },

        logout () {
          let url = "http://localhost:8081/logout";
          this.$http.get(url).then((res) => {
            localStorage.setItem('loggedIn', 'false');
            localStorage.setItem('username', '');
            location.reload();
          });
        },

        googleUrl () {
          let url = 'https://accounts.google.com/o/oauth2/v2/auth?scope=email&response_type=token&client_id=705445061234-hg27gdnem5jnfqlob55a0eb3as885lfh.apps.googleusercontent.com&redirect_uri=http://localhost:8080/token';

          location.assign(url);

        }
      }
    }

  </script>


<style type="text/css">
  .card-container.card {
    max-width: 350px;
    padding: 40px 40px;
  }

/*
 * Card component
 */
 .card {
  background-color: #F7F7F7;
  /* just in case there no content*/
  padding: 20px 25px 30px;
  margin: 0 auto 25px;
  margin-top: 50px;
  /* shadows and rounded borders */
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 2px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
  width: 96px;
  height: 96px;
  margin: 0 auto 10px;
  display: block;
  -moz-border-radius: 50%;
  -webkit-border-radius: 50%;
  border-radius: 50%;
}

/*
 * Form styles
 */
 .profile-name-card {
  font-size: 16px;
  font-weight: bold;
  text-align: center;
  margin: 10px 0 0;
  min-height: 1em;
}



.form-signin #inputEmail,
.form-signin #inputPassword {
  direction: ltr;
  height: 44px;
  font-size: 16px;
}

.form-signin input[type=email],
.form-signin input[type=password],
.form-signin input[type=text],
.form-signin button {
  width: 100%;
  display: block;
  margin-bottom: 10px;
  z-index: 1;
  position: relative;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

.form-signin .form-control:focus {
  border-color: rgb(104, 145, 162);
  outline: 0;
  -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
  box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
}

.btn.btn-signin {
  /*background-color: #4d90fe; */
  background-color: rgb(104, 145, 162);
  /* background-color: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));*/
  padding: 0px;
  font-weight: 700;
  font-size: 14px;
  height: 36px;
  -moz-border-radius: 3px;
  -webkit-border-radius: 3px;
  border-radius: 3px;
  border: none;
  -o-transition: all 0.218s;
  -moz-transition: all 0.218s;
  -webkit-transition: all 0.218s;
  transition: all 0.218s;
}

.btn.btn-signin:hover,
.btn.btn-signin:active,
.btn.btn-signin:focus {
  background-color: rgb(12, 97, 33);
}

textarea {
  resize: vertical; /* user can resize vertically, but width is fixed */
}

</style>