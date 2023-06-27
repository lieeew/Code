<%--
  Created by IntelliJ IDEA.
  User: liang
  Date: 2023/6/24
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Json</title>
    <%--    引入 ajax--%>
    <script src="scrip/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            // 给 事件 绑定 click
            $("#getJson").click(function () {
                let url = this.href;
                // console.log(url);
                $.getJSON(
                    url,
                    {"time": new Date},
                    (success) => {
                        console.log("success = " , success);
                        console.log("name = " + success.name);
                        console.log("address = " + success.address);
                    }
                )
                // 返回 false 阻止默认请求
                return false;
            })

            // 绑定点击事件提交 JSON 数据
            $("button[name='buttl']").click(function () {
                let userName = $("#userName").val();
                let age = $("#age").val();
                console.log(userName + " " + age);
                const url = "/SpringMVCWeb/json/user";

                // 将 JSON 对象转化成 JSON字符串
                let args = JSON.stringify({
                    "userName": userName,
                    "age": age
                });

                // 发送 AJAX 请求
                $.ajax({
                    url: url,
                    data: args,
                    // 必须使用 POST 请求，要不然会报错
                    type: "POST",
                    success : (data) => {
                        console.log("data = ", data);
                    },
                    // 这个参数是自定发送参数时的编码格式，会封装到请求头上
                    contentType: "application/json;charset=utf-8"
                })


            })
        })

    </script>
</head>
<body>
<h1>请求一个 json 数据</h1>
<%--
1. 这里一般点击之后要发送一个 AJAX 请求
2. 需要使用到 AJAX 之前的知识
--%>
<a href="<%=request.getContextPath()%>/json/dog" id="getJson"> 点击获取 JSON 数据 </a>

<h1>发出一个 json 数据</h1>
u: <input type="text" id="userName"> <br>
a: <input type="text" id="age"> <br>
<button name="buttl"> 添加用户 </button>

<h1> 文件下载 </h1>
<a href="<%=request.getContextPath()%>/download"> 下载图片 </a>

</body>
</html>
