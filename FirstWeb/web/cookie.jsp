<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/18
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //从请求中获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for(Cookie cookie : cookies) {
                out.println(cookie.getName()+":"+cookie.getValue());
            }
        } else {
            out.println("正在创建并返回cookie");
            Cookie cookie = new Cookie("name","zhangsan");
            Cookie cookie2 = new Cookie("age","23");
            cookie.setMaxAge(3600);
            cookie2.setMaxAge(3600);
            response.addCookie(cookie2);
            response.addCookie(cookie);
        }
    %>
</body>
</html>
