package impl;

import dao.CriteriaCustomer;
import dao.Customer;
import dao.CustomerDao;
import dao.BaseDao;

import java.util.List;

public class CustomerDaoJDBCImpl extends BaseDao<Customer> implements CustomerDao {
    @Override
    public List<Customer> getCustomerByCriteria(CriteriaCustomer cc) {
        String sql = "select * from customer where name LIKE ? AND address LIKE ? AND phone LIKE ?";
        return getForList(sql,cc.getName(),cc.getAddress(),cc.getPhone());
    }

    @Override
    public List<Customer> getAll() {
        String sql = "select * from customer";
        return getForList(sql);
    }

    @Override
    public int save(Customer customer) {
        String sql = "insert into customer(name,address,phone) values (?,?,?);";
        return update(sql,customer.name,customer.address,customer.phone);
    }

    @Override
    public Customer get(int id) {
        String sql = "select * from customer where id = ?";
        return get(sql,id+"");
    }

    @Override
    public int delete(int id) {
        String sql = "delete from customer where id = ?";
        return update(sql,id+"");
    }

    @Override
    public long getCountByName(String name) {
        String sql = "select count(*) from customer where name = ?";
        return getForValue(sql,name);
    }

    @Override
    public int update(Customer customer) {
        String sql = "update customer set name = ?,address=?,phone =? where id = ?";
        return update(sql,customer.name,customer.phone,customer.phone,customer.id+"");
    }
}
