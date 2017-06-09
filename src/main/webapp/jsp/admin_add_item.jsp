<%--
  Created by IntelliJ IDEA.
  User: joy12
  Date: 2017/6/9
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!--移动设备自适应-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>上架</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body onload="firstLoad()">
<!-- Page Header -->
<jsp:include page="header.jsp" flush="true" ></jsp:include>

<div class="page_content">
    <div class="offset_80 text_center text_title">
        上架
    </div>
    <div class="offset_80 display_center">
        <div style="font-size: 16px; margin: 20px 0">商品名称</div>
        <input class="input_lg" type="text" id="itemName" name="itemName">
    </div>
    <div class="offset_80 display_center">
        <div style="font-size: 16px; margin: 20px 0">商品定价</div>
        <input class="input_lg" type="text" id="itemPrice" name="itemPrice">
    </div>
    <div class="offset_80 display_center">
        <div style="font-size: 16px; margin: 20px 0">商品尺寸</div>
        <div style="display:flex; justify-content: center; align-items: center;">
            <label style="font-size: 14px; font-weight: normal; padding: 5px">镜框宽度：</label>
            <input class="input_sm" type="text" id="lensWidth" name="lensWidth">
            <label style="font-size: 14px; font-weight: normal; padding: 5px">镜框高度：</label>
            <input class="input_sm" type="text" id="lensHeight" name="lensHeight">
            <label style="font-size: 14px; font-weight: normal; padding: 5px">鼻梁宽度：</label>
            <input class="input_sm" type="text" id="bridgeWidth" name="bridgeWidth">
            <label style="font-size: 14px; font-weight: normal; padding: 5px">镜脚长度：</label>
            <input class="input_sm" type="text" id="templeLength" name="templeLength">
        </div>
    </div>
    <div class="offset_80 display_center">
        <div style="font-size: 16px; margin: 30px 0">商品图片</div>
        <input type="file" id="itemImg" name="itemImg" accept="image/png,image/jpg,image/jpeg" style="margin-left: 40%">
    </div>
    <div class="offset_60">
        <div class="pane">
            <div class="panel-heading">
                <div style="font-size: 16px" class="panel-title text_center">商品属性</div>
            </div>
            <div class="panel-body">
                <div class="style_selector" id="styleSelector">
                    <div class="checkbox_group">
                        <div class="checkbox_group_row">
                            <div class="checkbox_group_label text_center">款式</div>
                            <div class="checkbox_group_options" id="panel_user_type">
                                <label class="radio-inline">
                                    <input type="radio" id="man" value="男款" name="user_type">男款
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="woman" value="女款" name="user_type">女款
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="both" value="通用款" name="user_type">通用款
                                </label>
                            </div>
                        </div>
                        <div class="checkbox_group_row">
                            <div class="checkbox_group_label text_center">功能</div>
                            <div class="checkbox_group_options" id="panel_glasses_type">
                                <label class="radio-inline">
                                    <input type="radio" id="normal" value="框架眼镜" name="glasses_type">框架眼镜
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="sun" value="太阳眼镜" name="glasses_type">太阳眼镜
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="radiation" value="防辐射眼镜" name="glasses_type">防辐射眼镜
                                </label>
                            </div>
                        </div>
                        <div class="checkbox_group_row">
                            <div class="checkbox_group_label text_center">框型</div>
                            <div class="checkbox_group_options" id="panel_form">
                                <label class="radio-inline">
                                    <input type="radio" id="full" value="全框" name="form">全框
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="half" value="半框" name="form">半框
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="none" value="无框" name="form">无框
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="square" value="方框" name="form">方框
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="circle" value="圆框" name="form">圆框
                                </label>
                            </div>
                        </div>
                        <div class="checkbox_group_row">
                            <div class="checkbox_group_label text_center">材质</div>
                            <div class="checkbox_group_options" id="panel_material">
                                <label class="radio-inline">
                                    <input type="radio" id="bancai" value="板材" name="material">板材
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="jinshu" value="金属" name="material">金属
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="tr" value="TR90" name="material">TR
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="chuntai" value="纯钛" name="material">纯钛
                                </label>
                            </div>
                        </div>
                        <div class="checkbox_group_row">
                            <div class="checkbox_group_label text_center">风格</div>
                            <div class="checkbox_group_options" id="panel_style">
                                <label class="radio-inline">
                                    <input type="radio" id="business" value="商务" name="style">商务
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="casual" value="休闲" name="style">休闲
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="sports" value="运动" name="style">运动
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="fashion" value="潮流" name="style">潮流
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="shishang" value="时尚" name="style">时尚
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="classic" value="经典">经典
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="retro" value="复古">复古
                                </label>
                            </div>
                        </div>
                        <div class="checkbox_group_row">
                            <div class="checkbox_group_label text_center">颜色</div>
                            <div class="checkbox_group_options" id="panel_color">
                                <label class="radio-inline">
                                    <input type="radio" id="black" value="黑色" name="color">黑色
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="gray" value="灰色" name="color">灰色
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="white" value="白色" name="color">白色
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="blue" value="蓝色" name="color">蓝色
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="green" value="绿色" name="color">绿色
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="red" value="红色" name="color">红色
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="yellow" value="黄色" name="color">黄色
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="brown" value="棕色" name="color">棕色
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="purple" value="紫色" name="color">紫色
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="golden" value="金色" name="color">金色
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="silver" value="银色" name="color">银色
                                </label>
                                <!--换行第一个-->
                                <label class="radio-inline">
                                    <input type="radio" id="pattern" value="花纹" name="color">花纹
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" id="other" value="混合色" name="color">其他
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="display_center" style="margin-bottom: 100px">
        <button class="btn btn_submit btn-lg" id="btnAddSubmit">确认</button>
    </div>

</div>
</div>

<!-- Page Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>

<script type="text/javascript">

    $(document).ready(function(){
        $("#btnAddSubmit").click( function () {
            alert("catch submit btn click");
            var name = $("#itemName").val();
            var price = $("#itemPrice").val();

            if (name == null || price == null){
                alert("商品名称和定价为必填信息！");
                return;
            }

            var photo = "" + $("#itemImg").val();

            var lensWidth = "" + $("#lensWidth").val();
            var lensHeight = "" + $("#lensHeight").val();
            var bridgeWidth = "" + $("#bridgeWidth").val();
            var templeLength = "" + $("#templeLength").val();
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
                        user_type += ($(this).val());break;
                    case ("panel_glasses_type"):
                        glasses_type += ($(this).val());break;
                    case ("panel_color"):
                        color += ($(this).val());break;
                    case ("panel_style"):
                        style += ($(this).val());break;
                    case ("panel_form"):
                        form += ($(this).val());break;
                    case ("panel_material"):
                        material += ($(this).val());break;
                    default:
                        alert("选择面板出错");
                }
            });
            $.ajax({
                type: "post",//请求方式
                url: "/jsp/admin/itemAdd",
                timeout: 80000,//超时时间：8秒
                dataType: "json",//设置返回数据的格式
                data: {
                    "frameName": name,
                    "framePrice": price,
                    "framePhoto": photo,
                    "lensWidth": lensWidth,
                    "lensHeight": lensHeight,
                    "bridgeWidth": bridgeWidth,
                    "templeLength": templeLength,
                    "userType": user_type,
                    "glassesType": glasses_type,
                    "color": color,
                    "style": style,
                    "material": material,
                    "form": form
                },
                //请求成功后的回调函数 data为json格式
                success: function (data) {
                    if (data.retcode == 0){
                        alert("上架成功");
                    }else{}
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

