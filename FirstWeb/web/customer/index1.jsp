<%@ page import="java.util.List" %>
<%@ page import="dao.Customer" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/19
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%--用el和jstl重写MVC案例--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer的操作</title>
    <style>
        td{
            text-align: center;
        }
    </style>
    <script src="../scripts/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" >
       $(function(){
           $(".delete").click(function () {
               var content = $(this).parent().parent().find("td:eq(1)").text();
               var msg = "确定要删除"+ content+"的信息吗?";
              var flag = confirm(msg)
              return flag;
          }) ;
       });
    </script>
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
        <td><a href="/customer/add.jsp">Add New Customer</a></td>
    </tr>
    </table>
    <br><br>
    <table border="1" cellpadding="10" cellspacing="0">
        <%--<%--%>
            <%--List<Customer> customerList = (List<Customer>) request.getAttribute("customerList");--%>
            <%--if (customerList != null && customerList.size() >  0) {%>--%>
        <c:if test="${!empty requestScope.customerList}">
            <tr>
                <td>~Id</td>
                <td>--Name</td>
                <td>Address</td>
                <td>Phone</td>
                <td>UPDATE</td>
                <td>DELETE</td>
            </tr>
            <%--<%for (Customer customer :customerList) {%>--%>
            <c:forEach items="${requestScope.customerList}" var="cust">
                <c:out value="${cust}"/> <br>
                <tr>
                    <td>${cust.id}</td>
                    <td>${cust.name}</td>
                    <td>${cust.address}</td>
                    <td>${cust.phone}</td>
                    <c:url value="/edit.do" var="editurl">
                        <c:param name="id" value="${cust.id}"/>
                    </c:url>
                    <td><a href="${editurl}">UPDATE</a></td>
                    <c:url value="/delete.do" var="deleteurl">
                        <c:param name="id" value="${cust.id}"/>
                    </c:url>
                    <td><a class="delete" href="${deleteurl}">DELETE</a></td>
                </tr>
            <%--<%}--%>
                </c:forEach>
            <%--}--%>
        <%--%>--%>
    </table>
    </c:if>
</form>
</body>
</html>
