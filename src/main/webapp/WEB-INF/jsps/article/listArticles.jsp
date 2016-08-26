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
    <title>博文列表</title>
    <link href="${ctx}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <table id="articleTable" class="table table-striped">
        <thead>
        <tr>
            <th>序号</th>
            <th>标题</th>
            <th>时间</th>
            <th>类别</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="article" items="${articles}" varStatus="idx">
            <tr>
                <td>${idx.index+1}</td>
                <td>${article.title}</td>
                <td><fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${article.categoryName}</td>
                <td><div id="delete"><input class="btn btn-danger" type="button" onclick="destory(${article.id})" value="删除"/></div></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
<script src="${ctx}/resources/jquery/jquery-1.12.1.min.js"></script>
<script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script>
    function destory(id){
        url = "/article/deleteArticle?id="+id;
        $.get(url,function(msg){
            if (msg.result){
                location.reload();
            } else {
                alert("删除失败！");
            }
        },'json');
    }
</script>
</html>
