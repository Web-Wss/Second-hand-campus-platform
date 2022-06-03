package shop.massz.servlet;

import com.alibaba.fastjson.JSON;
import shop.massz.domain.GoodsBean;
import shop.massz.service.GoodsDetailsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsDetailsServlet", value = "/GoodsDetailsServlet")
public class GoodsDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goods_id = request.getParameter("goods_id");
        System.out.println(goods_id);
        List<GoodsBean> result = GoodsDetailsService.query(goods_id);
        String jsonArray = JSON.toJSONString(result);
        System.out.println(jsonArray);
        response.getWriter().print(jsonArray);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
