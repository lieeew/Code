<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/15
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--page 指令--%>
<%--1. language 表示 jsp 翻译后是什么语言文件, 只支持 java--%>
<%--2. contentType 表示 jsp 返回的数据类型，对应源码中 response.setContentType()参数值--%>
<%--3. pageEncoding 属性 表示当前 jsp 页面文件本身的字符集--%>
<%--4. import 属性 跟 java 源代码中一样。用于导包，导类--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>jsp简单求和计算器</h1>
<%
    // 1. 在jsp中, 该标签中可以写Java代码
    int a = 10;
    int b = 20;
    int reslut = a + b;
    // 2. jsp中内置的对象, 可以直接使用, 像out
    out.print(a + " + " + b + " + " + reslut);
%>
</body>
</html>
