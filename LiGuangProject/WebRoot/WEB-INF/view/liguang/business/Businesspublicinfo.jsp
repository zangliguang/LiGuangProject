<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String bid = request.getParameter("bid");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>商户发布信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="js/dropzone/css/basic.css" rel="stylesheet" />
<link href="js/dropzone/css/dropzone.css" rel="stylesheet" />
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

<body onbeforeunload="checkLeave()">
	<form method="post" onsubmit="saveInformation()" enctype="multipart/form-data" class="dropzone" id="dropzoneForm" name="dropzoneForm">
		<input type="hidden" name="filetype" id="filetype" value="123" />
		<div align="center">
			<input type="text" name="information.subject" value="主题">
			<br>
			<input type="text" name="information.content" value="内容">
			<br>
			<input type="text" name="information.bid" value=${business.bid} >
			<br>
			<input type="text" name="belongid" id="belongid" value=${business.bid} >
			<br>
			<input type="submit" value="提交" />
			<input type="reset" value="重置">
		</div>
	</form>

</body>
</html>
