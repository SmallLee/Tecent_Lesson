<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/23
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
request.getSession().setAttribute("token",new Date().getTime()+"");
%>
<%--将随机token放到表单的隐藏域中提交到servlet--%>
<form action="/repeat" method="post">
    <input type="hidden" name ="tokenValue" value="${token}">
    <input type="text" name="username">
    <input type="submit" value="提交">
</form>
</body>
</html>
