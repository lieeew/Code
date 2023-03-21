<%@ page import="com.hspedu.servlet.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 百花  二月
  Date: 2023/3/18
  Time: 19:39
  version : 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el</title>
</head>
<body>
<%
  request.setAttribute("name", "韩顺平教育");
%>

<%--
老韩解读
  1. 如果内容时null, 那么request.getAttribute("name") 返回的结果是 "null"字符串
  2. 如果内容时null, 那么 ${name} 返回的是 ""

--%>

<h1>表达式脚本</h1>

名字= <%=request.getAttribute("name") == null ? "" : request.getAttribute("name")%> <br>

<h1>el 表达式</h1>
名字 = ${name} <br>

<h1>取出数据</h1>
<%
    // 创建对象放入一些熟悉
    Book book = new Book();
    /*
     private String bookName;
     private String[] autors;
     private List<String> reader;
     private Map<String, String> topics;

     */

    book.setBookName("玩具总动员");
    book.setAutors(new String[]{"乔布斯", "tom"});
    List<String> readers = new ArrayList<>();
    readers.add("老韩");
    readers.add("老李");
    book.setReader(readers);
    HashMap<String, String> topics = new HashMap<>();
    topics.put("topic1", "玩具总动员是正的牛");
    topics.put("topic2", "玩具中动员包含哲理");
    book.setTopics(topics);

    request.setAttribute("book", book);
%>

book = ${book} <br>
bookName = ${book.bookName} <br>
bookWriter = ${book.autors} <br>
bookWriter[0] = ${book.autors[0]} <br>
bookWriter[1] = ${book.autors[1]} <br>
book.readers = ${book.reader} <br>
book.reader第一个读者 = ${book.reader.get(0)} <br>
<%--list也可以当做数组使用, 可以使用[]--%>
book.reader第一个读者 = ${book.reader[0]} <br>
book.reader第二个读者 = ${book.reader.get(1)} <br>
topic = ${book.topics["topic1"]} <br>
topic = ${book.topics["topic2"]} <br>


</body>
</html>
