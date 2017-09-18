<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/18
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=session.getId()%>
    <%
        session.setMaxInactiveInterval(5);
    %>
</body>
</html>
