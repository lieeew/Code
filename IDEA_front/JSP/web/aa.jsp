<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/17
  Time: 13:44
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>aa</title>
</head>
<body>

<%--
老韩解读
1. jsp提供了很多标签, 但是由于jsp不是重点
2. jsp:forward 本质就是等价于 request.getRequestDispatcher("/bb.jsp").forward(request, responses);

--%>
<jsp:forward page="/bb.jsp"></jsp:forward>
</body>
</html>
