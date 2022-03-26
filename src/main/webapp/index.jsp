
<%--解决页面乱码--%>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>index</title>
</head>

<body>
<h1>系统主页</h1>
<a href="${pageContext.request.contextPath}/user/logout">退出用户</a>
<ul>
    <%-- admin角色的用户能同时拥有用户管理和订单管理的权限，user角色的用户只拥有订单管理的权限 --%>
            <li><a href="">用户管理</a></li>
            <ul>
                <!--服务端新增-->
                <shiro:hasPermission name="admin:*:*">
                    <li><a href="${pageContext.request.contextPath}/userinsert.jsp">用户新增</a></li>
                </shiro:hasPermission>
                <!--服务端查询-->
                <shiro:hasPermission name="staff:common:*">
                    <li><a href="${pageContext.request.contextPath}/user/userSelect">用户查询</a></li>
                </shiro:hasPermission>
                <!--客户端查询-->
                <shiro:hasPermission name="user:common:*">
                    <li><a href="${pageContext.request.contextPath}/identification.jsp">身份信息完善</a></li>
                </shiro:hasPermission>
            </ul>

        <li><a href="">订单管理</a></li>
        <ul>
            <!--服务端新增-->
            <shiro:hasPermission name="staff:common:*">
            <li><a href="">用户新增</a></li>
            </shiro:hasPermission>
            <!--客户端新增-->
            <shiro:hasPermission name="user:private:*">
                <li><a href="">新增</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="staff:common:*">
                <li><a href="">用户删除</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="staff:common:*">
                <li><a href="">用户修改</a></li>
            </shiro:hasPermission>
            <!--服务端查询-->
            <shiro:hasPermission name="staff:common:*">
                <li><a href="">用户查询</a></li>
            </shiro:hasPermission>
            <!--客户端查询-->
            <shiro:hasPermission name="user:private:*">
                <li><a href="">查询</a></li>
            </shiro:hasPermission>
        </ul>

            <li><a href="">库存管理</a></li>
            <ul>
                <!--服务端查询-->
                <shiro:hasPermission name="staff:common:*">
                    <li><a href="">用户查询</a></li>
                </shiro:hasPermission>
                <!--用户查询-->
                <shiro:hasPermission name="user:private:*">
                    <li><a href="">查询</a></li>
                </shiro:hasPermission>
            </ul>
</ul>
</body>
</html>

