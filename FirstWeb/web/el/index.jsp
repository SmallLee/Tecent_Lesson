<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/29
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="index.jsp" method="post">
    <input type="text" name="name" value="${param.name}">
    <input type="submit">
</form>
<a href="index2.jsp?name=A&name=B&name=C">paramValues</a>
    <jsp:useBean id="person" class="dao.Person" scope="session"/>
    <jsp:setProperty name="person" property="age" value="10"/>
    <jsp:getProperty name="person" property="age"/>
    <%out.println(person.getAge());%>
    ${person.age}
<a href="index2.jsp">To Index2</a>
</body>
</html>
