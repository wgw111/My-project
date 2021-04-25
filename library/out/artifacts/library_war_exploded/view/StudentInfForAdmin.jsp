<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2021/4/23
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生管理系统</title>
</head>
<body>
<div class="container">
    <table>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>拉黑情况</td>
        </tr>
        <c:forEach items="${requestScope.pb.list}" var="i" step="1">
            <tr>
                <td>${i.id}</td>
                <td>${i.name}</td>
                <td>${i.gender}</td>
                <c:if test="${i.blacklist==0}">
                    <td>正常</td>
                </c:if>
                <c:if test="${i.blacklist!=0}">
                    <td>已被拉黑</td>
                </c:if>
                <td><a class="btn btn-default" href="${pageContext.request.contextPath}/addBlackListServlet?id=${i.id}" role="button">拉黑</a></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <table>
                    <li>
                        <a href="${pageContext.request.contextPath}/findAllStudentServlet?currentPage=${i-1}&rows=5" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="1" end="${requestScope.pb.totalPage}" step="1" var="i" varStatus="s">
                        <td><li><a href="${pageContext.request.contextPath}/findAllStudentServlet?currentPage=${i}&rows=5">${i}</a></li></td>
                    </c:forEach>
                </table>
                <li>
                    <a href="${pageContext.request.contextPath}/findAllStudentServlet?currentPage=${i+1}&rows=5" aria-label="Next">
                        <span style="font-size: 25px;margin: 5px">
                    共${requestScope.pb.totalCount}条记录,共${requestScope.pb.totalPage}页
                        </span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>