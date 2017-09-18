<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/18
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>写Cookie</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/read.jsp">to Read Cookie</a>
    <%
        Cookie  cookie = new Cookie("cookiePath","cookieValue");
        cookie.setMaxAge(200);
        cookie.setPath("/");
        response.addCookie(cookie);
    %>
</body>
</html>
