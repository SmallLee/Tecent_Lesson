<%@ page import="java.util.List" %>
<%@ page import="dao.Person" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/10/9
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="atguigu" uri="http://www.atguigu.com" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Person> personList = new ArrayList<Person>();
    Person person = new Person("AAA",1,"北京");
    Person person1 = new Person("BBB",2,"北京1");
    Person person2 = new Person("CCC",3,"北京2");
    personList.add(person);
    personList.add(person1);
    personList.add(person2);
    request.setAttribute("persons",personList);

%>
    <atguigu:foreach items="${requestScope.persons}" var="p">${p.name}--${p.age}--${p.address}</atguigu:foreach>
</body>
</html>
