<%--
  Created by IntelliJ IDEA.
  User: liang
  Date: 2023/6/27
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试自定义拦截器</title>
</head>
<body>
<h1>测试自定义拦截器</h1>
<a href="<%=request.getContextPath()%>/hi">测试自定义拦截器</a><br><br>
<a href="<%=request.getContextPath()%>/hello">登录</a>
</body>
</html>