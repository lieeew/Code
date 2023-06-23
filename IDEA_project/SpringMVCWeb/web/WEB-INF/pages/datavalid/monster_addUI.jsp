<%--
  Created by IntelliJ IDEA.
  User: liang
  Date: 2023/6/22
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>添加妖怪~~</h3>
<!-- 这里的表单，我们使用 springMVC 的标签来完成
特别说明几点:
1. SpringMVC 表单标签在显示之前必须在 request 中有一个bean, 该bean的属性和表单标签的字段要对应!
request 中的 key 为: form 标签的 modelAttribute 属性值，比如这里的monsters
2. SpringMVC 的 form:form 标签的 action 属性值中的/ 不代表WEB应用的根目录.
3. 这里使用 SpringMVC 的标签主要目的是 数据回显
-->
<form:form action="saveMonsters" method="POST" modelAttribute="monsters">妖怪名字:
    妖怪名字: <form:input path="name"/> <form:errors path="name"/>  <br><br>
    妖怪年龄~: <form:input path="age"/> <form:errors path="age"/> <br><br>
    电子邮件: <form:input path="email"/> <form:errors path="email"/>  <br><br>
    妖怪生日: <form:input path="birthday"/> <form:errors path="birthday"/> 要求以"9999-11-11"的形式<br><br>
    妖怪薪水: <form:input path="salary"/> <form:errors path="salary"/> 要求以"123,890.12"的形式<br><br>
    <input type="submit" value="添加妖怪"/>
</form:form>
</body>
</html>
