<%--
  Created by IntelliJ IDEA.
  User: joy12
  Date: 2017/5/28
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!--移动设备自适应-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>眼镜列表</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<!-- Page Footer -->
<jsp:include page="header.jsp"></jsp:include>

<div class="page_content">
    <div class="offset_40">
        <div class="panel panel_choose_style">
            <div class="panel-heading">
                <h4 class="panel-title text_center">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseOne">
                        选 择 面 板 ▼
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse">
                <div class="panel-body">
                    <form class="style_selector" id="styleSelector">
                        <div class="checkbox_group">
                            <div class="checkbox_group_row">
                                <div class="checkbox_group_label text_center">款式</div>
                                <div class="checkbox_group_options" id="panel_user_type">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="man" value="man">男式
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="woman" value="woman">女式
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="child" value="child">儿童
                                    </label>
                                </div>
                            </div>
                            <div class="checkbox_group_row">
                                <div class="checkbox_group_label text_center">功能</div>
                                <div class="checkbox_group_options" id="panel_glasses_type">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="nearsighted" value="nearsight">近视眼镜
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="sun" value="sun">太阳眼镜
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="farsighted" value="farsight">老花眼镜
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="sports" value="sports">运动眼镜
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="radiation" value="radiation">防辐射眼镜
                                    </label>
                                </div>
                            </div>
                            <div class="checkbox_group_row">
                                <div class="checkbox_group_label text_center">框型</div>
                                <div class="checkbox_group_options">
                                    <label class="checkbox-inline" id="panel_form">
                                        <input type="checkbox" id="full" value="full">全框
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="half" value="half">半框
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="none" value="none">无框
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="square" value="square">方框
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="circle" value="circle">圆框
                                    </label>
                                </div>
                            </div>
                            <div class="checkbox_group_row">
                                <div class="checkbox_group_label text_center">材质</div>
                                <div class="checkbox_group_options" id="panel_material">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="bancai" value="bancai">板材
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="jinshu" value="jinshu">金属
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="sugang" value="sugang">塑钢
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="trtaisu" value="trtaisu">TR钛塑
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="tanqianwei" value="tanqianwei">碳纤维
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="chuntai" value="chuntai">纯钛
                                    </label>
                                </div>
                            </div>
                            <div class="checkbox_group_row">
                                <div class="checkbox_group_label text_center">风格</div>
                                <div class="checkbox_group_options" id="panel_style">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="business" value="business">商务
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="casual" value="casual">休闲
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="fashion" value="fashion">潮款
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="retro" value="retro">复古
                                    </label>
                                </div>
                            </div>
                            <div class="checkbox_group_row">
                                <div class="checkbox_group_label text_center">颜色</div>
                                <div class="checkbox_group_options" id="panel_color">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="blackorwhite" value="bw">黑白
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="blue" value="blue">蓝色
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="red" value="red">红色
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="yellow" value="yellow">黄色
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="brown" value="brown">咖啡
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="silver" value="silver">银色
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="pattern" value="pattern">花纹
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="other" value="other">其他
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="align_right">
                            <button class="btn btn_submit" id="btnPanelSubmit">确认</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="offset_80">
        <ul class="imgs_wrap_4_info">
            <li class="item_list_show">
                <div class="item_wrap_brief">
                    <img class="item_img_4_info" src="css/img/child.png"/>
                    <div class="item_info_price">¥100.00</div>
                </div>

                <div class="item_panel" style="display: none">
                    <img class="item_img_4_info" src="css/img/child.png"/>
                    <div class="item_info_price">¥100.00</div>
                    <!--js需求：加载页面时从后台获取该眼镜的颜色类别，加载对应颜色的色框，点击色框更换图片-->
                    <%--<div class="item_info_color_selector">--%>
                        <%--<div class="item_info_color"></div>--%>
                        <%--<div class="item_info_color"></div>--%>
                        <%--<div class="item_info_color"></div>--%>
                        <%--<div class="item_info_color"></div>--%>
                    <%--</div>--%>
                    <div class="item_info_brief">
                        材质：TR钛塑
                        <%--<br>--%>
                        <%--可选瞳距：65-76--%>
                    </div>
                    <div class="display_inline">
                        <div class="btn btn_primary btn-xs btn_collect">
                            <span class="glyphicon glyphicon-heart-empty"></span>
                            收藏
                        </div>
                        <div class="btn btn_primary btn-xs btn_uncollect">
                            <span class="glyphicon glyphicon-heart"></span>
                            取消
                        </div>
                        <div class="btn btn_primary btn-xs" id="btnBuy" onclick="toBuy()">
                            <span class="glyphicon glyphicon-shopping-cart"></span>
                            购买
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>
</div>

<!-- Page Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>

