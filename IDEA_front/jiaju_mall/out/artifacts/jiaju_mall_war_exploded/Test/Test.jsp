<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/4/13
  Time: 21:18
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  request.setAttribute("k1", "request-k1");
%>
requestScope  = ${requestScope.k1} <br>

</body>
</html>
