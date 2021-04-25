<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2021/4/22
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评价</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addCommentServlet?SBIN=${pageContext.request.getParameter("SBIN")}" method="post">
    <table>
        <tr>
            <label for="score">评分</label>
            <select name="score" class="form-control" id="score" >
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
        </tr>
        <tr>
            <td>请输入你对此书的评价：<input type="text" name="comment"></td>
        </tr>
        <input class="btn btn-primary" type="submit" value="提交" />
    </table>
</form>
</body>
</html>
