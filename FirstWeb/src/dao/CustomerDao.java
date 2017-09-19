package dao;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomerByCriteria(CriteriaCustomer cc);
    List<Customer> getAll();
    void save(Customer customer);
    Customer get(int id);
    int delete(int id);
    long getCountByName(String name);
}
