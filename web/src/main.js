// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from "vue";
import App from "./App";
import router from "./router";
import { v4 as uuidv4 } from "uuid";

// 引入elementUI
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import "@/assets/css/reset.css";
// 导入 MyHttpServer
import MyHttpServer from "@/plugins/http";

//使用elementUI组件
Vue.use(ElementUI);
// 使用MyHttpServer插件
Vue.use(MyHttpServer);
Vue.use(uuidv4);

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: "#app",
  router,
  components: { App },
  template: "<App/>"
});
