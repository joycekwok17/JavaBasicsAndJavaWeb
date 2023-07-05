<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 7/5/23
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>hello jsp</h1>
<%
    out.println("hello jsp...");//out是一个隐式对象
    int a = 10;
%>

<%="hello~~"%>
<%=a%>

<%!
    void test(){
        String name = "tom";
    }
%>

</body>
</html>
