<%@ page import="javax.swing.text.html.CSS" %><%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/17
  Time: 7:10
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>域对象放入数据</title>
</head>
<body>
<%
    // 在不同的域对象中放入数据
    // 老韩解读
    // 因为 四个域对象是不同的对象, 因此可以key可以相同
    pageContext.setAttribute("k1", "pageContext(k1)");

    request.setAttribute("k1", "request(k1)");

    session.setAttribute("k1", "session(k1)");

    application.setAttribute("k1", "application(k1)");
    // 请求转发一波
//    request.getRequestDispatcher("/scope2.jsp").forward(request, response);
    // 重定向
    String contextPath = request.getContextPath();
    System.out.println("contextPath = " + contextPath);
    response.sendRedirect("/JSP" + "/scope2.jsp");

%>

<h1>取出scope中的数据</h1>
pageContext : <%=pageContext.getAttribute("k1")%> <br>

request : <%=request.getAttribute("k1")%> <br>

session : <%=session.getAttribute("k1")%> <br>

application : <%=application.getAttribute("k1")%> <br>

</body>
</html>
