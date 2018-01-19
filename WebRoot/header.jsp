<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>集团公司</title>
    <meta name="keywords" content="集团">
    <meta name="description" content="集团">
    
    <link rel="stylesheet" href="css/swiper.min.css" type="text/css">
    <link rel="stylesheet" href="css/iconfont.css" type="text/css">
    <link rel="stylesheet"  href="css/base.css" type="text/css">
    <link rel="stylesheet" href="css/newsEditor.css" type="text/css">
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/swiper.min.js"></script>

    <style type="text/css">
        img{
            width: 100%;
        }
        #other{
            height: 200px;
            margin-top: 20px;
        }
    </style>

    <style type="text/css">
        .icon {
            width: 1em; height: 1em;
            vertical-align: -0.15em;
            fill: currentColor;
            overflow: hidden;
        }
    </style>
	
	
  </head>
  <body>
  <div class="header">
    <div class="logo"><img src="images/logo_01.jpg" height="57" /></div>
    <div class="menu" id="ui_menu">
        <div class="item cur">
            <a class="a1" href="home.jsp">首页</a>
        </div>

        <div class="item ">
            <a class="a1" href="JinLanGroup.jsp">关于GNC</a>
            <div class="div">
                <a class="a2" href="JinLanGroup.jsp">集团介绍</a>
                <a class="a2" href="chairman.jsp">董事长</a>
                <a class="a2" href="enterpriseDevelopment.jsp">企业发展历程</a>
                <a class="a2" href="enterpriseCultuer.jsp">企业文化</a>
            </div>
        </div>

        <div class="item ">
            <a class="a1" href="http://localhost:8080/GroupOrg/NewsCenter?method=newsPageList">新闻中心</a>
            <div class="div">
                <a class="a2" href="news.jsp">集团要闻</a>
                <a class="a2" href="news.jsp">媒体报道</a>
                <a class="a2" href="news.jsp">精准扶贫</a>
                <a class="a2" href="news.jsp">TV</a>
            </div>
        </div>

        <div class="item ">
            <a class="a1" href="entityAndEcnonomic.jsp">互联网 · 金融 · 实体</a>
            <div class="div">
                <a class="a2" href="entityAndEcnonomic.jsp">商业模式</a>
                <a class="a2" href="entityAndEcnonomic.jsp">实体运营</a>
            </div>
        </div>

        <div class="item ">
            <a class="a1" href="teaminfo.jsp">团队风采</a>
            <div class="div">
                <a class="a2" href="teaminfo.jsp">运营部</a>
                <a class="a2" href="teaminfo.jsp">产品部</a>
                <a class="a2" href="teaminfo.jsp">市场部</a>
                <a class="a2" href="teaminfo.jsp">客服部</a>
                <a class="a2" href="teaminfo.jsp">人事部</a>
                <a class="a2" href="teaminfo.jsp">财务部</a>
            </div>
        </div>

        <div class="item ">
            <a class="a1" href="addGNC.jsp">加入GNC</a>
            <div class="div">
                <a class="a2" href="addGNC.jsp">代理</a>
                <a class="a2" href="addGNC.jsp">招聘</a>
            </div>
        </div>

        <div class="item ">
            <a class="a1" href="">联系我们</a>
            <div class="div">
                <a class="a2" href="telus.jsp">联系我们</a>
                <a class="a2" href="telus.jsp">在线留言</a>
            </div>
        </div>
    </div>
</div>
<script>
    /*导航的二级菜单触发*/
    $(document).ready(function(){
        $("#ui_menu .item").hover(function(){
            $(this).children("div").show();
        },function(){
            $(this).children("div").hide();
        });
    });
</script>