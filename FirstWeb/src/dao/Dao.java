package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JdbcUtil;

import javax.print.DocFlavor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
* 封装了基本的CRUD方法，以供子类继承使用
* 当前DAO直接在方法中获取数据库连接
* */
public class Dao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    private Class<T> clazz;


    public Dao(){
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type[] typeArguments = pt.getActualTypeArguments();
            if (typeArguments != null && typeArguments.length > 0) {
                if (typeArguments[0] instanceof Class) {
                    clazz = (Class<T>) typeArguments[0];
                }
            }
        }
    }

    public int update(String sql,String...args) {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.releaseConnection(connection);
        }
        return 0;
    }

    /**
     *
     * @param sql
     * @param args
     * @return 返回T的实体类
     */
    public T get(String sql,String...args) {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            return queryRunner.query(connection,sql,new BeanHandler<T>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.releaseConnection(connection);
        }
        return null;
    }
    public List<T> getForList(String sql, String...args){
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            return queryRunner.query(connection,sql,new BeanListHandler<T>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.releaseConnection(connection);
        }
        return null;
    }

    /**
     * 返回某个字段的值
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    public <E> E getForValue(String sql,String...args) {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            return (E) queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.releaseConnection(connection);
        }
        return  null;
    }
}
