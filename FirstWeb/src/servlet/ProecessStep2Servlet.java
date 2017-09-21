package servlet;

import dao.BuyerInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProecessStep2Servlet",urlPatterns = "/processStep2")
public class ProecessStep2Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        BuyerInfo buyerInfo = new BuyerInfo(name,address);
        System.out.println("age========"+req.getAttribute("age"));
        HttpSession session = req.getSession();
        session.setAttribute("buyerInfo",buyerInfo);
        resp.sendRedirect(req.getContextPath()+"/shopping/confirm.jsp");

    }
}
