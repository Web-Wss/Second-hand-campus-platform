package shop.massz.servlet;

import com.alibaba.fastjson.JSON;
import shop.massz.domain.GoodsBean;
import shop.massz.service.QueryService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryServlet", value = "/QueryServlet")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchvalue = request.getParameter("searchvalue");
        System.out.println(searchvalue);
//        查询用户所有的商品
        List<GoodsBean> result = QueryService.queryGoods(searchvalue);
        String jsonArray1 = JSON.toJSONString(result);
        response.getWriter().print(jsonArray1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
