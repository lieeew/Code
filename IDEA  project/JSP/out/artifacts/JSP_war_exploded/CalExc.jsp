<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %><%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/17
  Time: 20:51
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Integer num1 = parseInt(request.getParameter("num1"), 0);
    Integer num2 = parseInt(request.getParameter("num2"), 0);

    System.out.println("num1 = " + num1);
    System.out.println("num2 = " + num2);

    String symbol = request.getParameter("symbol");

    if ("add".equals(symbol)) {
        // 加法
        out.print("num1 + num2 = " + (num2 + num1));
    } else if ("delete".equals(symbol)) {
        // 减法
        out.print("num1 - num2 = " + (num1 - num2));
    } else if ("multiplication".equals(symbol)) {
        // 乘法
        out.print("num1 * num2 = " + (num1 * num2));
    } else if ("division".equals(symbol)) {
        // 除法
        out.print("num1 / num2 = " + (num1 / num2));
    } else {
        System.out.println("内部问题!!!");
    }
%>

<%!
    public Integer parseInt(String num, int defaultNum) {
        Pattern pattern = Pattern.compile("[+,-]{0,2}\\d+");
        Matcher matcher = pattern.matcher(num);

        if (matcher.find()) {
            System.out.println("~~~~~~~~~~~");
            int i = defaultNum;
            i = Integer.parseInt(num);
            return i;
        } else {
            // 输出错误一些信息, 转发页面
            return null;
        }
    }
%>
</body>
</html>
