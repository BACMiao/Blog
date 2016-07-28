<%--
  Created by IntelliJ IDEA.
  User: Black
  Date: 2016/6/1
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <title>注册</title>
    <link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div id="registerModal" class="modal show text-center">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                    <h2 class="text-primary">注册</h2>
                </div>
                <div class="modal-body">
                    <form action="/user/saveUser" id="userRegister" method="post">
                        <div class="control-group">
                            <input type="text" class="form-control input-lg required" name="username" style="height:40px; width: 360px; font-size: large" placeholder="新用户名" >
                        </div>
                        <div class="control-group">
                            <input type="password" class="form-control input-lg required" name="password" id="password" style="height:40px; width: 360px; font-size: large" placeholder="密码"/>
                        </div>
                        <div class="control-group">
                            <input type="password" class="form-control input-lg required" name="password2" style="height:40px; width: 360px; font-size: large" placeholder="确认密码"/>
                        </div>
                        <div class="control-group">
                            <button class="btn btn-primary btn-lg btn-block" style="width: 360px; height: 50px; font-size: large" type="submit">注册完毕</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

<script src="${ctx}/resources/js/jquery-1.12.1.min.js"></script>
<script src="${ctx}/resources/js/bootstrap.min.js"></script>
<script src="${ctx}/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
    $('#registerModal').modal({backdrop: 'static', keyboard: false}).css({
        width: 'auto',
        'margin-left': function () {
            return -($(this).width() / 2);
        }
    });

    $(function(){
        $("#userRegister").validate({
            rules : {
                username : {
                    required : true,
                    minlength:5,
                    maxlength:10
                },
                password : {
                    required : true,
                    minlength:6,
                    maxlength:15
                },
                password2 : {
                    required : true,
                    equalTo: "#password"
                },
            },
            messages : {
                username : {
                    required :'<div class="alert alert-danger" role="alert">请输入用户名</div>',
                    minlength:'<div class="alert alert-warning" role="alert">用户名不少于5个字符</div>',
                    maxlength:'<div class="alert alert-warning" role="alert">用户名不大于10个字符</div>'
                },
                password : {
                    required :'<div class="alert alert-danger" role="alert">请输入密码</div>',
                    minlength:'<div class="alert alert-warning" role="alert">密码不少于6位</div>',
                    maxlength:'<div class="alert alert-warning" role="alert">密码不多于15位</div>'
                },
                password2 : {
                    required :'<div class="alert alert-danger" role="alert">请确认密码</div>',
                    equalTo : '<div class="alert alert-danger" role="alert">两次密码输入不一致</div>'
                },
            },
            highlight : function(element) {
                $(element).closest('.control-group').addClass('error');
            },

            success : function(element) {
                $(element).closest('.control-group').removeClass('error').addClass('success');
            },

        })
    });

</script>
</body>
</html>
