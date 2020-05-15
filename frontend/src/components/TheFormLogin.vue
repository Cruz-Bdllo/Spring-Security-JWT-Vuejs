<template>
  <form v-on:submit.prevent="login">

    <!-- Username -->
    <div class="form-group text-center d-flex justify-content-center my-3">
      <input type="text" v-model="username" :class="{'is-valid':!$v.username.$invalid}" class="form-control" placeholder="Username:" required/>
    </div>
    <div v-if="!$v.username.minLength" class="invalid-feedback d-block">
      The username must have at least 6 letters. 
    </div>
    <div v-if="!$v.username.maxLength" class="invalid-feedback d-block">
      The username must have at most 30 letters. 
    </div>


    <!-- Password -->
    <div class="form-group d-flex justify-content-center my-3">
      <input type="password" v-model="password" class="form-control" :class="{'is-valid':!$v.password.$invalid}" placeholder="Password:" required/>
    </div>
    <div v-if="!$v.password.minLength" class="invalid-feedback d-block">
      The password must have at least 6 letters. 
    </div>

    <button type="submit" :disabled="$v.$invalid" class="btn btn-success mt-3">Log in</button>
  </form>
</template>

<script>

import {required, minLength, maxLength} from 'vuelidate/lib/validators';

export default {
    name: 'TheFormLogin',

    data() {
      return {
        username: '',
        password: null,
        submitStatus: null
      }
    },

    validations: {
      username: {
        required,
        minLength: minLength(6),
        maxLength: maxLength(30)
      },
      password: {
        required,
        minLength: minLength(6)
      }
    },


    methods: {
      login() {
        console.log("datos enviados");
      }
    },

    created () {
      console.log(this.$v.$invalid);
    },

}
</script>

<style scoped>
.form-group input{
    width: 70%;
}
</style>