package dao;

import java.util.List;

/**
 * 封装了通用的方法
 */
public interface CustomerDao {
    List<Customer> getCustomerByCriteria(CriteriaCustomer cc);
    List<Customer> getAll();
    int save(Customer customer);
    Customer get(int id);
    int delete(int id);
    long getCountByName(String name);
    int update(Customer customer);
}
