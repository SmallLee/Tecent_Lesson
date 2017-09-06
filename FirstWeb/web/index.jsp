<%@ page import="tencent.Person" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/6
  Time: 8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
          <%
            Person p = new Person();
            System.out.println(p.getPersonInfo());
          %>
  </body>
</html>
