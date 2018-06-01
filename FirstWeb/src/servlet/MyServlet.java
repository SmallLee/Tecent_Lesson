package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "MyServlet",urlPatterns = "/my")
public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Object requestAttr = req.getAttribute("requestAttr");
        //从JSP页面过来的请求获取不到值
        writer.println("requestAttr: "+requestAttr);
        writer.println(new Date());
        Object sessionAttr = req.getSession().getAttribute("sessionAttr");
        writer.println("sessionAttr: "+sessionAttr);
        Object applicationAttr = req.getServletContext().getAttribute("applicationAttr");
        writer.println("applicationAttr: "+applicationAttr);
    }
}
