<template>
  <div>
    <div class="login-wrap">
      <el-form
        class="login-form"
        label-position="top"
        label-width="80px"
        :model="formdata"
      >
        <h2>用户登录</h2>
        <el-form-item label="用户名">
          <el-input v-model="formdata.username"></el-input>
        </el-form-item>
        <el-form-item label="密  码">
          <el-input type="password" v-model="formdata.password"></el-input>
        </el-form-item>
        <el-button @click="handleLogin()" class="login-btn" type="primary"
          >登录</el-button
        >
        <el-button @click="handleRegister()" class="login-btn" type="success"
          >注册</el-button
        >
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      formdata: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    // 登录请求
    async handleLogin() {
      // 希望让异步操作的代码，看起来像同步代码
      const res = await this.$http.post(
        `/LoginServlet?username=${this.formdata.username}&password=${this.formdata.password}`
      );
      console.log(res);
      if (res.data == "200") {
        this.$router.push({ name: "home" });
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
    },

    // 注册
    handleRegister() {
      this.$router.push({ path: "register" });
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
  /* margin-top: 10px; */
  width: 48%;
}
</style>
