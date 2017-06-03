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
<jsp:include page="header.jsp"></jsp:include>

<div class="page-content-s">
    <h1 class="center">登录</h1>
    <form>
        <div class="form-group">
            <label>手机号码</label>
            <input class="form-control">
        </div>
        <div class="form-group">
            <label>密码</label>
            <input class="form-control">
        </div>
    </form>
    <div class="offset-top-30">
        <button type="submit" class="btn btn-block btn-primary">登录</button></div>
    <div class="right offset-top-20"><a>还没有账号</a></div>
</div>


<!-- Page Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>


</html>
