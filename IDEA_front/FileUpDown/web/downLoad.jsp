


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件下载</title>
    <base href="<%=request.getContextPath()+"/"%>>">
</head>
<body>
<h1>文件下载</h1>
<a href="fileDownLoadServlet?name=1.jpg">点击下载小狗图片</a><br/><br/>
<a href="fileDownLoadServlet?name=韩顺平零基础Java笔记.pdf">点击下载 韩顺平零基础Java笔记.pdf</a><br/><br/>
<a href="fileDownLoadServlet?name=高山流水.mp3">点击下载 高山流水.mp3</a><br/><br/>
</body>
</html>
