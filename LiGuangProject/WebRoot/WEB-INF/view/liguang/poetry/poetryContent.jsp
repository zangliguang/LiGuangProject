<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>${poetry.title}</title>

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

<%-- <%@include file="/WEB-INF/view/liguang/headNavigation.jsp" %>
<%@include file="/WEB-INF/view/liguang/headNavigation.jsp" %> --%>
<jsp:include page="/WEB-INF/view/liguang/headNavigation.jsp" flush="true">
<jsp:param name="name" value="abc" />
</jsp:include>

	${poetry.title}
	<br>
	
  ${poetry.poetry} 
<br>

	${poetry.remarks}
	<br> ${poetry.author}
	<br> ${poetry.creationdate}
	<br>
</body>
</html>
