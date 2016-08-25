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
    <link href="${ctx}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-inner">
            <div id="title" class="brand">博客管理系统</div>
            <div id="user_info">
                <div id="welcome" class="brand">欢迎管理员：${sessionScope.adminName}</div>
                <div id="logout"><a href="/admin/adminLogout">安全退出</a></div>
            </div>
    </div>
</nav>
<div id="wrapper">
    <div id="navigator">
        <div class="sidebar-menu navbar">
            <div id="navi">
                <a class="brand" href="#hello">管理中心</a>
            </div>
            <ul class="nav nav-pills nav-stacked" id="myTree">
                <li class="dropdown">
                    <a href="#adminMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                        管理员管理
                    </a>
                    <ul id="adminMeun" class="nav nav-list collapse menu-second">
                        <li><a href="#rule"><i class="icon-list"></i> 管理员列表</a></li>
                        <li><a href="#"><i class="icon-edit"></i> 修改管理员</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#userMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                        用户管理
                    </a>
                    <ul id="userMeun" class="nav nav-list collapse menu-second">
                        <li><a href="#"><i class="icon-list"></i> 用户列表</a></li>
                        <li><a href="#"><i class="icon-edit"></i> 修改用户</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#categoryMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                        类别管理
                    </a>
                    <ul id="categoryMeun" class="nav nav-list collapse menu-second">
                        <li><a href="#" target="MainFrame"><i class="icon-list"></i> 类别列表</a></li>
                        <li><a href="#categoryAdd"><i class="icon-plus"></i> 类别添加</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#articleMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                        博文管理
                    </a>
                    <ul id="articleMeun" class="nav nav-list collapse menu-second">
                        <li><a href="#"><i class="icon-list"></i> 博文列表</a></li>
                        <li><a href="#articleAdd"><i class="icon-plus"></i> 博文添加</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div id="main">
        <%--<!-- 选项卡面板 -->--%>
        <%--<div id="myTabContent" class="tab-content">--%>
            <div class="tab-pane fade in active" id="hello"><iframe name="MainFrame" src="/admin/main"></iframe></div>
            <%--<div class="tab-pane fade" id="categoryAdd"><iframe name="CategoryAdd" src="/category/add"></iframe></div>--%>
            <%--<div class="tab-pane fade" id="articleAdd"><iframe name="ArticleAdd" src="/article/add"></iframe></div>--%>
        <%--</div>--%>
    </div>
    <%--<div id="footer">Copyright © 2009-2015 All Rights Reserved Powered By Somoniu</div>--%>
</div>
<script src="${ctx}/resources/jquery/jquery-1.12.1.min.js"></script>
<script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script>
    $(function(){
        $("#myTree a").click(function(e){
            e.preventDefault();
            $(this).tab("show");
        });
    })
</script>
</body>
</html>
