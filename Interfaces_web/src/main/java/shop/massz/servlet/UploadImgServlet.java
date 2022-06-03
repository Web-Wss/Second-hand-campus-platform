package shop.massz.servlet;



import shop.massz.domain.AddGoodsImg;
import shop.massz.domain.GoodsBean;
import shop.massz.service.UploadImgService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;


@WebServlet(name = "UploadImgServlet", value = "/UploadImgServlet")
@MultipartConfig(location = "D:\\",fileSizeThreshold = 1024)
public class UploadImgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Expose-Headers","X-forward-port,X-forwarded-host");
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE");
        response.setHeader("Access-Control-Max-Age","3600");
//        得到商品名
        String goods_name = request.getParameter("goods_name");
        System.out.println("得到商品名:"+goods_name);
//        得到商品价格
        String goods_price = request.getParameter("goods_price");
        System.out.println("得到商品价格:"+goods_price);
//        得到商品分类
        String value = request.getParameter("value");
        int goods_sort = Integer.parseInt(value);
        System.out.println("得到商品分类:"+goods_sort);
//        得到商品描述
        String goods_describe = request.getParameter("goods_describe");
        System.out.println("得到商品描述:"+goods_describe);
//        得到用户id
        String user_id0 = request.getParameter("user_id");
        int user_id = Integer.parseInt(user_id0);
        System.out.println("得到用户id:"+user_id);
//        得到当前web项目的根目录，并在根目录中添加一个子文件夹/goods_img
//        String path = this.getServletContext().getRealPath("/goods_img");
        String path = this.getServletContext().getRealPath("/statics/imgs");

        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();//若没有则创建
        }
//        设置商品good_id从多少开始
        int goods_id = 0;
        goods_id = UploadImgService.GoodsMaxId() + 1;
        GoodsBean goodsBean = new GoodsBean(goods_id,goods_sort,goods_name,goods_price,goods_describe,new Date(),user_id);
//        向数据库中添加商品信息,成功返回true
        boolean b = UploadImgService.addGoods(goodsBean);
        System.out.println("向数据库中添加商品信息是否成功:"+b);
        for (Part part : request.getParts()) {
            //只处理上传文件区段
            if (part.getName().startsWith("file")) {
//                得到上传文件的后缀名
                String fileName = getFileName(part);
                String tup = UUID.randomUUID()+fileName;
                part.write(path+ "\\"+tup);
                System.out.println(path+tup);
//                封装商品图片信息
                String[] goods_img = {tup};
                AddGoodsImg addGoodsImg = new AddGoodsImg(goods_id,goods_img);
                UploadImgService.addImg(addGoodsImg);
            }
        }
    }

    private String getFileName(Part part) {
//        获取图片的具体内容
        String header = part.getHeader("Content-Disposition");
        String fname = header.substring(header.lastIndexOf("."),header.length()-1);
        return fname;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
