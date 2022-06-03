package shop.massz.dao;


import shop.massz.domain.GoodsBean;
import shop.massz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarketGoodsListQuery {
    public static List<GoodsBean> allGoods(String sort_id) {
        List<GoodsBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT  * FROM goods a  JOIN goods_img b  ON a.`goods_id`=b.`goods_id` AND a.sort_id ="+ "\'" +sort_id+"\'" +"GROUP BY a.`goods_id`  ORDER BY a.`goods_id` DESC;";
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

//    分页下的所有商品
    public static List<GoodsBean> fyGoods(String sort_id, String val) {
        List<GoodsBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            int val1 = Integer.parseInt(val);
            int startval = val1 * 25 - 25;
            int endval = val1 * 25;
            String sql1 = "SELECT  * FROM goods a  JOIN goods_img b  ON a.`goods_id`=b.`goods_id` AND a.sort_id=" + "\'" +sort_id +"\'" + "GROUP BY a.`goods_id`  ORDER BY a.`goods_id` DESC LIMIT "+startval+","+endval;
            pstm = conn.prepareStatement(sql1);
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

}
