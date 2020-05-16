<template>
  <div>
      <!-- Navbar -->
      <NavBar />

      <div class="container mt-5">
        <h1>Admin page</h1>

        <h3 class="text-left mt-5">Info user</h3>
        <hr>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>USERNAME</th>
                    <th>EMAIL</th>
                    <th>ROLE</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>{{user.idUser}}</td>
                    <td>{{user.username}}</td>
                    <td>{{user.email}}</td>
                    <td>{{user.roles.roleName}}</td>
                </tr>
            </tbody>
        </table>
      </div>
  </div>
</template>

<script>

import NavBar from '@/components/TheNavBar';
import {mapActions, mapState} from 'vuex';

export default {
    components: {
        NavBar
    },

    computed: {

        ...mapState({
            user: 'user'
        })

    },

    methods: {
        ...mapActions({
            getUser: 'getUserLocalStorage'
        })
    },

    created (){
        this.getUser();
    }
}
</script>

<style>

</style>