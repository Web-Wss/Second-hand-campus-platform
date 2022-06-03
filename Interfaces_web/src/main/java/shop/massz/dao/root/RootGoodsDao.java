package shop.massz.dao.root;

import shop.massz.domain.GoodsBean;
import shop.massz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RootGoodsDao {
    public static Object getGoodsList(int currentPage) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<GoodsBean> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT  a.*, b.*, c.*, d.user_nickname FROM goods a  JOIN goods_img b  ON a.`goods_id`=b.`goods_id` JOIN goods_sort c ON a.`sort_id` = c.sort_id  JOIN USER d ON a.`user_id` = d.user_id GROUP BY a.goods_id LIMIT ?,?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,(currentPage*6)-6);
            pstm.setInt(2,6);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new GoodsBean(rs.getInt("goods_id"),rs.getString("sort_name"),rs.getString("goods_name"),rs.getString("goods_img"),rs.getString("user_nickname")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn, pstm,rs);
        }
        return list;
    }

//    得到商品总数
    public static int goodsTotal() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int i = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT COUNT(*) FROM Goods;";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm,rs);
        }
        return i;
    }

//    搜索商品--模糊
    public static Object searchGoods(String value) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<GoodsBean> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT  a.*, b.*, c.*, d.user_nickname FROM goods a  JOIN goods_img b  ON a.`goods_id`=b.`goods_id`  JOIN goods_sort c ON a.`sort_id` = c.sort_id  JOIN USER d ON a.`user_id` = d.user_id WHERE CONCAT(a.`goods_name`,d.`user_nickname`)  LIKE "+ "\'%" +value + "%'" + " GROUP BY a.goods_id;";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new GoodsBean(rs.getInt("goods_id"),rs.getString("sort_name"),rs.getString("goods_name"),rs.getString("goods_img"),rs.getString("user_nickname")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

//    搜索分类下的商品
    public static Object searchGoodsSort(String value) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<GoodsBean> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT  a.*, b.*, c.*, d.user_nickname FROM goods a  JOIN goods_img b  ON a.`goods_id`=b.`goods_id`  JOIN goods_sort c ON a.`sort_id` = c.sort_id  JOIN USER d ON a.`user_id` = d.user_id WHERE c.sort_name  = "+ "\'" +value + "'" + " GROUP BY a.goods_id;";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new GoodsBean(rs.getInt("goods_id"),rs.getString("sort_name"),rs.getString("goods_name"),rs.getString("goods_img"),rs.getString("user_nickname")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
