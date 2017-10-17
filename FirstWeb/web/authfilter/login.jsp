<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/10/17
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/authLoginServlet?method=login" method="post">
Name:   <input type="text" name="username"><br>
        <input type="submit">
</form>
</body>
</html>
