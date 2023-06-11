<%--
  Created by IntelliJ IDEA.
  User: leikooo
  Date: 2023/6/11
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
</head>
<body>

<h1> 登录失败 </h1>
<%--重新登录的超链接--%>
<%--
1. <%=request.getContextPath()%>/homework/login.jsp 这里解析为 /SpringMVCTest/homework/login.jsp
2. 第一 / 会被浏览器解析为 http://localhost:8888/
--%>
<a href="<%=request.getContextPath()%>/homework/login.jsp">重新登录</a>
</body>
</html>
