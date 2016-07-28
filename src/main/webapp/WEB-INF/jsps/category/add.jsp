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
    <title>新增类别</title>
</head>
<body>
<form action="/category/addCategory" method="post">
    <table width="25%" border="1">
        <tr>
            <td>类别：</td>
            <td><input name="categoryName" type="text" /></td>
        </tr>
    </table>
    <input type="submit" value="增加"/>
</form>
</body>
</html>
