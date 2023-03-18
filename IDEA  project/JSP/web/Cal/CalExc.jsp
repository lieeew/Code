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
    Double num1 = parseInt(request.getParameter("num1"), 0);
    Double num2 = parseInt(request.getParameter("num2"), 0);


    if (num1 == null || num2 == null) {
        // 进行转发
        response.sendRedirect(request.getContextPath() + "/CalUi.jsp");
        return;
    }

    System.out.println("num1 = " + num1);
    System.out.println("num2 = " + num2);

    String symbol = request.getParameter("symbol");
    Double result = 0.0;
    if ("add".equals(symbol)) {
        // 加法
        result = num2 + num1;
        symbol = "+";
    } else if ("delete".equals(symbol)) {
        // 减法
        result = num1 - num2;
        symbol = "-";
    } else if ("multiplication".equals(symbol)) {
        // 乘法
        result = num1 * num2;
        symbol = "*";
    } else if ("division".equals(symbol)) {
        // 除法
        result = num1 / num2;
        symbol = "/";
    } else {
        System.out.println("内部问题!!!");
    }

    // 设置结果和num1和num2的值
//    session.setAttribute("num1", num1);
//    session.setAttribute("num2", num2);
//    session.setAttribute("result", result);
//    session.setAttribute("symbol", symbol);

    // 更好的写法是直接在这里处理
    String format = String.format("%s %s %s = %s", num1, symbol, num2, result); // 这个可以
    session.setAttribute("format", format);
    // 请求转发一波
    System.out.println("request.getContextPath() = " + request.getContextPath()); // /JSP

    request.getRequestDispatcher("/Cal/success.jsp").forward(request, response);

%>

<%!
    public Double parseInt(String num, double defaultNum) {
        Pattern pattern = Pattern.compile("^[+,-]{0,2}\\d+$");
        Matcher matcher = pattern.matcher(num);

        if (matcher.find()) {
            return Double.parseDouble(num);
        } else {
            // 输出错误一些信息, 转发页面
            return defaultNum;
        }
    }
%>
</body>
</html>
