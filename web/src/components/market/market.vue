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
        <li
          v-for="(item, i) in goodsSort"
          :key="i"
          @click="handleSort(item.sort_id)"
          :class="{ active: one === item.sort_id }"
        >
          {{ item.sort_name }}
        </li>
      </ul>
    </div>

    <!-- 商品内容 -->
    <el-skeleton v-if="MarketGoodsList.length <= 0" :rows="6" animated />

    <div class="goods_list" v-else>
      <div
        class="list"
        @click="handleDetail(item.goods_id)"
        v-for="(item, i) in MarketGoodsList.slice(0, 25)"
        :key="i"
      >
        <div class="img">
          <img :src="item.goods_img" />
        </div>
        <div class="title">
          {{ item.goods_name }}
        </div>
        <div class="price">￥{{ item.goods_price }}</div>
      </div>
    </div>
    <!-- 分页 -->
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="25"
        layout="total, prev, pager, next, jumper"
        :total="total"
        :key="key"
      >
      </el-pagination>
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
  data() {
    return {
      // 分页信息
      total: 0,
      key: 1,
      one: "1",
      currentPage: 1,
      // 商品分类
      goodsSort: [
        { sort_id: 1, sort_name: "女士服装" },
        { sort_id: 2, sort_name: "男士服装" },
        { sort_id: 3, sort_name: "美妆护肤" },
        { sort_id: 4, sort_name: "手机数码" },
        { sort_id: 5, sort_name: "食品饮料" },
        { sort_id: 6, sort_name: "珠宝饰品" },
        { sort_id: 7, sort_name: "图书文具" },
        { sort_id: 8, sort_name: "体育用品" }
      ],
      // 商品列表
      MarketGoodsList: []
    };
  },
  created() {
    // 获取分类
    this.getGoodsSort();
    // 给one赋值
    // this.one = this.$route.params.sort_id;
    if (this.$route.params.sort_id != undefined) {
      localStorage.setItem("sort_id", this.$route.params.sort_id);
      this.one = localStorage.getItem("sort_id");
    } else {
      this.one = localStorage.getItem("sort_id");
    }

    // console.log(this.$route.params.sort_id);
    // 进入页面获取分类下的数据
    this.getGoodsList();
  },

  methods: {
    // 获取商品列表
    async getGoodsList() {
      const res = await this.$http.post(
        `/MarketGoodsListServlet?sort_id=${this.one}`
      );
      console.log("101", res);
      this.MarketGoodsList = res.data;
      this.total = this.MarketGoodsList.length;
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      // 获取当前页的数据
      this.getCurrentList(`${val}`);
    },
    // 获取当前页的数据
    async getCurrentList(val) {
      const res = await this.$http.post(
        `/MarketGoodsListServlet?sort_id=${this.one}&val=${val}`
      );
      this.MarketGoodsList = res.data;
    },

    // 点击不同分类
    handleSort(sort_id) {
      // 用于分页重新加载
      this.key++;
      console.log(sort_id);
      localStorage.setItem("sort_id", sort_id);
      this.one = sort_id;
      // 请求当前分类下的商品
      this.getGoodsList();
    },

    // 获取分类
    async getGoodsSort() {
      const res = await this.$http.post("/GoodsSortServlet");
      this.goodsSort = res.data;
    },

    handleDetail(goods_id) {
      // this.$router.push({ path: "details" });
      this.$router.push({ name: "Details", params: { goods_id: goods_id } });
    }
  }
};
</script>

<style scoped>
.active {
  background-color: rgb(58, 195, 140);
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
  /* height: 1900px; */
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
  width: 500px;
  margin: 0 auto;
}
</style>
