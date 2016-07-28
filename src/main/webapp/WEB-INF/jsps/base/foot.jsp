<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/13
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>foot</title>
    <link href="${ctx}/resources/css/foot.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div id="footer">
        <p>声明：本博客所有文章版权属于<a href="/admin/login" style="text-decoration: none;color: black; cursor:default">作者</a>。没有作者许可不得转载，若作者同意转载，必须以超链接形式标明文章原始出处和作者。</p>
    </div>
</body>
</html>
