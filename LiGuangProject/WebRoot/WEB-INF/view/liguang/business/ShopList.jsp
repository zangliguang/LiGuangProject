<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>商户列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
         商店分类列表<br>
	<c:forEach items="${businessclasslist}" var="rec">
			<a href="">${rec.bclassname}</a>
	</c:forEach>
	<br>
	<br>
	<br>
	商店列表<br>
	<c:forEach items="${businesslist}" var="bs" varStatus="bstatus">
              <a href="liguang/business!getBusinessInfo.do?bid=${bs.bid}">${bs.shopname}</a>
	</c:forEach>


</body>
</html>
