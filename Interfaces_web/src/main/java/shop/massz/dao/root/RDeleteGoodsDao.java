package shop.massz.dao.root;

import shop.massz.domain.GoodsBean;
import shop.massz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RDeleteGoodsDao {

    public static List<GoodsBean> getGoodsImg(String goods_id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<GoodsBean> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT goods_img FROM goods_img WHERE goods_id = " + goods_id;
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new GoodsBean(rs.getString("goods_img")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm,rs);
        }
        return list;
    }

    public static void deleteGoodsImg(String goods_id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete from goods_img where goods_id = " + goods_id;
            pstm = conn.prepareStatement(sql);
            pstm.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm,rs);
        }
    }

    public static void deleteGoods(String goods_id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete from goods where goods_id = " + goods_id;
            pstm = conn.prepareStatement(sql);
            pstm.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm,rs);
        }
    }
}
