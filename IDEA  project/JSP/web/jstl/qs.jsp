<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/19
  Time: 12:33
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>quick start</title>
</head>
<body>
<%--解读
1. c:if .....类似
2. if (10 > 2) {
    out.print("<h4>10 > 2 为真</h4>");
}

--%>

<h1>快速入门</h1>
<c:if test="${ 10 > 2 }">
  <h4>10 > 2 为真</h4>
</c:if>

<c:if test="${10 < 30}">
  <h4>好家伙~~~</h4>
</c:if>
</body>
</html>
