package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC操作的工具类
 */
public class JdbcUtil {
    private static DataSource dataSource = null;

    static {
        //数据源只需要创建一次
        dataSource = new ComboPooledDataSource("");
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 释放Connection
     * @param connection
     */
    public static void releaseConnection(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
