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
<link href="js/dropzone/css/basic.css" rel="stylesheet" />
    <link  href="js/dropzone/css/dropzone.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/dropzone/dropzone.js"></script>

<script type="text/javascript">
$.ajaxSetup({
	async:false 
});
  //保存进度		
    function saveInformation()
    {
    	    /* var r=$("#dropzoneForm").valid(); */
	        var data=$("#dropzoneForm").serialize();
    		var url='liguang/information!saveOrupdate.do';
    		jQuery.post(url, data, function(result){
    				if(result=="success"){
               			/* art.dialog.alert("保存成功",function(){window.location.href="/pmcmanage/pmc-progress-picture.do";}); */
        			alert("保存成功"); 
    				}
    			});
    }
    
    
    function checkLeave(){
		var url='liguang/uploader!deleteNoOwnerfile.do';
		jQuery.post(url, null, function(result){});
　　}
  
  
   
  
    </script>
</head>

<body>
<%-- <%=request.getRequestURL() %><BR>
<%=request.getRequestURL().substring(0, request.getRequestURL().indexOf(request.getContextPath())) +request.getContextPath()%><BR>
<%=request.getContextPath() %><BR>
<%=request.getRealPath("/") %><br>
<%=application.getRealPath("/") %><br>
<%=application.getRealPath(request.getRequestURI())%><br>
<%=application.getRealPath("/") %><br>
${pageContext.request.contextPath} <br>
<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() %><br>
${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}<br>
<%=request.getRequestURL().substring(0, request.getRequestURL().indexOf(request.getContextPath())) +request.getContextPath()%><br> --%>
      商店详细信息（上传图片还没加jquery效果）<br>
      商店名称：${business.shopname}<br>
      联系电话：${business.masterphone}<br>
      备       注：${business.remarks}<br>
      省级代码：${business.province}<br>
      市级代码：${business.city}<br>
      区域代码：${business.area}<br>
	<c:forEach items="${attachmentlist}" var="rec">
	<div>
	<%-- <img src="<%=request.getRequestURL().substring(0, request.getRequestURL().indexOf(request.getContextPath())) +request.getContextPath()%>${rec.fileurl}"  width="700" height="440" /> --%>
	<img src="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>${rec.fileurl}"  width="700" height="440" />
	</div>
	</c:forEach> 
       
       <form method="post" onsubmit="saveInformation()" enctype="multipart/form-data" class="dropzone" id="dropzoneForm" name="dropzoneForm">
		<input type="hidden" name="filetype" id="filetype" value="123" />
		<div align="right">
			<input type="text" name="information.subject" value="${business.bid}">
			<br>
			<input type="text" name="information.content" value="内容">
			<br>
			<input type="text" name="information.bid" value="${business.bid}">
			<br>
			<input type="text" name="belongid" id="belongid" value=${business.bid} >
			<br>
			<input type="submit" value="提交" />
			<input type="reset" value="重置">
		</div>
	</form>  
</body>
</html>
