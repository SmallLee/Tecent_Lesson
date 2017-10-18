package filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

public class MyHttpServletRequest extends HttpServletRequestWrapper {

    public MyHttpServletRequest(HttpServletRequest request){
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String content = super.getParameter(name);
        System.out.println(content);
        if (content.contains("fuck")) {
            content = content.replace("fuck","xxx");
        }
        return content;
    }
}
