<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/5
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增博文</title>
</head>
<body>
<form action="/article/addArticle" method="post"  enctype="multipart/form-data">
    <table width="25%" border="1">
        <tr>
            <td>标题：</td>
            <td><input name="title" type="text" /></td>
        </tr>
        <tr>
            <td>类别：</td>
            <td><input name="categoryId" type="text" /></td>
        </tr>
        <tr>
            <td>博文：</td>
            <td><input name="file" type="file" /></td>
        </tr>
        <tr>
            <td>简介：</td>
            <td><textarea id="articleDescribe" name="articleDescribe" rows="10" cols="55"></textarea></td>
        </tr>
    </table>
    <input type="submit" value="发表"/>
</form>
</body>
</html>
