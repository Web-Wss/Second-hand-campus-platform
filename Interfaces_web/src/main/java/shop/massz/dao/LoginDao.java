package shop.massz.dao;



import shop.massz.domain.UserBean;
import shop.massz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public static UserBean Login(String user_username, String user_password) {
        UserBean userBean = new UserBean();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select  * from user where user_username = ? && user_password = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user_username);
            pstm.setString(2, user_password);
            rs = pstm.executeQuery();
            if (rs.next()) {
                userBean.setUser_username(rs.getString("user_username"));
                userBean.setUser_id(rs.getInt("user_id"));
                userBean.setUser_nickname(rs.getString("user_nickname"));
                userBean.setUser_phone(rs.getString("user_phone"));
                userBean.setUser_qq(rs.getString("user_qq"));
                userBean.setUser_wx(rs.getString("user_wx"));
                userBean.setUser_img(rs.getString("user_img"));
                userBean.setUser_status(rs.getString("user_status"));
                userBean.setUser_address(rs.getString("user_address"));
            }
            return userBean;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(conn, pstm, rs);
        }
        return userBean;
    }
}
