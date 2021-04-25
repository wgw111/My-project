<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2021/4/22
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addBookServlet" method="post">
    <div class="form-group">
        <label for="name">书名</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="请输入书名">
    </div>
    <div class="form-group">
        <label for="author">作者</label>
        <input type="text" class="form-control" id="author" name="author" placeholder="请输入作者名字">
    </div>
    <div class="form-group">
        <label for="SBIN">SBIN</label>
        <input type="text" class="form-control" id="SBIN" name="SBIN" placeholder="请输入SBIN号">
    </div>
    <div class="form-group">
        <label for="position">位置</label>
        <input type="text" class="form-control" id="position" name="position" placeholder="请输入位置">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>
