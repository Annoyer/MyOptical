<%--
  Created by IntelliJ IDEA.
  User: joy12
  Date: 2017/5/28
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!--移动设备自适应-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>主页</title>
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
                <form id="searchBarForm" class="display_inlineblock">
                    <input type="search" id="searchBar" class="search_bar" placeholder="搜索">
                </form>
                <button class="btn_primary btn-sm display_inlineblock" id="btnSearchSubmit">搜索</button>
            </div>
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
                <ul class="nav navbar-nav">
                    <li><a href="index.jsp">首页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            功能
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu naver_searchkey" data-v="glassesType">
                            <li class="naver_searchvalue" data-v="nearsight">近视眼镜</li>
                            <li class="naver_searchvalue" data-v="sun">太阳眼镜</li>
                            <li class="naver_searchvalue" data-v="farsight">老花眼镜</li>
                            <li class="naver_searchvalue" data-v="sports">运动眼镜</li>
                            <li class="naver_searchvalue" data-v="radiation">防辐射眼镜</li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            款式
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu naver_searchkey" data-v="userType">
                            <li class="naver_searchvalue" data-v="man">男式</li>
                            <li class="naver_searchvalue" data-v="woman">女式</li>
                            <li class="naver_searchvalue" data-v="child">儿童</li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            框形
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu naver_searchkey" data-v="form">
                            <li class="naver_searchvalue" data-v="full">全框</li>
                            <li class="naver_searchvalue" data-v="half">半框</li>
                            <li class="naver_searchvalue" data-v="none">无框</li>
                            <li class="naver_searchvalue" data-v="square">方框</li>
                            <li class="naver_searchvalue" data-v="circle">圆框</li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            材质
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu naver_searchkey" data-v="material">
                            <li class="naver_searchvalue" data-v="bancai">板材</li>
                            <li class="naver_searchvalue" data-v="jinshu">金属</li>
                            <li class="naver_searchvalue" data-v="sugang">塑钢</li>
                            <li class="naver_searchvalue" data-v="trtaisu">TR钛塑</li>
                            <li class="naver_searchvalue" data-v="tanqianwei">碳纤维</li>
                            <li class="naver_searchvalue" data-v="chuntai">纯钛</li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            风格
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu naver_searchkey" data-v="style">
                            <li class="naver_searchvalue" data-v="business">商务</li>
                            <li class="naver_searchvalue" data-v="casual">休闲</li>
                            <li class="naver_searchvalue" data-v="fashion">潮款</li>
                            <li class="naver_searchvalue" data-v="retro">复古</li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            颜色
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu naver_searchkey" data-v="color">
                            <li class="naver_searchvalue" data-v="bw">黑白</li>
                            <li class="naver_searchvalue" data-v="blue">蓝色</li>
                            <li class="naver_searchvalue" data-v="red">红色</li>
                            <li class="naver_searchvalue" data-v="yellow">黄色</li>
                            <li class="naver_searchvalue" data-v="brown">咖啡</li>
                            <li class="naver_searchvalue" data-v="silver">银色</li>
                            <li class="naver_searchvalue" data-v="pattern">花纹</li>
                            <li class="naver_searchvalue" data-v="other">其他</li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</header>
</body>

<script type="text/javascript">
    $(document).ready(function(){
        //根据关键字搜索，在图片上设置跳转到单个页面的带参数超链接
        $("#btnSearchSubmit").click(function () {
            var keyWord = $("#searchBar").val();
            alert("searchKey=" + keyWord);
            if (keyWord != ""){
                window.location.href = "search_items.jsp?keyWord=" + keyWord;
            }else{
                alert("请先输入关键词");
            }

        })

        $(".naver_searchvalue").click(function () {
            var key = $(this).parent().data("v");
            var value = $(this).html();
            alert("k:" + key + "  v:" + value);
            window.location.href = "search_items.jsp?key=" + key +"&value=" + value;
//            $.ajax({
//                type: "post",//请求方式
//                url: "search/naverbarAction",
//                timeout: 80000,//超时时间：8秒
//                data: {
//                    "key": key,
//                    "value": value
//                },
//                //请求成功后的回调函数 data为json格式
//                success: function () {
//                },
//                //请求出错的处理
//                error: function () {
//                    alert("请求出错");
//                }
//            })

        })

    });
</script>
</html>
