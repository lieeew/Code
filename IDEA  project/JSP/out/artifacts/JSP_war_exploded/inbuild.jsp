<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/16
  Time: 13:38
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象</title>
</head>
<body>

<%
    PrintWriter writer = response.getWriter();

    // response.sendRedirect("http://www.bing.com"); // 调转到百度

    request.getParameter("job");

    HttpSession session1 = request.getSession();
    session1.setAttribute("job", "Java工程师");

    // 这个就是相当于 ServletContext
    application.setAttribute("job", "php工程师");

    // 单独使用的 pageContext 可以存放数据, 但是该数据只在本页面使用!
    pageContext.setAttribute("job", "java工程师");

    // page对象类似于this
    out.print("page : " + page); // org.apache.jsp.inbuild_jsp@49b675ac

    String pwd = config.getInitParameter("pwd");


%>
</body>
</html>
