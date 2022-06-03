package shop.massz.servlet;

import shop.massz.service.DeletePersonGoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletePersonGoodsServlet", value = "/DeletePersonGoodsServlet")
public class DeletePersonGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goods_id = request.getParameter("goods_id");
        System.out.println(goods_id);
//        String paths = request.getSession().getServletContext().getRealPath("/statics/imgs");
//        String path = paths.substring(0,paths.length()-10);
        String path = this.getServletContext().getRealPath("/statics/imgs");
        System.out.println(path);
//        删除商品
        DeletePersonGoodsService.delete(goods_id,path);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
