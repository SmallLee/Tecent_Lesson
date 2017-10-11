<%@ page import="dao.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/10/10
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<Person> personList = new ArrayList<Person>();
        Person person = new Person("A",1,"BEIJING");
        Person person1 = new Person("B",2,"BEIJING2");
        Person person2 = new Person("C",3,"BEIJING3");
        personList.add(person);
        personList.add(person1);
        personList.add(person2);
        request.setAttribute("persons",personList);
    %>
    <%--遍历Collection--%>
    <c:forEach items="${requestScope.persons}" var="p" varStatus="status">
        ${status.count},${status.index},${p.name}--${p.age}--${p.address} <br>
    </c:forEach>
    <%
        HashMap<Integer,String> hashMap = new HashMap<Integer,String>();
        hashMap.put(1,"A");
        hashMap.put(2,"B");
        hashMap.put(3,"C");
        request.setAttribute("hashmap",hashMap);
    %>
    <%--遍历Map--%>
    <c:forEach items="${requestScope.hashmap}" var="hs" >
        ${hs.key}--${hs.value}
    </c:forEach>

    <%--URL操作--%>
    <c:import url="http://www.baidu.com"/>
    <%--重定向--%>
    <%--<c:redirect url="/jstl/jstl.jsp"/>--%>
    <h3>c:url</h3> <br>
    <c:url value="jstl.jsp" var="testurl">
        <c:param name="name" value="李小牛"/>
    </c:url>
    url:${testurl}
</body>
</html>
