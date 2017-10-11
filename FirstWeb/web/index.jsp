<%@ page import="tencent.Person" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/6
  Time: 8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
          <%
            Person p = new Person();
            System.out.println(p.getPersonInfo());
            out.print("abcd");
            out.println("1234");
          %>
     name: ${param.name}
  </body>
</html>
