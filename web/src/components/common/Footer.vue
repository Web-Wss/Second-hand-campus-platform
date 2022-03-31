<template>
  <div class="footer_box">
    <div class="footer_small">
      我是尾部内容
    </div>
  </div>
</template>

<script>
export default {
  name: "Footer"
};
</script>

<style scoped>
.footer_box {
  width: 100%;
  height: 100px;
  /* background-color: antiquewhite; */
}
.footer_small {
  background-color: rgb(65, 161, 97);
  border-radius: 15px;
  text-align: center;
  line-height: 100px;
  margin: 0 auto;
  width: 1200px;
  height: 100px;
}
</style>
