<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/19
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/add.do" method="post">
    <table>
        <tr>
            <td>CustomerName</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td >Address</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add"></td>
        </tr>
    </table>
</body>
</html>
