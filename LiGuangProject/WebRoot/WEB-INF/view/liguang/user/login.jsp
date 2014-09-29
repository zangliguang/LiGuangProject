<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form name="login" method="post" action="liguang/user!login.do">
		<div align="center">
			用户账号： <input type="text" name="user.loginname" value="18310019030"id="loginname"> <span  style="color:red; "  name="loginnametext" id="loginnametext"></span><br> <br> 
			用户密码： <input type="password" name="user.pwd" value="asd1215225" id="password"><span  style="color:red; "  name="pwdtext" id="pwdtext"></span>
			<br> <br> <input type="submit" value="登录" />
			<input type="reset" value="重置"> <input type="button"
				value="注册" onclick="window.location.href='./frontView/register.vm'">
            <input type ="hidden" name = "ip" value =<%=request.getRemoteAddr()%>  >		
		</div>
	</form>
  </body>
</html>
