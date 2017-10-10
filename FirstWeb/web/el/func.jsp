<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/10/10
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="atguigu" uri="http://www.atguigu.com" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${fn:length(param.name)}
    ${fn:toUpperCase(param.name)}
<%--测试自定义的el函数--%>
    ${atguigu:concat("a","b" )}
</body>
</html>
