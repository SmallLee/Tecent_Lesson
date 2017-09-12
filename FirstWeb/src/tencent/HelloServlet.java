package tencent;


import javax.servlet.*;
import java.io.IOException;
import java.io.InputStream;

public class HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //获得注册的Servlet的名字
        System.out.println("init"+servletConfig.getServletName());
        ServletContext servletContext = servletConfig.getServletContext();
        String realPath = servletContext.getRealPath("hello.txt");
        //D:\JavaProject\Tecent_Lesson\out\artifacts\FirstWeb_war_exploded\hello.txt
        System.out.println(realPath);
        String contextPath = servletContext.getContextPath();
        System.out.println("contextPath: "+contextPath);
        InputStream is1 = servletContext.getResourceAsStream("hello.txt");
        System.out.println("is1:  "+is1);
        InputStream is2 = getClass().getClassLoader().getResourceAsStream("hello.txt");
        System.out.println("is2 "+is2);//java.io.BufferedInputStream@9eddd2
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destory");
    }

    public HelloServlet(){
        System.out.println("HelloServlet constructor");
    }
}
/*
* getRealPath：获得当前web应用的某个文件在服务器上的地址
*getContextPath:获得当前Web应用的名称
*
* */