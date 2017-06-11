<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86761
  Date: 2017/6/8
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的处方</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style2.css"></head>
</head>
<body onload="loginCheckFunc()">
<jsp:include page="header.jsp"></jsp:include>
<div class="page-content-l"  style="align-self: center;margin-top: 20px">
    <h2>Hello,miao!</h2>
    <hr>
    <div class="row">
        <div class="infotab col-md-3">
            <ul class="nav2 nav-pills nav-stacked">
                <li><a href="myInfo">我的基本信息</a></li>
                <li class="active"><a href="prescription">我的规格</a></li>
                <li><a href="myOrder">我的订单</a></li>
                <li><a href="myCollection">我的收藏</a></li>
            </ul>
        </div>
        <div class="my-account col-md-9">
            <c:forEach items="${presList}" var="pres" step="1" varStatus="i">
            <div class="prescription-item col-md-5">
                <table class="table">
                    <caption>${pres.presName}</caption>
                <tr><td>  </td><td>(SPH)</td><td>(CYL)</td><td>Axis</td><td>PD</td></tr>
                <tr><td>left</td><td>${pres.lSph}</td><td>${pres.lCyl}</td><td>${pres.lAxis}</td><td>${pres.pd}</td></tr>
                    <tr><td>right</td><td>${pres.rSph}</td><td>${pres.rCyl}</td><td>${pres.rAxis}</td><td></td></tr>
                </table>
            </div></c:forEach>

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
