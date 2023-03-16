<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/15
  Time: 19:58
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表达式地值</title>
</head>
<body>
<h1>表达式地值</h1>

<%
    String name = "老韩";
    int age = 20;
    String email = request.getParameter("email");
%>

用户名 : <%=name%> <br>
工作 : <%="Java工程师"%> <br>
年龄 : <%=request.getParameter("age")%> <br>
email : <%=email%> <br>
</body>
</html>
