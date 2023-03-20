<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/19
  Time: 17:10
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>判断标签</title>
</head>
<body>
<c:set scope="request" var="num1" value="40">

</c:set>
<c:set scope="request" var="num2" value="30">

</c:set>

<c:if test="${num1 > num2}">
  <h1>${num1} > ${num2}</h1>
</c:if>

</body>
</html>
