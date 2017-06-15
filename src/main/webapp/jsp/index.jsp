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
<jsp:include page="header.jsp" flush="true" ></jsp:include>

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
        <h4 class="text_center">男式热销</h4>
        <hr class="my_hr"></div>
    <div id="manBestSeller" class="imgs_wrap_4">
        <a href="single_item?frameId=${man[0].frameId}"><img class="item_img_4" src="${man[0].framePhoto}"/></a>
        <a href="single_item?frameId=${man[1].frameId}"><img class="item_img_4" src="${man[1].framePhoto}"/></a>
        <a href="single_item?frameId=${man[2].frameId}"><img class="item_img_4" src="${man[2].framePhoto}"/></a>
        <a href="single_item?frameId=${man[3].frameId}"><img class="item_img_4" src="${man[3].framePhoto}"/></a>
        <a href="single_item?frameId=${man[4].frameId}"><img class="item_img_4" src="${man[4].framePhoto}"/></a>
        <a href="single_item?frameId=${man[5].frameId}"><img class="item_img_4" src="${man[5].framePhoto}"/></a>
        <a href="single_item?frameId=${man[6].frameId}"><img class="item_img_4" src="${man[6].framePhoto}"/></a>
        <a href="single_item?frameId=${man[7].frameId}"><img class="item_img_4" src="${man[7].framePhoto}"/></a>
    </div>
</div>
</div>


<div class="offset_80">
    <div><hr class="my_hr">
        <h4 class="text_center">女式热销</h4>
        <hr class="my_hr"></div>

    <div id="womanBestSeller" class="imgs_wrap_4">
        <a href="single_item?frameId=${woman[0].frameId}"><img class="item_img_4" src="${woman[0].framePhoto}"/></a>
        <a href="single_item?frameId=${woman[1].frameId}"><img class="item_img_4" src="${woman[1].framePhoto}"/></a>
        <a href="single_item?frameId=${woman[2].frameId}"><img class="item_img_4" src="${woman[2].framePhoto}"/></a>
        <a href="single_item?frameId=${woman[3].frameId}"><img class="item_img_4" src="${woman[3].framePhoto}"/></a>
        <a href="single_item?frameId=${woman[4].frameId}"><img class="item_img_4" src="${woman[4].framePhoto}"/></a>
        <a href="single_item?frameId=${woman[5].frameId}"><img class="item_img_4" src="${woman[5].framePhoto}"/></a>
        <a href="single_item?frameId=${woman[6].frameId}"><img class="item_img_4" src="${woman[6].framePhoto}"/></a>
        <a href="single_item?frameId=${woman[7].frameId}"><img class="item_img_4" src="${woman[7].framePhoto}"/></a>
    </div>
</div>
</div>

<div class="offset_80">
    <div><hr class="my_hr">
        <h4 class="text_center">墨镜热销</h4>
        <hr class="my_hr"></div>

    <div id="sunBestSeller" class="imgs_wrap_4">
        <a href="single_item?frameId=${sun[0].frameId}"><img class="item_img_4" src="${sun[0].framePhoto}"/></a>
        <a href="single_item?frameId=${sun[1].frameId}"><img class="item_img_4" src="${sun[1].framePhoto}"/></a>
        <a href="single_item?frameId=${sun[2].frameId}"><img class="item_img_4" src="${sun[2].framePhoto}"/></a>
        <a href="single_item?frameId=${sun[3].frameId}"><img class="item_img_4" src="${sun[3].framePhoto}"/></a>
        <a href="single_item?frameId=${sun[4].frameId}"><img class="item_img_4" src="${sun[4].framePhoto}"/></a>
        <a href="single_item?frameId=${sun[5].frameId}"><img class="item_img_4" src="${sun[5].framePhoto}"/></a>
        <a href="single_item?frameId=${sun[6].frameId}"><img class="item_img_4" src="${sun[6].framePhoto}"/></a>
        <a href="single_item?frameId=${sun[7].frameId}"><img class="item_img_4" src="${sun[0].framePhoto}"/></a>

    </div>
</div>
</div>

<!-- Page Footer -->
    <jsp:include page="footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
    if (${not empty param.msg}){
        alert("${param.msg}");
    }
</script>

</html>