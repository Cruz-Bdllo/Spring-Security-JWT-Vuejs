<template>
    <div>
        <!-- Navbar -->
        <NavBar />

        <!-- Content -->
        <div class="container mt-5">
            <div class="jumbotron">
                <h1 class="display-4">Hello, {{user.username}}</h1>
                <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
                <hr class="my-4">
                <p class="text-left">Roles: {{user.roles.roleName}}</p>
                <p class="text-left">Token: {{user.token}}</p>
            </div>
        </div>

    </div>
</template>

<script>

import {mapState, mapActions} from 'vuex';
import NavBar from '@/components/TheNavBar';

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

    created () {
        this.getUser();
    }


}
</script>

<style>

</style>