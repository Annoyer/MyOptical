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

<!-- Page Header -->
<jsp:include page="header.jsp"></jsp:include>

<div class="offset_60">
    <div class="page_content">
        <div class="text_title" id="itemName">眼镜设置</div>

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

                <button id="btnSaveSetting" class="btn btn_rectangle btn_primary btn-sm" style="float: right; margin-right: 10px;"  onclick="saveFunc(this)" value=""><span class="glyphicon glyphicon-floppy-disk"></span> 保存设置</button>
                <div class="form-group" style="width: 100px;float: right; margin-right: 10px;margin-top: 10px">
                    <select  id="presSelect" class="form-control input-sm" onchange="selectedFunc()">
                        <option>（我的处方）</option>
                            <c:forEach items="${list}" var="pres" step="1" varStatus="status">
                        <option>${pres.presName}</option>
                        </c:forEach>
                    </select>
                </div>
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
                            <td><input type="radio" name="material" value="普通"  onclick="lensFunc(this)"/> 普通镜片</td>
                            <td><input type="radio" name="material"  value="树脂" onclick="lensFunc(this)"/> 树脂镜片</td>
                            <td><input type="radio" name="material" value="防蓝光"  onclick="lensFunc(this)"/> 防蓝光镜片</td>
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
                    <h4 style="display: inline;" >价格：￥</h4><h4 style="display: inline;" id="lensPrice">20.00</h4>
                </div>
            </div>
        </div>

        <div class="offset_80">
            <div class="offset_bottom_-10">
                <div class="text_title_xs_normal display_inlineblock">个性定制</div>
                <label class="display_inlineblock text_title_xxs_normal margin_left_right_30"><input id="addCheck" type="checkbox"> 不需要定制</label>
            </div>
            <hr class="my_hr_long"/>
            <div class="offset_40">
                <table class="table_personalize_setting">
                    <tr>
                        <td class="col-md-2">镜脚刻字</td>
                        <td class="col-md-2">左侧（L）</td>
                        <td class="col-md-6"><input id="leftText" type="text" class="form-control" placeholder="左侧镜脚刻字"></td>
                    </tr>
                    <tr>
                        <td class="col-md-2"></td>
                        <td class="col-md-2">右侧（R）</td>
                        <td class="col-md-6"><input id="rightText" type="text" class="form-control" placeholder="右侧镜脚刻字"></td>
                    </tr>

                </table>
                <div class="width_90 display_right">
                    <h4 style="display: inline;">价格：￥ </h4><h4 style="display: inline;" id="additionalPrice">20.00</h4>
                </div>
            </div>
        </div>

        <div class="offset_80">
            <hr class="my_hr_long"/>
            <div class="offset_40">
                <div class="width_90 display_center">
                    <h3 style="display: inline;">总价：￥ </h3><h3  style="display: inline;" id="totalPrice">${frame.framePrice}</h3>
                    <div class="width_90 display_center">
                   <button class="offset_40 btn btn-lg btn_primary btn_padding_lg" style="display: block" onclick="settingFunc();return false">加入购物车</button>
                    </div>
                    </div>
            </div>
        </div>
    </div>
</div>

