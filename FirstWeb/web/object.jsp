<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/14
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象传递属性</title>
</head>
<body>
<h2>日期：<%=new Date()%></h2>
    <%
        pageContext.setAttribute("pageAttr","pageValue");
        request.setAttribute("requestAttr","requestValue");
        session.setAttribute("sessionAttr","sessionValue");
        application.setAttribute("applicationAttr","applicationValue");
    %>
    <%=pageContext.getAttribute("pageAttr")%>
    <%=request.getAttribute("requestAttr")%>
    <%=session.getAttribute("sessionAttr")%>
    <%=application.getAttribute("applicationAttr")%>
    <a href="${pageContext.request.contextPath}/my">go to Servlet</a>

</body>
</html>
