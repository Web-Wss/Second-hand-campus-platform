<template>
  <el-card class="box-card">
    <el-descriptions title="商品管理"> </el-descriptions>
    <!-- 表格 -->
    <el-table :data="Goodslist" style="width: 100%">
      <el-table-column type="index" label="#" width="60"> </el-table-column>
      <el-table-column prop="username" label="商品名称" width="320">
      </el-table-column>
      <el-table-column label="创建时间" width="200">
        <template slot-scope="scope">
          {{ scope.row.create_time | fmtdate }}
        </template>
      </el-table-column>

      <el-table-column prop="address" label="操作">
        <template slot-scope="scope">
          <el-row>
            <el-button
              size="mini"
              plain
              type="primary"
              icon="el-icon-edit"
              circle
              @click="showEditUserDia(scope.row)"
            ></el-button>
            <el-button
              size="mini"
              plain
              type="danger"
              icon="el-icon-delete"
              circle
              @click="showDeleUserMsgBox(scope.row.id)"
            ></el-button>
            <el-button
              size="mini"
              plain
              type="success"
              icon="el-icon-check"
              circle
              @click="showSetUseerRoleDia(scope.row)"
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
      Goodslist: [
        {
          id: 1,
          username: "商品名称商品名称商品名称商品名称",
          create_time: "2022-4-1"
        },
        {
          id: 1,
          username: "商品名称商品名称商品名称商品名称",
          create_time: "2022-4-1"
        },
        {
          id: 1,
          username: "商品名称商品名称商品名称商品名称",
          create_time: "2022-4-1"
        },
        {
          id: 1,
          username: "商品名称商品名称商品名称商品名称",
          create_time: "2022-4-1"
        },
        {
          id: 1,
          username: "商品名称商品名称商品名称商品名称",
          create_time: "2022-4-1"
        },
        {
          id: 1,
          username: "商品名称商品名称商品名称商品名称",
          create_time: "2022-4-1"
        },
        {
          id: 1,
          username: "商品名称商品名称商品名称商品名称",
          create_time: "2022-4-1"
        },
        {
          id: 1,
          username: "商品名称商品名称商品名称商品名称",
          create_time: "2022-4-1"
        },
        {
          id: 1,
          username: "商品名称商品名称商品名称商品名称",
          create_time: "2022-4-1"
        },
        {
          id: 1,
          username: "商品名称商品名称商品名称商品名称",
          create_time: "2022-4-1"
        }
      ]
    };
  }
};
</script>

<style></style>
