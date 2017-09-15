<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/15
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            boolean success = (Boolean) request.getAttribute("success");
            if (success) {
                out.println("删除成功"); %>
        <a href="/listAllStudent">listAllStudent</a>
           <%} else {
                out.println("删除失败");
            }
        %>
</body>
</html>
