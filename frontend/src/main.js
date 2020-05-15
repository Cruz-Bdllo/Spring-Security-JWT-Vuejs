import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Vuelidate from 'vuelidate'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(Vuelidate, VueAxios, axios)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
