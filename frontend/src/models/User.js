export default class User {
    
    
    constructor (username, password) {
        this.username = username;
        this.password = password;
    }

    setIdUser(idUser){
        this.idUser = idUser;
    }
    getIdUser () {
        return this.idUser;
    }

    setUsername (username) {
        this.username = username;
    }
    getUsername () {
        return this.username;
    }

    setUsername (username) {
        this.username = username;
    }
    getUsername () {
        return this.username;
    }

    setEmail (email) {
        this.email = email;
    }
    getEmail () {
        return this.email;
    }

    setRoles (roles) {
        this.roles = roles;
    }
    getRoles () {
        return this.roles;
    }

    setToken (token) {
        this.token = token;
    }
    getToken () {
        return this.token;
    }

    setPassword (password) {
        this.password = password;
    }
    getPassword () {
        return this.password;
    }


}