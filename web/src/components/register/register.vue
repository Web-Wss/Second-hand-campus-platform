<template>
  <div class="login-wrap">
    <el-form
      class="login-form"
      label-position="top"
      label-width="80px"
      :model="formdata"
    >
      <h2>用户注册</h2>
      <el-form-item label="用户名（建议学号注册）">
        <el-input v-model="formdata.user_username"></el-input>
      </el-form-item>
      <el-form-item label="密  码">
        <el-input type="password" v-model="formdata.user_password"></el-input>
      </el-form-item>
      <el-form-item label="昵 称">
        <el-input v-model="formdata.user_nickname"></el-input>
      </el-form-item>
      <el-form-item label="手 机">
        <el-input v-model="formdata.user_phone"></el-input>
      </el-form-item>
      <el-form-item label="Q Q">
        <el-input v-model="formdata.user_qq"></el-input>
      </el-form-item>
      <el-button @click="handleRegister()" class="login-btn" type="primary"
        >注册</el-button
      >
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      formdata: {
        user_username: "",
        user_password: "",
        user_nickname: "",
        user_phone: "",
        user_qq: ""
      }
    };
  },
  methods: {
    // 注册请求
    async handleRegister() {
      // 希望让异步操作的代码，看起来像同步代码
      const res = await this.$http.post(
        `/RegisterServlet?user_username=${this.formdata.user_username}&user_password=${this.formdata.user_password}&user_nickname=${this.formdata.user_nickname}&user_phone=${this.formdata.user_phone}&user_qq=${this.formdata.user_qq}`
      );
      console.log(res);
      if (res.status == "200") {
        // this.$router.push({ name: "home" });
        alert("注册成功!");
      }
      // const {
      //   data,
      //   meta: { msg, status }
      // } = res.data;
      // if (status === 200) {
      //   // 登录成功
      //   // 保存后台返回的token
      //   localStorage.setItem("token", data.token);
      //   // 1.跳转home
      // this.$router.push({ name: "home" });
      //   // 2.提示成功
      //   this.$message.success(msg);
      // } else {
      //   // 3、登录不成功，提示为啥不成功
      //   this.$message.error(msg);
      // }
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
