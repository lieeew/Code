<%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/15
  Time: 19:47
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp申明脚本</title>
</head>
<body>
<%!
  // 这个需要这样使用 还有!
    private String name = "jack";
    private int age;
    private static String company;

    public String getName() {
      return name;
    }

    static {
      company = "字节跳动";
    }

%>
</body>
</html>
