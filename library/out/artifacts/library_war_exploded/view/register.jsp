<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2021/4/21
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script>
        window.onload= function()
        {
            var img = document.getElementById("check");
            img.onclick=function ()
            {
                var date = new Date();
                img.src="${pageContext.request.contextPath}/codeServlet?"+date.getTime();
            }

        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/registerServlet" method="post">
    <table>
        <tr>
            <td>学号</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="gender"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="verifycode" id="code"></td>
        </tr>
        <tr>

            <td colspan="2"><img id="check" src="${pageContext.request.contextPath}/codeServlet?"></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
<div class="alert alert-warning alert-dismissible" role="alert">
    <button type="button" class="close" data-dismiss="alert" >
        <span>&times;</span></button>
    <strong>${pageContext.request.getAttribute("reg_msg")}</strong>
</div>
</body>
</html>
