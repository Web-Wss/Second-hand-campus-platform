<template>
  <el-card class="card-box">
    <div class="header">
      <div class="search">
        <el-input
          v-model="input"
          placeholder="请输入要搜索的 '用户名' 或 '用户昵称'"
        ></el-input>
      </div>
      <el-button
        class="btnsearch"
        type="primary"
        icon="el-icon-search"
        @click="searchUser()"
        >搜索用户</el-button
      >
      <el-button
        class="btnsearch"
        type="primary"
        icon="el-icon-circle-plus-outline"
        @click="addUser()"
        >添加用户</el-button
      >
    </div>
    <!-- 列表 -->
    <el-table :data="tableData" style="width: 100%" height="580">
      <el-table-column prop="user_id" label="用户ID" min-width="60">
      </el-table-column>
      <el-table-column prop="user_username" label="用户名" min-width="140">
      </el-table-column>
      <el-table-column prop="user_nickname" label="用户昵称" min-width="140">
      </el-table-column>
      <el-table-column prop="user_password" label="密码" min-width="100">
      </el-table-column>
      <el-table-column prop="user_status" label="能否登录" min-width="80">
        <template slot-scope="scope">
          <div>
            <el-switch
              v-model="scope.row.user_status"
              active-color="#13ce66"
              inactive-color="#ff4949"
              @change="change(scope.row.user_id, scope.row.user_status)"
            >
            </el-switch>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="操作" min-width="120">
        <template slot-scope="scope">
          <div>
            <el-button
              type="primary"
              icon="el-icon-edit"
              circle
              @click="EditUserInfo(scope.row)"
            ></el-button>
            <el-button
              type="danger"
              icon="el-icon-delete"
              circle
              @click="DeleteUser(scope.row)"
            ></el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <div class="block" v-show="showfy">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        layout="total, prev, pager, next, jumper"
        :page-size="8"
        :total="user_total"
      >
      </el-pagination>
    </div>

    <!-- 修改框 -->
    <el-dialog title="个人信息修改" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="用户名" :label-width="formLabelWidth">
          <el-input
            v-model="form.user_username"
            autocomplete="off"
            disabled
          ></el-input>
        </el-form-item>
        <el-form-item label="昵称" :label-width="formLabelWidth">
          <el-input v-model="form.user_nickname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="form.user_password" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="sendEditUserInfoBtn()"
          >确 定</el-button
        >
      </div>
    </el-dialog>

    <!-- 添加用户 -->
    <el-dialog title="个人信息修改" :visible.sync="dialogFormVisible1">
      <el-form :model="form">
        <el-form-item label="用户名" :label-width="formLabelWidth">
          <el-input v-model="form.user_username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="昵称" :label-width="formLabelWidth">
          <el-input v-model="form.user_nickname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="form.user_password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机" :label-width="formLabelWidth">
          <el-input v-model="form.user_phone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="QQ" :label-width="formLabelWidth">
          <el-input v-model="form.user_qq" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible1 = false">取 消</el-button>
        <el-button type="primary" @click="sendAddUser()">确 定</el-button>
      </div>
    </el-dialog>
  </el-card>
</template>

