<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/18
  Time: 22:16
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el的操作运算符</title>
</head>
<body>

<h1>el的操作运算符</h1>
<%
    request.setAttribute("num1", 10);
    request.setAttribute("num2", 30);
%>

num1 + num2 = ${num1 + num2} <br>
num1 > num2 = ${num1 < num2} <br>

</body>
</html>
