<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/18
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=session.getId()%>
    <%String username = (String) session.getAttribute("username");
        if (username == null) {
            username = "";
        }
    %>
    <form action="welcome.jsp" method="get">
     <input type="text" name="username" value="<%=username%>">
        <input type="submit" value="提交">
    </form>
</body>
</html>
