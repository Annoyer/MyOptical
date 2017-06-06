<%--
  Created by IntelliJ IDEA.
  User: joy12
  Date: 2017/5/28
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!--移动设备自适应-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>单个商品展示</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body onload="getFrameInfo()">
<!-- Page Header -->
<jsp:include page="header.jsp"></jsp:include>

<div class="offset_80">
    <div class="page_content">
        <div class="text_title" id="itemId"></div>
        <div class="item_img_wrapper_lg">
            <img class="img_lg" id="itemImgLg" src=""/>
        </div>
        <div class="offset_40">
            <div class="color_panel">
                <a class="color_choosen" style="background-color: #000000"></a>
                <a class="color_choice" style="background-color: red"></a>
                <a class="color_choice" style="background-color: blue"></a>
                <a class="color_choice" style="background-color: #ffffff"></a>
            </div>
        </div>

        <div class="offset_40">
            <div class="display_inlineblock">
                <div class="display_sm_inlineblocks display_center">
                    <div class="text_content" id="itemPrice">¥399.00</div>
                </div>
                <div class="divider_vertical"> | </div>
                <div class="display_sm_inlineblocks display_center">
                    <div class="btn btn-link btn-sm btn_collect" style="font-size: 15px; color:#26c6da;">
                        <span class="glyphicon glyphicon-heart"></span>
                        加入收藏
                    </div>
                    <div class="btn btn-link btn-sm btn_uncollect" style="font-size: 15px; color:#26c6da;">
                        <span class="glyphicon glyphicon-heart-empty"></span>
                        取消收藏
                    </div>
                </div>
                <div class="divider_vertical"> | </div>
                <div class="display_sm_inlineblocks display_center" style="margin-left: 35px">
                    <div class="btn btn_primary btn_lg btn_rectangle" id="btnBuy" onclick="toBuy()">
                        <span class="glyphicon glyphicon-shopping-cart"></span>
                        加入购物车
                    </div>
                </div>
            </div>
        </div>

        <div class="offset_60">
            <div class="text_title_sm">详细参数</div>
            <hr class="my_hr_long"/>
            <div>
                <table class="table_attribute">
                    <tbody>
                    <tr>
                        <td id="userType">款式：  </td>
                        <td id="lensHeight">镜框高度：  </td>
                    </tr>
                    <tr>
                        <td id="form">框型：  </td>
                        <td id="lensWidth">镜框宽度：  </td>
                    </tr>
                    <tr>
                        <td id="glassesType">功能：  </td>
                        <td id="bridgeWidth">鼻梁宽度：  </td>
                    </tr>
                    <tr>
                        <td id="material">材质：  </td>
                        <td id="templeLength">镜脚长度：  </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <hr class="my_hr_long"/>
        </div>


        <div class="offset_60">
            <div class="text_title_sm">评价</div>
            <div>
                <table class="table">
                    <tbody id="commentListBody">
                    <%--<tr>--%>
                        <%--<td class="comment_wrapper">--%>
                            <%--<div class="comment_user_name">相叶雅纪</div>--%>
                            <%--<div class="comment_content">hhhhhhhhhhhhhhhhh哈哈哈哈哈或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或或、hhhhh哈哈哈哈哈哈哈哈哈哈哈</div>--%>
                            <%--<div class="comment_timestamp">2016-12-25 16:00:00</div>--%>
                        <%--</td>--%>
                    <%--</tr>--%>

                    </tbody>
                </table>
                <hr class="my_hr_long"/>
                <div class="display_center">
                    <ul id="commentNavbar" class="pagination pagination-sm">
                        <%--<li><a href="#">&laquo;</a></li>--%>
                        <%--<li class="active"><a href="#">1</a></li>--%>
                        <%--<li><a href="#">2</a></li>--%>
                        <%--<li><a href="#">3</a></li>--%>
                        <%--<li><a href="#">4</a></li>--%>
                        <%--<li><a href="#">5</a></li>--%>
                        <%--<li><a href="#">&raquo;</a></li>--%>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Page Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>

