<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/21
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>step2：配送信息</h3>
<form action="<%=request.getContextPath()%>/processStep2" method="post">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td colspan="2">寄送信息</td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
