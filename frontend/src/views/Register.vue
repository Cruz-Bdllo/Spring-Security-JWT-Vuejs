<template>
    <div class="bg-login container-fluid h-100 d-flex align-items-center justify-content-center">
        <div class="container container-login py-5">

            <!-- Form -->
            <div class="row">
                <div class="col-12">
                    <img src="@/assets/logo.png" class="logo-login">
                    <h1 class="display-4 mb-4">Sign up</h1>

                    <!-- Component form login -->
                    <FormRegister />
                </div>
            </div>

            <!-- Have an account -->
            <div class="row mt-5">
                <div class="col-12">
                  <router-link class="account"
                    :to="{name:'Login'}">have account</router-link>
                </div>
            </div>

        </div>        
    </div>
</template>

<script>
import FormRegister from '@/components/TheFormRegister';

export default {

    components: {
        FormRegister
    }

};
</script>

<style>
</style>