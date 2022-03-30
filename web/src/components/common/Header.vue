<template>
  <div class="header_box">
    <div class="header_small">
      <div class="small_left">
        <ul>
          <li>欢迎来到马师专校园二手平台</li>
        </ul>
      </div>
      <div class="small_right">
        <ul>
          <li>请登录 / 注册</li>
          <li>小程序</li>
          <li>交易流程</li>
          <li>关于平台</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header"
};
</script>

<style scoped>
.header_box {
  width: 100%;
  height: 35px;
  background-color: #f5f5f5;
}

.header_small {
  width: 1200px;
  height: 35px;
  margin: 0 auto;
}

.small_left {
  float: left;
  width: 300px;
  height: 35px;
  font-size: 12px;
  color: #6c6c6c;
  line-height: 35px;
}

.small_left ul li {
  cursor: pointer;
  width: 300px;
  list-style: none;
}

.small_right {
  float: right;
  width: 360px;
  height: 35px;
  font-size: 12px;
  color: #6c6c6c;
  line-height: 35px;
}

.small_right ul li {
  cursor: pointer;
  text-align: right;
  float: left;
  width: 90px;
  list-style: none;
}
.small_right ul li:nth-child(1) {
  color: red;
}
</style>
