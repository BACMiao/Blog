<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/5
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>新增博文</title>
    <link href="${ctx}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/admin_manage.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="add">
    <form action="/article/addArticle" class="form-horizontal" method="post"  enctype="multipart/form-data">
        <div class="control-group">
            <label class="control-label" for="title">标题：</label>
            <div class="controls">
                <input name="title" id="title" type="text" style="height:30px; width: 220px;"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="category">类别：</label>
            <div class="controls">
                <select name="categoryId" id="category">
                    <c:forEach var="category" items="${category}" >
                        <option value="${category.cid}">${category.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="article">博文：</label>
            <div class="controls">
                <input name="file" id="article" type="file" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="description">简介：</label>
            <div class="controls">
                <textarea id="description" name="articleDescribe" style="height:200px; width: 360px;"></textarea>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn">发表</button>
            </div>
        </div>
    </form>
</div>

<script src="${ctx}/resources/jquery/jquery-1.12.1.min.js"></script>
<script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script>

</script>
</body>
</html>
