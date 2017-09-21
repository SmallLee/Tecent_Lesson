package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProcessStep1Servlet",urlPatterns = "/proceessStep1")
public class ProcessStep1Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] books = req.getParameterValues("book");
        req.getSession().setAttribute("books",books);
        req.setAttribute("age",12);
        resp.sendRedirect(req.getContextPath()+"/shopping/step2.jsp");
    }
}
