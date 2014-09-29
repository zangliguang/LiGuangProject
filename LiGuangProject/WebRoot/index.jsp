<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
	
	
	<script>
		$(function(){
			window.location.href ="liguang/business!goToHomePage.do"
		});
	</script>
	

  </head>
  
  <body>
  
  <!--  <a href="login.html">登录</a>
   <a href="register.html">注册</a>
   <a href="user.jsp">后台</a>
   <a href="liguang/business!getAllBusinessClassToWeb.do">首页</a>
     -->
  </body>
</html>
