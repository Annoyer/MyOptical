<%--
  Created by IntelliJ IDEA.
  User: joy12
  Date: 2017/5/28
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/style2.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<!-- Page Header -->
<jsp:include page="header.jsp"></jsp:include>

<div class="page-content-s">
    <h1 class="center">注册</h1>
    <div>
        <div class="form-group">
            <label>用户名</label>
            <input class="form-control" id="register_account">
        </div>
        <div class="form-group">
            <label>密码</label>
            <input class="form-control" id="register_password">
        </div>
        <div class="form-group">
            <label>确认密码</label>
            <input class="form-control" id="register_pw_confirm">
        </div>
        <div class="form-group">
            <label>昵称</label>
            <input class="form-control" id="register_nickname">
        </div>
        <div class="form-group">
            <label>手机号</label>
            <input class="form-control" id="register_phone">
        </div>
        <div class="form-group">
            <label>邮箱</label>
            <input class="form-control" id="register_email">
        </div>
    </div>
    <div class="offset-top-30">
        <button class="btn btn-block btn-primary" onclick="registerFunc()">注册</button></div>
    <div class="right offset-top-20"><a>已有账号</a></div>
</div>


<!-- Page Footer -->
<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
    function registerFunc() {
        var register_account=$("#register_account").val();
        var register_password=$("#register_password").val();
        var register_pw_confirm=$("#register_pw_confirm").val();
        var register_nickname = $("#register_nickname").val();
        var register_phone=$("#register_phone").val();
        var register_email=$("#register_email").val();

        if (register_account == null){
            $("#register_account").after('<div class="error-msg">用户名不能为空</div>');
        }else if (register_password == null){
            $("#register_password").after('<div class="error-msg">密码不能为空</div>');
        }else if (register_nickname == null){
            $("#register_nickname").after('<div class="error-msg">昵称不能为空</div>');
        }else if(register_password!=register_pw_confirm) {
            $("#file_error").empty().append("两次密码不一致...");
        }else {
            $.ajax({
                type: "post",//请求方式
                url: "register",
                timeout: 80000,//超时时间：8秒
                dataType: "json",//设置返回数据的格式
                data: {
                    "register_account": register_account,
                    "register_password": register_password,
                    "register_nickname": register_nickname,
                    "register_phone": register_phone,
                    "register_email": register_email
                },
                //请求成功后的回调函数 data为json格式
                success: function (data) {
                    alert(data.msg);
                    if (data.msg == "注册成功")
                        window.location.href = "login.jsp";
                },
                //请求出错的处理
                error: function () {
                    alert("请求出错");
                }
            });
        }
    }
</script>
</body>
</html>

