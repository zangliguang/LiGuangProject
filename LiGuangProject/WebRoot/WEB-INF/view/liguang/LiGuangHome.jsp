<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>黎光网站</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="keywords" content="黎光,主页">
<meta http-equiv="description" content="黎光网站的首页">


<!--  jquery plguin -->
<!--start slider -->
<link rel="stylesheet" href="css/bootstrap_css/fwslider.css" media="all">
<script src="js/bootstrap/jquery-ui.min.js"></script>
<script src="js/bootstrap/css3-mediaqueries.js"></script>
<script src="js/bootstrap/fwslider.js"></script>
<!--end slider -->


</head>

<body>

	<jsp:include page="/WEB-INF/view/liguang/headNavigation.jsp" flush="true">
		<jsp:param name="name" value="abc" />
	</jsp:include>


	<!--  jquery plguin -->
	<!--start slider -->
	<link rel="stylesheet" href="css/bootstrap_css/fwslider.css" media="all">
	<script src="js/bootstrap/jquery-ui.min.js"></script>
	<script src="js/bootstrap/css3-mediaqueries.js"></script>
	<script src="js/bootstrap/fwslider.js"></script>
	<!--end slider -->
	<div class="container">
		<!-- 主页图片 -->
		<div class="row">
			<div class="col-md-12">
				<!----start-images-slider---->
				<div class="images-slider">
					<div id="fwslider">
						<div>
							<div class="slide">
								<img src="images/home_page/img.jpg" alt="" />
								<div class="slide_content">
									<div class="slide_content_wrap">
										<p class="description">黎光网站</p>
										<h4 class="title">首页</h4>
										<p class="description">
											<a href="liguang/business!getAllBusinessClassToWeb.do" target="_blank">进入主站</a>
										</p>
										<div class="slide-btns description"></div>
									</div>
								</div>
							</div>
							<div class="slide">
								<img src="images/home_page/img2.jpg" alt="" />
								<div class="slide_content">
									<div class="slide_content_wrap">
										<p class="description">黎光网站</p>
										<h4 class="title">首页</h4>
										<p class="description">
											<a href="liguang/business!getAllBusinessClassToWeb.do">进入主站</a>
										</p>
										<div class="slide-btns description"></div>
									</div>
								</div>
							</div>
							<!--/slide -->
						</div>
						<div class="timers"></div>
						<div class="slidePrev">
							<span> </span>
						</div>
						<div class="slideNext">
							<span> </span>
						</div>
					</div>
					<!--/slider -->
				</div>
			</div>
		</div>

		<!-- 主营业务 -->
		<div class="row">
			<div class="col-md-12 text-center">
				<h2>主营业务</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="grid">
					<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">
							<a href="#" class="b-link-stripe b-animate-go  thickbox"> <img height="200" width="200" src="images/home_page/cont1.jpg" />
								<div class="b-wrapper">
									<h2 class="b-animate b-from-left    b-delay03 ">
										<img src="images/home_page/link-ico.png" alt="" />
									</h2>
								</div></a>
						</div>
					</div>
					<p class="text-center">Big block Lether Bag</p>
					<h2 class="text-center">$350.00</h2>
					<p class="text-center">
						<a href="details.html">Buy</a>
					</p>
				</div>
			</div>


			<!----start-model-box---->

			<div class="col-md-2">
				<div class="grid">
					<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">
							<a href="#" class="b-link-stripe b-animate-go  thickbox"> <img height="200" width="200" src="images/home_page/cont2.jpg" />
								<div class="b-wrapper">
									<h2 class="b-animate b-from-left    b-delay03 ">
										<img src="images/home_page/link-ico.png" alt="" />
									</h2>
								</div></a>
						</div>
					</div>
					<p class="text-center">Big block Lether Bag</p>
					<h2 class="text-center">$350.00</h2>
					<p class="text-center">
						<a href="details.html">Buy</a>
					</p>
				</div>
			</div>
			<div class="col-md-2">
				<div class="grid">
					<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">
							<a href="#" class="b-link-stripe b-animate-go  thickbox"> <img height="200" width="200" src="images/home_page/cont3.jpg" />
								<div class="b-wrapper">
									<h2 class="b-animate b-from-left    b-delay03 ">
										<img src="images/home_page/link-ico.png" alt="" />
									</h2>
								</div></a>
						</div>
					</div>
					<p class="text-center">Big block Lether Bag</p>
					<h2 class="text-center">$350.00</h2>
					<p class="text-center">
						<a href="details.html">Buy</a>
					</p>
				</div>
			</div>
			<div class="col-md-2">
				<div class="grid">
					<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">
							<a href="#" class="b-link-stripe b-animate-go  thickbox"> <img height="200" width="200" src="images/home_page/cont4.jpg" />
								<div class="b-wrapper">
									<h2 class="b-animate b-from-left    b-delay03 ">
										<img src="images/home_page/link-ico.png" alt="" />
									</h2>
								</div></a>
						</div>
					</div>
					<p class="text-center">Big block Lether Bag</p>
					<h2 class="text-center">$350.00</h2>
					<p class="text-center">
						<a href="details.html">Buy</a>
					</p>
				</div>
			</div>
			<div class="col-md-2">
				<div class="grid">
					<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper">
							<a href="#" class="b-link-stripe b-animate-go  thickbox"> <img height="200" width="200" src="images/home_page/cont2.jpg" />
								<div class="b-wrapper">
									<h2 class="b-animate b-from-left    b-delay03 ">
										<img src="images/home_page/link-ico.png" alt="" />
									</h2>
								</div></a>
						</div>
					</div>
					<p class="text-center">Big block Lether Bag</p>
					<h2 class="text-center">$350.00</h2>
					<p class="text-center">
						<a href="details.html">Buy</a>
					</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>


		<div class="clearfix"></div>

	</div>




	<!-- 底部 -->
	<div class="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul class="list-inline pull-left">
						<li><a href="#">Terms of Services</a></li>
						<li><a href="#">Refunds</a></li>
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">Contact</a></li>
					</ul>
					<form class="navbar-form pull-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="Find" class="btn btn-default">Find</button>
					</form>
				</div>
			</div>
			<div class="copy-right text-center">
				<p>
					Copyright &copy; 2014.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
				</p>
			</div>
		</div>
</body>
</html>
