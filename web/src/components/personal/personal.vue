<template>
  <div>
    <!-- 头部 -->
    <Header></Header>
    <Headerlogo></Headerlogo>
    <!-- 主体 -->
    <el-container class="container">
      <el-container>
        <el-aside class="aside" width="200px">
          <!-- 开启路由模式 -->
          <el-menu :router="true" :default-openeds="['1']">
            <el-submenu index="1">
              <template slot="title"
                ><i class="el-icon-menu"></i>个人中心</template
              >
              <el-menu-item-group>
                <el-menu-item index="/me"
                  ><i class="el-icon-user-solid"></i>个人信息</el-menu-item
                >
                <el-menu-item index="/addGoods"
                  ><i class="el-icon-circle-plus"></i>商品发布</el-menu-item
                >
                <el-menu-item index="/glGoods"
                  ><i class="el-icon-s-data"></i>商品管理</el-menu-item
                >
                <el-menu-item index="/cart"
                  ><i class="el-icon-s-goods"></i>购物车</el-menu-item
                >
                <el-menu-item index="/ddgl"
                  ><i class="el-icon-s-order"></i>订单管理</el-menu-item
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
    <!-- 尾部 -->
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/common/Header.vue";
import Footer from "@/components/common/Footer.vue";
import Headerlogo from "../common/Header_logo.vue";

export default {
  components: { Header, Footer, Headerlogo }
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
.main {
  /* background-color: #e4e4e4; */
}
/* 头部样式 */
.middle {
  text-align: center;
  line-height: 60px;
}
.loginout {
  line-height: 60px;
  text-decoration: none;
}
</style>
