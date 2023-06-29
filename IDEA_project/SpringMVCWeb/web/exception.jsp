<%--
  Created by IntelliJ IDEA.
  User: liang
  Date: 2023/6/28
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异常信息</title>
</head>
<body>
<h1> 测试信息 </h1>
<a href="<%=request.getContextPath()%>/testException01?num=0"> 点击进行局部异常测试 </a> <br> <br>
<a href="<%=request.getContextPath()%>/testGlobalException"> 点击测试全局异常 </a> <br> <br>
<a href="<%=request.getContextPath()%>/testException02"> 点击测试自定义异常 </a> <br> <br>
<a href="<%=request.getContextPath()%>/testException03"> 点击测试全局异常 </a> <br> <br>
<a href="<%=request.getContextPath()%>/testException04"> 点击测试未知异常 </a> <br> <br>
</body>
</html>
