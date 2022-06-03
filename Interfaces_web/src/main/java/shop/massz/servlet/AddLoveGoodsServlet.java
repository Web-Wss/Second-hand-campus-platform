package shop.massz.servlet;


import shop.massz.domain.LoveGoodsBean;
import shop.massz.service.LoveGoodsService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddLoveGoodsServlet", value = "/AddLoveGoodsServlet")
public class AddLoveGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goods_id1 = request.getParameter("goods_id");
        int goods_id = Integer.parseInt(goods_id1);
        String goods_name = request.getParameter("goods_name");
        String goods_img = request.getParameter("goods_img");
        String goods_price = request.getParameter("goods_price");
        String user_id1 = request.getParameter("user_id");
        int user_id = Integer.parseInt(user_id1);

//        查询goods_love表中love_id字段中最大的值
        int love_id = LoveGoodsService.getMaxLoveId() + 1;
//        将收藏的商品添加到库中
        LoveGoodsBean loveGoodsBean = new LoveGoodsBean();
        loveGoodsBean.setLove_id(love_id);
        loveGoodsBean.setGoods_id(goods_id);
        loveGoodsBean.setGoods_name(goods_name);
        loveGoodsBean.setGoods_img(goods_img);
        loveGoodsBean.setGoods_price(goods_price);
        loveGoodsBean.setUser_id(user_id);
        boolean result = LoveGoodsService.addLoveGoods(loveGoodsBean);
        response.getWriter().print(result);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
