<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>添加诗词</title>
<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="js/demo/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script language="javascript">
function myformatter(date){  
    var y = date.getFullYear();  
    var m = date.getMonth()+1;  
    var d = date.getDate();  
    var h = date.getHours();  
    var min = date.getMinutes();  
    var sec = date.getSeconds();  
    var str = y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d)+' '+(h<10?('0'+h):h)+':'+(min<10?('0'+min):min)+':'+(sec<10?('0'+sec):sec);  
    return str;  
}  
function myparser(s){  
    if (!s) return new Date();  
    var y = s.substring(0,4);  
    var m =s.substring(5,7);  
    var d = s.substring(8,10);  
    var h = s.substring(10,13);  
    var min = s.substring(14,16);  
    var sec = s.substring(17,19);  
    if (!isNaN(y) && !isNaN(m) && !isNaN(d) && !isNaN(h) && !isNaN(min) && !isNaN(sec)){  
        return new Date(y,m-1,d,h,min,sec);  
    } else {  
        return new Date();  
    }  
}

function submitPoetry(){
		
	    var data = $("#form1").serialize();
		var url = "liguang/poetry!saveOrupdate.do";
	    jQuery.post(url, data, function(result){
    		if(result != "addsucess"){
    		   alert("添加成功");
    		   $("#reset").trigger("click");
		     }
    		if(result != "addfail"){
    		   alert("添加失败");
    		   $("#reset").trigger("click");
		     }
		});
	

}
</script>
</head>

<body>
	<jsp:include page="/WEB-INF/view/liguang/headNavigation.jsp" flush="true">
		<jsp:param name="name" value="abc" />
	</jsp:include>
	
	<form align="center" id="form1" name="form1">
		<table align="center">
			<tr>
				<td>标题：</td>
				<td><input id="text1" type="text" name="poetry.title" value=""></td>
			</tr>
			<tr>
				<td>内容：</td>
				<td style="height:200px;width:600px;"><textarea name="poetry.poetry" style="resize:none;" cols="60" rows="15"></textarea></td>


			</tr>
			<tr>
				<td>分类：</td>
				<td><select name="poetry.classid">
						<option value="1">黎光校园</option>
						<option value="2">黎光苦逼</option>
						<option value="3">黎光失眠</option>
						<option value="4">黎光胡想</option>
						<option value="5">其他高手</option>
				</select>
				<td>
			</tr>

			<tr>
				<td>创作日期：</td>
				<!-- <td><input name="poetry.creationdate" class="easyui-datetimebox" data-options="formatter:myformatter,parser:myparser"value="new Date();"></input></td> -->
				<td><input name="poetry.creationdate" class="easyui-datetimebox" data-options="formatter:myformatter,parser:myparser"></input></td>
			</tr>


			<tr>
				<td>作者：</td>
				<td><input id="name" type="text" name="poetry.author" value="黎光""></td>
			</tr>
			<tr>
				<td>标注：</td>
				<td><input id="name" type="text" name="poetry.remarks" value="""></td>
			</tr>
			<tr align="center">
				<td height="41" align="center"><input type="button" value="提交" name="tect6" onClick="submitPoetry()"> <input type="reset" id="reset" value="重置"
					name="text7"></td>
			</tr>
		</table>
	</form>
</body>
</html>
