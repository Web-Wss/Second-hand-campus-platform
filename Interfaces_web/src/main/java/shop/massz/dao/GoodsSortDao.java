package shop.massz.dao;


import shop.massz.domain.GoodsSortBean;
import shop.massz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsSortDao {
    public static List<GoodsSortBean> getGoodsSort(){
        List<GoodsSortBean> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from goods_sort";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                list.add(new GoodsSortBean(rs.getString("sort_id"), rs.getString("sort_name")));
            }
//            System.out.println(list);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
//            C3P0Util.release(conn,psmt,rs);
        }
        return list;
    }
}
