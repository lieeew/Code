<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/19
  Time: 19:38
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作用域</title>
</head>
<body>

<c:set scope="page" var="name" value="pageLeikooo"> </c:set>
<c:set scope="session" var="name" value="sessionLeikooo"> </c:set>
<c:set scope="application" var="name" value="applicationLeikooo"> </c:set>
<c:set scope="request" var="name" value="requestLeikooo"> </c:set>

scope = ${name} <br>

</body>
</html>
