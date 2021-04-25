<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2021/4/21
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>
</head>
<body>
<table border="1" class="table table-bordered table-hover">
    <tr class="success">
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
    </tr>
        <tr>
            <td>${sessionScope.student.id}</td>
            <td>${sessionScope.student.name}</td>
            <td>${sessionScope.student.gender}</td>
        </tr>
</table>
<table>
    <tr>
        <td>借阅的书</td>
        <td>剩余天数</td>
    </tr>
    <c:forEach items="${sessionScope.student.bookList}" var="i" varStatus="s" step="1">
        <tr>
            <td>${i.name}</td>
            <td>${i.day}</td>
            <td>
                <a class="btn btn-default" href="${pageContext.request.contextPath}/returnBookServlet?SBIN=${i.SBIN}" role="button">还书</a>
            </td>
        </tr>
    </c:forEach>
    <a href="library.jsp" methods=""></a>
</table>
</body>
</html>
