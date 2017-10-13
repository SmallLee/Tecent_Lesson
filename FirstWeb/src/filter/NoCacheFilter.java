package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "NoCacheFilter",urlPatterns = "/cache/*")
public class NoCacheFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //禁用浏览器的缓存
        response.setDateHeader("Expires",-1);
        response.setHeader("Cache-Contrl","no-cache");
        response.setHeader("Pragma","no-cache");
        System.out.println("========http Filter");
        chain.doFilter(request,response);
        System.out.println( "Expires"+response.getHeader("Expires"));
        System.out.println( "Cache"+response.getHeader("Cache-Control"));
        System.out.println( "Pragma"+response.getHeader("Pragma"));
    }
}