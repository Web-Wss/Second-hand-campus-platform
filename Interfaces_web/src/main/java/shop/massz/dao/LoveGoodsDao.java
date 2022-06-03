package shop.massz.dao;



import shop.massz.domain.LoveGoodsBean;
import shop.massz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoveGoodsDao {

//    获取用户喜欢的商品信息
    public static List<LoveGoodsBean> getLoveGoods(String user_id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<LoveGoodsBean> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM goods_love WHERE user_id = " + user_id;
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new LoveGoodsBean(rs.getInt("love_id"),rs.getInt("goods_id"),rs.getString("goods_name"),rs.getString("goods_img"),rs.getString("goods_price"),rs.getInt("user_id")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    //    删除用户喜欢的商品信息
    public static boolean deleteGoods(String love_id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete from goods_love where love_id = " + love_id;
            pstm = conn.prepareStatement(sql);
            int i = pstm.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

//    得到love_id最大值
    public static int getMaxLoveId() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int love_id = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select MAX(love_id) from goods_love";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                love_id = rs.getInt(1);
            }
            return love_id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return love_id;
    }

//    向数据库中添加收藏的信息
    public static boolean addLoveGoods(LoveGoodsBean loveGoodsBean) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into goods_love values(?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,loveGoodsBean.getLove_id());
            pstm.setInt(2,loveGoodsBean.getGoods_id());
            pstm.setString(3,loveGoodsBean.getGoods_name());
            pstm.setString(4,loveGoodsBean.getGoods_img());
            pstm.setString(5,loveGoodsBean.getGoods_price());
            pstm.setInt(6,loveGoodsBean.getUser_id());
            i = pstm.executeUpdate();
            if (i > 0) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static boolean queryLoveGoods(String goods_id, String user_id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int rowCount;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM goods_love WHERE goods_id = "+ goods_id +" AND user_id = " + user_id;
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.last();
            rowCount = rs.getRow();
            if (rowCount > 0) {
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm,rs);
        }
        return false;
    }
}
