<%@ page import="java.util.List" %>
<%@ page import="dao.Person" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/30
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="h" uri="http://www.atguigu.com" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h:hello value="atguigu" count="10"/>
    <%
        List<Person> personList = (List<Person>) request.getAttribute("persons");
        out.println(personList);
    %>
    <h:max num1="120" num2="20"/>
    <h:readFile src="/readFile.txt"/>
</body>
</html>
