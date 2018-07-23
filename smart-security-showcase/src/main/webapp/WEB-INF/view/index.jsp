<%--
  Created by IntelliJ IDEA.
  User: zhourl
  Date: 2018/7/21
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="/security" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<security:guest>
    <p>身份:游客</p>
    <a href="<c:url value="/login"/> ">登录</a>
    <a href="<c:url value="/register"/> ">注册</a>
</security:guest>
<security:user>
    <p>身份:<security:principal/></p>
    <a href="<c:url value="/space"/> ">空间</a>
    <a href="<c:url value="/logout"/> ">推出</a>
</security:user>
<a href="<c:url value="/setting"/> ">设置</a>
</body>
</html>
