<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    Date date = new Date();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=session.getId()%>
    <form action="b.jsp" method="get">
        <input type="text" name="username">
        <input type="submit">
    </form>
</body>
</html>
