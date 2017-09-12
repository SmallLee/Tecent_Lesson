package servlet;

import sun.net.httpserver.HttpsServerImpl;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/loginservlet")
public class LoginServlet extends MyGenericServlet {

    private String localUsername;
    private String localPassword;
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
        localUsername = servletContext.getInitParameter("username");
        localPassword = servletContext.getInitParameter("password");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals(localUsername) && password.equals(localPassword)) {
            resp.getWriter().println("Welcome: "+username);
        } else {
            resp.getWriter().println("Sorry: "+username);
        }
    }
}
