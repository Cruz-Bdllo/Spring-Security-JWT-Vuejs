<template>
  <div class=" h-100 d-flex align-items-center justify-content-center">

      <div class="container mt-5">
            <div class="jumbotron">
                <h1 class="display-4">Not Found Page</h1>
                <hr class="my-4">
                <p>No se encontro la página solicitada.</p>
                <button @click="returnPage" class="btn btn-info">Regresar</button>
            </div>
        </div>

  </div>
</template>

<script>
export default {
    methods: {
        returnPage() {
            this.$router.go(-1);
        }
    },
}
</script>

<style>

</style>