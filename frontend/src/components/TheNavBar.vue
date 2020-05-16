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
        v-for="link in filterLinks" :key="link.name"
        
        :class="{'active':current==link.name}">
          <router-link class="nav-link" :to="{name: link.name}">
            {{link.name}} 
          </router-link>
        </li>
        
      </ul>
      
      <span class="mr-3 text-white">{{user.email}}</span>
      <button @click="logout" class="btn btn-purple my-2 my-sm-0" type="submit">Logout</button>
      
    </div>
  </nav>
</template>


<script>

import {mapState, mapActions} from 'vuex';

export default {
  
  data() {
    return {
      links: [
        {name:'Home', role: ['USER', 'ADMIN']},
        {name:'Account', role: ['USER', 'ADMIN']},
        {name:'Admin', role: ['ADMIN']}
      ],
      current: this.$route.name
    }
  },

  computed: {

    ...mapState({
      user: 'user'
    }),

    filterLinks () {
      // return this.links.filter(l => 
      //   this.user.roles.roleName === l.role.filter(e => e == this.user.role.roleName)
      // );

      //console.log(this.links.filter( l =>  (l.role[0] === this.user.roles.roleName) || (l.role[1] === this.user.roles.roleName)));
      return this.links.filter( l =>  (l.role[0] === this.user.roles.roleName) || (l.role[1] === this.user.roles.roleName));
    },

    isAdmin() {
      return this.user.roles.roleName === 'ADMIN'
    }

  },


  methods: {

    ...mapActions({
      logOut: 'logOut'
    }),

    logout() {
      this.logOut()
      this.$router.push({name: 'Login'});
    }

  }

}
</script>

<style scoped>

</style>