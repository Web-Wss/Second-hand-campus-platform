package shop.massz.servlet;



import com.alibaba.fastjson.JSON;
import shop.massz.domain.GoodsBean;
import shop.massz.service.GoodGoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsGoodsServlet", value = "/GoodsGoodsServlet")
public class GoodsGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GoodsBean> result = GoodGoodsService.getGoodGoods();
        String jsonArray = JSON.toJSONString(result);
        response.getWriter().print(jsonArray);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
