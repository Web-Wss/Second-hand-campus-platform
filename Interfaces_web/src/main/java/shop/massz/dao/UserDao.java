package shop.massz.dao;



import shop.massz.domain.UserBean;
import shop.massz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public static boolean editUserInfo(UserBean userBean) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "UPDATE USER SET user_username = ?, user_nickname = ?,user_phone = ?,user_qq = ?,user_wx = ?,user_address = ? WHERE user_id = " + userBean.getUser_id();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,userBean.getUser_username());
//            pstm.setString(2,userBean.getUser_password());
            pstm.setString(2,userBean.getUser_nickname());
            pstm.setString(3,userBean.getUser_phone());
            pstm.setString(4,userBean.getUser_qq());
            pstm.setString(5,userBean.getUser_wx());
            pstm.setString(6,userBean.getUser_address());
            i = pstm.executeUpdate();
            if (i > 0) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm);
        }
        return false;
    }

//    注册用户
    public static boolean register(UserBean userBean) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO USER (user_username,user_password,user_nickname,user_phone,user_qq) VALUES(?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userBean.getUser_username());
            pstm.setString(2,userBean.getUser_password());
            pstm.setString(3,userBean.getUser_nickname());
            pstm.setString(4, userBean.getUser_phone());
            pstm.setString(5, userBean.getUser_qq());
            i = pstm.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm);
        }
        return false;
    }
}
