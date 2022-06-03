package shop.massz.dao.root;

import shop.massz.domain.UserBean;
import shop.massz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RootUserDao {
    public static Object searchUser(String value) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<UserBean> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM USER WHERE CONCAT(user_username,user_nickname) LIKE "+ "\'%" + value + "%\'";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new UserBean(rs.getInt("user_id"),rs.getString("user_username"),rs.getString("user_nickname"),rs.getString("user_password"),String.valueOf(rs.getInt("user_status"))));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm,rs);
        }
        return list;
    }

//    得到所有用户--分页
    public static Object getUserList(int currentPage) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<UserBean> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM USER  LIMIT ?,?;";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,(currentPage*8)-8);
            pstm.setInt(2,8);
            rs = pstm.executeQuery();
            while (rs.next()) {
//                userBean.setUser_id(rs.getInt("user_id"));
//                userBean.setUser_username(rs.getString("user_username"));
//                userBean.setUser_nickname(rs.getString("user_nickname"));
//                userBean.setUser_password(rs.getString("user_password"));
//                userBean.setUser_status(rs.getString("user_status"));
                list.add(new UserBean(rs.getInt("user_id"),rs.getString("user_username"),rs.getString("user_nickname"),rs.getString("user_password"),String.valueOf(rs.getInt("user_status"))));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm,rs);
        }
        return list;
    }

//    获取用户总数
    public static int userTotal() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int i = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT COUNT(*) FROM USER;";
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

//    修改用户状态
    public static boolean editUserStatus(int user_id, int status) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update user set user_status = ? where user_id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,status);
            pstm.setInt(2,user_id);
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

//    修改用户信息
    public static boolean editUserInfo(UserBean userBean) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "update user set user_username = ?,user_nickname = ?,user_password = ? where user_id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,userBean.getUser_username());
            pstm.setString(2,userBean.getUser_nickname());
            pstm.setString(3,userBean.getUser_password());
            pstm.setInt(4,userBean.getUser_id());
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

//    删除用户
    public static boolean deleteUser(int user_id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "delete from user where  user_id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,user_id);
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

    public static boolean addUser(UserBean userBean) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = 0;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into user(user_username,user_nickname,user_password,user_phone,user_qq) values (?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,userBean.getUser_username());
            pstm.setString(2,userBean.getUser_nickname());
            pstm.setString(3,userBean.getUser_password());
            pstm.setString(4,userBean.getUser_phone());
            pstm.setString(5,userBean.getUser_qq());
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
