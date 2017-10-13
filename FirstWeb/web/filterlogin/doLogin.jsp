<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/10/13
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            //获取用户名，判断用户名是否正确
            String username = request.getParameter("name");
            if ("lxn".equals(username)){
                //存放到session中
                session.setAttribute(application.getInitParameter("userSessionKey"),username);
                response.sendRedirect("/filterlogin/list.jsp");
            }else{
                request.setAttribute("msg","用户名"+username+"不正确");
                request.getRequestDispatcher(request.getContextPath()+"/filterlogin/login.jsp").forward(request,response);
            }
        %>
</body>
</html>
