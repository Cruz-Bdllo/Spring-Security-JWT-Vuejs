<template>
    <div class="container-fluid h-100 d-flex align-items-center justify-content-center">

        <div class="container py-5">
            <div class="row">
                <div class="col-12">
                    <img src="@/assets/logo.png" class="logo-login">
                    <h1 class="display-4">Log in</h1>

                    <!-- Component form login -->
                    <FormLogin />
                </div>
            </div>

            <div class="row mt-5">
                <div class="col-12">
                  <router-link class="account"
                    :to="{name:'Logup'}">Don't have account?</router-link>
                </div>
            </div>
        </div>

    </div>
</template>

<script>

import FormLogin from '@/components/TheFormLogin';

export default {
    
    components: {
        FormLogin
    }

}
</script>

<style scoped>



</style>