<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 7/5/23
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> <%--开启el表达式--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${status==1}">
    <h1>hello true</h1>
</c:if>

<c:if test="${status==0}">
    <h1>hello fa</h1>
</c:if>
</body>
</html>
