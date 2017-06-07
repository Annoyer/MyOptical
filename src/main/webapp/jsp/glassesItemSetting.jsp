<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 86761
  Date: 2017/6/6
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!--移动设备自适应-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>眼镜设置</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <img src="" class="logo_img"/>
            </div>
            <div class="col-md-4 col-md-push-4">
                <form id="search">
                    <input type="search" id="searchBar" class="search_bar" placeholder="搜索">
                </form>
            </div>
            <div class="col-md-2 col-md-push-4">
                <button id="user" class="btn btn-link"></button>
                <button id="shopping" class="btn btn-link"></button>
            </div>
        </div>
    </div>
    <div class="my_navbar">
        <nav class="navbar" role="navigation" style="margin-bottom: 0px; border:none;">
            <div class="container-fluid">
                <div>
                    <ul class="nav navbar-nav">
                        <li><a href="#">首页</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                功能
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">近视眼镜</a></li>
                                <li><a href="#">太阳眼镜</a></li>
                                <li><a href="#">老花眼镜</a></li>
                                <li><a href="#">运动眼镜</a></li>
                                <li><a href="#">防辐射眼镜</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                款式
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">男式</a></li>
                                <li><a href="#">女式</a></li>
                                <li><a href="#">儿童</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                框形
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">全框</a></li>
                                <li><a href="#">半框</a></li>
                                <li><a href="#">无框</a></li>
                                <li><a href="#">方框</a></li>
                                <li><a href="#">圆框</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                材质
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">板材</a></li>
                                <li><a href="#">金属</a></li>
                                <li><a href="#">塑钢</a></li>
                                <li><a href="#">TR钛塑</a></li>
                                <li><a href="#">碳纤维</a></li>
                                <li><a href="#">纯钛</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                风格
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">商务</a></li>
                                <li><a href="#">休闲</a></li>
                                <li><a href="#">潮款</a></li>
                                <li><a href="#">复古</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                颜色
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">黑白</a></li>
                                <li><a href="#">蓝色</a></li>
                                <li><a href="#">红色</a></li>
                                <li><a href="#">黄色</a></li>
                                <li><a href="#">咖啡</a></li>
                                <li><a href="#">银色</a></li>
                                <li><a href="#">花纹</a></li>
                                <li><a href="#">其他</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>

