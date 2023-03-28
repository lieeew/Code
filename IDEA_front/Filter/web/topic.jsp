<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/25
  Time: 11:20
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输入评论</title>
</head>
<body>

<h1>评论</h1>

<h4>过滤词 : 苹果, 香蕉 ~~~ 是敏感词</h4> <br>
<form action="<%=request.getContextPath()%>/HomeworkServlet">
    用户名 : <input type="text" name="username"> <br><br>
    评论  :  <textarea name="content" rows="10" cols="20"></textarea> <br><br>
    <input type="submit" value="提交评论">
</form>
</body>
</html>
