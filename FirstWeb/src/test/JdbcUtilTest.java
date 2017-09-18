package test;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import util.JdbcUtil;

import java.sql.Connection;

/** 
* JdbcUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>¾ÅÔÂ 16, 2017</pre> 
* @version 1.0 
*/ 
public class JdbcUtilTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getConnection() 
* 
*/ 
@Test
public void testGetConnection() throws Exception {
    Connection connection = JdbcUtil.getConnection();
    System.out.println(connection);
}


/** 
* 
* Method: releaseConnection(Connection connection) 
* 
*/ 
@Test
public void testReleaseConnection() throws Exception { 

} 
}
