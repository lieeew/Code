<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/5/6
  Time: 8:12
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<base href="<%=request.getContextPath() + "/"%>">
<body>

<jsp:forward page="customerServlet?action=pageForName"/>

</body>
</html>
