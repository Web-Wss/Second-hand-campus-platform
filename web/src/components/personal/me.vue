<template>
  <div>
    <el-card class="box-card">
      <el-descriptions title="用户信息">
        <el-descriptions-item label="用户名">21121301037</el-descriptions-item>
        <el-descriptions-item label="昵称">前端菜鸟</el-descriptions-item>
        <el-descriptions-item label="QQ">1306822660</el-descriptions-item>
        <el-descriptions-item label="微信">13359074748</el-descriptions-item>
        <el-descriptions-item label="邮箱"
          >1306822660@qq.com</el-descriptions-item
        >
        <el-descriptions-item label="手机号">13359074748</el-descriptions-item>
        <el-descriptions-item label="收货地址"
          >马师专7#407</el-descriptions-item
        >
      </el-descriptions>
      <el-button @click="handleEdit()" class="login-btn" type="primary"
        >编辑</el-button
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
        <el-form-item label="邮箱：" :label-width="formLabelWidth">
          <el-input v-model="form.user_email" autocomplete="off"></el-input>
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
        <el-button type="primary" @click="dialogFormVisible = false"
          >保 存</el-button
        >
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogFormVisible: false,
      form: {
        user_username: "21121301037",
        user_nickname: "前端菜鸟",
        user_qq: "1306822660",
        user_wx: "13359074748",
        user_email: "1306822660@qq.com",
        user_phone: "13359074748",
        user_address: "马师专7#407"
      },
      formLabelWidth: "120px"
    };
  },
  methods: {
    handleEdit() {
      this.dialogFormVisible = true;
    }
  }
};
</script>

<style></style>
