package shop.massz.dao;

import shop.massz.domain.GoodsBean;
import shop.massz.domain.LoveGoodsBean;
import shop.massz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetTaGoodsDao {

    public static List<GoodsBean> getTaGoods(int user_id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<GoodsBean> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM goods a JOIN goods_img b ON a.`goods_id` = b.`goods_id`  WHERE user_id = ? GROUP BY a.`goods_id`";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,user_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new GoodsBean(rs.getString("goods_name"),rs.getString("goods_img"),rs.getString("goods_price"),rs.getInt("goods_id")));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
