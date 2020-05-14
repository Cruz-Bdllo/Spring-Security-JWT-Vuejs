<template>
  <form >

    <!-- Username -->
    <div class="form-group text-center d-flex justify-content-center my-3">
      <input type="text" class="form-control" placeholder="Username:" required/>
    </div>

    <!-- Email -->
    <div class="form-group text-center d-flex justify-content-center my-3">
      <input type="text" class="form-control" placeholder="Email:" required/>
    </div>

    <!-- Password -->
    <div class="form-group d-flex justify-content-center my-3">
      <input type="password" class="form-control" placeholder="Password:" required/>
    </div>

    <!-- Repeat Password -->
    <div class="form-group d-flex justify-content-center my-3">
      <input type="password" class="form-control" placeholder="Repeat password:" required/>
    </div>

    <!-- Register -->
    <button type="submit" class="btn btn-success mt-3">Log up</button>
  </form>
</template>

<script>
export default {
    name: 'TheFormRegister'
}
</script>

<style scoped>
.form-group input{
    width: 70%;
}
</style>