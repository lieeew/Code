<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hspedu.entity.Monster" %><%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/16
  Time: 11:57
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>代码脚本</title>
</head>
<body>
<%
    // 创建ArrayList , 放入两个Monster对象
    ArrayList<Monster> monsters = new ArrayList<>();
    monsters.add(new Monster("牛魔王", 1, "芭蕉扇"));
    monsters.add(new Monster("蜘蛛精", 2, "吐口水"));
%>

<h1>代码脚本</h1>
<table bgcolor="#a0107a" border="1px" width="300px">
    <tr>
        <th>id</th>
        <th>名字</th>
        <th>技能</th>
    </tr>
    <%
        for (int i = 0; i < monsters.size(); i++) {
            Monster monster = monsters.get(i);
    %>
    <tr>
        <td><%=monster.getId()%>
        </td>
        <td><%=monster.getName()%>
        </td>
        <td><%=monster.getSkill()%>
        </td>
    </tr>
    <%
        }
    %>

</table>

</body>
</html>
