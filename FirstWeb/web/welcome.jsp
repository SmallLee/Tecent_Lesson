<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/18
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
</head>
<body>
<%--如果请求参数中有username或者cookie中有值，显示欢迎，否则重定向到登录页面--%>
        <%
            String username = request.getParameter("username");
            if (username != null && !username.trim().equals("")) {
                Cookie cookie = new Cookie("username",username);
                cookie.setMaxAge(30);
                response.addCookie(cookie);
            } else {
                Cookie[] cookies = request.getCookies();
                if (cookies != null && cookies.length > 0) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("username")) {
                            username = cookie.getValue();
                        }
                    }
                }
            }

            if (username != null && !username.trim().equals("")) {
                out.println("Welcome: "+username);
            } else {
                response.sendRedirect("/login.jsp");
            }
        %>
</body>
</html>
