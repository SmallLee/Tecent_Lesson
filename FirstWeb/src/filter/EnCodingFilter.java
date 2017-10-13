package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EnCodingFilter",urlPatterns = "/encoding/*")
public class EnCodingFilter extends HttpFilter {
    private String encoding;
    @Override
    protected void init() {
        encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
    }
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request,response);
    }
}
