package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.WildcardType;

@WebServlet(name = "RepeatSubmitServlet",urlPatterns = "/repeat")
public class RepeatSubmitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String token = (String) req.getAttribute("token");
//        System.out.println(token);
//        String username = req.getParameter("username");
//        System.out.println(username);
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        Object token = session.getAttribute("token");
        System.out.println(token);
        String tokenValue = req.getParameter("tokenValue");
        System.out.println(tokenValue);
        if (token != null && tokenValue != null && tokenValue.equals(token)) {
            session.removeAttribute("token");
        } else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            byte[] bytes = "重复提交".getBytes("gbk");
            writer.println(new String(bytes,"utf-8"));
            System.out.println(new String(bytes,"utf-8"));
        }
    }
}
