<%@ page import="dao.Person" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/29
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="person" class="dao.Person" scope="request"/>
    <%--<%--%>
    <%--Person p = (Person) request.getAttribute("person");--%>
    <%--if (p == null) {--%>
    <%--p = (Person) Class.forName("dao.Person").newInstance();--%>
    <%--request.setAttribute("person",p);--%>
    <%--}--%>
    <%--%>--%>
    <%--代码作用相同--%>
    <%--<jsp:setProperty name="person" property="age" value="10"/>--%>
    <%--<%--%>
        <%--person.setAge(10);--%>
    <%--%>--%>
    <%--代码作用相同--%>
    <%--<jsp:getProperty name="person" property="age"/>--%>
    <%--<%=person.getAge()%>--%>
    <%--http://localhost:8080/useBean.jsp?age=10&name=lxn--%>
    <jsp:setProperty name="person" property="*"/>
    name:<jsp:getProperty name="person" property="name"/>
    age:<jsp:getProperty name="person" property="age"/>
    address:<jsp:getProperty name="person" property="address"/>

    <jsp:useBean id="person2" beanName="dao.Person" type="java.lang.Object" scope="request"/>
    <%
        Object object = request.getAttribute("person2");
        if (object == null) {
            object = Class.forName("dao.Person").newInstance();
            request.setAttribute("person2",object);
        }
    %>
</body>
</html>
