<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/7/20
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>search</title>
    <link href="${ctx}/resources/css/search.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="/article/findArticleByTitle" method="get">
    <div id="search">
        <div id="message">
        </div>
        <div id="input">
            <input type="text" name="title" style="height: 30px;width: 150px;margin: 25px; font-size: large" placeholder="搜索">
        </div>
        <div id="button">
            <button type="submit" data-placement="top" title="搜索"><i class="icon-search icon-white"></i></button>
        </div>
    </div>
</form>
    <script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
    <script src="${ctx}/resources/js/bootstrap.min.js"></script>
    <script>

    </script>
</body>
</html>