<script>
export default {
  data() {
    return {
      showfy: true,
      // 修改用户信息
      formLabelWidth: "120px",
      dialogFormVisible: false,
      dialogFormVisible1: false,
      form: {
        user_id: 0,
        user_username: "",
        user_nickname: "",
        user_password: "",
        type: [],
        user_phone: "",
        user_qq: ""
      },
      currentPage: 1,
      input: "",
      user_total: 0,
      tableData: []
    };
  },
  created() {
    let root = localStorage.getItem("root");
    let name = localStorage.getItem("name");
    if (root != "21121301037" && name != "wss") {
      this.$router.push({ name: "home" });
    }
    this.getUserTotal();
    this.getUserList();
  },
  methods: {
    // 搜索用户
    searchUser() {
      console.log(this.input);
      if (this.input == "") {
        this.$message({
          message: "要搜索的值不能为空!!!",
          type: "error"
        });
      } else {
        this.$http
          .post(`/SearchUserServlet?value=${this.input}`)
          .then(res => {
            console.log(res);
            for (let i = 0; i < res.data.length; i++) {
              if (res.data[i].user_status == 1) {
                res.data[i].user_status = true;
              } else {
                res.data[i].user_status = false;
              }
            }
            this.tableData = res.data;
            this.input = "";
            this.showfy = false;
            this.$message({
              message: "搜索的结果已经以列表形式展示！",
              type: "success"
            });
          })
          .catch(err => {
            console.log(err);
          });
      }
    },
    // 添加用户
    addUser() {
      this.dialogFormVisible1 = true;
    },
    sendAddUser() {
      this.$http
        .post(
          `/AddUserServlet?user_username=${this.form.user_username}&user_password=${this.form.user_password}&user_nickname=${this.form.user_nickname}&user_phone=${this.form.user_phone}&user_qq=${this.form.user_qq}`
        )
        .then(res => {
          console.log(res);
          if (res.data == true) {
            this.$notify({
              title: "成功提示",
              message: "用户已成功添加！",
              type: "success"
            });
            this.getUserTotal();
            this.getUserList();
          }
        })
        .catch(err => {
          console.log(err);
        });

      this.dialogFormVisible1 = false;
    },
    // 删除用户
    DeleteUser(user) {
      // 删除提示
      this.$confirm("此操作将永久删除该用户, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.getUserTotal();
          console.log(user.user_id);
          this.$http
            .post(`/DeleteUserServlet?user_id=${user.user_id}`)
            .then(res => {
              console.log(res);
              console.log("模结果:", this.user_total % 8);
              if (this.user_total % 8 == 1) {
                console.log("前进1页");
                this.handleCurrentChange(this.currentPage - 1);
              } else {
                console.log("没有前进");
                this.handleCurrentChange(this.currentPage);
              }
              this.getUserTotal();
            })
            .catch(err => {
              console.log(err);
            });
          this.$message({
            type: "success",
            message: "删除成功!"
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    // 修改用户信息
    EditUserInfo(user) {
      console.log(user);
      this.dialogFormVisible = true;
      this.form.user_id = user.user_id;
      this.form.user_username = user.user_username;
      this.form.user_nickname = user.user_nickname;
      this.form.user_password = user.user_password;
    },
    sendEditUserInfoBtn() {
      this.$http
        .post(
          `/REditUserInfoServlet?user_id=${this.form.user_id}&user_username=${this.form.user_username}&user_nickname=${this.form.user_nickname}&user_password=${this.form.user_password}`
        )
        .then(res => {
          console.log(res);
          if (res.data == true) {
            this.$notify({
              title: "成功提示",
              message: "用户信息已成功修改！",
              type: "success"
            });
          }
          // 修改成功刷新当前页面
          // 查询总人数
          this.getUserTotal();
          // 最新的总人数
          this.user_total;
          // 判断人数与页数是否匹配
          console.log("前往", this.currentPage);
          this.handleCurrentChange(this.currentPage);
        })
        .catch(err => {
          console.log(err);
        });
      this.dialogFormVisible = false;
    },
    // 改变用户能否登录
    async change(user_id, user_status) {
      // 发送请求
      const res = await this.$http.post(
        `/EditUserStatusServlet?user_id=${user_id}&user_status=${user_status}`
      );
      console.log(res);
      if (res.data == true) {
        this.$message({
          message: "用户能否登录状态已被修改！",
          type: "success"
        });
      }
    },
    // 得到用户总数
    async getUserTotal() {
      const res = await this.$http.get("/UserTotalServlet");
      this.user_total = res.data;
    },
    // 获取用户列表
    async getUserList() {
      const res = await this.$http.post(`/GetUserInfoServlet?currentPage=1`);
      console.log(res);
      for (let i = 0; i < res.data.length; i++) {
        if (res.data[i].user_status == 1) {
          res.data[i].user_status = true;
        } else {
          res.data[i].user_status = false;
        }
      }
      this.tableData = res.data;
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      console.log(`当前页: ${val}`);
      this.$http
        .post(`/GetUserInfoServlet?currentPage=${val}`)
        .then(res => {
          console.log(res);
          for (let i = 0; i < res.data.length; i++) {
            if (res.data[i].user_status == 1) {
              res.data[i].user_status = true;
            } else {
              res.data[i].user_status = false;
            }
          }
          this.tableData = res.data;
        })
        .catch(err => {
          console.log(err);
        });
    }
  }
};
</script>

<style scoped>
.card-box {
  margin: 0 auto;
  /* height: calc(100vh - 45px); */
}
.header {
  width: 100%;
  height: 40px;
  /* background-color: aqua; */
  display: flex;
  margin-bottom: 15px;
}
.search {
  width: 300px;
  margin-right: 10px;
}
/* 分页 */
.block {
  width: 600px;
  margin: 0 auto;
}
</style>
