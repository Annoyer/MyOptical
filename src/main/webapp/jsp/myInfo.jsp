<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86761
  Date: 2017/6/8
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style2.css"></head>
<body onload="loginCheckFunc()">
<jsp:include page="header.jsp"></jsp:include>
<div class="page-content-l"  style="align-self: center;margin-top: 50px">
    <h2>Hello,${myInfo.name}!</h2>
    <hr>
    <div class="row">
        <div class="infotab col-md-3">
            <ul class="nav2 nav-pills nav-stacked">
                <li class="active"><a href="myInfo">我的基本信息</a></li>
                <li><a href="prescription">我的规格</a></li>
                <li><a href="myOrder">我的订单</a></li>
                <li><a href="myCollection">我的收藏</a></li>
            </ul>
        </div>
        <div class="my-account col-md-9">
            <div class="row">
                <div class="col-md-6">
                    <table class="table">
                        <tr><td class="no-border">姓名：</td><td class="no-border">${myInfo.name}</td></tr>
                        <tr><td class="no-border">邮箱：</td><td class="no-border">${myInfo.email}</td></tr>
                        <tr><td class="no-border">手机号：</td><td class="no-border">${myInfo.phone}</td></tr>
                    </table>
                </div>
            </div>
            <div class=row>
                <div class="col-md-6"><h5 style="color: #60927e">我的收货地址</h5></div>
                <div class="col-md-6" style="text-align: right"><button class="btn btn-primary" >添加地址</button></div>
            </div>
            <c:forEach items="${addressEntities}" var="addr" step="1">
            <div class="panel panel-default" style="margin-top: 5px">
                <div class="panel-body" >
                    <div class="col-md-9">
                        <p>${addr.state} ${addr.city} ${addr.street} ${addr.other}</p>
                    </div>
                    <div class="col-md-3" style="text-align: right; width: 150px">
                        <button type="button" class="btn btn-default btn-block">删除</button>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>
        <jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
    function loginCheckFunc() {
        if("${loginStatus}"==0)
        {
            alert("请先登录");
            window.location.href="login.jsp";
        }
    }



</script>
</body>
</html>
