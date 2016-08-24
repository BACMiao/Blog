<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
	<title>导航树</title>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/tree.css" />
    <link href="${ctx}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="sidebar-menu">
            <a class="brand" href="#">管理中心</a>
            <ul class="nav nav-pills nav-stacked">
                <li class="dropdown">
                    <a href="#adminMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                        管理员管理
                    </a>
                    <ul id="adminMeun" class="nav nav-list collapse menu-second">
                        <li><a href="#"><i class="icon-list"></i> 管理员列表</a></li>
                        <li><a href="#"><i class="icon-edit"></i> 修改管理员</a></li>
                    </ul>
                </li>
                <li class="divider-vertical"></li>
                <li class="dropdown">
                    <a href="#userMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                        用户管理
                    </a>
                    <ul id="userMeun" class="nav nav-list collapse menu-second">
                        <li><a href="#"><i class="icon-list"></i> 用户列表</a></li>
                    </ul>
                </li>
                <li class="divider-vertical"></li>
                <li class="dropdown">
                    <a href="#categoryMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                        类别管理
                    </a>
                    <ul id="categoryMeun" class="nav nav-list collapse menu-second">
                        <li><a href="#"><i class="icon-list"></i> 类别列表</a></li>
                        <li><a href="#"><i class="icon-plus"></i> 类别添加</a></li>
                    </ul>
                </li>
                <li class="divider-vertical"></li>
                <li class="dropdown">
                    <a href="#articleMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                        博文管理
                    </a>
                    <ul id="articleMeun" class="nav nav-list collapse menu-second">
                        <li><a href="#"><i class="icon-list"></i> 博文列表</a></li>
                        <li><a href="students/Students_query.action"><i class="icon-plus"></i> 博文添加</a></li>
                    </ul>
                </li>
            </ul>
    </div>
<script src="${ctx}/resources/jquery/jquery-1.12.1.min.js"></script>
<script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script>

</script>
</body>
</html>