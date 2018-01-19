<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="header.jsp" %>
<div class="index_banner">
    <div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img src="images/lb_07.jpg" alt=""></div>
            <div class="swiper-slide"><img src="images/lb_04.jpg" alt=""></div>
            <div class="swiper-slide"><img src="images/lb_05.jpg" alt=""></div>
            <div class="swiper-slide"><img src="images/lb_06.jpg" alt=""></div>
        </div>
        <div class="swiper-pagination"></div>
    </div>
    <!-- Initialize Swiper -->
    <script>
        var swiper = new Swiper('.swiper-container', {
            pagination: '.swiper-pagination',
            nextButton: '.swiper-button-next',
            prevButton: '.swiper-button-prev',
            paginationClickable: true,
            spaceBetween: 30,
            centeredSlides: true,
            autoplay: 6000,
            autoplayDisableOnInteraction: false
        });
    </script>
</div>


<div class="index_2">
    <div class="p1">
        <div class="i_2_title">新闻</div>
		<c:forEach var="news" items="${newsList}" varStatus="status" begin="0" end="7">
		
        <a class="item" href="http://localhost:8080/GroupOrg/News?method=queryNewsByTitles&id=${news.nId}" target="_blank" >
            <h3>${news.nTitle }</h3><span><fmt:formatDate value="${news.nTime}" pattern="yyyy-MM-dd"/></span>
        </a>
        </c:forEach>
    </div>
    <div class="p2">
        <div class="i_2_title m_b_1">招聘</div>
        <a class="item" href="#" target="_blank">助理</a>
        <a class="item" href="#" target="_blank">总监</a>
        <a class="item" href="#" target="_blank">经理</a>
        <a class="item" href="#" target="_blank">区域总经理</a>
        <a class="item" href="#" target="_blank">副总经理</a>
        <a class="item" href="#" target="_blank">出纳员</a>
        <a class="item" href="#" target="_blank">副总经理</a>
        <a class="item" href="#" target="_blank">项目经理</a>
    </div>
    <div class="p3">
        <div class="i_2_title">TV</div>
        <!--<div class="video" id="video"></div>-->
        <div id="video" class="video"  style="width: 350px; height: 197px;"></div>       
        <script type="text/javascript" src="ckplayer/ckplayer.js"></script>
        <style type="text/css">body{margin:0;padding:0px;font-family:"Microsoft YaHei",YaHei,"微软雅黑",SimHei,"黑体";font-size:14px}</style>
        <script type="text/javascript">
            var videoObject = {
                container: '#video', //容器的ID或className
                variable: 'player',//播放函数名称
                flashplayer:true,
                poster:'images/gnc_sh.jpg',//封面图片                                                                                                                                                                                                                                                                                                                                  
                video: [//视频地址列表形式
                    ['http://localhost:8080/GroupOrg/video/gnc_01.mp4', 'video/mp4', '中文标清', 0],
                    ['http://img.ksbbs.com/asset/Mon_1703/d0897b4e9ddd9a5.mp4', 'video/mp4', '中文高清', 0],
                    ['http://img.ksbbs.com/asset/Mon_1703/eb048d7839442d0.mp4', 'video/mp4', '英文高清', 10],
                    ['http://img.ksbbs.com/asset/Mon_1703/d30e02a5626c066.mp4', 'video/mp4', '英文超清', 0],
                ]
            };
            var player = new ckplayer(videoObject);
        </script>  
    </div>
</div>
<div class="index_3">
    <a class="item" href="#" target="_blank"><img src="images/map_img_04.png" width="400" height="130" /></a>
    <a class="item" href="#" target="_blank"><img src="images/map_img_02.png" width="400" height="130" /></a>
    <a class="item" href="#" target="_blank"><img src="images/map_img_01.png" width="400" height="130" /></a>
</div>
<div class="index_4">
    <div class="w">
        <div class="item">集团产业：</div>
        <a class="item" href="#" target="_blank"><img src="" width="32" height="32" />GNC</a>
        <a class="item" href="#" target="_blank"><img src="" width="32" height="32" />酒业</a>
        <a class="item" href="#" target="_blank"><img src="" width="32" height="32" />大健康</a>
        <a class="item" href="#1" target="_blank"><img src="#" width="32" height="32" />软件技术</a>
        <a class="item" href="#" target="_blank"><img src="" width="32" height="32" />教育行业</a>
        <a class="item" href="#" target="_blank"><img src="" width="32" height="32" />驾校联盟</a>
    </div>
</div>


<div class="floatdiv" id="ui_floatdiv">
    <div class="item" data="adds"><i class="icon iconfont icon-dizhi"></i>
        <div class="div adds" id="ui_adds" style="display: none;">贵州省贵阳市观山湖区诚信南路</div>
    </div>
    <div class="item" data="tel"><i class="icon iconfont icon-dianhua"></i>
        <div class="div tel" id="ui_tel" style="display: none;">0851-85956565</div>
    </div>
    <div class="item" data="qr"><i class="icon iconfont icon-weixin"></i>
        <div class="div qr" id="ui_qr" style="display: none;"><img src="images/map_img_01.png"></div>
    </div>
</div>
<script>
    $(function(){
        $("#ui_floatdiv .item").hover(function(){
            var id = $(this).attr("data");
            $("#ui_"+id).show();
        },function(){
            var id = $(this).attr("data");
            $("#ui_"+id).hide();
        });
    });
</script>
<%@include file="footer.jsp"%>

