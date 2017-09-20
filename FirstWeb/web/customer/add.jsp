<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/19
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script src="../scripts/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
    <%
        String msg = (String) request.getAttribute("msg");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        if (msg != null) {%>
    <br>
        <font color="red"><%=msg%></font>
    <br>
        <%}
    %>
<form action="/add.do" method="post">
    <table>
        <tr>
            <td>CustomerName</td>
            <td><input type="text" name="name" value="<%=name==null?"":name%>"></td>
        </tr>
        <tr>
            <td >Address</td>
            <td><input type="text" name="address" value="<%=address==null?"":address%>"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" value="<%=phone==null?"":phone%>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add"></td>
        </tr>
    </table>
</form>
</body>
</html>
