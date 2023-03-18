<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/17
  Time: 22:28
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功</title>
</head>
<body>

<h1>计算结果</h1>

<h2><%=session.getAttribute("format")%></h2> <br>

<a href="<%=request.getContextPath()%>/Cal/CalUi.jsp">点击返回计算</a>
</body>
</html>
