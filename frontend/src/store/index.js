import Vue from "vue";
import Vuex from "vuex";
import axios from 'axios'

const API_URL = 'http://localhost:8585/api/';

Vue.use(Vuex);

export default new Vuex.Store({



state: {
	user: null,
	responseSignUp: null,
	responseLogin: null,
	responseExistEmail: null,
	responseExistUsername: null
},

mutations: {

	setUser(state, value) {
		state.user = value;
	},
	

	setResponseSignUp (state, value) {
		state.responseSignUp = value;
	},

	setResponseLogin (state, value) {
		state.responseLogin = value;
	},

	setUserInLocalStorage (state, value) {
		localStorage.setItem('userLog', value);
	},

	setResponseExistEmail(state, val) {
		state.responseExistEmail = val;
	},

	setResponseExistUsername(state, val) {
		state.responseExistUsername = val;
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
				// console.log(response.data);
				commit('setResponseSignUp', response.data);
			})
	},


	loginStore ({commit}, user) { // connect to db

		return new Promise((resolve, reject) => {
			axios.post( API_URL + 'signin', {
				username: user.getUsername(),
				password: user.getPassword()
			}).then( response => {
				response.data.roles = response.data.roles[0];
				commit('setUserInLocalStorage', JSON.stringify(response.data));
				commit('setUser', response.data);				
				commit('setResponseLogin', null);
				resolve();				
			}).catch( err => {
				commit('setResponseLogin', 'User or password failed');
				
				console.log(err);
			});
		});

	},

	getUserLocalStorage ({commit}) { // created
		
		commit('setUser', JSON.parse(localStorage.getItem( 'userLog' )));
	},


	logOut ({commit}) {
		localStorage.clear();
		commit('setUser', null);
	},

	existEmailDB({commit}, email) {
		console.log(email)
		axios.get(API_URL+'existuser/' + email)
			.then(response => {
				console.log(response.data);
				commit('setResponseExistEmail', response.data);
			}).catch(() => commit('setResponseExistEmail', null));
	},

	existUsernameDB({commit}, username) {
		axios.get(API_URL + 'existusername/' + username)
			.then(response => {
				commit('setResponseExistUsername', response.data);
			}).catch(() => commit('setResponseExistUsername', null));
	},

	validateToken({commit, state}){

		axios.get(API_URL + 'home', {
			headers: {
				Authorization: 'Bearer ' + state.user.token
			}
		}).then(res => {
			console.log( res.status );
		}).catch(err => {
			console.log(err);
		})
				
	}

},

getters: {

	isUserAuth() {
		return (localStorage.getItem('userLog')) ? true : false;
	}

}

});
