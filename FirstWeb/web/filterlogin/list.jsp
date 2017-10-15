<%@ page import="javax.swing.text.Document" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/10/13
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../scripts/jquery-3.2.1.min.js"></script>
    <script>
        $(function () {
            $("#btn_logouot").click(function () {
                location.href = "/filterlogin/login.jsp";
                document.write("sdf")
                <%
                System.out.println("===zhixingle");
                session.setAttribute(application.getInitParameter("userSessionKey"),null);%>
            });
        });
        <%out.print("dsfds");%>
    </script>
</head>
<body>
<a href="a.jsp">TO A PAGE</a>
<a href="b.jsp">TO B PAGE</a>
<a href="c.jsp">TO C PAGE</a> <br>
    <button id="btn_logouot">退出登录</button>
</body>
</html>
