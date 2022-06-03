package shop.massz.servlet;



import com.alibaba.fastjson.JSON;
import shop.massz.domain.LoveGoodsBean;
import shop.massz.service.LoveGoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoveGoodsServlet", value = "/LoveGoodsServlet")
public class LoveGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取用户id
        String user_id = request.getParameter("user_id");
//        根据用户查询收藏的商品
        List<LoveGoodsBean> result = LoveGoodsService.getLoveGoods(user_id);
        String jsonArray = JSON.toJSONString(result);
        response.getWriter().print(jsonArray);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
