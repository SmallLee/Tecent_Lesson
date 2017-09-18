<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/18
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        session.setAttribute("username",username);%>
<a href="login.jsp">退出登录</a>
    <%session.invalidate();%>
</body>
</html>
