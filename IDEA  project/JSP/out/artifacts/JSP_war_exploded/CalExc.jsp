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
    int result = 0;
    if ("add".equals(   symbol)) {
        // 加法
        result = (num2 + num1);
        symbol = "+";
    } else if ("delete".equals(symbol)) {
        // 减法
        result = (num1 - num2);
        symbol = "-";
    } else if ("multiplication".equals(symbol)) {
        // 乘法
        result = (num1 * num2);
        symbol = "*";
    } else if ("division".equals(symbol)) {
        // 除法
        result = (num1 / num2);
        symbol = "/";
    } else {
        System.out.println("内部问题!!!");
    }

    // 设置结果和num1和num2的值
    session.setAttribute("num1", num1);
    session.setAttribute("num2", num2);
    session.setAttribute("result", result);
    session.setAttribute("symbol", symbol);
    // 请求转发一波
    request.getRequestDispatcher("/success.jsp").forward(request, response);


%>

<%!
    public Integer parseInt(String num, int defaultNum) {
        Pattern pattern = Pattern.compile("^[+,-]{0,2}\\d+$");
        Matcher matcher = pattern.matcher(num);

        if (matcher.find()) {
            System.out.println("~~~~~~~~~~~");
            return Integer.parseInt(num);
        } else {
            // 输出错误一些信息, 转发页面
            return defaultNum;
        }
    }
%>
</body>
</html>
