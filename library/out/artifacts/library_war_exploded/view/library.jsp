<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2021/4/21
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书馆</title>
</head>
<body>
<div class="container">
    <table>
        <tr>
            <td>书名</td>
            <td>作者</td>
            <td>位置</td>
            <td>SBIN</td>
            <td>借阅情况</td>
        </tr>
        <c:forEach items="${pb.list}" var="i" step="1">
            <tr>
                <%--点击书名可查看评论--%>
                <td><a class="btn btn-default" href="${pageContext.request.contextPath}/CommentServlet?SBIN=${i.SBIN}&name=${i.name}" role="button">${i.name}</a></td>
                <td>${i.author}</td>
                <td>${i.position}</td>
                <td>${i.SBIN}</td>
                <td>${i.isBrought}</td>
                <td><a  href="${pageContext.request.contextPath}/lendBookServlet?SBIN=${i.SBIN}&isBrought=${i.isBrought}" id="lend" methods="post">借阅</a></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <table>
                <li>
                    <a href="${pageContext.request.contextPath}/libraryServlet?currentPage=${i-1}&rows=5" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" step="1" var="i" varStatus="s">
                    <td><li><a href="${pageContext.request.contextPath}/libraryServlet?currentPage=${i}&rows=5">${i}</a></li></td>
                </c:forEach>
                </table>
                <li>
                    <a href="${pageContext.request.contextPath}/libraryServlet?currentPage=${i+1}&rows=5" aria-label="Next">
                        <span style="font-size: 25px;margin: 5px">
                    共${pb.totalCount}条记录,共${pb.totalPage}页
                        </span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span></button>

    </div>
</div>
</body>
</html>