<!-- Page Footer -->
<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">





    function saveFunc(btn) {

       // alert("save!");
        var presName=prompt("请输入处方持有人：");
//        var lSph = $("#sphL").val();
//        var lCyl =$("#cylL").val();
//        var lAxis=$("#axisL").val();
//        var pd=$("#pd").val();
//        var rSph=$("#sphR").val();
//        var rCyl=$("#cylR").val();
//        var rAxis=$("#axisR").val();


        btn.value=presName;
        alert("保存成功！");
//        $.ajax({
//            type: "post",//请求方式
//            url: "save/prescription",
//            timeout: 80000,//超时时间：8秒
//            dataType: "json",//设置返回数据的格式
//            data: {
//                "presName":presName,
//                "lSph": lSph,
//                "lCyl":lCyl,
//                "lAxis":lAxis,
//                "pd":pd,
//                "rSph":rSph,
//                "rCyl":rCyl,
//                "rAxis":rAxis,
//
//            },
//            success: function (data) {
//                if(data.returnCode=="1"){
//                    alert("添加成功！");
//                }
//                if(data.returnCode=="0"){
//                    alert("请先登录！");
//                    window.location.href="login";
//                }
//            },
//            //请求出错的处理
//            error: function () {
//                alert("请求出错");
//            }
//        });
    }

    function settingFunc() {
        var lSph = $("#sphL").val();
      //  alert(lSph);
        var lCyl =$("#cylL").val();
        var lAxis=$("#axisL").val();
        var pd=$("#pd").val();
        var rSph=$("#sphR").val();
        var rCyl=$("#cylR").val();
        var rAxis=$("#axisR").val();
        var lensMaterial=$('input[name="material"]:checked').val();
        var frameID="${frame.frameId}";
       // alert(lensMaterial);
        var lensColor=$("#lensColor").val();
        var glassesPrice=document.getElementById("totalPrice").innerHTML;
       // alert(glassesPrice);

        var leftText=$("#leftText").val();
        var rightText=$("#rightText").val();
        var presName=$("#btnSaveSetting").val();

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
                "glassesPrice":glassesPrice,
                "rightText":rightText,
                "leftText":leftText,
                "presName":presName
            },

            //请求成功后的回调函数 data为json格式
            success: function (data) {
                if(data.returnCode=="1"){
                    alert("添加成功！");
                    window.location.href ="cart";
                }
                else
                    alert("添加失败!");
            },
            //请求出错的处理
            error: function () {
                alert("请求出错");
            }
        });
    }

    function lensFunc(lens) {
        if(lens.value=="普通"){
            document.getElementById("lensPrice").innerHTML="20.00";
        }
        else if(lens.value=="树脂"){
            document.getElementById("lensPrice").innerHTML="40.00";
        }
        else if(lens.value=="防蓝光"){
            document.getElementById("lensPrice").innerHTML="80.00";
        }
        //alert(document.getElementById("lensPrice").value);
        var total=parseFloat(document.getElementById("totalPrice").innerHTML);
        total=total+parseFloat(document.getElementById("lensPrice").innerHTML);
        document.getElementById("lensPrice").innerHTML=document.getElementById("lensPrice").innerHTML;
        document.getElementById("totalPrice").innerHTML=total.toString();

    }

    $("#addCheck").click(function () {
           var total=parseFloat(document.getElementById("totalPrice").innerHTML);
       if(this.checked){
          // alert("noadd Checked!");
           document.getElementById("additionalPrice").innerHTML="0.00";
           total=total-20;
           document.getElementById("totalPrice").innerHTML=total.toString();
       }

       else {
         //  alert("no add unchecked!");
           document.getElementById("additionalPrice").innerHTML="20.00";
           total=total+20;
           document.getElementById("totalPrice").innerHTML=total.toString();
       }
       document.getElementById("totalPrice").innerHTML=total.toString();

    });

    function selectedFunc(){
        var sphl=document.getElementById("sphL").options;
        var sphr=document.getElementById("sphR").options;
        var cyll=document.getElementById("cylL").options;
        var cylr=document.getElementById("cylR").options;
        var axisl=document.getElementById("axisL").options;
        var axisr=document.getElementById("axisR").options;
        var pd=document.getElementById("pd").options;
        //alert("length="+myOptions.length);
        var vs = $('select  option:selected').val();
        var i=$('select  option:selected').index()-1;
        var x;
       // alert(vs);
        //alert(i);
        $.ajax({
            type: "post",//请求方式
            url: "get/prescription",
            timeout: 80000,//超时时间：8秒
            dataType: "json",//设置返回数据的格式
            data: {
                "presIndex":i
            },
            success: function (data) {
                if(data.returnCode=="1"){
                    //alert("hey！");

                    for(x=0;x<sphr.length;x++){
                        if(sphr[x].value==data.rSph){
                            sphr[x].selected=true;
                        }
                    }
                    for(x=0;x<sphl.length;x++){
                        if(sphl[x].value==data.lSph){
                            sphl[x].selected=true;
                        }
                    }
                    for(x=0;x<cyll.length;x++){
                        if(cyll[x].value==data.lCyl){
                            cyll[x].selected=true;
                        }
                    }
                    for(x=0;x<cylr.length;x++){
                        if(cylr[x].value==data.rCyl){
                            //alert("lAxis="+data.lAxis);
                            cylr[x].selected=true;
                        }
                    }
                    for(x=0;x<axisl.length;x++){
                        if(axisl[x].value==data.lAxis){
                            axisl[x].selected=true;
                        }
                    }
                    for(x=0;x<axisr.length;x++){
                        if(axisr[x].value==data.rAxis){
                            axisr[x].selected=true;
                        }
                    }
                    for(x=0;x<pd.length;x++){
                        if(pd[x].value==data.pd){
                            pd[x].selected=true;
                        }
                    }
                }
                if(data.returnCode=="0"){
                    alert("请先登录！");
                    window.location.href="login";
                }
            },
            //请求出错的处理
            error: function () {
                alert("不使用处方");
            }
        });

    }

</script>
</body>
</html>
