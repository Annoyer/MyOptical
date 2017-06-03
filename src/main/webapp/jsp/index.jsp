<%--
  Created by IntelliJ IDEA.
  User: joy12
  Date: 2017/5/20
  Time: 13:38
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
<!-- Page Header -->
<jsp:include page="header.jsp"></jsp:include>

<!--广告轮转-->
<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="css/img/slide1.png" alt="First slide">
        </div>
        <div class="item">
            <img src="css/img/slide2.png" alt="Second slide">
        </div>
        <div class="item">
            <img src="css/img/slide3.png" alt="Third slide">
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="carousel-control left" href="#myCarousel"
       data-slide="prev">&lsaquo;
    </a>
    <a class="carousel-control right" href="#myCarousel"
       data-slide="next">&rsaquo;
    </a>
</div>

<div class="offset_80">
    <div><hr class="my_hr">
        <h4 class="text_center">热销商品</h4>
        <hr class="my_hr"></div>

    <div class="imgs_wrap_4">
        <img class="item_img_4" src="css/img/child.png"/>
        <img class="item_img_4" src="css/img/child.png"/>
        <img class="item_img_4" src="css/img/child.png"/>
        <img class="item_img_4" src="css/img/child.png"/>
        <img class="item_img_4" src="css/img/child.png"/>
        <img class="item_img_4" src="css/img/child.png"/>
        <img class="item_img_4" src="css/img/child.png"/>
        <img class="item_img_4" src="css/img/child.png"/>
    </div>
</div>
</div>

<div class="offset_80">
    <div><hr class="my_hr">
        <h4 class="text_center">男式新品</h4>
        <hr class="my_hr"></div>
    <div class="imgs_wrap_4">
        <img class="item_img_4" src="css/img/boy.png"/>
        <img class="item_img_4" src="css/img/boy.png"/>
        <img class="item_img_4" src="css/img/boy.png"/>
        <img class="item_img_4" src="css/img/boy.png"/>
        <img class="item_img_4" src="css/img/boy.png"/>
        <img class="item_img_4" src="css/img/boy.png"/>
        <img class="item_img_4" src="css/img/boy.png"/>
        <img class="item_img_4" src="css/img/boy.png"/>
    </div>
</div>
</div>


<div class="offset_80">
    <div><hr class="my_hr">
        <h4 class="text_center">女式新品</h4>
        <hr class="my_hr"></div>

    <div class="imgs_wrap_4">
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
    </div>
</div>
</div>

<div class="offset_80">
    <div><hr class="my_hr">
        <h4 class="text_center">墨镜新品</h4>
        <hr class="my_hr"></div>

    <div class="imgs_wrap_4">
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
        <img class="item_img_4" src="css/img/girl.png"/>
    </div>
</div>
</div>

<!-- Page Footer -->
    <jsp:include page="footer.jsp"></jsp:include>
</body>


</html>