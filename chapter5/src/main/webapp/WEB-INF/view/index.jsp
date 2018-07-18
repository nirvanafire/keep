<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<h2>Index!</h2>
<shiro:guest>
    <p>身份:游客</p>
    <a href="<c:url value="/login"/> ">登录</a>
    <a href="<c:url value="/register"/> ">注册</a>
</shiro:guest>
<shiro:user>
    <p>身份:<shiro:principal/></p>
    <a href="<c:url value="/space"/> ">空间</a>
    <a href="<c:url value="/logout"/> ">推出</a>
</shiro:user>
</body>
</html>
