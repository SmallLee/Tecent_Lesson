<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/10/9
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="atguigu" uri="http://www.atguigu.com" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <atguigu:choose>
        <atguigu:when test="${param.age > 24}">大学毕业</atguigu:when>
        <atguigu:when test="${param.age > 20}">高中毕业</atguigu:when>
        <atguigu:otherwise>小学毕业</atguigu:otherwise>
    </atguigu:choose>
</body>
</html>
