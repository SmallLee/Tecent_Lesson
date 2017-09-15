<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/14
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    BBB PAGE

    <%--<jsp:include page="a.jsp"/>--%>
    <%--<jsp:forward page="a.jsp"/>--%>
    <%--<%--%>
        <%--request.getRequestDispatcher("a.jsp").forward(request,response);--%>

    <%--%>--%>
    <%--post请求--%>
    <%request.setCharacterEncoding("UTF-8");%>
    <%--<%=request.getParameter("username")%>--%>
    <%--<%--%>
        <%--byte[] value = request.getParameter("username").getBytes("ISO-8859-1");--%>
        <%--String str = new String(value,"UTF-8");--%>
    <%--%>--%>
    <%--<%=str.toString()%>--%>
    <%=request.getParameter("username")%>
</body>
</html>
