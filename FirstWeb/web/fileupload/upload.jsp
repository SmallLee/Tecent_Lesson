<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/10/18
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/uploadServlet" method="post" enctype="multipart/form-data">
    File :<input type="file" name="file"><br>
    <input type="text" name="desc">
    <input type="submit" value="上传">
</form>
</body>
</html>
