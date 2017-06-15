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
    <title>我的订单</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style2.css"></head>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container"  style="align-self: center;margin-top: 50px">
    <h2>交易成功! 本次消费 ${orderInfo.totalPrice} 元。</h2> <h5>${orderInfo.orderTime}</h5>
    <hr>


        <div class="center">
            <div class="order-item row">

                <c:forEach items="${glassesList}" var="glasses" step="1">
                    <div class="order-glasses-item row">
                        <div class="tr tr-info">
                            <h4>${glasses.frameName}</h4>
                            <img src="${glasses.framePhoto}">
                        </div>
                        <div class="tr tr-pre">
                            <table class="table">
                                <tr><td>    </td> <td>(SPH)</td><td>(CYL)</td><td>Axis</td></tr>
                                <tr><td>left</td> <td>${glasses.lSph}</td><td>${glasses.lCyl}</td><td>${glasses.lAxis}</td></tr>
                                <tr><td>right</td><td>${glasses.rSph}</td><td>${glasses.rCyl}</td><td>${glasses.lAxis}</td></tr>
                                <tr><td>PD</td><td>${glasses.pd}</td></tr>
                            </table>
                        </div>
                        <div class="tr tr-add">
                            <ul>
                                <li>防辐射镜片</li>
                                <li>刻字：miao</li>
                            </ul>
                        </div>
                        <div class="tr tr-price">
                            <h3>￥${glasses.glassesPrice}</h3>
                        </div>
                        <div class="tr tr-operator">
                            <button type="button" class="btn btn-default btn-success btn-lg btn-block" onclick="commentFunc(${glasses.frameId})">评价</button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
    function commentFunc(thisFrameId) {
       // alert("frameId="+thisFrameId);
        window.location.href="commentFrame?frameId="+thisFrameId;
    }

</script>
</body>
</html>
