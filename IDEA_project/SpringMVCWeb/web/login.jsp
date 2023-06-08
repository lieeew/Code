<%--
  Created by IntelliJ IDEA.
  User: leikooo
  Date: 2023/6/6
  Time: 6:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<%--这样写表示地是 http://ip:port/web工程路径/login--%>
<form action="login" method="get">
    u: <input type="text" name="username"> <br>
    p: <input type="password" name="password"> <br>
    <input type="submit" value="登录">
</form>

</body>
</html>
