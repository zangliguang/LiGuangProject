<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page import="com.zang.liguang.po.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>黎光网站</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="icon" href="images/home_page/me.jpg">
<!-- Bootstrap core CSS -->
<link href="css/bootstrap_css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="css/bootstrap_css/bootstrap.min.css" rel="stylesheet"> -->
<link href="css/bootstrap_css/theme.css" rel='stylesheet' type='text/css' />


<!----//webfonts---->
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap/dropdown.js"></script>
<script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap/bootstrap.min.js"></script>



</head>

<body>
	<%
	    String username="";
	    String userid="";
		User user = (User) session.getValue("user");
	if(null!=user){
		username = user.getLoginname();	
		userid=user.getUid();
	}
	%>
	<!-- Static navbar -->
	<div class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">黎光网站</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">

					<%
						if (null != username && username.length() > 0) {
					%>
					<li class="active"><a href="businessRegister.jsp?masterid=<%=userid %>">商户注册</a></li>
					<%} %>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">黎光诗词 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="liguang/poetry!listAllPoetryByPage.do">查看</a></li>
							<li><a href="liguang/poetry!gotoAddPoetryPage.do" target="_blank">添加诗词</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">

					<%
						if (null != username && username.length() > 0) {
					%>
					<li class="active"><a href="./"><%=username%> </a></li>
					<li><a href="MyInfo.jsp">我的账户</a></li>
					<li><a href="liguang/business!getMyBusinessByMasterId.do" target="_blank" rel="nofollow">我的商店</a></li>
					<li><a href="background.jsp" target="_blank" rel="nofollow">后台</a></li>

					<li><a href="login.jsp?exit=true">退出</a></li>
					<%
						} else {
					%>
					<li><a href="login.jsp">登录</a></li>
					<li><a href="register.html">注册</a></li>

					<%
						}
					%>


				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</div>
</body>
</html>
