<%@ page import="dao.Person" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/10/10
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%request.setAttribute("book","<<Java>>");%>
<%--使用el--%>
    book:${requestScope.book}
<%--使用jstl--%>
    book:<c:out value="${requestScope.book}"/> <br>
    <h3>c:set</h3>
    <c:set var="name" value="atguigu" scope="page"/>
    name:${pageScope.name} <br>
    <%
        Person person = new Person();
        person.setName("abcd");
        request.setAttribute("person",person);
    %>
    name:${requestScope.person.name}
    <%--给javabean赋值--%>
    <c:set target="${requestScope.person}" property="name" value="${param.name}"/>
        name:${requestScope.person.name} <br>
    <h3>c:remove</h3> <br>
    <c:set value="1992" scope="session" var="date"/>
        data:${sessionScope.date} <br>
        <c:remove var="date" scope="session"/>
            data:--${sessionScope.date}
    <h3>c:if</h3> <br>
    <c:set value="19" scope="request" var="age"/>
    <c:if test="${requestScope.age > 18}">成年人</c:if>
    //把判断的结果存储起来
    <c:if test="${param.age > 18}" var="isAdult" scope="request"/>
    <c:out value="${requestScope.isAdult}"/>

</body>
</html>
