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

<body onload="firstLoad()">
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
                    <div class="style_selector" id="styleSelector">
                        <div class="checkbox_group">
                            <div class="checkbox_group_row">
                                <div class="checkbox_group_label text_center">款式</div>
                                <div class="checkbox_group_options" id="panel_user_type">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="man" value="男式">男式
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="woman" value="女式">女式
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="child" value="儿童">儿童
                                    </label>
                                </div>
                            </div>
                            <div class="checkbox_group_row">
                                <div class="checkbox_group_label text_center">功能</div>
                                <div class="checkbox_group_options" id="panel_glasses_type">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="nearsighted" value="近视眼镜">近视眼镜
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="sun" value="太阳眼镜">太阳眼镜
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="farsighted" value="老花眼镜">老花眼镜
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="sports" value="运动眼镜">运动眼镜
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="radiation" value="防辐射眼镜">防辐射眼镜
                                    </label>
                                </div>
                            </div>
                            <div class="checkbox_group_row">
                                <div class="checkbox_group_label text_center">框型</div>
                                <div class="checkbox_group_options">
                                    <label class="checkbox-inline" id="panel_form">
                                        <input type="checkbox" id="full" value="全框">全框
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="half" value="半框">半框
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="none" value="无框">无框
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="square" value="方框">方框
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="circle" value="圆框">圆框
                                    </label>
                                </div>
                            </div>
                            <div class="checkbox_group_row">
                                <div class="checkbox_group_label text_center">材质</div>
                                <div class="checkbox_group_options" id="panel_material">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="bancai" value="板材">板材
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="jinshu" value="金属">金属
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="sugang" value="塑钢">塑钢
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="trtaisu" value="TR钛塑">TR钛塑
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="tanqianwei" value="碳纤维">碳纤维
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="chuntai" value="纯钛">纯钛
                                    </label>
                                </div>
                            </div>
                            <div class="checkbox_group_row">
                                <div class="checkbox_group_label text_center">风格</div>
                                <div class="checkbox_group_options" id="panel_style">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="business" value="商务">商务
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="casual" value="休闲">休闲
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="fashion" value="潮款">潮款
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="retro" value="复古">复古
                                    </label>
                                </div>
                            </div>
                            <div class="checkbox_group_row">
                                <div class="checkbox_group_label text_center">颜色</div>
                                <div class="checkbox_group_options" id="panel_color">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="blackorwhite" value="黑白">黑白
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="blue" value="蓝色">蓝色
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="red" value="红色">红色
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="yellow" value="黄色">黄色
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="brown" value="咖啡">咖啡
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="silver" value="银色">银色
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="pattern" value="花纹">花纹
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="other" value="其他">其他
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="align_right">
                            <button class="btn btn_submit" id="btnPanelSubmit">确认</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="offset_80">
        <ul class="imgs_wrap_4_info">
            <li class="item_list_show" data-frameId="">
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

    //第一次加载本页面时，获取后台从mv传来的list
    function firstLoad() {
        alert("<%=request.getContextPath()%>/jsp/search/firstLoad");
        var key = "${param.key}";
        var value = "${param.value}";
        var keyWord = "${param.keyWord}";
        $.ajax({
            type: "post",//请求方式
            url: "<%=request.getContextPath()%>/jsp/search/firstLoad",
            data:{
                key:key,
                value:value,
                keyWord:keyWord
            },
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

    function showList(d) {
        alert("进入显示阶段");
        var parent = $(".imgs_wrap_4_info");
        parent.html("");
        if (d.msg == "success"){
            var list = d.framelist;
            alert(d);
            alert(list);
            for (var i=0; i<list.length; i++){
                parent.append('<li class="item_list_show" data-frameid="' +
                    list[i].frameId +
                    '"><div class="item_wrap_brief"> <img class="item_img_4_info" src="' +
                    list[i].framePhoto +
                    '"/><div class="item_info_price">¥' +
                    list[i].framePrice +
                    '</div></div><div class="item_panel" style="display: none"><img class="item_img_4_info" src="' +
                    list[i].framePhoto +
                    '"/><div class="item_info_price">¥' +
                    list[i].framePrice +
                    '</div><div class="item_info_brief">材料：' +
                    list[i].material +
                    '</div><div class="display_inline"><div class="btn btn_primary btn-xs btn_collect"><span class="glyphicon glyphicon-heart-empty"></span>收藏</div>' +
                    '<div class="btn btn_primary btn-xs btn_uncollect"><span class="glyphicon glyphicon-heart"></span>取消</div>' +
                    '<div class="btn btn_primary btn-xs" id="btnBuy" onclick="toBuy()"><span class="glyphicon glyphicon-shopping-cart"></span>购买</div></div></div></li>');
            }
        } else if (d.msg == "no_result"){
            parent.html("无查找结果");
        }

        //给新添加的元素绑定事件监听函数

        $(".item_list_show").hover(function(){
            $(this).children('div.item_wrap_brief').toggle();
            $(this).children('div.item_panel').toggle();
        });

        $(".item_img_4_info").click(function(){
            var frameId = $(this).parent().parent().data("frameid");
            alert(frameId);
            window.location.href = "single_item.jsp?frameId=" + frameId;
        });


        //收藏
        $(".btn_collect").click(function(){
            var currentBtn = $(this);
            var frameId = $(this).parent().parent().parent().data("frameid");
            alert("frameId:" + frameId);
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
            var frameId = $(this).parent().parent().parent().data("frameId");
            alert("frameId:" + frameId);
            $.ajax({
                type: "post",//请求方式
                url: "user/uncollect",
                timeout: 80000,//超时时间：8秒
                dataType: "json",//设置返回数据的格式
                data: {
                    "frameId": frameId
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
    }



    $(document).ready(function(){
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
                        user_type += (":" + $(this).val());break;
                    case ("panel_glasses_type"):
                        glasses_type += (":" + $(this).val());break;
                    case ("panel_color"):
                        color += (":" + $(this).val());break;
                    case ("panel_style"):
                        style += (":" + $(this).val());break;
                    case ("panel_form"):
                        form += (":" + $(this).val());break;
                    case ("panel_material"):
                        material += (":" + $(this).val());break;
                    default:
                        alert("选择面板出错");
                }
            });
            alert("usertype=" + user_type + "\nglassestype=" + glasses_type + "\nstyle=" + style + "\ncolor=" + color + "\nform=" + form + '\nmaterial=' + material);
            $.ajax({
                type: "post",//请求方式
                url: "<%=request.getContextPath()%>/jsp/search/panelOptions",
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

    });

</script>

</html>
