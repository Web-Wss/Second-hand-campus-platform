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
          <li v-if="user_nickname == undefined" @click="handleLoginRegistere()">
            请登录 / 注册
          </li>
          <li v-else>{{ user_nickname }}</li>
          <li>小程序</li>

          <li @click="handleJylc()">交易流程</li>
          <li @click="handleGypt()">关于平台</li>
          <!-- 小程序logo -->

          <li class="logo">
            <img
              src="https://s02.mifile.cn/assets/static/image/logo-mi2.png"
              alt=""
            />
          </li>
        </ul>
      </div>
    </div>
    <!-- 交易流程 -->
    <el-dialog title="交易流程" :visible.sync="dialogJylc">
      <ul>
        <li>1、注册账号</li>
      </ul>
    </el-dialog>
    <!-- 关于平台 -->
    <el-dialog title="关于平台" :visible.sync="dialogGypt">
      看看网于2022年4月15日正式上线。 <br /><br />看看网开发的原由：
      <ul>
        <li>现有的“校园二手群”检索商品很繁琐</li>
      </ul>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      user_nickname: "",
      dialogJylc: false,
      dialogGypt: false
    };
  },
  created() {
    this.user_nickname = localStorage.getItem("user_nickname");
  },
  methods: {
    handleLoginRegistere() {
      this.$router.push({ path: "login" });
    },
    handleJylc() {
      this.dialogJylc = true;
    },
    handleGypt() {
      this.dialogGypt = true;
    }
  }
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
  width: 420px;
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
  width: 150px;
  color: red;
}
/* .small_right ul li:nth-child(2):hover {
  color: red;
} */

/* 小程序 */
li.logo {
  display: none;
  position: relative;
  top: 5px;
  left: 180px;
}
.small_right ul li:nth-child(2):hover + li + li + li {
  transition: all 0.2s linear;

  display: block;
}
.logo img {
  width: 90px;
}

/* 交易流程 */
.jylc {
  /* top: -35px; */
  position: fixed;
  z-index: 9;
  width: 100%;
  height: 100vh;
  /* background-color: rgb(194, 194, 194, 0.7); */
}
.jylc .jylc_small {
  line-height: 100px;
  border-radius: 25px;
  margin: 50px auto;
  width: 500px;
  height: 500px;
  background-color: rgb(40, 199, 159);
}
</style>
