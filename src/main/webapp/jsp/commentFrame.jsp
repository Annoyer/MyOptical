<%--
  Created by IntelliJ IDEA.
  User: 86761
  Date: 2017/6/15
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发表评价</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style2.css"></head>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container"  style="align-self: center;margin-top: 20px">
    <h2>${frame.frameName}</h2>
    <hr>
    <div class="row">

        <div class="">
            <div class="order-item">

                <div class="order-glasses-item row">
                    <div class="tr tr-info">

                        <img src=${frame.framePhoto}>
                    </div>
                    <div class="tr tr-comm">
                        <form role="form">
                            <div class="form-group">

                                <textarea id="myComment" class="form-control" rows="5"></textarea>
                            </div>
                        </form>
                    </div>
                    <div class="tr tr-operator">
                        <button type="button" class="btn btn-default btn-success btn-lg btn-block" onclick="commentFunc()">评价</button>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function commentFunc() {
    var commentStr=document.getElementById("myComment").value;
    $.ajax(
        {
            type: "post",//请求方式
            url: "order/postComment",
            timeout: 800000,//超时时间：8秒
            // dataType: "json",//设置返回数据的格式
            data: {"commentStr":commentStr,
                "frameId":${frame.frameId}
            },

            //请求成功后的回调函数 data为json格式
            success: function (data) {
                //alert(data.returnCode);
                if (data.returnCode == 1) {
                    alert("评价成功！");
                    window.location.href = "single_item?frameId="+${frame.frameId};
                }
                else{
                    alert("评价失败！");
                    window.location.href = "login.jsp";
                }
            },
            //请求出错的处理
            error: function (data) {
                alert("请求出错");

            }
        }
    );}
</script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
