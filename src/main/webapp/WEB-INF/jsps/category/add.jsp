<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/5
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <title>新增类别</title>
    <link href="${ctx}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/admin_manage.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="add_category">
    <form action="/category/addCategory" class="form-horizontal" method="post">
        <div class="control-group">
            <label class="control-label" for="category">类别：</label>
            <div class="controls">
                <input name="categoryName" id="category" type="text" style="height:30px; width: 220px;"/>
                <input type="submit" class="btn" value="增加"/>
            </div>
        </div>
    </form>
</div>

</body>
</html>
