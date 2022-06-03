<template>
  <div>
    <Header></Header>
    <HeaderLogo></HeaderLogo>
    <!-- 详细区域 -->
    <!-- <template>
      <el-skeleton style="width: 240px">
        <template slot="template">
          <el-skeleton-item
            variant="image"
            style="width: 240px; height: 240px;"
          />
          <div style="padding: 14px;">
            <el-skeleton-item variant="p" style="width: 50%" />
            <div
              style="display: flex; align-items: center; justify-items: space-between;"
            >
              <el-skeleton-item variant="text" style="margin-right: 16px;" />
              <el-skeleton-item variant="text" style="width: 30%;" />
            </div>
          </div>
        </template>
      </el-skeleton>
    </template> -->
    <div class="goods_xq">
      <!-- <el-skeleton
        :rows="1"
        variant="image"
        style="width: 240px; height: 240px;"
        animated
        v-if="this.goodsDetails.length <= 0"
      /> -->

      <el-skeleton-item
        class="xq_left"
        variant="image"
        style="width: 450px; height: 450px;"
        animated
        v-if="this.goodsDetails.length <= 0"
      />

      <div class="xq_left" v-else>
        <div class="img">
          <img :src="aImg" alt="" />
        </div>
        <div class="img_list">
          <ul>
            <li v-for="(item, i) in goodsDetails" :key="i" @click="btnAImg(i)">
              <img :src="item.goods_img" />
            </li>
          </ul>
        </div>
      </div>

      <div class="xq_right">
        <div class="title">
          <b>商品名称：</b
          ><el-skeleton
            :rows="1"
            animated
            v-if="this.goodsDetails.length <= 0"
          />{{ name }}
        </div>
        <div class="price">
          <b>发布时间：</b
          ><el-skeleton
            :rows="1"
            animated
            v-if="this.goodsDetails.length <= 0"
          />{{ time }}
        </div>
        <div class="price">
          <b>商品价格：</b
          ><el-skeleton
            :rows="1"
            animated
            v-if="this.goodsDetails.length <= 0"
          />￥{{ price }}
        </div>
        <el-skeleton :rows="1" animated v-if="this.loveresult == false" />
        <div class="addCart" v-else>
          <el-button
            v-if="isLoveGoods == false"
            @click="addLoveGoods()"
            class="login-btn"
            type="success"
            >加入收藏</el-button
          >
          <el-button
            v-else
            @click="addLoveGoods()"
            class="login-btn"
            type="info"
            disabled
            >已收藏</el-button
          >
        </div>
        <div>
          Ta的在售商品:<span class="tadezaishou" @click="tadezaishou()">
            {{ TaGoodsSize }} </span
          >件
        </div>
        <div class="lxmj">
          <el-button @click="lxmjsj()" class="login-btn" type="primary"
            >联系卖家手机</el-button
          >
          <el-button @click="lxmjwx()" class="login-btn" type="primary"
            >联系卖家微信</el-button
          >
        </div>
        <div class="spms">
          <b>商品描述:</b><br /><el-skeleton
            :rows="1"
            animated
            v-if="this.goodsDetails.length <= 0"
          />
          {{ describe }}
        </div>
      </div>
    </div>
    <el-dialog title="Ta的在售" :visible.sync="dialogVisible" width="50%">
      <!-- 表格 -->
      <el-table :data="TadezaishouData" style="width: 100%" height="500">
        <el-table-column type="index" label="#" width="90"> </el-table-column>
        <el-table-column prop="goods_name" label="商品名称" width="200">
        </el-table-column>
        <el-table-column prop="goods_name" label="商品图片" width="180">
          <template slot-scope="scope">
            <img :src="scope.row.goods_img" alt="" style="width:70px" />
          </template>
        </el-table-column>
        <el-table-column prop="goods_price" label="商品价格（元）" width="180">
        </el-table-column>
        <el-table-column prop="address" label="操作">
          <template slot-scope="scope">
            <el-row>
              <el-button
                type="success"
                round
                @click="ToDetail(scope.row.goods_id)"
                >进入商品详情</el-button
              >
            </el-row>
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/common/Header.vue";
import HeaderLogo from "@/components/common/Header_logo.vue";
import Footer from "@/components/common/Footer.vue";

