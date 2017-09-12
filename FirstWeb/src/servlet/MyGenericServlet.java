package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;

public  class MyGenericServlet implements Servlet,ServletConfig,Serializable{
    public static final long serialVersionUID =1L ;
    private ServletConfig servletConfig;
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig =servletConfig;
        this.init();
    }

    public void init(){

    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException{

    };

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
    public void log(String msg){
        servletConfig.getServletContext().log(msg);
    }

    @Override
    public String getServletName() {
        return servletConfig.getServletName();
    }

    @Override
    public ServletContext getServletContext() {
        return servletConfig.getServletContext();
    }

    @Override
    public String getInitParameter(String s) {
        return servletConfig.getInitParameter(s);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return servletConfig.getInitParameterNames();
    }
}
