<%@ page import="java.util.List" %>
<%@ page import="dao.Student" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/15
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示所有的学生信息</title>
</head>
<body>
<a href="listAllStudent">listAllStudent</a><br>
        <%
            List<Student> studentList = (List<Student>) request.getAttribute("students");
            if (studentList==null) return;;
            for (Student student : studentList) {%>
                <tr>
                    <td><%=student.id%></td>
                    <td><%=student.age%></td>
                    <td><%=student.name%></td>
                    <a href="deleteStudent?id=<%=student.id%>">delete</a>
                    <br>
                </tr>
            <%}
        %>
</body>
</html>
