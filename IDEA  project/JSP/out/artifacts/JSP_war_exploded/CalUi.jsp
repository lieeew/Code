<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %><%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/17
  Time: 13:57
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homework</title>
</head>
<body>

<h1>JSP 版本计算器</h1>

<form action="/JSP/CalExc.jsp" method="post">
    num1 : <input type="text" name="num1"> <br><br>
    num2 : <input type="text" name="num2"> <br><br>

    运算符号 : <select name="symbol">
    <option value="add">+</option>
    <option value="delete">-</option>
    <option value="multiplication">*</option>
    <option value="division">/</option>
</select> <br><br>
    <input type="submit" value="计算">
</form>

</body>
</html>