<div class="offset_60">
    <div class="page_content">
        <div class="text_title" id="itemName">订单确认</div>

        <div class="offset_80">
            <div class="text_title_xs_normal">镜框选择</div>
            <hr class="my_hr_long"/>
            <div class="offset_60">
                <div class="item_img_wrapper_sm background_100 display_inlineblock display_verticalalign_top" id="itemImgsm" style="background: url(${frame.framePhoto}) no-repeat; background-size:100% 100%;">
                </div>
                <div class="display_inlineblock display_verticalalign_top margin_left_right_40">
                    <div class="text_title margin_left_right_40">${frame.frameName}</div>
                    <div class="offset_80">
                        <h4 id="framePrice">价格：￥ ${frame.framePrice}</h4>
                    </div>
                </div>
            </div>
        </div>

        <div class="offset_80">
            <div class="offset_bottom_-10">
                <div class="text_title_xs_normal display_inlineblock">镜片选择</div>
                <label class="display_inlineblock text_title_xxs_normal margin_left_right_30"><input type="checkbox"> 只要镜框</label>
                <button id="btnSaveSetting" class="btn btn_rectangle btn_primary btn-sm" style="float: right; margin-right: 10px;"><span class="glyphicon glyphicon-floppy-disk"></span> 保存设置</button>
            </div>
            <hr class="my_hr_long"/>
            <div class="offset_40">
                <table class="table_lense_setting">
                    <tr>
                        <td></td>
                        <td>度数（SPH）</td>
                        <td>散光（CYL）</td>
                        <td>轴位（Axis）</td>
                        <td>瞳距（PD）</td>
                    </tr>
                    <tr>
                        <td>左眼（L）</td>
                        <td>
                            <div class="form-group">
                                <select id="sphL"class="form-control input-sm">
                                    <c:forEach var="i" begin="0" end="128">
                                        <option><c:out value="${i*0.25-20}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                        <td>
                            <div class="form-group">
                                <select id="cylL"class="form-control input-sm">
                                    <c:forEach var="i" begin="0" end="80">
                                        <option><c:out value="${i*0.25-6}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                        <td>
                            <div class="form-group">
                                <select id="axisL"class="form-control input-sm">
                                    <c:forEach var="i" begin="0" end="180">
                                        <option><c:out value="${i}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                        <td>
                            <div class="form-group">
                                <select id="pd"class="form-control input-sm">
                                    <c:forEach var="i" begin="0" end="44">
                                        <option><c:out value="${i+35}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>右眼（R）</td>
                        <td>
                            <div class="form-group">
                                <select id="sphR"class="form-control input-sm">
                                    <c:forEach var="i" begin="0" end="128">
                                        <option><c:out value="${i*0.25-20}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                        <td>
                            <div class="form-group">
                                <select id="cylR"class="form-control input-sm">
                                    <c:forEach var="i" begin="0" end="80">
                                        <option><c:out value="${i*0.25-6}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                        <td>
                            <div class="form-group">
                                <select id="axisR" class="form-control input-sm">
                                    <c:forEach var="i" begin="0" end="180">
                                    <option><c:out value="${i}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <form>
                            <td><input type="radio" name="material" value="commLense" /> 普通镜片</td>
                            <td><input type="radio" name="material" value="resinLense" /> 树脂镜片</td>
                            <td><input type="radio" name="material" value="antiBlueLense" /> 防蓝光镜片</td>
                        </form>
                    </tr>
                    <tr>
                        <td>镜片颜色</td>
                        <td>
                            <div class="form-group">
                                <select id="lensColor"class="form-control input-sm">
                                    <option>透明</option>
                                    <option>20%棕色</option>
                                    <option>20%蓝色</option>
                                    <option>20%粉色</option>
                                </select>
                            </div>
                        </td>
                    </tr>

                </table>
                <div class="width_90 display_right">
                    <h4 id="lensPrice">价格：￥ 00.00</h4>
                </div>
            </div>
        </div>

        <div class="offset_80">
            <div class="offset_bottom_-10">
                <div class="text_title_xs_normal display_inlineblock">个性定制</div>
            </div>
            <hr class="my_hr_long"/>
            <div class="offset_40">
                <table class="table_personalize_setting">
                    <tr>
                        <td class="col-md-2">镜脚刻字</td>
                        <td class="col-md-2">左侧（L）</td>
                        <td class="col-md-6"><input type="text" class="form-control" placeholder="左侧镜脚刻字"></td>
                    </tr>
                    <tr>
                        <td class="col-md-2"></td>
                        <td class="col-md-2">右侧（R）</td>
                        <td class="col-md-6"><input type="text" class="form-control" placeholder="右侧镜脚刻字"></td>
                    </tr>
                    <tr>
                        <td>偏光夹</td>
                        <td>
                            <div class="form-group">
                                <select id="polarizer" class="form-control input-sm">
                                    <option>0</option>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>梯度夹</td>
                        <td>
                            <div class="form-group">
                                <select id="gradientClamp" class="form-control input-sm">
                                    <option>0</option>
                                </select>
                            </div>
                        </td>
                    </tr>
                </table>
                <div class="width_90 display_right">
                    <h4 id="additionalPrice">价格：￥ 00.00</h4>
                </div>
            </div>
        </div>

        <div class="offset_80">
            <hr class="my_hr_long"/>
            <div class="offset_40">
                <div class="width_90 display_center">
                    <h3>总价：￥ ${frame.framePrice}</h3>
                    <button class="offset_40 btn btn-lg btn_primary btn_padding_lg" onclick="settingFunc();return false">加入购物车</button>
                </div>
            </div>
        </div>
    </div>
</div>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <img src="" class="logo_img"/>
            </div>
            <div class="col-md-3 footer_item">
                <div class="item_title">关于我们</div>
                <div class="item_content">联系电话：800-125-125</div>
            </div>
            <div class="col-md-3 footer_item">
                <div class="item_title">配送服务</div>
                <div class="item_content">XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</div>
            </div>
            <div class="col-md-3 footer_item">
                <div class="item_title">售后服务</div>
                <div class="item_content">XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</div>
            </div>
        </div>
    </div>

</footer>

<script type="text/javascript">
    function settingFunc() {
        var lSph = $("#sphL").val();
        alert(lSph);
        var lCyl =$("#cylL").val();
        var lAxis=$("#axisL").val();
        var pd=$("#pd").val();
        var rSph=$("#sphR").val();
        var rCyl=$("#cylR").val();
        var rAxis=$("#axisR").val();
        var lensMaterial=$('input[name="material"]:checked').val();
        var frameID="${frame.frameId}";
        alert(lensMaterial);
        var lensColor=$("#lensColor").val();
        var glassesPrice="${frame.framePrice}";
        $.ajax({
            type: "post",//请求方式
            url: "glassesItem/Setting",
            timeout: 80000,//超时时间：8秒
            dataType: "json",//设置返回数据的格式
            data: {
                "frameId":frameID,
                "lSph": lSph,
                "lCyl":lCyl,
                "lAxis":lAxis,
                "pd":pd,
                "rSph":rSph,
                "rCyl":rCyl,
                "rAxis":rAxis,
                "lensMaterial":lensMaterial,
                "lensColor":lensColor,
                "glassesPrice":glassesPrice
            },
            //请求成功后的回调函数 data为json格式
            success: function (data) {
                if(data.returnCode=="1")
                    alert("添加成功！");
                else
                    alert("添加失败!");
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
