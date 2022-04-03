import Vue from "vue";
import Router from "vue-router";
// 引入login
import Login from "@/components/login/login.vue";
import Home from "@/components/home/home.vue";
import Register from "@/components/register/Register.vue";
import Market from "@/components/market/market.vue";
import Details from "@/components/details/details.vue";
import Personal from "@/components/personal/personal.vue";
import Me from "@/components/personal/me.vue";
import AddGoods from "@/components/personal/addGoods.vue";
import GlGoods from "@/components/personal/glGoods.vue";
import Cart from "@/components/personal/cart.vue";
import Ddgl from "@/components/personal/ddgl.vue";

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
      path: "/register",
      name: "Register",
      component: Register
    },
    {
      path: "/home",
      name: "home",
      component: Home
    },
    {
      path: "/market",
      name: "Market",
      component: Market
    },
    {
      path: "/details",
      name: "Details",
      component: Details
    },
    {
      path: "/personal",
      name: "Personal",
      component: Personal,
      children: [
        {
          path: "/me",
          name: "/Me",
          component: Me
        },
        {
          path: "/addGoods",
          name: "/AddGoods",
          component: AddGoods
        },
        {
          path: "/glGoods",
          name: "/GlGoods",
          component: GlGoods
        },
        {
          path: "/cart",
          name: "/Cart",
          component: Cart
        },
        {
          path: "/ddgl",
          name: "/Ddgl",
          component: Ddgl
        }
      ]
    }
  ]
});
