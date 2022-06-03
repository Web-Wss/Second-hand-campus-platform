package shop.massz.servlet;



import com.alibaba.fastjson.JSON;
import shop.massz.domain.GoodsBean;
import shop.massz.service.MarketGoodsListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MarketGoodsListServlet", value = "/MarketGoodsListServlet")
public class MarketGoodsListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取商品分类id
        String sort_id = request.getParameter("sort_id");
        String val = request.getParameter("val");
        System.out.println("sort_id====="+sort_id);
        System.out.println("val====="+val);
        if (val == null) {
//            先获取分页下的所有商品
            List<GoodsBean> result = MarketGoodsListService.allGoods(sort_id);
            String jsonArray = JSON.toJSONString(result);
            response.getWriter().print(jsonArray);
        }else {
            //获取分页下的商品
            List<GoodsBean> result1 = MarketGoodsListService.fyGoods(sort_id,val);
            String jsonArray1 = JSON.toJSONString(result1);
            response.getWriter().print(jsonArray1);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
