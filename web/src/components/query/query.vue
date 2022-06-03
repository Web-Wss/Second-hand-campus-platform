<template>
  <div>
    <!-- 头部 -->
    <Header></Header>
    <HeaderLogo></HeaderLogo>
    <Search @checkshow="checkshowFn"></Search>
    <div class="searchList">
      <div
        class="list"
        @click="handleDetail(item.goods_id)"
        v-for="(item, i) in MarketGoodsList"
        :key="i"
      >
        <div class="img">
          <img :src="item.goods_img" alt="" />
        </div>
        <div class="title">
          {{ item.goods_name }}
        </div>
        <div class="price">￥{{ item.goods_price }}</div>
      </div>
    </div>
  </div>
</template>

<script>
import Header from "@/components/common/Header.vue";
import HeaderLogo from "@/components/common/Header_logo.vue";
import Search from "@/components/common/Search.vue";
import Footer from "@/components/common/Footer.vue";
export default {
  components: {
    Header,
    Footer,
    HeaderLogo,
    Search
  },
  data() {
    return {
      searchvalue: "",
      // 商品列表
      MarketGoodsList: []
    };
  },

  created() {
    this.searchvalue = this.$route.params.searchvalue;
    console.log("123123", this.$route.params.searchvalue);
    this.getGoodsList();
  },

  methods: {
    // 去商品详情页
    handleDetail(goods_id) {
      // this.$router.push({ path: "details" });
      this.$router.push({ name: "Details", params: { goods_id: goods_id } });
    },
    async checkshowFn(f) {
      this.searchvalue = f;
      const res = await this.$http.post(`/QueryServlet?searchvalue=${f}`);
      console.log(res);
      this.MarketGoodsList = res.data;
      console.log("父组件中:", f);
    },
    // 获取查询的商品列表
    async getGoodsList() {
      const res = await this.$http.post(
        `/QueryServlet?searchvalue=${this.searchvalue}`
      );
      console.log(res);
      this.MarketGoodsList = res.data;
    }
  }
};
</script>

<style scoped>
/* 商品列表 */
.searchList {
  display: flex;
  flex-wrap: wrap;
  margin: 10px auto;
  width: 1200px;
  /* height: 1900px; */
  /* background-color: #f4f4f4; */
}
.searchList .list {
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
.searchList .list:hover {
  box-shadow: 0px 7px 10px 0px #86c9c0;
  top: -4px;
}

.searchList .list img {
  width: 200px;
  height: 240px;
  border-radius: 25px;
}
.searchList .list .title {
  text-align: center;
  line-height: 25px;
  width: 200px;
  height: 50px;
  /* background-color: yellow; */
}
.searchList .list .price {
  border-radius: 25px;
  text-align: center;
  color: red;
  font-size: 26px;
  line-height: 50px;
  width: 200px;
  height: 50px;
  /* background-color: wheat; */
}
</style>
