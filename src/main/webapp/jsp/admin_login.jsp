<%--
  Created by IntelliJ IDEA.
  User: joy12
  Date: 2017/5/28
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!--移动设备自适应-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/style2.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<!-- Page Header -->
<jsp:include page="header.jsp" flush="true" ></jsp:include>

<div class="page-content-s">
    <h1 class="center">管理员登录</h1>
    <div>
        <div class="form-group">
            <label>用户名</label>
            <input class="form-control" id="login_account">
        </div>
        <div class="form-group">
            <label>密码</label>
            <input class="form-control" id="login_password">
        </div>
    </div>
    <div class="offset-top-30">
        <button class="btn btn-block btn-primary" onclick="loginFunc()">登录</button></div>
</div>


<!-- Page Footer -->
<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
    function loginFunc() {
        var login_account=$("#login_account").val();
        var login_password=$("#login_password").val();

        if (login_account == null){
            $("#login_account").after('<div class="error-msg">用户名不能为空</div>');
        }else if (login_password == null){
            $("#login_password").after('<div class="error-msg">密码不能为空</div>');
        }else {
            $.ajax({
                type: "post",//请求方式
                url: "admin/adminLogin",
                timeout: 80000,//超时时间：8秒
                dataType: "json",//设置返回数据的格式
                data: {
                    "login_account": login_account,
                    "login_password": login_password
                },
                //请求成功后的回调函数 data为json格式
                success: function (data) {
                    alert(data.msg);
                    if (data.retcode == 0){
                        window.location.href = "index.jsp";
                    }

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
