<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 指定了base标签 -->
    <base href="<%=request.getContextPath()+"/"%>>">
    <style type="text/css">
        input[type="submit"] {
            outline: none;
            border-radius: 5px;
            cursor: pointer;
            background-color: #31B0D5;
            border: none;
            width: 70px;
            height: 35px;
            font-size: 20px;
        }

        img {
            border-radius: 50%;
        }

        form {
            position: relative;
            width: 400px;
            height: 200px;
        }

        .input-file-container {
            position: absolute;
            width: 200px;
            height: 100%;
        }

        input[type="file"] {
            position: absolute;
            left: 0;
            top: 0;
            height: 100%;
            opacity: 0;
            cursor: pointer;
            width: 100%;
            z-index: 2;
        }

        #prevView1, #prevView2 {
            float: left;
            margin-right: 10px;
        }

        .clear {
            clear: both;
        }
    </style>

    <script type="text/javascript">
        function prev(event, imgId) {
            //获取展示图片的区域
            var img = document.getElementById(imgId);
            //获取文件对象
            var file = event.files[0];
            //获取文件阅读器： Js的一个类，直接使用即可
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function () {
                //给img的src设置图片url
                img.setAttribute("src", this.result);
            }
        }
    </script>

</head>
<body>
<!-- 表单的 enctype 属性要设置为 multipart/form-data，
     表示提交的数据是多个部分构造，有文件和文本。
     method="post" 的原因是因为 post 可以传输的数据量较大。 -->
<%-- 前面有一个 base 标签，需要注意 --%>
<form action="FileUploadServlet" enctype="multipart/form-data" method="post">
    <div class="input-file-container">
        家居图1: <img src="2.jpg" alt="" width="100" height="100" id="prevView1">
        <input type="file" name="pic1" id="1" value="" onchange="prev(this, 'prevView1')"/>
        家居名1: <input type="text" name="name1"><br/>
    </div>
    <br> <br> <br> <br> <br> <br> <br>
    <div class="input-file-container">
        家居图2: <img src="2.jpg" alt="" width="100" height="100" id="prevView2">
        <input type="file" name="pic2" id="2" value="" onchange="prev(this, 'prevView2')"/>
        家居名2: <input type="text" name="name2"><br/>
    </div>
    <div class="clear"></div>
    <br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
