<template>
  <form >
    <div class="form-group text-center d-flex justify-content-center my-3">
      <input type="text" class="form-control" placeholder="Username:" required/>
    </div>
    <div class="form-group d-flex justify-content-center my-3">
      <input type="password" class="form-control" placeholder="Password:" required/>
    </div>
    <button type="submit" class="btn btn-success mt-3">Log in</button>
  </form>
</template>

<script>
export default {
    name: 'TheFormLogin'
}
</script>

<style scoped>
.form-group input{
    width: 70%;
}
</style>