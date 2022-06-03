package shop.massz.servlet;


import shop.massz.service.LoveGoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteLoveGoodsServlet", value = "/DeleteLoveGoodsServlet")
public class DeleteLoveGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String love_id = request.getParameter("love_id");
        System.out.println(love_id);
//        删除当前用户喜欢的商品，根据love_id
        boolean result = LoveGoodsService.deleteGoods(love_id);
        response.getWriter().print(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
