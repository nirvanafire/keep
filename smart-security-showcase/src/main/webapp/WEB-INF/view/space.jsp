<%@ taglib prefix="security" uri="/security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<security:authenticated>
    <p>当前用户：<security:principal /></p>
    <security:hasRole name="admin">
        <p>Admin用户显示</p>
    </security:hasRole>
    <security:lacksRole name="admin">
        <p>不是Admin用户显示</p>
    </security:lacksRole>
    <security:hasPermission name="admin:*">
        <p>超级管理员权限</p>
    </security:hasPermission>
    <security:hasPermission name="admin:query">
        <p>可以看看东西</p>
    </security:hasPermission>
</security:authenticated>
</body>
</html>
