// 插件模块
import axios from "axios";
const MyHttpServer = {};
MyHttpServer.install = Vue => {
  // 后端接口总地址
  axios.defaults.baseURL = "/api";
  // 添加实例方法
  // Vue.prototype.$http = axios;
  Vue.prototype.$http = axios;
};
export default MyHttpServer;
