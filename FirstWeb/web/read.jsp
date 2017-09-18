<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/9/18
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            String cookieValue = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length> 0) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("cookiePath")) {
                        cookieValue = cookie.getValue();
                    }
                }
            }
            if (cookieValue != null) {
                out.println(cookieValue);
                out.println(request.getScheme());
                out.println(request.getServerName());
                out.println(request.getServerPort());
            } else {
                out.print("没有指定的cookie");
            }
        %>
</body>
</html>
