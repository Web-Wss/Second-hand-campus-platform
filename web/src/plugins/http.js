// 插件模块
import axios from "axios";
const MyHttpServer = {};
MyHttpServer.install = Vue => {
  // 后端接口总地址
  axios.defaults.baseURL = "/api";
  // 携带cookie
  axios.defaults.withCredentials = true;

  axios.interceptors.request.use(
    config => {
      config.headers.token = localStorage.getItem("token");
      config.headers.user_username = localStorage.getItem("user_username");
      return config;
    },
    error => {
      console.log("err", err);
    }
  );

  Vue.prototype.$http = axios;
};

export default MyHttpServer;
