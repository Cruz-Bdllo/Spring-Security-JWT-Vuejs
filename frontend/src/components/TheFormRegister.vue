<template>
  <form v-on:submit.prevent="signup">

    <!-- Username -->
    <div class="form-group text-center d-flex justify-content-center my-3">
      <input type="text" @change="validUsername" v-model="username" class="form-control" :class="{'is-valid':!$v.username.$invalid}" placeholder="Username:" required/>
    </div>
    <div v-if="!$v.username.minLength" class="invalid-feedback d-block">
      The username must have at least 6 letters. 
    </div>
    <div v-if="!$v.username.maxLength" class="invalid-feedback d-block">
      The username must have at most 30 letters. 
    </div>
    <div v-if="existUsername" class="invalid-feedback d-block">
        {{existUsername}}
    </div>

    <!-- Email -->
    <div class="form-group text-center d-flex justify-content-center my-3">
      <input type="text" @change="validEmail" v-model="email" class="form-control" :class="{'is-valid':!$v.email.$invalid}" placeholder="Email:" required/>
    </div>
    <div v-if="existEmail" class="invalid-feedback d-block">
        {{existEmail}}
    </div>

    <!-- Password -->
    <div class="form-group d-flex justify-content-center my-3">
      <input type="password" v-model="password" class="form-control" :class="{'is-valid':!$v.password.$invalid}" placeholder="Password:" required/>
    </div>
    <div v-if="!$v.password.minLength" class="invalid-feedback d-block">
      The password must have at least 6 letters. 
    </div>

    <!-- Repeat Password -->
    <div class="form-group d-flex justify-content-center my-3">
      <input type="password" v-model="samePassword" class="form-control" :class="{'is-valid':!$v.samePassword.$invalid}" placeholder="Repeat password:" required/>
    </div>
    <div v-if="samePassword && $v.samePassword.$invalid" class="invalid-feedback d-block">
      The password must be same the before field password 
    </div>

    

    <!-- Register -->
    <button type="submit" :disabled="$v.$invalid || existEmail || existUsername" class="btn btn-success mt-3">Sign up</button>
  </form>
</template>

<script>

import { required, email, minLength, maxLength, sameAs } from 'vuelidate/lib/validators';
import { mapActions, mapState } from 'vuex';
import User from '../models/User';

export default {
    name: 'TheFormRegister',
    data() {
      return {
        username: null,
        email: null,
        password: null,
        samePassword: null
      }
    },

    computed: {

      ...mapState({
        existEmail: 'responseExistEmail',
        existUsername: 'responseExistUsername'
      })

    },

    methods: {

      ...mapActions({ 
        signUp: 'signUp',
        existEmailDB: 'existEmailDB',
        existUsernameDB: 'existUsernameDB'
      }),

      signup() { // debe enviar los datos al api

        // construir el objeto User
        let userSignUp = new User(this.username, this.password);
        userSignUp.setEmail(this.email);

        this.signUp(userSignUp); // metodo del store
        this.$router.push({name: 'Login'});

      },


      validEmail () {
        this.existEmailDB(this.email);
      },

      validUsername () {
        this.existUsernameDB(this.username);
      }

    },

    validations: {
      username: {
        required: required,
        minLength: minLength(6),
        maxLength: maxLength(30)
      },
      email: {
        required: required,
        email: email
      },
      password: {
        required: required,
        minLength: minLength(6)
      },
      samePassword: {
        required: required,
        sameAsPassword: sameAs('password')
      }
    }
}
</script>

<style scoped>
.form-group input{
    width: 70%;
}
</style>