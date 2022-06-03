import Vue from "vue";
import Router from "vue-router";
// 引入login
import Login from "@/components/login/login.vue";
import Home from "@/components/home/home.vue";
import Register from "@/components/register/Register.vue";
import Market from "@/components/market/market.vue";
import Details from "@/components/details/details.vue";
import Query from "@/components/query/query.vue";
import Personal from "@/components/personal/personal.vue";
import Me from "@/components/personal/me.vue";
import AddGoods from "@/components/personal/addGoods.vue";
import GlGoods from "@/components/personal/glGoods.vue";
import Cart from "@/components/personal/cart.vue";
// import Ddgl from "@/components/personal/ddgl.vue";

import Root from "@/components/root/root.vue";
import UsersGl from "@/components/root/usersgl.vue";
import GoodsGl from "@/components/root/goodsgl.vue";

Vue.use(Router);

const router = new Router({
  base: "/dist",
  mode: "hash",
  // base: process.env.BASE_URL,
  routes: [
    { path: "*", redirect: "/Home" },
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
      path: "/query",
      name: "Query",
      component: Query
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
        }
        // {
        //   path: "/ddgl",
        //   name: "/Ddgl",
        //   component: Ddgl
        // }
      ]
    },
    {
      path: "/root",
      name: "Root",
      component: Root,
      children: [
        {
          path: "/usersgl",
          name: "/UsersGl",
          component: UsersGl
        },
        {
          path: "/goodsGl",
          name: "/GoodsGl",
          component: GoodsGl
        }
      ]
    }
  ]
});

// 添加导航守卫
router.beforeEach((to, from, next) => {
  if (
    to.path === "/login" ||
    to.path === "/register" ||
    to.path === "/home" ||
    to.path === "/details" ||
    to.path === "/market"
  ) {
    next();
    // to and from are both route objects. must call `next`.
  } else {
    let token = localStorage.getItem("token");
    if (token === null || token === "") {
      alert("请登录！");
      next("/login");
    }
    next();
  }
});

export default router;
