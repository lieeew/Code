<%--
  Created by IntelliJ IDEA.
  User: leikooo
  Date: 2023/6/7
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>登录页面</h1>

<form action="user/login">
  <input type="text" name="username"> <br>
  <input type="password" name="password"> <br>
  <input type="submit">
</form>

<hr><h1>传入更加简单的参数</h1>
<a href="user/login/李华/123456" >点击调转</a>

<hr> <h1> 测试参数 </h1>

<form action="user/search" method="post">
    bookId : <input type="text" name="bookId"> <br>
    bookName : <input type="text" name="bookName"> <br>
    <input type="submit" />
</form>

</body>
</html>
