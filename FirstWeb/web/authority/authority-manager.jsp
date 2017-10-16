<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/10/16
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理权限页面</title>
</head>
<body>
    <h4>管理权限</h4>
    <form action="/authority?method=getAuthorities" method="post">
        Name: <input type="text" name="username">
        <input type="submit">
    </form>
    <%--权限展示和修改--%>
    <c:if test="${requestScope.user != null}">
        ${requestScope.user.name}的权限是
        <form action="/authority?method=updateAuthority" method="post">
            <input type="hidden" name="username" value="${user.name}">
            <c:forEach items="${authorities}" var="auth">
                <c:set var="flag" value="false"/>
                <c:forEach items="${user.authorities}" var="userAuth">
                    <c:if test="${auth.url eq userAuth.url}">
                        <c:set var="flag" value="true"/>
                    </c:if>
                </c:forEach>
                <c:if test="${flag == true}">
                    <input type="checkbox" checked="checked" name="cbauth" value="${auth.url}"> ${auth.displayName} <br><br>
                </c:if>
                <c:if test="${flag == false}">
                    <input type="checkbox" name="cbauth" value="${auth.url}"> ${auth.displayName} <br><br>
                </c:if>
            </c:forEach>
            <input type="submit">
        </form>
    </c:if>

</body>
</html>
