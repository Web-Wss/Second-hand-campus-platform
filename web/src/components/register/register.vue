<template>
  <div class="login-wrap">
    <el-form
      class="login-form"
      label-position="top"
      label-width="80px"
      :model="formdata"
    >
      <h2>用户注册</h2>
      <!-- <el-form-item label="用户名（建议学号注册）"> -->
      <el-input
        style="margin:10px"
        v-model="formdata.user_username"
        placeholder="用户名（建议学号注册）"
      ></el-input>
      <!-- </el-form-item> -->
      <!-- <el-form-item label="密  码"> -->
      <el-input
        style="margin:10px"
        type="password"
        v-model="formdata.user_password"
        placeholder="密  码"
      ></el-input>
      <!-- </el-form-item> -->
      <!-- <el-form-item label="昵 称"> -->
      <el-input
        style="margin:10px"
        v-model="formdata.user_nickname"
        placeholder="昵 称"
      ></el-input>
      <!-- </el-form-item> -->
      <!-- <el-form-item label="手 机（*必填项/用于商品(买/卖)联系）"> -->
      <el-input
        style="margin:10px"
        v-model="formdata.user_phone"
        placeholder="手 机（*必填项/用于商品(买/卖)联系）"
      ></el-input>
      <!-- </el-form-item> -->
      <!-- <el-form-item label="Q Q"> -->
      <el-input
        style="margin:10px"
        v-model="formdata.user_qq"
        placeholder="Q Q"
      ></el-input>
      <el-form-item label="验证码">
        <el-col :span="10">
          <el-input v-model="formdata.code" size="20"></el-input>
        </el-col>
        <img
          style="width:110px; cursor:pointer"
          :src="yzmimg"
          alt=""
          @click="changeYzmImg()"
        />
      </el-form-item>
      <!-- </el-form-item> -->
      <el-button @click="handleRegister()" class="login-btn" type="primary"
        >注册</el-button
      >
      <el-switch
        v-show="false"
        v-model="value3"
        active-color="#28c17a"
        inactive-color="#dedede"
        @click="jzmmmethod()"
      >
      </el-switch>
    </el-form>
  </div>
</template>

<script>
import { v4 } from "uuid";

export default {
  data() {
    return {
      value3: true,
      formdata: {
        user_username: "",
        user_password: "",
        user_nickname: "",
        user_phone: "",
        user_qq: "",
        code: "",
        uuidyzm: "",
        yzmimg: ""
      }
    };
  },
  created() {
    this.getYzmImg();
  },
  methods: {
    // 换一张验证码
    changeYzmImg() {
      this.getYzmImg();
      this.value3 = !this.value3;
    },
    // 获取验证码
    getYzmImg() {
      let uuidyzm = v4();
      this.uuidyzm = uuidyzm;
      this.yzmimg =
        "http://localhost:8080/Interfaces/CheckCodeServlet?uuidyzm1=" + uuidyzm;
    },
    // 注册请求
    async handleRegister() {
      const resyzm = await this.$http.post(
        `/CheckCodeServlet?code=${this.formdata.code}&uuidyzm2=${this.uuidyzm}`
      );
      console.log(resyzm);

      if (resyzm.data) {
        // 希望让异步操作的代码，看起来像同步代码
        const res = await this.$http.post(
          `/RegisterServlet?user_username=${this.formdata.user_username}&user_password=${this.formdata.user_password}&user_nickname=${this.formdata.user_nickname}&user_phone=${this.formdata.user_phone}&user_qq=${this.formdata.user_qq}`
        );
        console.log(res);
        if (res.data == true) {
          alert("注册成功!");
          this.$router.push({ name: "Login" });
        } else {
          alert("用户名已存在，注册失败!");
        }
      } else {
        alert("验证码输入有误");
        this.changeYzmImg();
        this.formdata.code = "";
      }
    }
  }
};
</script>

<style scoped>
.login-wrap {
  height: 100vh;
  background-color: #e4e4e4;
  /* 弹性盒模型 */
  display: flex;
  /* 水平垂直居中 */
  justify-content: center;
  align-items: center;
}
.login-wrap .login-form {
  width: 400px;
  background-color: #fff;
  border-radius: 5px;
  padding: 30px;
}
.login-wrap .login-btn {
  width: 100%;
}
</style>
