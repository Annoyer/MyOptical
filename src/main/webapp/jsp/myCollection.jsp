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
    <title>我的收藏</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style2.css"></head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="page-content-l"  style="align-self: center;margin-top: 50px">
    <h2>Hello,miao!</h2>
    <hr>
    <div class="row">
        <div class="infotab col-md-3">
            <ul class="nav2 nav-pills nav-stacked">
                <li><a href="myInfo">我的基本信息</a></li>
                <li><a href="prescription">我的规格</a></li>
                <li><a href="myOrder">我的订单</a></li>
                <li class="active"><a href="myCollection">我的收藏</a></li>
            </ul>
        </div>
        <div class="my-account col-md-9">
            <c:forEach items="${list}" var="frame" step="1" varStatus="i">
                <div class="col-xs-3 cart-item">
                    <div class="cart-item-header" style="color: #fff"><p>glasses shop</p></div>
                    <div class="cart-item-body">

                        <p>${frame.frameName}</p>
                        <h4>￥${frame.framePrice}</h4>
                    </div>
                    <div class="cart-item-footer row">
                        <button type="button" class="col-xs-6 btn btn-primary btn-sm" onclick="toSetting()">购买</button>
                        <button id="collect" type="button" class="col-xs-6 btn btn-default btn-sm" onclick="uncollectFunc()">移出收藏夹</button>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function(){
        $("#collect").click(function(){
            $(this).parents(".cart-item").remove();
        });
    });


</script>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
