package shop.massz.servlet;


import com.alibaba.fastjson.JSON;
import shop.massz.domain.GoodsBean;
import shop.massz.domain.LoveGoodsBean;
import shop.massz.service.GetTaGoodsService;
import shop.massz.service.LoveGoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//获取Ta的在售商品
@WebServlet(name = "GetTaGoodsServlet", value = "/GetTaGoodsServlet")
public class GetTaGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取用户ID
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        System.out.println("user_id==="+user_id);
        List<GoodsBean> result = GetTaGoodsService.getTaGoods(user_id);
        String jsonArray = JSON.toJSONString(result);
        response.getWriter().print(jsonArray);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
