package util;

import java.sql.*;

public class JDBCUtils {
//    获取数据库连接
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/second_hand_campus_platform?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }
//    关闭数据库连接
    public static void release(PreparedStatement preStmt, Connection conn) {
        if (preStmt != null) {
            try {
                preStmt.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
            preStmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    //    查询
    public static void release(ResultSet rs,PreparedStatement preStmt,Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        release(preStmt,conn);
    }

}
