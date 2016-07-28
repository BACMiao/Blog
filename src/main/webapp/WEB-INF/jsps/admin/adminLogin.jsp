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
    <link href="${ctx}/resources/css/admin_login.css" rel="stylesheet" type="text/css"/>
    <title>后台登录</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div id="logo"></div>
        <div id="heading">
            <div id="title">后台管理系统</div>
            <div id="subTitle">Ver 2.0.0</div>
        </div>
    </div>
    <div id="main">
        <div id="mainBg">
            <div id="mainPanel">
                <div id="left">
                    <div id="image"></div>
                </div>
                <div id="right">
                    <form name="loginForm" action="/admin/exist" method="post">
                        <!-- start of login form -->
                        <div id="welcome">
                            <span id="welcome-text">后&nbsp;台&nbsp;登&nbsp;录</span>
                        </div>
                        <div id="user-name">
                            <span class="item">用户名:</span>
                            <span><input type="text" name="username" class="form-input"></span>
                        </div>
                        <div id="user-password">
                            <span class="item">密&nbsp;&nbsp;&nbsp;码:</span>
                            <span class="input"><input type="password" name="password" class="form-input"></span>
                        </div>
                        <div id="button-group">
                            <input type="submit" class="btn" value="登录"/>
                            <input type="reset" class="btn" value="重置"/>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
    <div id="footer">
        <div id="text">声明：本博客所有文章版权属于作者。没有作者许可不得转载，若作者同意转载，必须以超链接形式标明文章原始出处和作者。</div>
    </div>
</div>
</body>
</html>
