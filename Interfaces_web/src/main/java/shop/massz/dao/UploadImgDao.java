package shop.massz.dao;



import shop.massz.domain.AddGoodsImg;
import shop.massz.domain.GoodsBean;
import shop.massz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadImgDao {

    public static int getGoodsMaxId() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int GoodsMaxId = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT MAX(goods_id) FROM goods;";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                GoodsMaxId = rs.getInt(1);
            }
            return GoodsMaxId;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm,rs);
        }
        return GoodsMaxId;
    }

    public static boolean addGoods(GoodsBean goodsBean) {
        int goods_id = goodsBean.getGoods_id();
        int sort_id = goodsBean.getSort_id();
        String goods_name = goodsBean.getGoods_name();
        String goods_price = goodsBean.getGoods_price();
        String goods_describe = goodsBean.getGoods_describe();
        Date time = goodsBean.getGoods_time();
        int user_id = goodsBean.getUser_id();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String goods_time = sdf.format(time);

        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into goods values(" + "\'"+goods_id +"\'"+"," +"\'"+ sort_id+ "\'"+ ","+"\'"+goods_name+ "\'"+","+"\'"+goods_price+ "\'"+","+"\'"+goods_describe+ "\'"+","+"\'"+goods_time+ "\'"+","+"\'"+user_id + "\'"+ ")";
            pstm = conn.prepareStatement(sql);
            int b = pstm.executeUpdate();
            if (b > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm);
        }
        return false;
    }

//    添加商品图片到数据库中
    public static void addImg(AddGoodsImg addGoodsImg ) {
        String[] goods_img = addGoodsImg.getGoods_img();
        int goods_id = addGoodsImg.getGoods_id();
        Connection conn = null;
        PreparedStatement pstm = null;
        boolean b = true;
        try {
            conn = JDBCUtil.getConnection();
            for (int i = 0; i < goods_img.length; i ++) {
                String sql = "insert into goods_img (goods_id,goods_img) values("+goods_id+","+ "\'" + "http://localhost:8080/Interfaces/statics/imgs/" + goods_img[i]+"\'"+")";
                pstm = conn.prepareStatement(sql);
                pstm.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm);
        }

    }
}
