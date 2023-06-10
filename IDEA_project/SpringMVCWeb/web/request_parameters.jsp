<%--
  Created by IntelliJ IDEA.
  User: leikooo
  Date: 2023/6/8
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试 request</title>
</head>
<body>

<h2> 获取到超链接的数据 </h2>
<hr>
<a href="vote/vote01?name=hsp">获取超链接的参数</a>

<h2>获取到Http消息头</h2>
<hr>
<a href="vote/vote02">获取到Http消息头</a>

<h2>JavaBean封装</h2>
<hr>
<form action="vote/vote03" method="post">
    主人号:<input type="text" name="id"><br>
    主人名:<input type="text" name="name"><br>
    宠物号:<input type="text" name="pet.id"><br>
    宠物名:<input type="text" name="pet.name"><br>
    <input type="submit" value="添加主人和宠物">
</form>

<hr>
<h1>获取 servlet api </h1>
<form action="vote/vote04" method="post">
    用户名:<input type="text" name="username"><br>
    密 码:<input type="password" name="password"><br>
    <input type="submit" value="添加用户">
</form>

</body>
</html>
