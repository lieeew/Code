<%--
  Created by IntelliJ IDEA.
  User: leikooo
  Date: 2023/6/6
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>购买商品</h1>
<%--不需要加 / --%>
<form action="user/buy" method="post">
    购买人:<input type="text" name="username"><br>
    够买量:<input type="text" name="nums"><br>
    <input type="submit" value="购买">
</form>

<hr><h1>演示 params 的使用</h1>
<a href="user/find?bookId=110">查询书籍</a>

<hr><h1>演示 Ant 风格的请求资源方式 </h1>
<a href="user/message/aa">发送消息 1</a><br>
<a href="user/message/aa/bb/cc">发送消息 2</a><br>

<hr><h1>占位符的演示</h1>
<a href="user/reg/kristina/300">占位符的演示</a>

</body>
</html>
