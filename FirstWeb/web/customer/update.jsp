<%@ page import="dao.Customer" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/20
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        String msg = (String) request.getAttribute("msg");
        String id = null;
        String name = null;
        String address = null;
        String phone = null;
        String oldName = null;
        Customer customer = (Customer) request.getAttribute("customer");
//        从Servlet转发过来的
        if (customer != null) {
            id = customer.id+"";
            name = customer.name;
            address = customer.address;
            phone = customer.phone;
            oldName = customer.name;
        } else {
            //修改失败过来的
            id = request.getParameter("id");
            name = request.getParameter("oldName");//修改失败，name变为原来的name
            address = request.getParameter("address");
            phone = request.getParameter("phone");
            oldName = request.getParameter("oldName");
        }
    %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
    <%
        if (msg != null) {%>
            <font color="red"><%=msg%></font>
        <%}
    %>
<form action="/update.do" method="post">
    <table>
        <tr>
            <td><input type="hidden" name="id" value="<%=id%>"></td>
            <td><input type="hidden" name="oldName" value="<%=oldName%>"></td>
        </tr>
        <tr>
            <td>CustomerName</td>
            <td><input type="text" name="name" value="<%=name%>"></td>
        </tr>
        <tr>
            <td >Address</td>
            <td><input type="text" name="address" value="<%=address%>"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" value="<%=phone%>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"></td>
        </tr>
    </table>
</form>
</body>
</html>
