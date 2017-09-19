<%@ page import="java.util.List" %>
<%@ page import="dao.Customer" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/19
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer的操作</title>
    <style>
        td{
            text-align: center;
        }
    </style>
</head>
<body>
<form action="/query.do" method="post">
    <table>
    <tr>
        <td>CustomerName</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td >Address</td>
        <td><input type="text" name="address"></td>
    </tr>
    <tr>
        <td>Phone</td>
        <td><input type="text" name="phone"></td>
    </tr>
    <tr>
        <td><input type="submit" value="Query"></td>
        <td><a href="">Add New Customer</a></td>
    </tr>
    </table>
    <br><br>
    <table border="1" cellpadding="10" cellspacing="0">
        <%
            List<Customer> customerList = (List<Customer>) request.getAttribute("customerList");
            if (customerList != null && customerList.size() >  0) {%>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Address</td>
                <td>Phone</td>
                <td>UPDATE</td>
                <td>DELETE</td>
            </tr>
            <%for (Customer customer :customerList) {%>
                <tr>
                    <td><%=customer.id%></td>
                    <td><%=customer.name%></td>
                    <td><%=customer.address%></td>
                    <td><%=customer.phone%></td>
                    <td><a href="/update.dp?id=<%=customer.id%>">UPDATE</a></td>
                    <td><a href="/delete.do?id=<%=customer.id%>">DELETE</a></td>
                </tr>
            <%}
            }
        %>
    </table>
</form>
</body>
</html>
