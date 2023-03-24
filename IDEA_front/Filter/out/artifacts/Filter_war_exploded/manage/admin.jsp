<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/22
  Time: 17:14
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    参考目录变为<%=request.getContextPath()%>/manage/ --%>
    <base href="<%=request.getContextPath()%>/manage/">
</head>
<body>
<h1>后台管理</h1>
<%
    System.out.println("request = " + request);
%>

<a href="#">用户列表</a> || <a href="#">添加用户</a> || <a href="#">删除用户</a> <br><br>
<img src="beautifulGirl.jpg" alt="beautifulGirl" width="500">
</body>

</html>
