package shop.massz.servlet;



import com.alibaba.fastjson.JSON;
import shop.massz.service.GoodsSortService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GoodsSortServlet", value = "/GoodsSortServlet")
public class GoodsSortServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Object result = GoodsSortService.getGoodsSort();
        System.out.println(result);
        String jsonArray = JSON.toJSONString(result);
        response.getWriter().print(jsonArray);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
