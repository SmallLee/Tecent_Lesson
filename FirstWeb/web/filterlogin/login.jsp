<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/10/13
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String msg = (String) request.getAttribute("msg");
        if (msg != null) {%>
            <font color="red">${msg}</font>
        <%}
    %>
<form action="doLogin.jsp" method="post">
    <input type="text" name="name"><br>
    <input type="submit">
</form>
</body>
</html>
