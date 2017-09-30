<%@ page import="dao.Person" %>
<%@ page import="com.mysql.jdbc.interceptors.SessionAssociationInterceptor" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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
    names:${paramValues.name[0]}
    <%
        Person p = new Person();
        p.setName("atguigu");
        session.setAttribute("com.lxn",p);
    %>
<%--其他隐含对象--%>
    JSESSIONID: ${cookie.JSESSIONID.value}<br>
    <!--获取请求头信息-->
    Accept-Encoding:${header["Accept-Encoding"]}<br>
    <!--initParam,获取全局配置参数-->
        username:${initParam.username}<br>
    <!--pageContext对象-->
    pageContext:
    <br>
        contextPath:${pageContext.request.contextPath}
    <br>
        sessionid:${pageContext.session.id}
    <br>
        <%
            List<String> names = new ArrayList<String>();
            request.setAttribute("names",names);
        %>
    <!--empty可以作用于一个集合，若集合不存在或者集合元素为空，则true-->
        names: ${empty requestScope.names}
    <br>
    <br>
    <br>
</body>
</html>
