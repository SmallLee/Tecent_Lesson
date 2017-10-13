package filter;

import tag.PrintUpperTag;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(filterName = "CheckIsLoginFilter",urlPatterns = "/filterlogin/*")
public class CheckIsLoginFilter extends HttpFilter {
    private String sessionKey;
    private String redirectUrl;
    private String unFilteredUrls;
    @Override
    protected void init() {
        ServletContext servletContext = getFilterConfig().getServletContext();
        sessionKey = servletContext.getInitParameter("userSessionKey");
        redirectUrl = servletContext.getInitParameter("redirectUrl");
        unFilteredUrls = servletContext.getInitParameter("unFilteredUrls");
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //请求的url
        String requestURL = request.getRequestURL().toString();
//        System.out.println("requestURL:  "+requestURL);//http://localhost:8080/filterlogin/list.jsp
        String requestURI = request.getRequestURI();
//        System.out.println("requestURI: "+requestURI);///filterlogin/list.jsp
        String servletPath = request.getServletPath();
//        System.out.println("servletPath: "+servletPath);///filterlogin/list.jsp

        //检查servletPath是否为不需要过滤的url
        if (unFilteredUrls.contains(servletPath)) {
            chain.doFilter(request,response);
            return;
        }
        //重定向的页面
        String username = (String) request.getSession().getAttribute("username");
        System.out.println("username: "+username);
        if (username == null) {
            response.sendRedirect(request.getContextPath() + redirectUrl);
            return;
        }
        chain.doFilter(request,response);
    }
}
