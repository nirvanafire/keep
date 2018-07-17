<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: zhourl
  Date: 2018/7/17
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Space</title>
</head>
<body>
<h2>空间</h2>
<shiro:authenticated>
    <p>当前用户：<shiro:principal /></p>
    <shiro:hasRole name="admin">
        <p>Admin用户显示</p>
    </shiro:hasRole>
    <shiro:lacksRole name="admin">
        <p>不是Admin用户显示</p>
    </shiro:lacksRole>
    <shiro:hasPermission name="admin:*">
        <p>超级管理员权限</p>
    </shiro:hasPermission>
    <shiro:hasPermission name="admin:query">
        <p>可以看看东西</p>
    </shiro:hasPermission>
</shiro:authenticated>
</body>
</html>