export default {
  name: "Details",
  components: { Header, HeaderLogo, Footer },
  data() {
    return {
      // Ta的在售
      TaGoodsSize: 0,
      dialogVisible: false,
      TadezaishouData: [
        {
          goods_id: 1,
          goods_name: "美妆蛋",
          goods_img:
            "http://localhost:8080/Interfaces/statics/imgs/2731fdb1-a8ed-4bb6-abc7-802f0dbb5f92.webp",
          goods_price: 30
        },
        {
          goods_id: 2,
          goods_name: "我是名称",
          goods_img:
            "http://localhost:8080/Interfaces/statics/imgs/2731fdb1-a8ed-4bb6-abc7-802f0dbb5f92.webp",
          goods_price: 99
        }
      ],
      // 当前商品是否已经被收藏
      isLoveGoods: false,
      loveresult: false,
      name: "",
      price: "",
      describe: "",
      time: "",
      phone: "",
      wx: "",
      // 一张图片
      aImg: "",
      // 商品id
      goods_id: 0,
      user_id: 0,
      goodsDetails: []
    };
  },
  created() {
    // 获取商品详细信息
    if (this.$route.params.goods_id != undefined) {
      localStorage.setItem("goods_id", this.$route.params.goods_id);
      this.goods_id = localStorage.getItem("goods_id");
    } else {
      this.goods_id = localStorage.getItem("goods_id");
    }
    this.getGoodsDetails();
    // 查询当前商品是否已经被当前用户收藏
    this.queryLoveGoods();
  },
  methods: {
    // 它的在售商品
    tadezaishou() {
      this.dialogVisible = true;
    },
    // 进入商品详情页
    ToDetail(goods_id) {
      console.log(goods_id);
      localStorage.setItem("goods_id", goods_id);
      this.getGoodsDetails();
      this.$router.go(0);
      this.dialogVisible = false;
    },

    // 查询当前商品是否已经被当前用户收藏
    async queryLoveGoods() {
      // 发送请求查询
      const res = await this.$http.post(
        `QueryLoveGoodsServlet?goods_id=${
          this.goods_id
        }&user_id=${localStorage.getItem("user_id")}`
      );
      console.log("res========", res);
      if (res.data) {
        this.isLoveGoods = true;
      } else {
        this.isLoveGoods = false;
      }
      this.loveresult = true;
    },
    // 收藏当前商品
    async addLoveGoods() {
      if (localStorage.getItem("user_id") == undefined) {
        alert("请先登录!!!");
        this.$router.push({ path: "login" });
      } else {
        const res = await this.$http.post(
          `/AddLoveGoodsServlet?goods_id=${this.goods_id}&goods_name=${
            this.goodsDetails[0].goods_name
          }&goods_img=${this.goodsDetails[0].goods_img}&goods_price=${
            this.goodsDetails[0].goods_price
          }&user_id=${localStorage.getItem("user_id")}`
        );
        console.log(res);
        if (res) {
          // 重新加载页面
          this.$router.go(0);
        }
      }
    },
    // 联系卖家手机
    lxmjsj() {
      alert(this.phone);
    },
    // 联系卖家微信
    lxmjwx() {
      alert(this.wx);
    },
    // 显示大图
    btnAImg(i) {
      console.log(i);
      // console.log(this.goodsDetails[i].goods_img);
      this.aImg = this.goodsDetails[i].goods_img;
      console.log(this.aImg);
    },
    // 获取商品详细信息
    async getGoodsDetails() {
      const res = await this.$http.post(
        `GoodsDetailsServlet?goods_id=${this.goods_id}`
      );
      console.log(res);
      this.goodsDetails = res.data;

      this.aImg = this.goodsDetails[0].goods_img;
      this.name = this.goodsDetails[0].goods_name;
      this.price = this.goodsDetails[0].goods_price;
      this.describe = this.goodsDetails[0].goods_describe;
      this.time = this.goodsDetails[0].goods_time;
      this.phone = this.goodsDetails[0].user_phone;
      this.wx = this.goodsDetails[0].user_wx;
      this.user_id = this.goodsDetails[0].user_id;

      // 获取Ta的在售商品
      const res1 = await this.$http.post(
        `GetTaGoodsServlet?user_id=${this.user_id}`
      );
      console.log(res1);
      this.TaGoodsSize = res1.data.length;
      this.TadezaishouData = res1.data;
    }
  }
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
  cursor: pointer;
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
  height: 60px;
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

.tadezaishou {
  cursor: pointer;
  font-size: 30px;
  color: red;
}
</style>
