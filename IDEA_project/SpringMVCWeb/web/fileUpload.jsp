<%--
  Created by IntelliJ IDEA.
  User: liang
  Date: 2023/6/27
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 文件上传和下载 </title>
</head>
<body>
<h1> 文件上传 </h1>
<form action="<%=request.getContextPath()%>/fileUpload" method="post" enctype="multipart/form-data">
    文件的介绍: <input type="text" name="introduce"> <br>
    选择文件: <input type="file" name="file"> <br>
    <input type="submit" value="文件上传">
</form>
</body>
</html>
