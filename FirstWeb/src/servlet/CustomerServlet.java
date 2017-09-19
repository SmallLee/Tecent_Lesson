package servlet;

import dao.CriteriaCustomer;
import dao.Customer;
import dao.CustomerDao;
import impl.CustomerDaoJDBCImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "*.do")
public class CustomerServlet extends HttpServlet {
    private CustomerDao customerDao = new CustomerDaoJDBCImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到/add.do
        String servletPath = req.getServletPath();
        //获取方法名，add,delete
        String methodName = servletPath.substring(1,servletPath.lastIndexOf("."));
        try {
            //通过反射调用方法，getDeclaredMethod调用所有的方法
            Method method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        int count = (int) customerDao.getCountByName(name);
        if (count > 0 ) {
            req.setCharacterEncoding("UTF-8");
            req.setAttribute("msg","用户名"+name+"已经存在，请重新选择!");
            System.out.println(req.getAttribute("msg"));
            req.getRequestDispatcher("/customer/add.jsp").forward(req,resp);
        } else {
            Customer customer = new Customer(name,address,phone);
            customerDao.save(customer);
            resp.sendRedirect("/customer/success.jsp");//避免表单重复提交
//            req.getRequestDispatcher("/customer/success.jsp").forward(req,resp);
        }
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
            customerDao.delete(id);
        } catch(Exception e){
        }
        resp.sendRedirect("/query.do");
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取模糊查询的参数
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        //封装成一个CriteriaCustomer对象
        CriteriaCustomer cc = new CriteriaCustomer(name,address,phone);
        List<Customer> customerList = customerDao.getCustomerByCriteria(cc);
        req.setAttribute("customerList",customerList);
        req.getRequestDispatcher("/customer/index.jsp").forward(req,resp);
    }
}
