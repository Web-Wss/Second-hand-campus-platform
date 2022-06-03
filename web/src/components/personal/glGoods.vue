<template>
  <el-card class="box-card">
    <el-descriptions title="商品管理"> </el-descriptions>
    <!-- 表格 -->
    <el-table :data="Goodslist" style="width: 100%">
      <el-table-column type="index" label="#" width="90"> </el-table-column>
      <el-table-column prop="goods_name" label="商品名称" width="220">
      </el-table-column>
      <el-table-column label="创建时间" width="220">
        <template slot-scope="scope">
          {{ scope.row.goods_time }}
        </template>
      </el-table-column>

      <el-table-column prop="address" label="操作">
        <template slot-scope="scope">
          <el-row>
            <el-button
              plain
              type="danger"
              icon="el-icon-delete"
              circle
              @click="showDeleUserMsgBox(scope.row.goods_id)"
            ></el-button>
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
      user_id: "",
      Goodslist: []
    };
  },
  created() {
    this.user_id = localStorage.getItem("user_id");
    this.getGoodsList();
  },
  methods: {
    // 获取商品
    async getGoodsList() {
      const res = await this.$http.post(
        `PersonGoodsServlet?user_id=${this.user_id}`
      );
      console.log(res);
      this.Goodslist = res.data;
    },
    async showDeleUserMsgBox(goods_id) {
      let yesorno = confirm("确认删除此商品么？");
      if (yesorno) {
        const res = await this.$http.post(
          `DeletePersonGoodsServlet?goods_id=${goods_id}`
        );
        alert("此商品已被删除");
      } else {
        alert("您取消了此操作!!!");
      }
      this.getGoodsList();
    }
  }
};
</script>

<style></style>
