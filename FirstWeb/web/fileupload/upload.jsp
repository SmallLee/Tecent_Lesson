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
                $("#last").before("   <tr class='file'>\n" +
                    "            <td>File"+count+":</td><td> <input type=\"file\" name='file"+count+"'></td>\n" +
                    "        </tr>\n" +
                    "        <tr class='desc'>\n" +
                    "            <td> Desc"+count+":</td>\n" +
                    "            <td><input type=\"text\" name='desc"+count+"'>" +
                    "<button type='button' id='delete"+count+"'>删除</button></td></tr>");
                count++;
                $("#delete"+(count-1)).click(function () {
                   var tr = $(this).parent().parent();
                    tr.prev("tr").remove();
                    tr.remove();
                    //对索引进行重排序
                    $(".file").each(function (index) {
                        $(this).find("td:first").text("File"+(index+1));
                        $(this).find("td:last input").attr("name","file"+(index+1));
                    });
                    $(".desc").each(function (index) {
                        $(this).find("td:first").text("Desc"+(index+1));
                        $(this).find("td:last input").attr("name","desc"+(index+1));
                    });
                    count = count - 1;
                });
            });
        });
    </script>
</head>
<body>
<form action="<%=request.getContextPath()%>/fileupload" method="post" enctype="multipart/form-data">
    <table>
        <tr class="file">
            <td>File1:</td>
            <td> <input type="file" name="file1"></td>
        </tr>
        <tr class="desc">
            <td> Desc1:</td>
            <td><label>
                <input type="text" name="desc1">
            </label></td>
        </tr>
        <tr id="last">
            <td> <input type="submit" value="上传"></td>
            <td><button class="addFile" type="button">增加一个新的</button></td>
        </tr>
    </table>
</form>
</body>
</html>
