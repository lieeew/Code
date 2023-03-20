<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/19
  Time: 13:06
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>c 核心库set方法</title>
</head>
<body>

<c:set scope="application" var="name" value="李华">hello~~~</c:set>

<%
    application.setAttribute("key", "value");
%>
change = ${applicationScope.name} <br>
key = ${applicationScope.key};

</body>
</html>
