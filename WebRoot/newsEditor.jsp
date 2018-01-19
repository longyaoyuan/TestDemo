<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="header.jsp" %>
<div class="sub_banner"></div>
<div class="news_editor">
    <form name="upfile"  action="${pageContext.request.contextPath}/News?method=editor" method="post">
        <div id="news_div">新闻编辑区</div>
        <div>标题：<input type="text" name="title" value="">
        		 时间：<input type="text" name="time" value="">
        		 发布人：<input type="text" name="pbush" value="">
        </div>
      
      	<!--  
       <div class="news_title">新闻标题：<input id="news_title" type="text" name="news_title" value=""></div>
        <div class="news_time">发布时间：<input id="news_time" type="text" name="news_time" value=""></div>-->
        <div class="news_content"> 新闻内容:<textarea id="container" rows="100" cols="50" name="container">      
 		</textarea>
 		
            <!-- 加载编辑器的容器 -->
  
                      <!-- 配置文件 -->
            <script type="text/javascript" src="ueditor/ueditor.config.js"></script>
                        <!-- 编辑器源码文件 -->
            <script type="text/javascript" src="ueditor/ueditor.all.js"></script>
                        <!-- 实例化编辑器 -->
            <script type="text/javascript">
                var ue = UE.getEditor('container');
            </script>
 
       </div>
       <div class="news_btn"><input type="submit" value="保存"></div>
    </form>
</div>
<%@include file="footer.jsp"%>