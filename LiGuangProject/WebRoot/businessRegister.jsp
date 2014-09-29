<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.zang.liguang.po.User"%>
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

<title>商户注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/area.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%
	    String username="";
	    String userid="";
		User user = (User) session.getValue("user");
	%>
	<jsp:include page="/WEB-INF/view/liguang/headNavigation.jsp" flush="true">
		<jsp:param name="name" value="abc" />
	</jsp:include>
	<form action="liguang/business!saveOrupdateBusiness.do" method="post" autocomplete="off" id="marketForm">
		<div>
			<label> 您的姓名 </label>
			<input name="business.mastername" type="text" value="<%=null!=user.getName()?user.getName():""%>">
			<br /> <br />
			<label> 您的电话</label>
			<input name="business.masterphone" type="text">
			<br /> <br />
			<label> 您的邮箱 </label>
			<input name="business.masteremail" type="text">
			<br /> <br />
			<label> 商店名称 </label>
			<input name="business.shopname" type="text">
			<br /> <br />
			<label>商店位置 </label>
			<select name="business.province" id="province2"></select>
			<select name="business.city" id="city2"></select>
			<select name="business.area" id="area2"></select>
			<br /> <br />
			<label>详细地址 </label>
			<input name="business.detailaddress" type="text">
			<br /> <br />
			<label>店铺联系电话 </label>
			<input name="business.shopphone" type="text">
			<br /> <br />
			<label>营业执照牌号 </label>
			<input name="business.licence" type="text">
			<br /> <br />
			<label>备注</label>
			<input name="business.remarks" type="text">
			<input name="business.masterid" type="hidden" value="<%=user.getUid()%>">
			<br /> <br />
			<input type="submit" value="确认">
			<input type="reset" value="重置">
		</div>

		<script type="text/javascript">
			BindProvince("province2", "city2", "area2");
		</script>
	</form>
</body>
</html>
