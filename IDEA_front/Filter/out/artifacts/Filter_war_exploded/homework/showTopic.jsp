<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/25
  Time: 11:21
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示评论</title>
</head>
<body>

<h1> ${sessionScope.username} 发表的评论是</h1>

<h3>${sessionScope.content}</h3>

</body>
</html>
