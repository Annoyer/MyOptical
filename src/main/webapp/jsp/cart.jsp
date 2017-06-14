<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86761
  Date: 2017/6/7
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/buttons.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style2.css"></head>
    <title>我的购物车</title>
</head>
<body>
<!-- Page Header -->
<jsp:include page="header.jsp"></jsp:include>
<div class="container"  style="align-self: center;margin-top: 20px">
<h2>购物车</h2>
<hr>
<div class="th-list">
    <div class="th th-check">
        <input type="checkbox"> 全选
    </div>
    <div class="th th-info">镜框信息</div>
    <div class="th th-pre">镜片处方</div>
    <div class="th th-add">附加</div>
    <div class="th th-price">价格</div>
    <div class="th th-count">数量</div>
    <div class="th th-operator">操作</div>
</div>
<c:forEach items="${glassesList}" var="glasses" step="1" varStatus="i">
<div class="cart-item-lg" style="margin-top: 5px">
    <div class="tr tr-check"><input id="glassesCheck" class="glassesCheck" type="checkbox" value="${glasses.glassesItemId}"/>
    </div>
    <div class="tr tr-info">
        <h4 id="framename">${glasses.frameName}</h4>

        <img id="framePhoto" src=${glasses.framePhoto}>
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

           <li>左侧刻字：
               <c:if test="${not empty glasses.leftText}">${glasses.leftText}</c:if>
               <c:if test="${empty glasses.leftText}">无</c:if>
           </li>

            <li>右侧刻字：
                <c:if test="${not empty glasses.rightText}">${glasses.rightText}</c:if>
                <c:if test="${empty glasses.rightText}">无</c:if>
            </li>
        </ul>
    </div>
    <div class="tr tr-price">
        <h3 class="price">${glasses.glassesPrice}</h3>
    </div>
    <div class="tr tr-count">
        <input type="text" class="form-control glassesCount" value="1" style="width: 40px">
    </div>
    <div class="tr tr-operator">
        <button type="button" class="btn btn-default btn-sm btn-block" onclick="deleteFunc(this);" value="${glasses.glassesItemId}">删除</button>
        <button type="button" class="btn btn-default btn-sm btn-block" onclick="toCollectFunc(this,${glasses.frameId})" value="${glasses.glassesItemId}">移入收藏夹</button>
    </div>
</div>
</c:forEach>
<div class="checkout center">
    <button type="button" class="btn btn-default btn-lg btn-success" onclick="orderFunc()">结算</button>
</div>



</div>
<!-- Page Footer -->
<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
    function orderFunc() {
        var glassesItem=document.getElementsByClassName("cart-item-lg");
        var checks=document.getElementsByClassName("glassesCheck");
        var val=new Array();
        var count=new Array();
        var total=0;

        for(var i=0;i<glassesItem.length;i++){

            if(glassesItem[i].getElementsByClassName("glassesCheck")[0].checked) {
                val.push((glassesItem[i].getElementsByClassName("glassesCheck")[0]).value);
                count.push((glassesItem[i].getElementsByClassName("glassesCount")[0]).value);
                total=total+(glassesItem[i].getElementsByClassName("glassesCount")[0]).value*
                    parseFloat((glassesItem[i].getElementsByClassName("price")[0]).innerHTML);
            }
        }

        $.ajax({
            type: "post",//请求方式
            url: "balance",
            timeout: 800000,//超时时间：8秒
           // dataType: "json",//设置返回数据的格式
            data: {"ids[]":val,
            "counts[]":count,
            "totalPrice":total
            },

            //请求成功后的回调函数 data为json格式
            success: function (data) {
                alert(data.returnCode);
                if (data.returnCode == 1) {
                    alert("订单创建成功！");
                    window.location.href = "myOrder?orderId="+data.orderId;
                }
                else{
                    alert("请先登录！");
                    window.location.href = "login.jsp";
                }
            },
            //请求出错的处理
            error: function (data) {
                alert("请求出错");

            }
        });
    }

    function deleteFunc(delBtn){
        alert(delBtn.value);
        var glassesItemId=delBtn.value;

        $.ajax({
            type: "post",//请求方式
            url: "cart/delete",
            timeout: 80000,//超时时间：8秒
            dataType: "json",//设置返回数据的格式
            data: {
                "glassesItemId":glassesItemId,
            },

            //请求成功后的回调函数 data为json格式
            success: function (data) {
                if(data.returnCode=="1"){
                   // alert("删除成功！");
                    window.location.href ="cart";
                }
                else
                    alert("删除失败!");
            },
            //请求出错的处理
            error: function () {
                alert("请求出错");
            }
        });
    }

    function toCollectFunc(btn,frameId){
        $.ajax({
            type: "post",//请求方式
            url: "user/collect",
            timeout: 80000,//超时时间：8秒
            dataType: "json",//设置返回数据的格式
            data: {
            "frameId": frameId
        },
        //请求成功后的回调函数 data为json格式
        success: function (data) {
            //alert("移入收藏夹");
            deleteFunc(btn);
            //alert("从购物车删除")
        },
        //请求出错的处理
        error: function () {
            alert("请求出错");
        }
        });

    }
</script>

</body>
</html>