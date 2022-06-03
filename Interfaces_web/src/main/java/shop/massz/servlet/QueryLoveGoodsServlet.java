package shop.massz.servlet;


import shop.massz.service.LoveGoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QueryLoveGoodsServlet", value = "/QueryLoveGoodsServlet")
public class QueryLoveGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goods_id = request.getParameter("goods_id");
        String user_id = request.getParameter("user_id");
        System.out.println("gods_id==="+goods_id);
        System.out.println("user_id==="+user_id);
//        查询收藏的库中有没有此数据
        boolean result = LoveGoodsService.queryLoveGoods(goods_id, user_id);
        response.getWriter().print(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
