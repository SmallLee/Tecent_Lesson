<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/19
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="../scripts/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
    <c:if test="${requestScope.msg != null}">
        <br>
        <font color="red">${requestScope.msg}</font>
        <br>
    </c:if>
<form action="/add.do" method="post">
    <table>
        <tr>
            <td>CustomerName</td>
            <td><input type="text" name="name" value="${param.name}"></td>
        </tr>
        <tr>
            <td >Address</td>
            <td><input type="text" name="address" value="${param.address}"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" value="${param.phone}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add"></td>
        </tr>
    </table>
</form>
</body>
</html>
