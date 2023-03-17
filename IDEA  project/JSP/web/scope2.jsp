<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/17
  Time: 7:20
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope2.jsp</title>
</head>
<body>

<h1>取出scope2中的数据</h1>
pageContext : <%=pageContext.getAttribute("k1")%> <br>

request : <%=request.getAttribute("k1")%> <br>

session : <%=session.getAttribute("k1")%> <br>

application : <%=application.getAttribute("k1")%> <br>
</body>
</html>
