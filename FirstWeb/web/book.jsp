<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/18
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示书的信息</title>
</head>
<body>
    <%=request.getParameter("book")%>

    <a href="books.jsp">Return</a>
    <%
        String book = request.getParameter("book");
        Cookie[] cookies = request.getCookies();
        List<Cookie> bookCookies = new ArrayList<Cookie>();
        //保存books.jsp传过来的匹配的那个Cookie
        Cookie tempCookie = null;
       if (cookies != null && cookies.length > 0) {
           for (Cookie cookie : cookies) {
               if (cookie.getName().startsWith("lxn_")) {
                   bookCookies.add(cookie);
                   if (cookie.getValue().equals(book)) {
                       tempCookie = cookie;
                   }
               }
           }
       }
       //cookie不存在
       if (bookCookies.size() >= 5 && tempCookie == null) {
           tempCookie = bookCookies.get(0);
       }
       //删除cookie
       if (tempCookie != null) {
           tempCookie.setMaxAge(0);
           response.addCookie(tempCookie);
       }
       Cookie cookie = new Cookie("lxn_"+book,book);
       response.addCookie(cookie);
    %>
</body>
</html>
