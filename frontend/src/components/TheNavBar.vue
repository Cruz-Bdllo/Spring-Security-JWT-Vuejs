<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand">JWT | VueJS</a>
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item" 
        v-for="link in links" :key="link.name"
        :class="{'active':current==link.name}">
          <router-link class="nav-link" :to="{name: link.name}">
            {{link.name}}
          </router-link>
        </li>
        
      </ul>
      
      <span class="mr-3 text-white">mail@mail.com</span>
      <button class="btn btn-purple my-2 my-sm-0" type="submit">Logout</button>
      
    </div>
  </nav>
</template>


<script>
export default {
  
  data() {
    return {
      links: [
        {name:'Home'},
        {name:'Account'}
      ],
      current: this.$route.name
    }
  },

}
</script>

<style scoped>

</style>