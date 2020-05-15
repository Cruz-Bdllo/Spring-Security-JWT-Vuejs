import Vue from "vue";
import Vuex from "vuex";
import User from "../models/User";
import axios from 'axios'

const API_URL = 'http://localhost:8585/api/';

Vue.use(Vuex);

export default new Vuex.Store({



state: {
	user: null,
	responseSignUp: null
},

mutations: {

	setUser(state, value) {
		state.user = value;
	},
	setResponseSignUp (state, value) {
		state.responseSignUp = value;
	}

},

actions: {


	signUp({ commit }, valUser) { // must connect to API (this method is async)
		// let user = new User(valUser);
		//console.log(valUser);
		axios.post(API_URL + 'signup', {
			username: valUser.getUsername(),
			password: valUser.getPassword(),
			email: valUser.getEmail()
		})
			.then((response) => {
				console.log(response.data);
				commit('setResponseSignUp', response.data);
			})

		// axios({
		// 	method: 'post',
		// 	url: 'http://127.0.0.1:8181/api/signup/',
		// 	data: {
		// 		username: valUser.getUsername(),
		// 		email: valUser.getEmail(),
		// 		password: valUser.getPassword()
		// 	}
		// });


		// console.log(valUser);
	},
}



});
