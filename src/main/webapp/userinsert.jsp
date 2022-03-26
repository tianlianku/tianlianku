<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 2022/2/23
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<form action="${pageContext.request.contextPath}/user/staffregister" method="post">
    <input name="username" type="text" class="kuang_txt phone" placeholder="用户名">
    <input name="password" id="pw" type="password" class="kuang_txt possword" placeholder="密码(不少于6位)" ><br>
    <input name="repassword" id="repw" type="password" class="kuang_txt possword" placeholder="确认密码" onkeyup="checkpassword()"><br>
    <span id="tishi"></span><br></input>
    <input type="submit" value="注册">
</form>
</body>
</html>
