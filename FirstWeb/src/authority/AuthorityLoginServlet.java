package authority;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "AuthorityLoginServlet",urlPatterns = "/authLoginServlet")
public class AuthorityLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        try {
            Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name = request.getParameter("username");
        User user = UserDao.get(name);
        request.getSession().setAttribute("user",user);
        response.sendRedirect(request.getContextPath() + "/authfilter/articles.jsp");
    }
    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("user",null);
        response.sendRedirect(request.getContextPath()+"/authfilter/logout.jsp");
    }
}
