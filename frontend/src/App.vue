<template>
  <div id="app" class="h-100">
    
    <router-view/>
  </div>
</template>

<style>
body, html{
  height: 100%;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  text-decoration: none;
  color: #2c3e50;
}


.account{
    color: black !important;
    padding: 10px 40px;
    border-bottom: 5px solid #EAECEE;
    text-decoration: none !important;
}
.account:hover{
    border-bottom: 5px solid #42b983;
    transition: .3s ease-in-out;
}

.logo-login{
    width: 150px;
    height: 150px;
}

.btn-purple{
  background: #9B59B6;
  color: white;
}
.btn-purple:hover{
  background: rgb(161, 100, 185);
  color: rgb(235, 235, 235);
}
</style>
