<%@ page import="dao.Customer" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/20
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<c:set var="customer" value="${requestScope.customer}"/>
    <c:set var="id" value="${customer != null ? customer.id:param.id}"/>
    <c:set var="name" value="${customer != null ? customer.name:param.oldName}"/>
    <c:set var="address" value="${customer != null ? customer.address:param.address}"/>
    <c:set var="phone" value="${customer != null ? customer.phone:param.phone}"/>
    <c:set var="oldName" value="${customer != null ? customer.name:param.oldName}"/>
<c:if test="${requestScope.msg != null}">
    <font color="red">${requestScope.msg}</font>
</c:if>

<form action="/update.do" method="post">
    <table>
        <tr>
            <td><input type="hidden" name="id" value="${id}"></td>
            <td><input type="hidden" name="oldName" value="${oldName}"></td>
        </tr>
        <tr>
            <td>CustomerName</td>
            <td><input type="text" name="name" value="${name}"></td>
        </tr>
        <tr>
            <td >Address</td>
            <td><input type="text" name="address" value="${address}"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" value="${phone}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"></td>
        </tr>
    </table>
</form>
</body>
</html>
