package dao;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAll();
    void save(Customer customer);
    Customer get(int id);
    void delete(int id);
    long getCountByName(String name);
}
