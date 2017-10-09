<%@ page import="java.time.Period" %>
<%@ page import="dao.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/30
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("A",1,"beijing"));
        personList.add(new Person("B",2,"beijing2"));
        personList.add(new Person("C",3,"beijing3"));
        request.setAttribute("persons",personList);
        request.getRequestDispatcher("/tag/testtag.jsp").forward(request,response);
    %>
</body>
</html>
