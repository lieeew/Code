<%@ page import="org.springframework.web.servlet.config.annotation.EnableWebMvc" %><%--
  Created by IntelliJ IDEA.
  User: liang
  Date: 2023/6/26
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button[name='butt1']").click(function () {
                let stringify = JSON.stringify({
                    "name": $("#name").val(),
                    "address": $("#address").val()
                });

                console.log("stringify = ", stringify)

                $.ajax({
                    url: "http://localhost:8888/SpringMVCTest/JSON/getJson2",
                    data: stringify,
                    // 必须使用 POST 请求，要不然会报错
                    type: "POST",
                    success: (data) => {
                        console.log("data = ", data);
                    },
                    // 封装到消息头
                    contentType: "application/json;charset=utf-8",
                    dataType: "JSON"
                })
                // 阻止默认返回
                return false;
            })

            $("button[name='butt2']").click(function () {
                $.ajax({
                    url: `<%=request.getContextPath()%>/JSON/getJson3`,
                    data: JSON.stringify({
                        "userName": $("#userName").val(),
                        "age": $("#age").val()
                    }),
                    type: "POST",
                    success: (data) => {
                        console.log("data = ", data);
                    },
                    contentType: "application/json;charset=utf-8",
                    dataType: "JSON"
                })
            })
        })

    </script>
</head>
<body>
<h1>请求一个 json 数据</h1>
<a href="<%=request.getContextPath()%>/JSON/getJson" id="getJson"> 点击获取 json 数据 </a>

<h1>发出一个 json 数据</h1>
u:<input id="name" type="text"><br/>
a:<input id="address" type="text"><br/>
<button name="butt1">添加一个动物</button>

<h1>发出一个 json 数据</h1>
u:<input id="userName" type="text"><br/>
a:<input id="age" type="text"><br/>
<button name="butt2">添加用户</button>

<h1> 点击下载文件 </h1>
<a href="<%=request.getContextPath()%>/JSON/downLoadMessage"> 点击下载文件 </a>


</body>
</html>
