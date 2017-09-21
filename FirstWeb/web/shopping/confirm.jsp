<%@ page import="dao.BuyerInfo" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/21
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>确认信息页面</title>
</head>
<body>
    <%
        String[] books = (String[]) session.getAttribute("books");
        BuyerInfo buyerInfo = (BuyerInfo) session.getAttribute("buyerInfo");
        out.println("购买的书有");%>
        <table border="1" cellspacing="0" cellpadding="10">
            <tr><td colspan="2">书名</td></tr>
        <%for (String book : books) {%>
            <tr><td colspan="2"><%=book%></td></tr>
        <%}
    %>
            <tr>
                <td>姓名</td>
                <td><%=buyerInfo.name%></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><%=buyerInfo.address%></td>
            </tr>
        </table>
</body>
</html>
