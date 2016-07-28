<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/6
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>${article.title}</title>
    <link href="${ctx}/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/article.css" rel="stylesheet" type="text/css"/>

</head>
<body>
    <div id="main">
        <jsp:include page="../base/head.jsp"/>
        <jsp:include page="../base/search.jsp"/>
        <div id="article">
            <div id="article-body"></div>
            <hr style="height:5px;border:none;border-top:5px groove skyblue;"/>
            <div id="discuss">
                <c:forEach var="discuss" items="${discuss}" varStatus="idx">
                    <h4>${idx.index+1}楼：${discuss.username}&nbsp;&nbsp;<fmt:formatDate value="${discuss.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></h4>
                    ${discuss.message}<br/>
                    <div id="reply">
                    <c:forEach var="replies" items="${reply}">
                        <c:if test="${replies.parentId == discuss.ownId}">
                            <h5>${replies.username}&nbsp;&nbsp;<fmt:formatDate value="${replies.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
                            ${replies.message}<br/>
                        </c:if>
                    </c:forEach>
                    </div>
                    <button class="btn head" type="button">回复</button>
                    <div id="content" style="display:none;">
                        <form action="/discuss/reply?parentId=${discuss.did}" method="post">
                            <textarea name="message" rows="10" cols="70"></textarea>
                            <div class="button">
                                <input type="submit" class="btn btn-primary" value="回复">
                                <input type="reset" class="btn btn-warning" value="清空">
                            </div>
                        </form>
                    </div>
                    <br/>
                </c:forEach>
                <hr/>
                <form action="/discuss/add?articleId=${article.id}" method="post">
                    发表评论：
                    <div>
                        <textarea id="message" name="message"></textarea>
                        <div class="button">
                            <input type="submit" class="btn btn-primary" value="评论"/>
                            <input type="reset" class="btn btn btn-warning" value="清空"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <jsp:include page="../base/foot.jsp"/>
        <jsp:include page="../base/tooltip.jsp"/>
        <div class="clear"></div>
    </div>

    <script src="${ctx}/resources/jquery/jquery-1.12.1.min.js"></script>
    <script src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function(){
            url = "/article/json?id=" + ${article.id};
            $.getJSON(url,function(article){
                msg = article.msg;
                $("#article-body").html(msg);
            });

            $("#discuss button.head").bind("click", function(){
                var loginUsername="<%=session.getAttribute("loginUsername")%>";
                var $content = $(this).next();
                if (loginUsername=='null'){
                    alert("请先登录！")
                }else {
                    if ($content.is(":visible")){
                        $content.hide();
                    }else {
                        $content.show();
                    }
                }
            });
        })
    </script>
</body>
</html>
