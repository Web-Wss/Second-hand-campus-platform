import Vue from "vue";
import Router from "vue-router";
// 引入login
import Login from "@/components/login/login.vue";
import Home from "@/components/home/home.vue";

Vue.use(Router);

export default new Router({
  routes: [
    { path: "*", redirect: "/Login" },
    {
      path: "/login",
      name: "Login",
      component: Login
    },
    {
      path: "/home",
      name: "home",
      component: Home
    }
  ]
});
