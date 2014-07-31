
<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>user</title>
<!-- 引入Jquery -->
<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="js/demo/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#mydatagrid').datagrid({
			title : '用户列表',
			iconCls : 'icon-ok',
			width : 1200,
			pageSize : 5,//默认选择的分页是每页5行数据  
			pageList : [ 3, 5, 10, 15, 20 ],//可以选择的分页集合  
			nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
			striped : true,//设置为true将交替显示行背景。  
			collapsible : true,//显示可折叠按钮  
			toolbar : "#tb",//在添加 增添、删除、修改操作的按钮要用到这个  
			url : 'liguang/user!getAll.do',//url调用Action方法  
			loadMsg : '数据装载中......',
			singleSelect : false,//为true时只能选择单行  
			fitColumns : true,//允许表格自动缩放，以适应父容器  
			//sortName : 'xh',//当数据表格初始化时以哪一列来排序  
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
			var ed = $('#mydatagrid').datagrid('getEditor', {
				index : editIndex,
				field : 'sex'
			});
			var sexname = $(ed.target).combobox('getText');
			$('#mydatagrid').datagrid('getRows')[editIndex]['sexvalue'] = sexname;
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
			/* } else {
				$('#mydatagrid').datagrid('selectRow', editIndex);
			} */
		}
	}
	function append() {
		//if (endEditing()){
		$('#mydatagrid').datagrid('appendRow', {
			loginname:'登录名',
			name: '新名称',
			birthday: '1990-12-12',
			sex: '0',
			phonenum:'18827765432',
			email:'aa@sad.com',
			identity:'1421241234145124',
		});
		editIndex = $('#mydatagrid').datagrid('getRows').length - 1;
		$('#mydatagrid').datagrid('selectRow', editIndex).datagrid('beginEdit',
				editIndex);
		//}
	}
	function removeit() {
	/* 	//if (editIndex == undefined){return}
		$('#mydatagrid').datagrid('cancelEdit', editIndex).datagrid(
				'deleteRow', editIndex);
		editIndex = undefined; */
		
		var rows = $('#mydatagrid').datagrid('getChecked');
		var rowindexs = $('#mydatagrid').datagrid('getSelections');
		var rowindex = $('#mydatagrid').datagrid('getRowIndex', rowindexs[0]);
		var url = 'liguang/user!deleteUser.do';
		for (var i = 0; i < rowindexs.length; i++) {
			rowindex = $('#mydatagrid').datagrid('getRowIndex', rowindexs[i]);

			var eds = $('#mydatagrid').datagrid('getEditors', rowindex);

			var data = {
				'user.uid' : rows[i].uid
			};
			$.post(url, data, function(result) {
			});
			$('#mydatagrid').datagrid('reload');
		}
		 /* location.reload(); */
	}
	function accept() {
		var rows = $('#mydatagrid').datagrid('getChecked');
		var rowindexs = $('#mydatagrid').datagrid('getSelections');
		var rowindex = $('#mydatagrid').datagrid('getRowIndex', rowindexs[0]);
		var url = 'liguang/user!saveOrupdate.do';
		for (var i = 0; i < rowindexs.length; i++) {
			rowindex = $('#mydatagrid').datagrid('getRowIndex', rowindexs[i]);

			/* var ed = $('#mydatagrid').datagrid('getEditor', {index:i,field:'sex'});
			var sexvalue = $(ed.target).combobox('getValue');
			$(eds[2].target).val()
			$(eds[2].target).combobox('getValue') */
			var eds = $('#mydatagrid').datagrid('getEditors', rowindex);

			var data = {
				'user.uid' : rows[i].uid,
				'user.name' : $(eds[1].target).val(),
				'user.loginname' : $(eds[0].target).val(),
				'user.sex' : $(eds[2].target).combobox('getValue'),
				'birthday' : $(eds[3].target).datebox('getValue'),
				'user.phonenum' : $(eds[4].target).val(),
				'user.email' : $(eds[5].target).val(),
				'user.identity' : $(eds[6].target).val()
			};
			$.post(url, data, function(result) {
			});
			$('#mydatagrid').datagrid('endEdit', rowindex)
		}
		$('#mydatagrid').datagrid('reload');
		/* if (endEditing()){
			$('#mydatagrid').datagrid('acceptChanges');
		} */

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

	/* function myformatter(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
				+ (d < 10 ? ('0' + d) : d);
	}

	function myparser(s) {
		if (!s)
			return new Date();
		var ss = (s.split('-'));
		var y = parseInt(ss[0], 10);
		var m = parseInt(ss[1], 10);
		var d = parseInt(ss[2], 10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
			return new Date(y, m - 1, d);
		} else {
			return new Date();
		}
	} */
	
	
		//这里是扩展validatebox的方法
		$.extend($.fn.validatebox.defaults.rules, {
		    phone: {
			        // 验证手机号码
			        validator: function(value) {
			            return /^(13|15|18)\d{9}$/i.test(value); //这里就是一个正则表达是
			        },
			        message: '手机号码格式不正确' //这里是错误后的提示信息
		     }
	  });
	
</script>

</head>
<body>
	<h2>
		<b>easyui的DataGrid实例</b>
	</h2>

	<table id="mydatagrid" align="center">
		<thead>
			<tr>
				<th data-options="field:'loginname',width:200,align:'center',editor:'text'">登陆名</th>
				<th data-options="field:'name',width:200,align:'center',editor:'text'">姓名</th>
				<th
					data-options="field:'sex',width:100,align:'center',
				
				formatter: function(value, row) { return row.sex=='1'?'女':'男';},
				editor: {
				    type: 'combobox',
				    options: {
				        valueField: 'sex',
				        textField: 'sexvalue',
				        data: [{'sex':'0','sexvalue': '男'},{'sex':'1','sexvalue': '女'}],
				    }
				}">性别</th>
				<th
					data-options="field:'birthday',width:100,align:'center',sortable:true,
					editor: {
					    type: 'datebox',
					    
					    <!-- parser:myparser, formatter:myformatter -->
					}
					">生日</th>
				<th data-options="field:'phonenum',width:200,align:'center',editor:{type:'validatebox',options:{required:true,validType:'phone'}}">电话</th>
				<th data-options="field:'email',width:200,align:'center',editor:{type:'validatebox',options:{required:true,validType:'email'}}">邮件</th>
				<th data-options="field:'identity',width:200,align:'center',editor:'text'">身份证</th>
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