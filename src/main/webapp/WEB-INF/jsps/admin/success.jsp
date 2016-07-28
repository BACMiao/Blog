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
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/index.css" />
    <title>后台管理系统</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div id="logo"></div>
        <div id="title">后台管理系统</div>
        <div id="user_info">
            <div id="welcome">欢迎${sessionScope.adminName}使用本系统</div>
            <div id="logout"><a href="/admin/adminLogout">安全退出</a></div>
        </div>
    </div>
    <div id="navigator">
        <iframe src="/admin/tree"></iframe>
    </div>
    <div id="main">
        <iframe name="MainFrame" src="/admin/main"></iframe>
    </div>
    <div id="footer">Copyright © 2009-2015 All Rights Reserved Powered By Somoniu</div>
</div>
</body>
</html>
