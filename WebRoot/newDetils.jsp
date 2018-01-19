<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="header.jsp" %>
<div class="sub_banner"></div>

<div class="sub_nav"><a href="">首页</a>&gt;<a href="#">新闻中心</a> &gt; 内容</div>

<div class="sub">
    <div class="sub_l">
        <div class="title">新闻中心</div>
        <a class="item1 cur" href="#">集团要闻</a>
        <a class="item1 " href="#">媒体报道</a>
        <a class="item1 " href="#">精准扶贫</a>
        <a class="item1 " href="#">TV</a>
    </div>

    <div class="sub_r">

     <c:forEach var="news" items="${NewsList}" varStatus="status" >
       
        <div class="s_r_h1"><span>${news.nTitle}</span></div>
     
        <div class="s_r_h2">
        
            发布时间：<fmt:formatDate value="${news.nTime}" pattern="yyyy-MM-dd"/>
            
            </div>
        <div class="content">
			${news.nContent}
											
        </div>
		</c:forEach>
        </div>

        <div class="clear"></div>
    </div>
<%@ include file="footer.jsp"%>