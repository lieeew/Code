<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/19
  Time: 10:34
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>域对象</title>
</head>
<body>
<h1>4个常用的域对象</h1>

<%
    request.setAttribute("k1", "request-k1");
    session.setAttribute("k1", "session-k1");
    application.setAttribute("k1", "application-k1");
    pageContext.setAttribute("k1", "pageContext-k1");
%>

requestScope  = ${requestScope.k1} <br>
sessionScope = ${sessionScope.k1} <br>
applicationScope = ${applicationScope.k1} <br>
pageContextScope = ${pageScope.k1} <br>

</body>
</html>
