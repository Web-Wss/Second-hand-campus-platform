package shop.massz.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    // 创建一个数据源对象
    private static DataSource dataSource = null;
    // 初始化 -- 读取配置文件的信息，生成数据库连接池
    static {
        try {
            Properties prop = new Properties();
            // 根据当前这个类的classes的路径加载定义的配置文件
            prop.load(new JDBCUtil().getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
            // 得到数据源
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    // 获取数据库的连接对象
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static QueryRunner getQueryRunner(){
        return new QueryRunner(dataSource);
    }

    // 关闭连接对象 -- 释放资源
    public static void release(Connection conn, PreparedStatement pstmt) {
        if(pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            pstmt = null;
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            conn = null;
        }
    }
    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            rs = null;
        }
        release(conn,pstmt);
    }
}
