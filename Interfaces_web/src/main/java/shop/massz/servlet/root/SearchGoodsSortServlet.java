package shop.massz.servlet.root;

import com.alibaba.fastjson.JSON;
import shop.massz.service.root.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchGoodsSortServlet", value = "/SearchGoodsSortServlet")
public class SearchGoodsSortServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("value");
        Object result = GoodsService.searchGoodsSort(value);
        String jsonArray = JSON.toJSONString(result);
        System.out.println(jsonArray);
        response.getWriter().print(jsonArray);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
