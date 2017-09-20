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
* 封装了基本的CRUD方法，以供子类继承使用，通过JdbcUtil连接数据库
* */
public class BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    private Class<T> clazz;


    public BaseDao(){
        //通过反射获取当前类表示的实体（类，接口，基本类型或void）的直接父类的Type
        Type type = getClass().getGenericSuperclass();
        System.out.println("type:---------"+type);
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            //返回泛型参数数组
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
