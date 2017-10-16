package servlet;

import authority.Authority;
import authority.User;
import authority.UserDao;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AuthorityServlet",urlPatterns = "/authority")
public class AuthorityServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        System.out.println("methodname: "+methodName);
        try {
            Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAuthorities(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //获取用户名
        String username = request.getParameter("username");
        //根据用户名获取对应的User
        User user = UserDao.get(username);
        request.setAttribute("user",user);
        request.setAttribute("authorities",UserDao.getAuthorities());
        request.getRequestDispatcher("/authority/authority-manager.jsp").forward(request,response);
    }
    public void updateAuthority(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String[] authorities = request.getParameterValues("cbauth");
        List<Authority> authorityList = UserDao.getAuthorities(authorities);
        UserDao.update(username,authorityList);
        request.getRequestDispatcher("/authority/authority-manager.jsp").forward(request,response);
    }
}
