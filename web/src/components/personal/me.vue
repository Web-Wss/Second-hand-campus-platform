<template>
  <div>
    <el-card class="box-card">
      <el-descriptions title="用户信息">
        <el-descriptions-item label="用户名">{{
          form.user_username
        }}</el-descriptions-item>
        <el-descriptions-item label="昵称">{{
          form.user_nickname
        }}</el-descriptions-item>
        <el-descriptions-item label="QQ">{{
          form.user_qq
        }}</el-descriptions-item>
        <el-descriptions-item label="微信">{{
          form.user_wx
        }}</el-descriptions-item>
        <el-descriptions-item label="手机号">{{
          form.user_phone
        }}</el-descriptions-item>
        <el-descriptions-item label="收货地址">{{
          form.user_address
        }}</el-descriptions-item>
      </el-descriptions>
      <el-button @click="handleEdit()" class="login-btn" type="primary"
        >编辑基本信息</el-button
      >
      <el-button @click="EdituserPwd()" class="login-btn" type="warning"
        >修改登录密码</el-button
      >
      <el-button @click="logOut()" class="login-btn" type="danger"
        >退出登录</el-button
      >
    </el-card>
    <el-dialog title="个人信息编辑" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="用户名：" :label-width="formLabelWidth">
          <el-input v-model="form.user_username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="昵称：" :label-width="formLabelWidth">
          <el-input v-model="form.user_nickname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="QQ：" :label-width="formLabelWidth">
          <el-input v-model="form.user_qq" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="微信：" :label-width="formLabelWidth">
          <el-input v-model="form.user_wx" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机号：" :label-width="formLabelWidth">
          <el-input v-model="form.user_phone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="收货地址：" :label-width="formLabelWidth">
          <el-input v-model="form.user_address" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="EditUser">保 存</el-button>
      </div>
    </el-dialog>
    <!-- 修改用户密码窗口 -->
    <el-dialog title="修改密码" :visible.sync="dialogPwd">
      <el-form :model="form">
        <el-form-item label="原 密 码：" :label-width="formLabelWidth">
          <el-input
            v-model="form.user_password1"
            autocomplete="off"
            show-password
          ></el-input>
        </el-form-item>
        <el-form-item label="新 密 码：" :label-width="formLabelWidth">
          <el-input
            v-model="form.user_password2"
            autocomplete="off"
            show-password
          ></el-input>
        </el-form-item>
        <el-form-item label="确 认 密 码：" :label-width="formLabelWidth">
          <el-input
            v-model="form.user_password3"
            autocomplete="off"
            show-password
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogPwd = false">取 消</el-button>
        <el-button type="primary" @click="EditUser">提 交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogFormVisible: false,
      dialogPwd: false,
      form: {
        user_username: "",
        user_password1: "",
        user_password2: "",
        user_password3: "",
        user_nickname: "",
        user_qq: "",
        user_wx: "",
        user_phone: "",
        user_address: "",
        // user_id
        user_id: ""
      },
      formLabelWidth: "120px"
    };
  },
  created() {
    this.form.user_username = localStorage.getItem("user_username");
    this.getUser();
  },
  methods: {
    // 获取用户信息
    async getUser() {
      this.form.user_username = localStorage.getItem("user_username");
      this.form.user_nickname = localStorage.getItem("user_nickname");
      this.form.user_qq = localStorage.getItem("user_qq");
      this.form.user_wx = localStorage.getItem("user_wx");
      this.form.user_phone = localStorage.getItem("user_phone");
      this.form.user_address = localStorage.getItem("user_address");
      this.form.user_id = localStorage.getItem("user_id");
      localStorage.setItem("user_id", this.form.user_id);
    },
    // 修改用户密码
    EdituserPwd() {
      this.dialogPwd = true;
    },
    handleEdit() {
      this.dialogFormVisible = true;
    },
    // 编辑用户信息事件
    async EditUser() {
      const res = await this.$http.post(
        `EditUserInfoServlet?user_username=${this.form.user_username}&user_nickname=${this.form.user_nickname}&user_qq=${this.form.user_qq}&user_wx=${this.form.user_wx}&user_phone=${this.form.user_phone}&user_id=${this.form.user_id}&user_address=${this.form.user_address}`
      );
      console.log(res);
      this.dialogFormVisible = false;
      if (res.data) {
        localStorage.setItem("user_username", this.form.user_username);
        localStorage.setItem("user_nickname", this.form.user_nickname);
        localStorage.setItem("user_qq", this.form.user_qq);
        localStorage.setItem("user_wx", this.form.user_wx);
        localStorage.setItem("user_phone", this.form.user_phone);
        localStorage.setItem("user_address", this.form.user_address);
        alert("修改成功!");
      } else {
        alert("修改失败!");
      }
    },
    // 退出登录
    logOut() {
      let result = confirm("确认退出当前用户登录么？？？");
      if (result) {
        localStorage.clear();
        this.$router.push({ path: "home" });
      }
    }
  }
};
</script>

<style></style>
