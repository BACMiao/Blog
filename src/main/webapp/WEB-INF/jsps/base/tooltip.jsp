<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/7/17
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>tooltip</title>
    <link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/resources/css/tooltip.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="col-xs-3 pull-right" id="myScrollspy">
        <ul class="nav nav-tabs nav-stacked navbar-right" data-spy="affix">
            <li><a id="user-message" data-toggle="tooltip" data-placement="top" title="作者信息">
                <i class="icon-user"></i>
            </a></li>
            <li><a id="two-dimension" data-toggle="tooltip" data-placement="top" title="二维码">
                <i class=" icon-qrcode"></i>
            </a></li>
            <li><a href="#" id="back-to-top" data-toggle="tooltip" data-placement="top" title="返回顶部">
                <i class=" icon-chevron-up"></i>
            </a></li>
        </ul>
    </div>
    <div id="two-dimension-picture">
        <img src="http://7xv9yx.com1.z0.glb.clouddn.com/bapocalypseHead.png">
    </div>

    <script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
    <script src="${ctx}/resources/js/bootstrap.min.js"></script>

<script>
    $(function(){
        //当滚动条的位置处于距顶部200像素以下时，跳转链接出现，否则消失
        $(function () {
            $(window).scroll(function(){
                if ($(window).scrollTop()>500){
                    $("#back-to-top").fadeIn(1000);
                }
                else
                {
                    $("#back-to-top").fadeOut(1000);
                }
            });

            //当点击跳转链接后，回到页面顶部位置
            $("#back-to-top").click(function(){
                $('body,html').animate({scrollTop:0},1000);
                return false;
            });
        });
    });

    $(document).ready(function(){
        $("#two-dimension-picture").hide();
        $("#user-message").mouseenter(function(){
            $("").show();
        });
        $("#user-message").mouseleave(function(){
            $("").hide();
        });
        $("#two-dimension").mouseenter(function(){
            $("#two-dimension-picture").show();
        });
        $("#two-dimension").mouseleave(function(){
            $("#two-dimension-picture").hide();
        });
    });
</script>
</body>
</html>
