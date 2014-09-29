<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注册页面</title>
<!-- <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="js/demo/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script> -->

</head>

<body>
	<jsp:include page="/WEB-INF/view/liguang/headNavigation.jsp" flush="true">
		<jsp:param name="name" value="abc" />
	</jsp:include>


	<link rel="stylesheet" href="css/register_css/style.css">
	<link rel="stylesheet" href="css/register_css/bootstrap.min.css">
	<script type="text/javascript" src="js/register_js/jquery.backstretch.min.js"></script>
	<script type="text/javascript" src="js/register_js/scripts.js"></script>

	<div class="register-container container">
		<div class="row">
			<div class="span5">
				<img src="images/register_page/iphone.png" alt="">
			</div>
			<div class="register span6">
				<form action="liguang/user!register.do" method="post">
					<h2>
						注册 <span class="red"><strong>黎光网站</strong></span>
					</h2>
					
					
					<label for="phone">Phone</label>
					<input type="text" id="phone" name="user.phonenum" placeholder="enter your phone...">
					<label for="email">Email</label>
					<input type="text" id="email" name="user.email" placeholder="enter your email...">
					
					<label for="username">Username</label>
					<input type="text" id="username" name="user.loginname" placeholder="choose a username...">
					<label for="password">Password</label>
					<input type="password" id="password" name="user.pwd" placeholder="choose a password...">
					<label for="repassword">ReEnterPassword</label>
					<input type="password" id="repassword" name="repassword" placeholder="enter  password again">
					
					<button type="submit">REGISTER</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
