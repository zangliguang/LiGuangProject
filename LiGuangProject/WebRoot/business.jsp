<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String classid =request.getParameter("classid");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'business.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- 引入Jquery -->
<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="js/demo/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/liguangjs.js"></script>
<script type="text/javascript">
		
		$(function() {  
			var classid=request('classid');
		    $('#mydatagrid').datagrid({  
		        title : '业务',  
		        iconCls : 'icon-ok',  
		        width : 600,  
		        pageSize : 10,//默认选择的分页是每页5行数据  
		        pageList : [5, 10, 15, 20 ],//可以选择的分页集合  
		        nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
		        striped : true,//设置为true将交替显示行背景。  
		        collapsible : true,//显示可折叠按钮  
		        toolbar:"#tb",//在添加 增添、删除、修改操作的按钮要用到这个  
		        url:'liguang/business!getAllBusinessByClassid.do?classid='+classid+'',//url调用Action方法  
		        loadMsg : '数据装载中......',  
		        singleSelect:false,//为true时只能选择单行  
		        fitColumns:true,//允许表格自动缩放，以适应父容器  
		        //sortName : 'ordernum',//当数据表格初始化时以哪一列来排序  
		        //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。  
		        remoteSort : false,  
		         frozenColumns : [ [ {  
		            field : 'ck',  
		            checkbox : true  
		        } ] ],   
		        pagination : true,//分页  
				rownumbers : true,//行数  
				loadFilter : pagerFilter,
				onDblClickRow : onDoubleClickdoublRow
		    });   
		      
		});  
		  
		function pagerFilter(data) {
			if (typeof data.length == 'number' && typeof data.splice == 'function') { // is array
				data = {
					total : data.length,
					rows : data
				}
			}
			var dg = $(this);
			var opts = dg.datagrid('options');
			var pager = dg.datagrid('getPager');
			pager.pagination({
				onSelectPage : function(pageNum, pageSize) {
					opts.pageNumber = pageNum;
					opts.pageSize = pageSize;
					pager.pagination('refresh', {
						pageNumber : pageNum,
						pageSize : pageSize
					});
					dg.datagrid('loadData', data);
				}
			});
			if (!data.originalRows) {
				data.originalRows = (data.rows);
			}
			var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
			var end = start + parseInt(opts.pageSize);
			data.rows = (data.originalRows.slice(start, end));
			return data;
		}
		
		var editIndex = undefined;
		function endEditing() {
			if (editIndex == undefined) {
				return true
			}
			if ($('#mydatagrid').datagrid('validateRow', editIndex)) {
				$('#mydatagrid').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onDoubleClickdoublRow(index) {
			if (editIndex != index) {
				//if (endEditing()){
				$('#mydatagrid').datagrid('selectRow', index).datagrid('beginEdit',
						index);
				editIndex = index;
			}
		}
		function append() {
			var object =$('#mydatagrid').datagrid('getData');
			var num =object.total;
			$('#mydatagrid').datagrid('appendRow', {
				
				bname:'新业务'+(num+1),
			});
			editIndex = $('#mydatagrid').datagrid('getRows').length - 1;
			$('#mydatagrid').datagrid('selectRow', editIndex).datagrid('beginEdit',
					editIndex);
			//}
		}
		function removeit() {
			
			var rows = $('#mydatagrid').datagrid('getChecked');
			var rowindexs = $('#mydatagrid').datagrid('getSelections');
			var rowindex = $('#mydatagrid').datagrid('getRowIndex', rowindexs[0]);
			var url = 'liguang/business!deletebusiness.do';
			for (var i = 0; i < rowindexs.length; i++) {
				rowindex = $('#mydatagrid').datagrid('getRowIndex', rowindexs[i]);
		
				var eds = $('#mydatagrid').datagrid('getEditors', rowindex);
		
				var data = {
					'business.bid' : rows[i].bid
				};
				$.post(url, data, function(result) {
				});
				$('#mydatagrid').datagrid('reload');
			}
		}
		function accept() {
			var rows = $('#mydatagrid').datagrid('getChecked');
			var rowindexs = $('#mydatagrid').datagrid('getSelections');
			var rowindex = $('#mydatagrid').datagrid('getRowIndex', rowindexs[0]);
			var url = 'liguang/business!saveOrupdateBusiness.do';
			for (var i = 0; i < rowindexs.length; i++) {
				rowindex = $('#mydatagrid').datagrid('getRowIndex', rowindexs[i]);
		
				var eds = $('#mydatagrid').datagrid('getEditors', rowindex);
		
				var data = {
					'business.bid' : rows[i].bid,
					'business.bname' : $(eds[0].target).val(),
					'business.classid' :request('classid')
				};
				$.post(url, data, function(result) {
				});
				$('#mydatagrid').datagrid('endEdit', rowindex)
			}
			$('#mydatagrid').datagrid('reload');
		
		}
		function reject() {
			$('#mydatagrid').datagrid('rejectChanges');
			editIndex = undefined;
		}
		function getChanges() {
			var rows = $('#mydatagrid').datagrid('getChecked');
			var rowindexs = $('#mydatagrid').datagrid('getSelections');
			var rowindex = $('#mydatagrid').datagrid('getRowIndex', rowindexs[0]);
			alert(rowindex);
		}
		function  go(val,row){
			var classid=row.bclassid;
			var url ="liguang/business!getAllBusinessByClassid.do?classid="+classid;
			/* return '<a href="liguang/business!getAllBusinessByClassid.do?classid='+row.bclassid+'"  >查看</a>  ' */
			return '<a href="business.jsp?classid='+row.bclassid+'"  >查看</a>  '
			}
</script> 
</head>

<body>
  <h2>  
        <b>业务</b>  
    </h2>  
  
    <table id="mydatagrid" align="center">  
       <thead>  
            <tr>  
                <th data-options="field:'bid',width:100,align:'center'">编号</th>  
                <th data-options="field:'bname',width:100,align:'center',editor:'text'">业务名</th>  
                <th width="165" data-options="field:'aa',align:'center',formatter:go">查看</th>
            </tr>  
        </thead>  
    </table>  
     <div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">Append</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">Remove</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">Accept</a> <a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-undo',plain:true" onclick="reject()">Reject</a> <a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">GetChanges</a>
	</div>

</body>
</html>
