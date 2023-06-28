<%--
  Created by IntelliJ IDEA.
  User: liang
  Date: 2023/6/28
  Time: 6:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 文件上传到服务器 </title>
</head>
<body>

<form enctype="multipart/form-data" method="post" action="<%=request.getContextPath()%>/uploadFile">
    description:<input type="text" name="description"> <br> <br>
    document: <input type="file" name="file">
    <input type="submit" value="提交数据">
</form>

</body>
</html>
