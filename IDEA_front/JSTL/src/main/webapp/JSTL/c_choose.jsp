<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/19
  Time: 17:34
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--老韩解读
1. 如果是 ${sessionScope.score} 那么明确指定的是从session 域对象取出数据
2. 如果不写 ${score} 那么就按照 从小到大的顺序进行找 pageContext --> request -->session --> application
--%>
<c:set scope="session" var="score" value="70"> </c:set>

<%--这个就类似于switch ....default--%>
<c:choose>
    <c:when test="${sessionScope.score > 90}">
        <h1>${score} --- 成绩优秀</h1>
    </c:when>
    <c:when test="${sessionScope.score > 60}">
        <h1>${score} -- 成绩及格</h1>
    </c:when>
    <c:otherwise>
        <h1>${score} -- 成绩不合格</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
