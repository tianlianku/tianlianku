<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 2022/2/24
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/identification" method="post">
    手机号:<input name="num" type="text"  placeholder="身份认证必填"></br>>
    年龄：<input name="age" id="age" type="text"  ><br>
    地址：<input name="address" id="address" type="text"   onkeyup="checkpassword()"><br>
    <span id="tishi"></span><br></input>
    <input type="submit" value="认证">
</form>
</body>
</html>
