<template>
  <div>
    <el-card class="box-card">
      <el-descriptions title="商品发布"> </el-descriptions>
      <el-button @click="handleAddGoods()" class="login-btn" type="primary"
        >发布</el-button
      >
    </el-card>
    <el-dialog title="商品发布页面" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="商品名称：" :label-width="formLabelWidth">
          <el-input v-model="form.goods_name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="商品分类：" :label-width="formLabelWidth">
          <template>
            <el-select v-model="value" placeholder="请选择">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </template>
        </el-form-item>
        <el-form-item label="商品价格" :label-width="formLabelWidth">
          <el-input v-model="form.goods_price" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="商品描述" :label-width="formLabelWidth">
          <el-input v-model="form.goods_describe" autocomplete="off"></el-input>
        </el-form-item>
        <el-upload
          class="upload-demo"
          action="#"
          multiple
          :headers="headers"
          :auto-upload="false"
          :file-list="fileList"
          :on-change="handleChange"
        >
          <el-button size="small" type="primary">点击上传商品图片</el-button>
          <div slot="tip" class="el-upload__tip">
            只能上传jpg/png文件，且不超过500kb
          </div>
        </el-upload>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="upload">发 布</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogFormVisible: false,
      // 分类下拉框
      options: [
        {
          value: "1",
          label: "女士服装"
        },
        {
          value: "2",
          label: "男士服装"
        },
        {
          value: "3",
          label: "美肤护肤"
        },
        {
          value: "4",
          label: "手机数码"
        },
        {
          value: "5",
          label: "食品饮料"
        },
        {
          value: "6",
          label: "珠宝饰品"
        },
        {
          value: "7",
          label: "图书文具"
        },
        {
          value: "8",
          label: "体育用具"
        }
      ],

      // 上传图片列表
      fileList: [],
      // 请求头
      headers: {
        "Content-Type": "multipart/form-data"
      },

      // 上传图片个数
      // dialogFormVisible: false,
      // 商品分类
      value: "",
      // 用户id
      user_id: "",
      // 商品名称，商品价格，商品描述
      form: {
        goods_name: "",
        goods_price: "",
        goods_describe: ""
      },
      formLabelWidth: "120px"
    };
  },
  created() {
    this.user_id = localStorage.getItem("user_id");
  },
  methods: {
    // 发布按钮
    handleAddGoods() {
      this.dialogFormVisible = true;
    },
    handleChange(file, fileList) {
      //文件数量改变
      this.fileList = fileList;
    },

    //商品发布按钮
    upload() {
      var param = new FormData();
      this.fileList.forEach((val, index) => {
        param.append("file", val.raw);
      });
      this.$http
        .post(
          `/UploadImgServlet?user_id=${this.user_id}&value=${this.value}&goods_name=${this.form.goods_name}&goods_price=${this.form.goods_price}&goods_describe=${this.form.goods_describe}`,
          param
        )
        .then(response => {});

      this.$message({
        message: "上传成功!",
        duration: 1000
      });
    }
  }
};
</script>

<style></style>
