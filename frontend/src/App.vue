<template>
  <div id="app" class="container text-center">
    <br />
    <navbar></navbar>
    <br />
    <router-view id="router-view"></router-view>
  </div>
</template>

<script>
import Navbar from './components/Navbar'
import MainPanel from './components/Main-panel'

export default {
  components: { Navbar, MainPanel }
}
</script>

<style lang="sass">

  // Bootstrap
  $icon-font-path: '../node_modules/bootstrap-sass/assets/fonts/bootstrap/';
  $link-color: #42b983;
  $brand-success: #42b983;
  @import 'node_modules/bootstrap-sass/assets/stylesheets/bootstrap';

  // font awesome
  $fa-font-path: '../node_modules/font-awesome/fonts/';
  @import 'node_modules/font-awesome/scss/font-awesome';

  //some styling adaptations
  h1
    color: #42b983
  p
    text-align: justify
</style>
