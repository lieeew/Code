<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/19
  Time: 13:46
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>m
<head>
    <title>jstl</title>
</head>
<body>

<c:set scope="application" var="name" value="李华">

</c:set>

<c:set scope="session" var="leikooo" value="程序员">

</c:set>
<c:set var="page" value="pageVlue">

</c:set>

<%
    request.setAttribute("key", "value");
    request.setAttribute("name", "李华");
%>

name = <%=request.getAttribute("key")%> <br>
key = <%=request.getAttribute("name")%> <br>
name = ${requestScope.name} <br>
key = ${requestScope.key} <br>
aplicationName = ${applicationScope.name} <br>
session = ${sessionScope.leikooo} <br>
pageValue = ${pageScope.page} <br>
</body>
</html>
