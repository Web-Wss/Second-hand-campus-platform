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
        <template>
          <div class="zddlwz">自动登录</div>
          <el-switch
            v-model="value1"
            active-color="#28c17a"
            inactive-color="#dedede"
            @click="zzdlmethod()"
          >
          </el-switch>
          <div class="jzmmwz">记住密码</div>
          <el-switch
            v-model="value2"
            active-color="#28c17a"
            inactive-color="#dedede"
            @click="jzmmmethod()"
          >
          </el-switch>
          <el-switch
            v-show="false"
            v-model="value3"
            active-color="#28c17a"
            inactive-color="#dedede"
            @click="jzmmmethod()"
          >
          </el-switch>
        </template>

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
import { v4 } from "uuid";
export default {
  data() {
    return {
      value1: false,
      value2: false,
      value3: true,
      formdata: {
        username: "",
        password: "",
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

    // 登录请求
    async handleLogin() {
      const resyzm = await this.$http.post(
        `/CheckCodeServlet?code=${this.formdata.code}&uuidyzm2=${this.uuidyzm}`
      );
      console.log(resyzm);

      if (resyzm.data) {
        // 希望让异步操作的代码，看起来像同步代码
        const res = await this.$http.post(
          `/LoginServlet?username=${this.formdata.username}&password=${this.formdata.password}&value1=${this.value1}&value2=${this.value2}`
        );
        if (res.data != "登录失败") {
          console.log(res);
          localStorage.setItem("user_id", res.data.result.user_id);
          localStorage.setItem("user_username", res.data.result.user_username);
          localStorage.setItem("user_nickname", res.data.result.user_nickname);
          localStorage.setItem("user_phone", res.data.result.user_phone);
          localStorage.setItem("user_wx", res.data.result.user_wx);
          localStorage.setItem("user_qq", res.data.result.user_qq);
          localStorage.setItem("user_img", res.data.result.user_img);
          localStorage.setItem("user_address", res.data.result.user_address);
          //将从后端获取的token存入本地
          localStorage.setItem("token", res.data.token);
          // alert("登录成功!");
          this.$router.push({ name: "home" });
        } else {
          alert("登录失败");
          this.changeYzmImg();
          this.formdata.code = "";
        }
      } else {
        alert("验证码输入有误");
        this.changeYzmImg();
        this.formdata.code = "";
      }
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

.zddlwz,
.jzmmwz {
  margin: 20px 30px;
  display: inline-block;
}
</style>
