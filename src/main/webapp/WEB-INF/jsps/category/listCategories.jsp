<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/8/25
  Time: 20:07
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>类别列表</title>
    <link href="${ctx}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <table id="categoryTable" class="table table-striped">
        <thead>
        <tr>
            <th>序号</th>
            <th>类别</th>
            <th>文章数量</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categories}" varStatus="idx">
            <tr>
                <td>${idx.index+1}</td>
                <td>${category.categoryName}</td>
                <td>${category.number}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
<script src="${ctx}/resources/jquery/jquery-1.12.1.min.js"></script>
<script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script>

</script>
</html>