<script type="text/javascript">
    var thisframeId = "${param.frameId}";
    var allComments = null;
    var maxPageIndex = 0;
    var currentPageIndex = 0;
    var pageSize = 5;

    function getFrameInfo() {
        alert("<%=request.getContextPath()%>/jsp/search/getSingleItem");
        $.ajax({
            type: "post",//请求方式
            url: "<%=request.getContextPath()%>/jsp/search/getSingleItem",
            data:{
                thisframeId:thisframeId
            },
            timeout: 80000,//超时时间：8秒
            //请求成功后的回调函数 data为json格式
            success: function (data) {
                $('#itemId').html(data.frameInfo.frameName);
                $('#itemImgLg').attr('src',data.frameInfo.framePhoto);
                $('#itemPrice').html("￥ " + data.frameInfo.framePrice);
                $('#userType').html("款式：  " + data.frameInfo.userType);
                $('#form').html("框型：  " + data.frameInfo.form);
                $('#glassesType').html("功能：  " + data.frameInfo.glassesType);
                $('#material').html("材质：  " + data.frameInfo.material);
                alert(data.commentList.length + "条评论");
                allComments = data.commentList;
                if (allComments.length == 0){
                    $('#commentListBody').html("暂无评论");
                }else{
                    maxPageIndex = (allComments.length%5 == 0)? (allComments.length/5) : (allComments.length/5+1);
                    for (var i=1; i<=maxPageIndex && i<=10; i++){
                        var node = $('<li id="page' +
                            i +'"><a href="#" onclick="showComments(' +
                            i + ')">' +
                            i +'</a></li>');
                        $('#commentNavbar').append(node);
                    }
                    var node = $('<li id="previous"><a href="#"  onclick="showComments(-1)">&laquo;</a></li>');
                    $('#commentNavbar').prepend(node);
                    node = $('<li id="next"><a href="#" onclick="showComments(-2)">&raquo;</a></li>');
                    $('#commentNavbar').append(node);

                    alert(maxPageIndex + "页评论");
                    currentPageIndex = 1;
                    showComments(1);
                }

            },
            //请求出错的处理
            error: function () {
                alert("请求出错");
            }
        })
    }

    function toBuy(){
        //获取该物品信息并跳转到参数选择页面
        window.location.href='';
    }

    function showComments(pageIndex) {
        var parent = $('#commentListBody');
        var currentId = "#page" + currentPageIndex;
        if (pageIndex == -1){
            if (currentPageIndex == 1) return;
            $(currentId).removeClass("active");
            currentPageIndex = currentPageIndex - 1;
        }else if (pageIndex == -2){
            if (currentPageIndex == maxPageIndex) return;
            $(currentId).removeClass("active");
            currentPageIndex = currentPageIndex + 1;
        }else{
            $(currentId).removeClass("active");
            currentPageIndex = pageIndex;
        }
        var pageId = "#page" + currentPageIndex;
        $(pageId).addClass("active");
        var start = (currentPageIndex-1)*5;
        var end = (start+5) <= (allComments.length) ? (start+5) : (allComments.length);
        //一次全部加载到前台，前台控制分页，一页5条
        for (var i=start; i<end; i++){
            var time = formatTime(allComments[i].commTime);
            if (allComments[i].commPhoto != null){
                var comment = $('<tr><td class="comment_wrapper"><div class="comment_user_name">' +
                    allComments[i].customerId +
                    '</div><div class="comment_content">' +
                    allComments[i].commText +
                    '<div><img class="comment_img" src="' +
                    allComments[i].commPhoto +
                    '"></div></div><div class="comment_timestamp">' +
                    time +
                    '</div></td></tr>');
            }else{
                var comment = $('<tr><td class="comment_wrapper"><div class="comment_user_name">' +
                    allComments[i].customerId +
                    '</div><div class="comment_content">' +
                    allComments[i].commText +
                    '</div><div class="comment_timestamp">' +
                    time +
                    '</div></td></tr>');
            }

            parent.append(comment);
        }
    }

    function add0(m){return m<10?'0'+m:m }
    function formatTime(shijianchuo) {
//shijianchuo是整数，否则要parseInt转换
        var time = new Date(shijianchuo);
        var y = time.getFullYear();
        var m = time.getMonth()+1;
        var d = time.getDate();
        var h = time.getHours();
        var mm = time.getMinutes();
        var s = time.getSeconds();
        return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
    }

    $(document).ready(function(){
        //收藏
        $(".btn_collect").click(function(){
            var currentBtn = $(this);
            alert("frameId:" + thisframeId);
            $.ajax({
                type: "post",//请求方式
                url: "user/collect",
                timeout: 80000,//超时时间：8秒
                dataType: "json",//设置返回数据的格式
                data: {
                    "frameId": thisframeId
                },
                //请求成功后的回调函数 data为json格式
                success: function (data) {
                    if (data.retcode == -1){
                        alert("请先登录");
                        window.location.href = "login.jsp";
                    }else {
                        if (data.retcode == 0){
                            alert("收藏成功");
                        }
                        else if (data.retcode == 1){
                            alert("您已收藏过该商品");
                        }
                        currentBtn.next('div').css("display","inline-block");
                        currentBtn.css("display","none");
                    }
                },
                //请求出错的处理
                error: function () {
                    alert("请求出错");
                }
            });

        });

        //取消收藏
        $(".btn_uncollect").click(function(){
            var currentBtn = $(this);
            alert("frameId:" + thisframeId);
            $.ajax({
                type: "post",//请求方式
                url: "user/uncollect",
                timeout: 80000,//超时时间：8秒
                dataType: "json",//设置返回数据的格式
                data: {
                    "frameId": thisframeId
                },
                //请求成功后的回调函数 data为json格式
                success: function (data) {
                    if (data.retcode == -1){
                        alert("请先登录");
                        window.location.href = "login.jsp";
                    }else{
                        if (data.retcode == 1){
                            alert("您未收藏过该商品");
                        }else if (data.retcode == 0){
                            alert("取消收藏成功");
                        }
                        currentBtn.prev('div').css("display","inline-block");
                        currentBtn.css("display","none");
                    }
                },
                //请求出错的处理
                error: function () {
                    alert("请求出错");
                }
            });

        });

        $(".color_choice").click(function(){
            //要切换图片
            $(this).attr("class","color_choosen");
            $(this).siblings().attr("class","color_choice");
        });

    });

</script>

</html>