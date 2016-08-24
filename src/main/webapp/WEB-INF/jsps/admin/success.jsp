<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/4
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>博客管理系统</title>
    <link href="${ctx}/resources/css/admin_main.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<nav class="navbar" role="navigation">
    <div class="navbar-inner">
            <div id="title" class="pull-left">博客管理系统</div>
            <div id="user_info">
                <div id="welcome">欢迎管理员：${sessionScope.adminName}</div>
                <div id="logout"><a href="/admin/adminLogout">安全退出</a></div>
            </div>
    </div>
</nav>
<div id="wrapper">

    <div id="navigator">
        <iframe src="/admin/tree"></iframe>
    </div>
    <div id="main">
        <iframe name="MainFrame" src="/admin/main"></iframe>
    </div>
    <%--<div id="footer">Copyright © 2009-2015 All Rights Reserved Powered By Somoniu</div>--%>
</div>
</body>
</html>
