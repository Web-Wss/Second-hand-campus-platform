<template>
  <div>
    <!-- 头部 -->
    <Header></Header>
    <HeaderLogo></HeaderLogo>
    <!-- 搜索 -->
    <Search></Search>
    <!-- 分类 -->
    <div class="sort_nav">
      <ul class="sort_small">
        <li class="active">女生服装</li>
        <li>男生服装</li>
        <li>美妆护肤</li>
        <li>手机数码</li>
        <li>茶酒美食</li>
        <li>珠宝饰品</li>
        <li>图书文具</li>
        <li>体育用具</li>
      </ul>
    </div>

    <!-- 商品内容 -->
    <div class="goods_list">
      <div class="list" @click="handleDetail()" v-for="item in 25" :key="item">
        <div class="img">
          <img
            src="https://img1.baidu.com/it/u=1172381108,1718486977&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=889"
            alt=""
          />
        </div>
        <div class="title">
          我是商品名称我是商品名称我是商品名称我是商品名称
        </div>
        <div class="price">￥50.00</div>
      </div>
      <!-- 分页 -->
      <div class="block">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-size="25"
          layout="total, prev, pager, next, jumper"
          :total="879"
        >
        </el-pagination>
      </div>
    </div>
    <!-- 尾部 -->
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/common/Header.vue";
import HeaderLogo from "@/components/common/Header_logo.vue";
import Search from "@/components/common/Search.vue";
import Footer from "@/components/common/Footer.vue";

export default {
  components: { Header, HeaderLogo, Search, Footer },
  methods: {
    handleDetail() {
      this.$router.push({ path: "details" });
    }
  }
};
</script>

<style scoped>
.active {
  background-color: aqua;
}
.sort_nav {
  margin-top: 10px;
  width: 100%;
  height: 50px;
  /* background-color: yellowgreen; */
}

.sort_nav .sort_small {
  display: flex;
  margin: 0 auto;
  width: 1200px;
  height: 50px;
  /* background-color: aqua; */
}

.sort_nav .sort_small li {
  cursor: pointer;
  border: 1px solid rgb(87, 197, 44);
  margin: 0px 5px;
  border-radius: 25px;
  text-align: center;
  line-height: 50px;
  width: 100px;
  height: 50px;
  flex: 1;
  /* background-color: rgb(69, 161, 197); */
  float: left;
  list-style: none;
}

/* 商品列表 */
.goods_list {
  display: flex;
  flex-wrap: wrap;
  margin: 10px auto;
  width: 1200px;
  height: 1900px;
  /* background-color: #f4f4f4; */
}
.goods_list .list {
  cursor: pointer;
  border-radius: 25px;
  margin: 10px 20px;
  width: 200px;
  height: 350px;
  background-color: rgb(255, 255, 255);
  transition: all 0.2s linear;
  position: relative;
  top: 0;
}
.goods_list .list:hover {
  box-shadow: 0px 7px 10px 0px #86c9c0;
  top: -4px;
}

.goods_list .list img {
  width: 200px;
  height: 240px;
  border-radius: 25px;
}
.goods_list .list .title {
  text-align: center;
  line-height: 25px;
  width: 200px;
  height: 50px;
  /* background-color: yellow; */
}
.goods_list .list .price {
  border-radius: 25px;
  text-align: center;
  color: red;
  font-size: 26px;
  line-height: 50px;
  width: 200px;
  height: 50px;
  /* background-color: wheat; */
}
/* 分页 */
.block {
  margin: 0 auto;
}
</style>
