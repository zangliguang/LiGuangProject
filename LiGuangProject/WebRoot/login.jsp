<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>登陆页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>

<SCRIPT type="text/javascript">
function loginAction() {
		var url='liguang/user!login.do';
		var data=$("#login").serialize();
		jQuery.post(url, data, function(result){
			if(result.ret=="error"){
				alert("登录失败")
			}else{
				window.location.href ="liguang/business!goToHomePage.do"
			}
		});
	}
</SCRIPT>
	<%
	    String i=request.getParameter("exit");
      if(null!=i&&i.equals("true")){
    	  session.invalidate();
      }
     %>
	
	<form name="login" id="login" method="post" action="liguang/user!login.do">
		<div align="center">
			用户账号：
			<input type="text" name="user.phonenum" value="18310019030" id="loginname">
			<span style="color:red; " name="loginnametext" id="loginnametext"></span><br> <br> 用户密码：
			<input type="password" name="user.pwd" value="asd1215225" id="password">
			<span style="color:red; " name="pwdtext" id="pwdtext"></span> <br> <br>
			<!-- <input type="submit" value="登录" /> -->
			<input type="button" value="登录" onclick="loginAction()" />
			<input type="reset" value="重置">
			<input type="button" value="注册" onclick="window.location.href='register.jsp'">
			<input type="hidden" name="ip" value=<%=request.getRemoteAddr()%>>
		</div>
	</form>
</body>
</html>
