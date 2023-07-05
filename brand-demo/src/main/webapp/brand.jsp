<%--
  Created by IntelliJ IDEA.
  User: xc
  Date: 7/5/23
  Time: 6:51 PM
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

<input type="button" value="Add New Brand" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>


    <%--    <tr align="center">--%>
    <%--        <td>2</td>--%>
    <%--        <td>优衣库</td>--%>
    <%--        <td>优衣库</td>--%>
    <%--        <td>10</td>--%>
    <%--        <td>优衣库，服适人生</td>--%>
    <%--        <td>禁用</td>--%>

    <%--        <td><a href="#">修改</a> <a href="#">删除</a></td>--%>
    <%--    </tr>--%>


    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
                <%--            <td>${status.index}</td>--%>
            <td>${brand.id}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status == 1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status == 0}">
                <td>禁用</td>
            </c:if>

            <td>
                <a href="/brand-demo/selectByIdServlet?id=${brand.id}">修改</a>
                <a href="/brand-demo/deleteByIdServlet?id=${brand.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

<%--<hr>--%>
<%--<c:forEach begin="1" end="10" var="i">--%>
<%--    <a href="#">${i}</a>--%>
<%--</c:forEach>--%>

<script>
    document.getElementById("add").onclick = function () {
        location.href = "/brand-demo/addBrand.jsp";
    }
</script>

<script>
    document.getElementById("delete").onclick = function () {
        location.href = "/brand-demo/deleteByIdServlet";
    }
</script>

</body>
</html>
