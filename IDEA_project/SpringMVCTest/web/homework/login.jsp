<%--
  Created by IntelliJ IDEA.
  User: leikooo
  Date: 2023/6/11
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<%--注意层级目录, 可以加上 base 标签--%>
<form action="<%=request.getContextPath()%>/homework/login">
    U : <input type="text" name="username" /> <br>
    p : <input type="password" name="password" /> <br>
    <input type="submit" value="登录" />
</form>

</body>
</html>
