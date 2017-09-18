package test;

import dao.Customer;
import dao.CustomerDao;
import impl.CustomerDaoJDBCImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* CustomerDaoJDBCImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>æ≈‘¬ 16, 2017</pre> 
* @version 1.0 
*/ 
public class CustomerDaoJDBCImplTest { 
private CustomerDao customerDao = new CustomerDaoJDBCImpl();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getAll() 
* 
*/ 
@Test
public void testGetAll() throws Exception {
    List<Customer> customerList = customerDao.getAll();
    System.out.println(customerList.toString());
//TODO: Test goes here... 
} 

/** 
* 
* Method: save(Customer customer) 
* 
*/ 
@Test
public void testSave() throws Exception { 
//TODO: Test goes here...
    Customer customer = new Customer("nihao","Œ‰∫∫","99999");
    customerDao.save(customer);
} 

/** 
* 
* Method: get(int id) 
* 
*/ 
@Test
public void testGet() throws Exception { 
//TODO: Test goes here...
    Customer customer = customerDao.get(2);
    System.out.println(customer.name);
} 

/** 
* 
* Method: delete(int id) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here...
    customerDao.delete(1);
}
/**
* 
* Method: getCountByName(String name) 
* 
*/ 
@Test
public void testGetCountByName() throws Exception { 
//TODO: Test goes here...
    long count = customerDao.getCountByName("zhangsan");
    System.out.println(count);
}
}
