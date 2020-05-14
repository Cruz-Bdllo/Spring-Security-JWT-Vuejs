<template>
    <div>
        <!-- Navbar -->
        <NavBar />

        <!-- Content -->
        <div class="container mt-5">
            <div class="jumbotron">
                <h1 class="display-4">Hello, username</h1>
                <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
                <hr class="my-4">
                <p>Roles: roles</p>
                
            </div>
        </div>

    </div>
</template>

<script>

import NavBar from '@/components/TheNavBar';

export default {

components: {
    NavBar
}

}
</script>

<style>

</style>