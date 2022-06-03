<template>
  <div>
    <!-- 头部 -->
    <Header></Header>
    <!-- 主体 -->
    <el-container class="container">
      <el-container>
        <el-aside class="aside" width="200px">
          <!-- 开启路由模式 -->
          <el-menu :router="true" :default-openeds="['1']">
            <el-submenu index="1">
              <template slot="title"
                ><i class="el-icon-menu"></i>超级用户</template
              >
              <el-menu-item-group>
                <el-menu-item index="/usersgl"
                  ><i class="el-icon-user-solid"></i>用户管理</el-menu-item
                >
                <el-menu-item index="/goodsgl"
                  ><i class="el-icon-s-data"></i>商品管理</el-menu-item
                >
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main class="main">
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Header from "@/components/common/Header.vue";
import Footer from "@/components/common/Footer.vue";
export default {
  components: { Header, Footer },
  data() {
    return {};
  },
  created() {
    let root = localStorage.getItem("root");
    let name = localStorage.getItem("name");
    if (root != "21121301037" && name != "wss") {
      this.$router.push({ name: "home" });
    }
  }
};
</script>

<style scoped>
.container {
  margin: 0 auto;
  width: 1200px;
  height: 100%;
}
.aside {
  background-color: #ffffff;
}
</style>
