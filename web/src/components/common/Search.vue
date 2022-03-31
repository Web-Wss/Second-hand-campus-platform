<template>
  <div class="search">
    <div class="search_input">
      <input type="text" value="" placeholder="请输入要搜索的商品，按回车键" />
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.search {
  margin-top: 10px;
  width: 100%;
  height: 40px;
  /* background-color: aqua; */
}
.search .search_input {
  margin: 0 auto;
  width: 500px;
  height: 40px;
  /* background-color: beige; */
}
.search .search_input input {
  text-align: center;
  border-radius: 25px;
  border-width: 1px;
  border-color: rgb(36, 156, 66);
  width: 500px;
  height: 40px;
}
</style>
