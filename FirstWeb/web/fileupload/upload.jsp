<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2017/10/18
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/scripts/jquery-3.2.1.min.js">

    </script>
    <script>
        var count = 2;
        $(function () {
            $(".addFile").click(function () {
                $("#br").before(" File"+
                    count+": <input type='file' name='file+" +
                    count +"+'/><br>Desc"+
                    count+": <input type='text' name='desc" +
                    count+" '/><input type='submit' value='上传'>" +
                    " <button class='addFile+"+count+"' type='button'>Add</button>\n" +
                    "        <button class='deleteFile+"+count+"' type='button'>Delete</button><br><br>");
                count ++;
            });
        });
    </script>
</head>
<body>
<form action="/uploadServlet" method="post" enctype="multipart/form-data">
    <span id="part">
    File1: <input type="file" name="file"><br>
    Desc1: <input type="text" name="desc">
    <input type="submit" value="上传">
    <button class="addFile" type="button">Add</button>
        <button class="deleteFile">Delete</button><br><br>
    <br id="br">
    </span>
</form>
</body>
</html>
