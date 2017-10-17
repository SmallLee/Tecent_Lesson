package filter;

import authority.Authority;
import authority.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//过滤web根目录下authority目录下的所有文件
@WebFilter(filterName = "AuthorityFilter",urlPatterns = "/authfilter/*")
public class AuthorityFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String servletPath = request.getServletPath();
        List<String> uncheckedUrls = Arrays.asList("/authfilter/403.jsp","/authfilter/login.jsp",
                "/authfilter/logout.jsp","/authfilter/articles.jsp","/authfilter/authority-manager.jsp");
        if (uncheckedUrls.contains(servletPath)) {
            chain.doFilter(request,response);
            return;
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath()+"/authfilter/login.jsp");
            return;
        } else {
            List<Authority> authorities = user.getAuthorities();
            Authority authority = new Authority(null,servletPath);
            if (authorities.contains(authority)) {
                chain.doFilter(request,response);
                return;
            }
        }
        response.sendRedirect(request.getContextPath()+"/authfilter/403.jsp");
    }
}
