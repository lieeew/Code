<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hspedu.Monster.Monster" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/19
  Time: 20:07
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>c:forEach 标签</title>
</head>
<body>
<h1>c:forEach 标签</h1>
<hr/>
<h1>第1种遍历方式从i到j</h1>
<ul>
    <%--
    1.遍历 1 到 5，
    2. 输出 begin 属性设置开始的索引 end 属性设置结束的索引
    3. var 属性表示循环的变量(也是当前正在遍历到的数据)
    4. 等价 for (int i = 1; i <= 5; i++) {}
    5. 在默认情况下, i 每次会递增1
    --%>

    <c:forEach begin="1" end="5" step="1" var="i">
        <li> 第 ${i}</li>
    </c:forEach>

</ul>
<hr/>
<h1>第2种遍历方式：遍历数组</h1>
<%
    request.setAttribute("sports", new String[]{"打篮球", "乒乓球"});
%>
<%--
    <c:forEach items="${ requestScope.sports }" var="item"/>
    1. items 遍历的集合/数组
    2. var 遍历到的数据
    3. 等价 for (Object item: arr) {}
--%>

<c:forEach items="${sports}" var="sport">
    <h4>运动 = ${sport}</h4>
</c:forEach>


<hr/>
<h1>第3种遍历方式：遍历Map</h1>
<%
    Map<String, Object> map = new HashMap<>();
    map.put("key1", "北京");
    map.put("key2", "上海");
    map.put("key3", "天津");
    request.setAttribute("cities", map);
%>
<%--
    1. items 遍历的map集合
    2. var 遍历到的数据
    3. entry.key 取出key
    4. entry.value 取出值
--%>

<c:forEach items="${requestScope.cities}" var="city">
    <h4> 城市 ${city.key} -- ${city.value}</h4>
</c:forEach>

<hr/>
<h1>第4种遍历方式：遍历List</h1>
<%
  List<Monster> monsters = new ArrayList<>();
  monsters.add(new Monster(100, "小妖怪", "巡山的"));
  monsters.add(new Monster(200, "大妖怪", "做饭的"));
  monsters.add(new Monster(300, "老妖怪", "打扫位置的"));
  request.setAttribute("monsters", monsters);
%>
<%--
    items 表示遍历的集合
    var 表示遍历到的数据
    begin 表示遍历的开始索引值 ,从0开始计算
    end 表示结束的索引值
    step 属性表示遍历的步长值
    varStatus 属性表示当前遍历到的数据的状态,可以得到step,begin,end等属性值
    //老师提示, 对于jstl标签，能看懂，会使用即可
--%>

<c:forEach items="${requestScope.monsters}" var="monster">
    妖怪的信息 : ${monster.id} -- ${monster.name} -- ${monster.skill}<br/>
</c:forEach>

<hr>
<c:forEach items="${requestScope.monsters}" var="monster">
    妖怪的信息 : ${monster.id} -- ${monster.name} -- ${monster.skill} <br>
</c:forEach>
</body>
</html>
