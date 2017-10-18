package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ContentFilter",urlPatterns = "/contentfilter/bbs.jsp")
public class ContentFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("HttpServletRequest "+request);
//        并没有提供诸如setParameter的方法
//        1.弱对于一个类的方法不满意，需要进行重写，最简单的方式是继承父类，重写方法
        //若实现，需要继承org.apache.catalina.connector.RequestFacade，而这仅仅是Tomcat服务器的实现
        //若更换服务器，该方案不可行
        //2.直接写一个HttpServletRequest的实现类，实现方法，不行
        //装饰HttpServletRequest的getParameter方法，
        HttpServletRequest myHttpServletRequest = new MyHttpServletRequest(request);
        chain.doFilter(myHttpServletRequest,response);
    }
}
