<%@ page import="com.hspedu.Monster.Monster_" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/20
  Time: 14:05
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示查询怪物</title>
</head>
<body>

<h1>显示怪物信息</h1>

<%--<%--%>
<%--    HashMap<Integer, Monster_> monsters = new HashMap<Integer, Monster_>();--%>

<%--    monsters.put(100, new Monster_(100, "小妖怪", "巡山的", 344.7));--%>
<%--    monsters.put(200, new Monster_(200, "大妖怪", "做饭的", 1345.7));--%>
<%--    monsters.put(300, new Monster_(300, "老妖怪", "打扫卫生", 12212.2));--%>

<%--    request.setAttribute("monsters", monsters);--%>
<%--    代码没毛病--%>
<%--%>--%>

<table border="1px">
    <tr>
        <th>id</th>
        <th>job</th>
        <th>name</th>
        <th>sal</th>
    </tr>
    <c:forEach begin="100" step="100" end="300" var="i">

        <c:if test="${requestScope.id != i}">
<%--            这个条件必须写在${}里面--%>
            <tr>
                <td>${requestScope.monsters[i].id}</td>
                <td>${requestScope.monsters[i].job}</td>
                <td>${requestScope.monsters[i].name}</td>
                <td>${requestScope.monsters[i].sal}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>

</body>
</html>
