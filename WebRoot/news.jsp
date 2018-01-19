<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="header.jsp"%>
<div class="sub_banner"></div>

<div class="sub_nav"><a href="http://localhost:8080/GroupOrg/News?method=newsList">首页</a>&gt;<a href="#">新闻中心</a> &gt; 列表</div>

<div class="sub">
    <div class="sub_l">
        <div class="title">新闻中心</div>
        <a class="item1 cur" href="news.jsp">集团要闻</a>
        <a class="item1 " href="news.jsp">媒体报道</a>
        <a class="item1 " href="news.jsp">精准扶贫</a>
        <a class="item1 " href="news.jsp">TV</a>
    </div>
    
    <div class="sub_r">
        <div class="s_r_title">
            <div class="h1">集团新闻</div>
            <div class="h2">Group News</div>
        </div>

        <div class="news_list">
        
        <c:forEach var="groupNews" items="${pageQueryList}" varStatus="status"> 
            <a class="item mr" href="http://localhost:8080/GroupOrg/News?method=queryNewsByTitles&id=${groupNews.nId}" target="_blank" id="newsTitle">
                <div class="thumb"><img src="images/map_img_01.png"></div>
                <div class="txt">
                    <div class="date">
                        <span class="s1">
                        <fmt:formatDate value="${groupNews.nTime}" pattern="dd"/></span>
                        <span class="s2">
                        <fmt:formatDate value="${groupNews.nTime}" pattern="yyyy-MM"/>
                        </span>
                    </div>
                    <div class="h3" id="title">${groupNews.nTitle}</div>
                    <div class="h4" >DETIAILS&gt;&gt;</div>
                </div> 
            </a>
             </c:forEach>
        </div>
        <div id="pages">
        	
            <a class="btn btn-default">共${totalPage}页</a>
            <a class="btn btn-default" href="http://localhost:8080/GroupOrg/NewsCenter?method=prePage&currentPage=${currentPage}" >上一页</a>          
            <a class="btn btn-default">第${currentPage}页</a>
            <a href="http://localhost:8080/GroupOrg/NewsCenter?method=nextPage&currentPage=${currentPage}" class="btn btn-default">下一页</a>
        </div>
    </div>
    <div class="clear"></div>
</div>
<%@include file="footer.jsp"%>