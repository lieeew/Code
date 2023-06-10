<%--
  Created by IntelliJ IDEA.
  User: leikooo
  Date: 2023/6/9
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取的数据显示页面</title>
</head>
<body>
<h1>获取的数据显页面</h1>
<hr>
取出数据 <br>
address : ${requestScope.address} <br>
主人名字: ${requestScope.master.name} <br>
主人id : ${requestScope.master.id} <br>
宠物的号: ${requestScope.master.pet.id} <br>
宠物名 : ${requestScope.master.pet.name}

<hr>
取出 session 域的数据 <br>
address : ${sessionScope.address} <br>
主人名字= ${sessionScope.master.name}
主人信息= ${sessionScope.master}
</body>
</html>
