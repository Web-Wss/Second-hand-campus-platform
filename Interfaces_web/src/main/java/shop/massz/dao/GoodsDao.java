package shop.massz.dao;



import shop.massz.domain.GoodsBean;
import shop.massz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {
//    得到home首页的10条商品数据——好物推荐
    public static List<GoodsBean> getGoodGoods() {
        List<GoodsBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT  * FROM goods a  JOIN goods_img b  ON a.`goods_id`=b.`goods_id` GROUP BY a.goods_id ORDER BY RAND() LIMIT 10";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new GoodsBean(rs.getInt("goods_id"),rs.getInt("sort_id"),rs.getString("goods_name"),rs.getString("goods_price"),rs.getString("goods_describe"),rs.getDate("goods_time"),rs.getInt("user_id"),rs.getInt("id"),rs.getString("goods_img")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm,rs);
        }
        return list;
    }

//    获得商品详细信息
    public static List<GoodsBean> getGoodsDetails(String goods_id) {
        List<GoodsBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "   SELECT * FROM goods a JOIN goods_img b  ON a.`goods_id`=b.`goods_id` JOIN USER c ON c.user_id = a.user_id  WHERE a.`goods_id` = " + goods_id;
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new GoodsBean(rs.getInt("goods_id"),rs.getInt("sort_id"),rs.getString("goods_name"),rs.getString("goods_price"),rs.getString("goods_describe"),rs.getDate("goods_time"),rs.getInt("user_id"),rs.getInt("id"),rs.getString("goods_img"),rs.getString("user_username"),rs.getString("user_nickname"),rs.getString("user_phone"),rs.getString("user_wx")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm,rs);
        }
        return list;
    }

    public static List<GoodsBean> getPersonGoods(String user_id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<GoodsBean> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from goods where user_id = " + user_id;
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new GoodsBean(rs.getInt("goods_id"),rs.getInt("sort_id"),rs.getString("goods_name"),rs.getString("goods_price"),rs.getString("goods_describe"),rs.getDate("goods_time"),rs.getInt("user_id")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm,rs);
        }
        return list;
    }

    //    模糊查询
    public static List<GoodsBean> queryGoods(String searchvalue) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<GoodsBean> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT  * FROM goods a  JOIN goods_img b  ON a.`goods_id` = b.`goods_id` WHERE goods_name LIKE " + "\'%" + searchvalue + "%\'" + " GROUP BY a.`goods_id` ORDER BY a.`goods_id` DESC";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new GoodsBean(rs.getInt("goods_id"),rs.getInt("sort_id"),rs.getString("goods_name"),rs.getString("goods_price"),rs.getString("goods_describe"),rs.getDate("goods_time"),rs.getInt("user_id"),rs.getInt("id"),rs.getString("goods_img")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
