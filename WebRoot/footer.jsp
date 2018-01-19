<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>footer</title>
</head>
<body>
<div class="footer">
    <div class="copyright">
        <div class="l">Copyright &copy; 集团股份有限公司&nbsp;&nbsp;&nbsp;黔ICP备789456号</div>
        <div class="link" id="ui_link">
            <span>分子公司链接</span>
            <div style="display: none;">
                <a href="#" target="_blank">集团公司</a>
                <a href="#" target="_blank">集团公司</a>
                <a href="#" target="_blank">集团公司</a>
                <a href="#" target="_blank">集团公司</a>
                <a href="#" target="_blank">集团公司</a>
                <a href="#" target="_blank">集团公司</a>
                <a href="#" target="_blank">集团公司</a>
                <a href="#" target="_blank">集团公司</a>
            </div>
        </div>
        <div class="r">
            <a href="#" target="_blank">企业邮箱</a>&nbsp;&nbsp;&nbsp;
            <a href="#" target="_blank">VPN</a>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){
        $("#ui_link").hover(function(){
            $(this).children("div").show();
        },function(){
            $(this).children("div").hide();
        });
    });
</script>
  </body>
</html>