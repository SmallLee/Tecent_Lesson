<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/18
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有的书</title>
</head>
<body>
    <h3>请选择书本</h3>
    <a href="book.jsp?book=JavaWeb">JavaWeb</a><br>
    <a href="book.jsp?book=Android">Android</a><br>
    <a href="book.jsp?book=HTML">HTML</a><br>
    <a href="book.jsp?book=JavaScript">JavaScript</a><br>
    <a href="book.jsp?book=Php">Php</a><br>
    <a href="book.jsp?book=AngularJS">AngularJS</a><br>
    <a href="book.jsp?book=Java">Java</a><br>
    <a href="book.jsp?book=Ajax">Ajax</a><br>
    <%
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().startsWith("lxn")) {
                out.println(cookie.getValue()+" ");
            }
        }
    %>
</body>
</html>
