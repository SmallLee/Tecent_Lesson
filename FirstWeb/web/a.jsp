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
<%
    request.getRequestDispatcher("b.jsp").forward(request,response);
    System.out.println("bbbbb");
%>
    <%--<%--%>
    <%--pageContext.forward("b.jsp");--%>
    <%--%>--%>
    <a href="http://www.baidu.com">百度</a>
    <%--<jsp:forward page="b.jsp"/>--%>
</body>
</html>
