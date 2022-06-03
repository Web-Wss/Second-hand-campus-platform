package shop.massz.dao;


import shop.massz.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CheckCodeDao {
    public static void setCode(String codekey, String code) {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into verification(codekey,codevalue) values(?,?) ";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,codekey);
            pstm.setString(2,code);
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,pstm);
        }
    }
}
