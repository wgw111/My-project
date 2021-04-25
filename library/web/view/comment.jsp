<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2021/4/23
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table class="table table-striped">
    <tr>
        <td>书名</td>
        <td>评论</td>
        <td>评分</td>
    </tr>
    <tr>
        <td>${sessionScope.name}</td>
        <c:forEach items="${sessionScope.comments}" var="i">
            <td>${i.comments}</td>
            <td>${i.score}</td>
            <td><a class="btn btn-default" href="${pageContext.request.contextPath}/delCommentServlet?SBIN=${i.SBIN}" role="button">Link</a></td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
