<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/22
  Time: 17:14
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/LoginCheckServlet">
  U : <input type="text" name="userName"> <br><br>
  p : <input type="password" name="pwd"> <br><br>
  <input type="submit" value="用户登录">
</form>

</body>
</html>
