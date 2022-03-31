<template>
  <div>
    <Header></Header>
    <HeaderLogo></HeaderLogo>
    <!-- 详细区域 -->
    <div class="goods_xq">
      <div class="xq_left">
        <div class="img">
          <img
            src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d764150a470174741d8b0b04515f7a78.jpg?thumb=1&w=300&h=300&f=webp&q=90"
            alt=""
          />
        </div>
        <div class="img_list">
          <ul>
            <li v-for="i in 5" :key="i">
              <img
                src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d764150a470174741d8b0b04515f7a78.jpg?thumb=1&w=300&h=300&f=webp&q=90"
                alt=""
              />
            </li>
          </ul>
        </div>
      </div>
      <div class="xq_right">
        <div class="title">
          <b>商品名称：</b
          >我是商品名称我是商品名称我是商品名称我是商品名称我是商品名称我是商品名称
        </div>
        <div class="price"><b>商品价格：</b>￥50.00</div>
        <div class="addCart">
          <el-button @click="handleLogin()" class="login-btn" type="success"
            >加入购物车</el-button
          >
        </div>
        <div class="lxmj">
          <el-button @click="handleLogin()" class="login-btn" type="primary"
            >联系卖家</el-button
          >
        </div>
        <div class="spms">
          <b>商品描述:</b
          >商品描述商品描述商品描述商品描述商品描述商品描述商品描述商品描述商品描述商品描述商品描述商品描述
        </div>
      </div>
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/common/Header.vue";
import HeaderLogo from "@/components/common/Header_logo.vue";
import Footer from "@/components/common/Footer.vue";

export default {
  components: { Header, HeaderLogo, Footer }
};
</script>

<style scoped>
.goods_xq {
  margin: 10px auto;
  width: 1200px;
  height: 600px;
  /* background-color: violet; */
}

.goods_xq .xq_left {
  float: left;
  width: 500px;
  height: 600px;
  /* background-color: aqua; */
}
.goods_xq .xq_left .img {
  margin: 10px auto;
  width: 450px;
  height: 450px;
  /* background-color: brown; */
}
.goods_xq .xq_left .img img {
  width: 450px;
  height: 450px;
}
.goods_xq .xq_left .img_list {
  width: 500px;
  height: 100px;
  /* background-color: wheat; */
}
.goods_xq .xq_left .img_list ul li {
  margin: 10px;
  display: block;
  float: left;
  width: 80px;
  height: 80px;
  /* background-color: turquoise; */
  list-style: none;
}
.goods_xq .xq_left .img_list ul li img {
  width: 80px;
  height: 80px;
}

.xq_right {
  font-size: 18px;
  padding: 20px;
  float: right;
  width: 660px;
  height: 560px;
  /* background-color: turquoise; */
}
.xq_right .title {
  width: 650px;
  height: 80px;
  /* background-color: burlywood; */
}
.xq_right .price {
  /* line-height: 50px; */
  margin-top: 15px;
  width: 650px;
  height: 50px;
  /* background-color: burlywood; */
}
.xq_right .addCart {
  margin-top: 15px;
  width: 650px;
  height: 50px;
  /* background-color: burlywood; */
}
.xq_right .lxmj {
  margin-top: 15px;
  width: 650px;
  height: 50px;
  /* background-color: burlywood; */
}
.xq_right .spms {
  margin-top: 15px;
  width: 650px;
  height: 250px;
  /* background-color: burlywood; */
}
</style>
