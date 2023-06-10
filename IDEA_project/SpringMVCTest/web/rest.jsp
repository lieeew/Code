<%--
  Created by IntelliJ IDEA.
  User: leikooo
  Date: 2023/6/8
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"> </script>
    <script type="text/javascript">
        $(function () {
            $("#deleteBook").click(function () {
                // alert("ok");
                var href = this.href;
                $("#hiddenForm").attr("action", href);
                $(":hidden").val("DELETE");
                $("#hiddenForm").submit();//这里就是提交删除请求了
                return false; //这里必须返回 false,否则会提交两次
            });
        })
    </script>
</head>
<body>
<h3>Rest 风格的 crud 操作案例</h3>
<br>
<hr>
<h3>rest 风格的 url 查询书籍[get]</h3>
<a href="user/book/100">点击查询书籍</a>
<br>
<hr>
<h3>rest 风格的 url 添加书籍[post]</h3>
<form action="user/book" method="post">
    name:<input name="book" type="text"> <br>
    <input type="submit" value="添加书籍">
</form>
<br>
<hr>
<h3>rest 风格的 url, 删除一本书</h3>
<!--
    1. 这里我们需要将删除方式（get）转成 delete 的方式，需要使用过滤器和jquery来完成
    2. name="_method" 名字需要写成 _method 因为后台的 HiddenHttpMethodFilter 就是按这个名字来获取 hidden 域的值，从而进行请求转换的.
 -->
<a href="user/book/100" id="deleteBook">删除指定 id 的书</a>

<form action="" method="POST" id="hiddenForm">
    <input type="hidden" name="_method"/>
</form>
<br>
<hr>
<h3>rest 风格的 url 修改书籍[put]~</h3>
<form action="user/book/100" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="修改书籍~">
</form>
</body>
</html>
