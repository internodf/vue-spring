<template>
  <div>
    <div class="navbar  navbar-default navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <router-link to="/" class="navbar-brand">CHIRP</router-link>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
          <ul class="nav navbar-nav">
            <li>
              <router-link to="/">Home</router-link>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li>
              <router-link to="/signup" class="nav-item nav-link"> Sign Up </router-link>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <img id="banner" src="../assets/banner.png" class="img-responsive" alt="Responsive image">
  </div>
</template>

<script>
export default {
}
</script>

<style>
  #banner {
    margin-top: 70px;
  }
</style>