<script type="text/javascript">
    function toBuy(){
        //【未完成】获取该物品信息并跳转到参数选择页面
        window.location.href='';
    }

    //第一次加载本页面时，获取后台从mv传来的list
    function firstLoad() {
        alert("<%=request.getContextPath()%>/jsp/search/firstLoad");
        $.ajax({
            type: "get",//请求方式
            url: "<%=request.getContextPath()%>/jsp/search/firstLoad",
            timeout: 80000,//超时时间：8秒
            //请求成功后的回调函数 data为json格式
            success: function (data) {
                showList(data);
            },
            //请求出错的处理
            error: function () {
                alert("请求出错");
            }
        })
    }




    $(document).ready(function(){
        alert("<%=request.getContextPath()%>/jsp/search/firstLoad");
        $.ajax({
            type: "get",//请求方式
            url: "<%=request.getContextPath()%>/jsp/search/firstLoad",
            timeout: 80000,//超时时间：8秒
            //请求成功后的回调函数 data为json格式
            success: function (data) {
                showList(data);
            },
            //请求出错的处理
            error: function () {
                alert("请求出错");
            }
        })

        $(".item_list_show").hover(function(){
            $(this).children('div.item_wrap_brief').toggle();
            $(this).children('div.item_panel').toggle();
        });


        //收藏
        $(".btn_collect").click(function(){
            $.ajax({
                type: "post",//请求方式
                url: "user/collect",
                timeout: 80000,//超时时间：8秒
                dataType: "json",//设置返回数据的格式
                data: {
                    "frameId": ${frameInfo.frameId}
                },
                //请求成功后的回调函数 data为json格式
                success: function (data) {
                    if (data.retcode == 0){
                        alert("收藏成功");
                    }
                    else {
                        alert("您已收藏过该商品");
                    }
                    $(this).next('div').css("display","inline-block");
                    $(this).css("display","none");
                },
                //请求出错的处理
                error: function () {
                    alert("请求出错");
                }
            });

        });

        //取消收藏
        $(".btn_uncollect").click(function(){
            $.ajax({
                type: "post",//请求方式
                url: "user/uncollect",
                timeout: 80000,//超时时间：8秒
                dataType: "json",//设置返回数据的格式
                data: {
                    "frameId": ${frameInfo.frameId}
                },
                //请求成功后的回调函数 data为json格式
                success: function (data) {
                    if (data.retcode == 0){
                        alert("取消收藏成功");
                    }
                    else {
                        alert("您未收藏过该商品");
                    }
                    $(this).prev('div').css("display","inline-block");
                    $(this).css("display","none");
                },
                //请求出错的处理
                error: function () {
                    alert("请求出错");
                }
            });

        });

        //根据参数查找，在图片上设置跳转到单个页面的带参数超链接
        $("#btnPanelSubmit").click( function () {
            alert("catch submit btn click");
            var glasses_type = "";
            var color = "";
            var style = "";
            var user_type = "";
            var form = "";
            var material = "";
            $(":checked").each(function(){
                var parentId = $(this).parent().parent().attr('id');
                switch (parentId) {
                    case ("panel_user_type"):
                        user_type += (":" + $(this).html());break;
                    case ("panel_glasses_type"):
                        glasses_type += (":" + $(this).html());break;
                    case ("panel_color"):
                        color += (":" + $(this).html());break;
                    case ("panel_style"):
                        style += (":" + $(this).html());break;
                    case ("panel_form"):
                        form += (":" + $(this).html());break;
                    case ("panel_material"):
                        material += (":" + $(this).html());break;
                    default:
                        alert("选择面板出错");
                }
            });
            alert("usertype=" + user_type + "\nglassestype=" + glasses_type + "\nstyle=" + style + "\ncolor=" + color + "\nform=" + form + '\nmaterial=' + material);
            $.ajax({
                type: "post",//请求方式
                url: "search/panelOptions",
                timeout: 80000,//超时时间：8秒
                dataType: "json",//设置返回数据的格式
                data: {
                    "userType": user_type,
                    "glassesType": glasses_type,
                    "color": color,
                    "style": style,
                    "material": material,
                    "form": form
                },
                //请求成功后的回调函数 data为json格式
                success: function (data) {
                    showList(data);
                },
                //请求出错的处理
                error: function () {
                    alert("请求出错");
                }
            });
        })


        function showList(d) {
            alert("进入显示阶段");
            var parent = $(".imgs_wrap_4_info");
            if (data.msg == "success"){
                var list = d.framelist;
                for (var i=0; i<list.length; i++){
                    parent.append('<li class="item_list_show"><div class="item_wrap_brief"> <img class="item_img_4_info" src="' +
                        list.framePhoto +
                        '"/><div class="item_info_price">¥' +
                        list.framePrice +
                        '</div></div><div class="item_panel" style="display: none"><img class="item_img_4_info" src="' +
                        list.framePhoto +
                        '"/><div class="item_info_price">¥' +
                        list.framePrice +
                        '</div><div class="item_info_brief">' +
                        list.material +
                        '</div><div class="display_inline"><div class="btn btn_primary btn-xs btn_collect"><span class="glyphicon glyphicon-heart-empty"></span>收藏</div>' +
                        '<div class="btn btn_primary btn-xs btn_uncollect"><span class="glyphicon glyphicon-heart"></span>取消</div>' +
                        '<div class="btn btn_primary btn-xs" id="btnBuy" onclick="toBuy()"><span class="glyphicon glyphicon-shopping-cart"></span>购买</div></div></div></li>');
                }
            } else if (data.msg == "no_result"){
                parent.html("无查找结果");
            }
        }


    });

</script>

</html>
