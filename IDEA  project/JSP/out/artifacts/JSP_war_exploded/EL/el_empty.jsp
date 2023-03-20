<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/18
  Time: 22:45
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>empty</title>
</head>
<body>

<%
    request.setAttribute("reg1", null);
    request.setAttribute("reg2", "");
    request.setAttribute("reg3", new Object[]{});
    request.setAttribute("reg4", new HashMap<>());
    request.setAttribute("reg5", new ArrayList<>());
    request.setAttribute("k", 70);
%>

reg1 = ${empty reg1} <br>
reg2 = ${empty reg2} <br>
reg3 = ${empty reg3} <br>
reg4 = ${empty reg4} <br>
reg5 = ${empty reg5} <br>

三元运算符 = ${k > 60 ? "及格" : "不及格"} <br>


</body>
</html>
