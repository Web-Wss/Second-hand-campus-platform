<template>
  <div>
    <!-- 头部 -->
    <Header></Header>
    <HeaderLogo></HeaderLogo>
    <!-- 搜索 -->
    <Search></Search>
    <!-- 主体 -->
    <div class="main">
      <div class="main_nav">
        <span>商品分类</span>
        <ul>
          <li
            v-for="(item, i) in goodsSort"
            :key="i"
            @click="ToMarket(item.sort_id)"
          >
            {{ item.sort_name }}
          </li>
        </ul>
      </div>
      <div class="main_swiper">
        <div class="swiper_show">
          <template>
            <el-carousel :interval="5000" height="420px">
              <el-carousel-item v-for="item in goodGoods" :key="item.id">
                <img
                  :src="item.goods_img"
                  alt=""
                  width="930px"
                  height="420px"
                  @click="imgToDetail(item.goods_id)"
                />
              </el-carousel-item>
            </el-carousel>
          </template>
        </div>
      </div>
    </div>

    <!-- 每周精选 -->
    <div class="week">
      <ul>
        <li v-for="item in swiperList" :key="item.id">
          <img :src="item.src" alt="" />
        </li>
      </ul>
    </div>

    <!-- 好物 -->
    <div class="goodGoods">
      <span>—— —— —— —— —— 好物抢先购 —— —— —— —— ——</span>
      <div class="goodGoods_list">
        <ul>
          <li
            v-for="(item, i) in goodGoods"
            :key="i"
            @click="ToDetail(item.goods_id)"
          >
            <img :src="item.goods_img" />
            <div class="name">{{ item.goods_name }}</div>
          </li>
        </ul>
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
  components: {
    Header,
    Footer,
    HeaderLogo,
    Search
  },
  data() {
    return {
      // 好物列表
      goodGoods: [],
      // 分类列表
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
      // 轮播图列表
      swiperList: [
        {
          id: 1,
          src:
            "https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/39bb34167f6c178d6bb768d8872c97f8.jpg?w=2452&h=920"
        },
        {
          id: 2,
          src:
            "https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/222d6c61df75f30e6782ec476d5c8273.jpg?thumb=1&w=1226&h=460&f=webp&q=90"
        },
        {
          id: 3,
          src:
            "https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/dd741adcce9417d72ea4c1a6dfcc96e2.jpg?thumb=1&w=1226&h=460&f=webp&q=90"
        },
        {
          id: 4,
          src:
            "https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/918820682e4a490221cfd92b24c14b86.jpg?thumb=1&w=1226&h=460&f=webp&q=90"
        }
      ]
    };
  },
  created() {
    // 获取分类
    this.getGoodsSort();
    // 获取好物列表
    this.getGoodGoods();
  },
  methods: {
    ToMarket(sort_id) {
      console.log(sort_id);
      this.$router.push({ name: "Market", params: { sort_id: sort_id } });
    },
    // 跳转到商品详情页面
    ToDetail(goods_id) {
      console.log(goods_id);
      this.$router.push({ name: "Details", params: { goods_id: goods_id } });
    },
    // 获取好物列表
    async getGoodGoods() {
      const res = await this.$http.get("/GoodsGoodsServlet");
      // console.log("goodgoods:", res);
      this.goodGoods = res.data;
      console.log(res);
    },
    // 获取分类列表
    async getGoodsSort() {
      const res = await this.$http.post("/GoodsSortServlet");
      this.goodsSort = res.data;
    },

    imgToDetail(goods_id) {
      console.log(goods_id);
    }
  }
};
</script>

<style scoped>
/* 主体 */
.main {
  margin: 50px auto 0px;
  width: 1200px;
  height: 420px;
  /* background-color: violet; */
}
.main .main_nav {
  width: 250px;
  height: 420px;
  box-shadow: -9px 9px 30px rgb(207 207 207 / 50%);
  float: left;
}
.main .main_nav span {
  text-align: center;
  display: block;
  width: 250px;
  height: 50px;
  line-height: 50px;
  background-color: rgb(96, 163, 132);
}
.main .main_nav ul {
  width: 250px;
  height: 370px;
  background-color: rgb(247 255 249);
}
.main .main_nav ul li {
  width: 250px;
  height: 45px;
  line-height: 45px;
  text-align: center;
  list-style: none;
}
.main .main_nav ul li:hover {
  cursor: pointer;
  background-color: rgb(98, 165, 177);
}

/* 轮播 */
.main_swiper {
  float: right;
  width: 930px;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 420px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
/* 每周精选 */
.week {
  margin: 10px auto;
  width: 1200px;
  height: 180px;
  /* background-color: rgb(11, 155, 119); */
}
.week ul {
  width: 1200px;
  display: flex;
}
.week ul li {
  margin: 10px 10px;
  flex: 1;
  border-radius: 50px;
  list-style: none;
  width: 280px;
  height: 150px;
  background-color: rgb(25, 175, 25);
}
.week ul li img {
  width: 280px;
  height: 150px;
  border-radius: 50px;
}

/* 好物 */
.goodGoods {
  margin: 10px auto;
  width: 1200px;
  height: 700px;
  /* background-color: blueviolet; */
}
.goodGoods span {
  display: block;
  font-size: 26px;
  text-align: center;
  width: 1200px;
  height: 50px;
  line-height: 50px;
  /* background-color: antiquewhite; */
}
.goodGoods .goodGoods_list {
  width: 1200px;
  height: 650px;
  /* background-color: violet; */
}
.goodGoods .goodGoods_list ul {
  display: flex;
  flex-wrap: wrap;
  position: absolute;
  width: 1200px;
}
.goodGoods .goodGoods_list ul li {
  cursor: pointer;
  top: 0;
  list-style: none;
  margin: 10px 20px;
  border-radius: 25px;
  width: 200px;
  height: 300px;
  position: relative;
  margin-top: 5px;
  transition: all 0.2s linear;
  /* background-color: aqua; */
}
.goodGoods .goodGoods_list ul li:hover {
  box-shadow: 0px 7px 10px 0px #86c9c0;
  top: -4px;
}

.goodGoods .goodGoods_list ul li img {
  border-radius: 25px;
  width: 200px;
  height: 220px;
}
.goodGoods .goodGoods_list ul li .name {
  margin: 0 auto;
  width: 170px;
  height: 70px;
  text-align: center;
  line-height: 70px;
  /* background-color: wheat; */
}
</style>
