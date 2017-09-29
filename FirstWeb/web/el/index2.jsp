<%@ page import="dao.Person" %>
<%@ page import="com.mysql.jdbc.interceptors.SessionAssociationInterceptor" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/29
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${sessionScope.person.age}
    name:${sessionScope.com.lxn.name}
    name:${sessionScope["com.lxn"].name}
    <%
        Person p = new Person();
        p.setName("atguigu");
        session.setAttribute("com.lxn",p);
    %>
</body>
</html>
