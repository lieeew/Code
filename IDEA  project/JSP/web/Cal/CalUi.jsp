<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %><%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/17
  Time: 13:57
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homework</title>
    <script type="text/javascript">
        function check() {
            let num1 = document.getElementById("num1").value;
            let num2 = document.getElementById("num2").value;

            // alert("num1 = " + num1 + " num2 = " + num2 );
            var numPattern = /^[-]?([1-9]\d*|0)$/;

            if (!numPattern.test(num1)) {
                alert("num1不是整数!!!");
                return false;
            }
            if (!numPattern.test(num2)) {
                alert("num2不是整数!!!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>

<h1>JSP 版本计算器</h1>

<%--action="/JSP/CalExc.jsp"--%>
<form action="/JSP/Cal/CalExc.jsp" method="post" onsubmit="return check()">
    num1 : <input type="text" name="num1" id="num1"> <br><br>
    num2 : <input type="text" name="num2" id="num2"> <br><br>

    运算符号 :
    <select name="symbol">
        <option value="add">+</option>
        <option value="delete">-</option>
        <option value="multiplication">*</option>
        <option value="division">/</option>
    </select> <br><br>
    <input type="submit" value="计算" onclick="check()">
</form>

</body>
</html>
