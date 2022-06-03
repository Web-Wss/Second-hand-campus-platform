package shop.massz.servlet.root;

import com.alibaba.fastjson.JSON;
import shop.massz.service.root.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchGoodsServlet", value = "/SearchGoodsServlet")
public class SearchGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        搜索商品列表 ------ 模糊搜索
        String value = request.getParameter("value");
        Object result = GoodsService.searchGoods(value);
        String jsonArray = JSON.toJSONString(result);
        System.out.println(jsonArray);
        response.getWriter().print(jsonArray);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
