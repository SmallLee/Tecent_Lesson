<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/21
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择购买的书</title>
    <style>
        td{
            text-align: center;
        }
    </style>
</head>
<body>
    <h3>step1：选择你要购买的书</h3>
    <form action="<%=request.getContextPath()%>/proceessStep1" method="post">
        <table border="1" cellspacing="0" cellpadding="10">
            <tr>
                <td>书名</td>
                <td>购买</td>
             </tr>
            <tr>
                <td>Java</td>
                <td><input type="checkbox" name="book" value="Java"></td>
            </tr>
            <tr>
                <td>Android</td>
                <td><input type="checkbox" name="book" value="Android"></td>
            </tr>
            <tr>
                <td>Html</td>
                <td><input type="checkbox" name="book" value="Html"></td>
            </tr>
            <tr>
                <td>JS</td>
                <td><input type="checkbox" name="book" value="JS"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="购买"></td>
            </tr>
        </table>
    </form>
</body>
</html>
