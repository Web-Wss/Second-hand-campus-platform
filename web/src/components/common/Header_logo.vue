<template>
  <div class="logo_list_box">
    <div class="logo_list">
      <div class="logo">
        <img
          @click="handleHome()"
          src="https://s02.mifile.cn/assets/static/image/logo-mi2.png"
          alt=""
        />
      </div>
      <div class="list">
        <ul>
          <li @click="handleMarket()">二手市场</li>
          <li @click="handleXq()">需求中心</li>
          <li @click="handleSq()">二手社区</li>
        </ul>
      </div>
      <div class="person">
        <div class="img">
          <img src="https://cn.vuejs.org/images/logo.svg" alt="" />
        </div>
        <div class="title">个人中心</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header_logo",
  methods: {
    handleHome() {
      this.$router.push({ path: "home" });
    },
    // 二手市场
    handleMarket() {
      this.$router.push({ path: "market" });
    },
    handleXq() {
      alert("此模块正在开发中...");
    },
    handleSq() {
      alert("此模块正在开发中...");
    }
  }
};
</script>

<style scoped>
.logo_list_box {
  width: 100%;
  height: 100px;
  border-bottom: 1px solid rebeccapurple;
}
.logo_list {
  margin: 10px auto;
  width: 1200px;
  height: 100px;
  /* background-color: blanchedalmond; */
}
.logo {
  float: left;
  width: 300px;
  height: 100px;
}
.logo img {
  cursor: pointer;
  width: 100px;
  height: 100px;
}
.list {
  float: left;
  width: 800px;
  height: 100px;
}
.list ul li {
  cursor: pointer;
  margin: 25px;
  float: left;
  margin-left: 20px;
  list-style: none;
  text-align: center;
  line-height: 50px;
  color: white;
  border-radius: 50px;
  width: 150px;
  height: 50px;
  background-color: rgb(89, 172, 41);
}
.list ul li:nth-child(2) {
  background-color: #888888;
}
.list ul li:nth-child(3) {
  background-color: #888888;
}

.person {
  float: right;
  width: 60px;
  height: 100px;
}
.person img {
  width: 60px;
  height: 60px;
}
.person .title {
  color: rgb(106, 121, 42);
  text-align: center;
  width: 60px;
  height: 30px;
  font-size: 13px;
}
</style>
