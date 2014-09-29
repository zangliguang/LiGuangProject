<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


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

<title>诗词列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="黎光,诗词,列表">
<meta http-equiv="description" content="诗词列表">

<style type="text/css">
.content {
	margin-left: auto;
	margin-right: auto;
	padding-left: 25px;
	padding-right: 25px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}
/** TABLE STYLES **/
table#myTable input[type="checkbox"] {
	width: 30px;
	margin: 0;
}

table#myTable th:first-child {
	padding-left: 50px;
}

table#myTable tr:nth-child(odd) {
	background: #f0f0f0;
}

table#myTable {
	border: 1px solid #e9e9e9;
	width: 100%;
	-khtml-border-radius: 5px;
	-moz-border-radius: 5px;
	-ms-border-radius: 5px;
	-o-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
}

table#myTable thead tr {
	background: #ededee !important;
	background: -moz-linear-gradient(top, #ededee 0%, #dddddd 100%)
		!important;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #ededee),
		color-stop(100%, #dddddd)) !important;
	background: -webkit-linear-gradient(top, #ededee 0%, #dddddd 100%)
		!important;
	background: -o-linear-gradient(top, #ededee 0%, #dddddd 100%) !important;
	background: -ms-linear-gradient(top, #ededee 0%, #dddddd 100%)
		!important;
	background: linear-gradient(to bottom, #ededee 0%, #dddddd 100%)
		!important;
	border-bottom: 1px solid #fff;
}

table#myTable thead tr:hover {
	color: #000;
}

table#myTable tr {
	border: 1px solid #e9e9e9;
	background: #fff;
}

table#myTable tr:hover {
	background: #208ed3; /* Old browsers */
	background: -moz-linear-gradient(top, #208ed3 0%, #0272bd 100%);
	/* FF3.6+ */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #208ed3),
		color-stop(100%, #0272bd)); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #208ed3 0%, #0272bd 100%);
	/* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(top, #208ed3 0%, #0272bd 100%);
	/* Opera 11.10+ */
	background: -ms-linear-gradient(top, #208ed3 0%, #0272bd 100%);
	/* IE10+ */
	background: linear-gradient(to bottom, #208ed3 0%, #0272bd 100%);
	/* W3C */
	color: #fff;
	cursor: pointer;
}

table#myTable th {
	font-weight: bold;
	min-width: 100px;
	padding: 15px 15px 0 15px;
	text-align: left;
}

table#myTable td {
	vertical-align: middle;
	padding: 15px;
}

table#myTable thead tr .header {
	background-image: url('../images/bg.gif');
	background-repeat: no-repeat;
	background-position: center right;
	cursor: pointer;
	height: 2em;
}

table#myTable thead tr .headerSortUp {
	background-image: url('../images/asc.gif');
}

table#myTable thead tr .headerSortDown {
	background-image: url('../images/desc.gif');
}

table#myTable thead tr .headerSortDown,table#myTable thead tr .headerSortUp
	{
	color: #208ed3;
}

table#myTable thead tr th.avatar {
	padding-left: 70px;
}

table#myTable td.avatar {
	line-height: 30px;
}

table#myTable td.avatar img {
	float: left;
	margin: 0 15px 0 0
}
</style>


</head>

<body>
	<script>
		function go() {

			var page = document.getElementById("next").value - 1;
			if (page <= document.getElementById("pN").value) {
				window.location.href = 'liguang/poetry!listAllPoetryByPage.do?currentPage='
						+ page;
			}
		}
	</script>
	<jsp:include page="/WEB-INF/view/liguang/headNavigation.jsp" flush="true">
		<jsp:param name="name" value="abc" />
	</jsp:include>
	<div class="container">
		<table id="myTable" border="0" width="100">
			<thead>
				<tr>
					<th>名称</th>
					<th>标注</th>
					<th>作者</th>
					<th>日期</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${poetrylist}" var="poetry">

					<tr>
						<td><a href="liguang/poetry!getPoetrybyId.do?PoetryId=${poetry.poetryid}">${poetry.title}</a></td>
						<td>${poetry.remarks}</td>
						<td>${poetry.author}</td>
						<td>${poetry.creationdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="hidden" id="pN" name="pN" value="${pageNum}" />

		<ul class="pagination pagination-lg">
			<c:if test="${0!=currentPage}">
				<li><a href="liguang/poetry!listAllPoetryByPage.do?currentPage=${currentPage-1}">上一页</a></li>
			</c:if>
			<c:forEach var="page" begin="1" end="${pageNum}" step="1">
				<c:choose>
					<c:when test="${page==currentPage+1}">
						<li class="active"><a href="liguang/poetry!listAllPoetryByPage.do?currentPage=${page-1}">${page}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="liguang/poetry!listAllPoetryByPage.do?currentPage=${page-1}">${page}</a></li>
					</c:otherwise>

				</c:choose>
			</c:forEach>

			
			<c:if test="${pageNum!=currentPage+1}">
				<li><a href="liguang/poetry!listAllPoetryByPage.do?currentPage=${currentPage+1}">下一页</a></li>
			</c:if>
			<%-- <li><a>当前第${currentPage+1}页</a></li> --%>
			<font size="6">&nbsp&nbsp&nbsp&nbsp共${pageNum}页</font>
			<input type="number" class="text-align:center" style="height:30px;width: 60px " id="next" name="next" step="1" min="1" max="${pageNum}" />
			<input type="button" id="go" value="go" name="next" onclick="go()" />
		</ul>

	</div>

</body>
</html>
