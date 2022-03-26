<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 2022/2/22
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%--解决页面乱码--%>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>register</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        function checkpassword() {
            var password = document.getElementById("pw").value;
            var repassword = document.getElementById("repw").value;

            if(password == repassword) {
                document.getElementById("tishi").innerHTML="<br><font color='green'>两次密码输入一致</font>";
                document.getElementById("submit").disabled = false;

            }else {
                document.getElementById("tishi").innerHTML="<br><font color='red'>两次输入密码不一致!</font>";
                document.getElementById("submit").disabled = true;
            }
        }
    </script>
</head>

<body>
<h1>用户注册</h1>

<form action="${pageContext.request.contextPath}/user/register" method="post">
    <input name="username" type="text" class="kuang_txt phone" placeholder="用户名/手机号">
    <input name="password" id="pw" type="password" class="kuang_txt possword" placeholder="密码(不少于6位)" ><br>
    <input name="repassword" id="repw" type="password" class="kuang_txt possword" placeholder="确认密码" onkeyup="checkpassword()"><br>
    <span id="tishi"></span><br></input>
    <input type="submit" value="注册">
</form>
</body>
</html>

