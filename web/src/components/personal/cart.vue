<template>
  <el-card class="box-card">
    <el-descriptions title="我的收藏"> </el-descriptions>
    <!-- 表格 -->
    <el-table :data="love_list" style="width: 100%">
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
              plain
              type="danger"
              icon="el-icon-delete"
              circle
              @click="DeleteLoveGoods(scope.row.love_id)"
            ></el-button>
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
  </el-card>
</template>

<script>
export default {
  data() {
    return {
      // 我的收藏商品列表
      love_list: [],
      // 用户id
      user_id: 0
    };
  },

  created() {
    // 进入页面之前查询数据库中当前用户收藏的商品
    this.user_id = localStorage.getItem("user_id");
    this.getLoveGoodsList();
  },
  methods: {
    // 删除收藏的商品
    async DeleteLoveGoods(love_id) {
      let yesorno = confirm("确认删除此商品的收藏么？");
      if (yesorno) {
        const res = await this.$http(
          `/DeleteLoveGoodsServlet?love_id=${love_id}`
        );
        if (res) {
          alert("此收藏的商品已被删除");
          this.getLoveGoodsList();
        } else {
          alert("删除失败，请稍后重试!!!");
        }
      }
    },
    // 进入商品详情页
    ToDetail(goods_id) {
      console.log(goods_id);
      this.$router.push({ name: "Details", params: { goods_id: goods_id } });
    },
    // 获取当前用户收藏的商品
    async getLoveGoodsList() {
      const res = await this.$http.post(
        `/LoveGoodsServlet?user_id=${this.user_id}`
      );
      console.log(res);
      this.love_list = res.data;
    }
  }
};
</script>

<style scoped></style>
