<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>首页jquery导航</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/global.css">
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/slides.min.jquery.js"></script>
	<script>
		$(function(){
			$('#slides').slides({
				preload: true,
				preloadImage: 'images/loading.gif',
				play: 5000,
				pause: 2500,
				hoverPause: true,
				animationStart: function(){
					$('.caption').animate({
						bottom:-35
					},100);
				},
				animationComplete: function(current){
					$('.caption').animate({
						bottom:0
					},200);
					if (window.console && console.log) {
						// example return of current slide number
						console.log(current);
					};
				}
			});
		});
	</script>


</head>

<body>
<div align="center">
欢迎来到黎光的网站 
<a  href="login.jsp;">请登录 </a> &nbsp &nbsp &nbsp  
<a  href="register.html;" rel="nofollow">免费注册</a>&nbsp &nbsp &nbsp
<a  href="background.jsp" rel="nofollow">后台</a>
<a  href="publicinfo.jsp" rel="nofollow">发布信息</a>

</div>


	<div style="height:100px;"></div>

	<!--导航 Start-->
	<div class="menu">
		<div class="all-sort">
			<h2>
				<a href="">全部商品分类</a>
			</h2>
		</div>
		<div class="ad">
			<a href=""> <img src="images/rBEhVlJEA84IAAAAAAAZY9Mm2-UAADmFQNaVy4AABl7123.jpg" width="141" height="40" />
			</a>
		</div>
		<div class="nav">
			<ul class="clearfix">
				<li><a href="http://www.jq22.com" class="current">首页</a></li>
				<li><a href="http://www.jq22.com">服装城</a></li>
				<li><a href="http://www.jq22.com">超市</a></li>
				<li><a href="http://www.jq22.com">团购</a></li>
				<li><a href="http://www.jq22.com">拍卖</a></li>
				<li><a href="http://www.jq22.com">在线游戏</a></li>
			</ul>
		</div>
	</div>
	<!--导航 End-->
	<!--所有分类 Start-->
	<div class="wrap">
		<div class="all-sort-list">
			
			<c:forEach items="${businessclasslist}" var="rec">
			
			<div class="item bo">
				<h3>
					<span>·</span><a href="">${rec.bclassname}</a>
				</h3>
				<div class="item-list clearfix">
					<div class="close">x</div>
					<div class="subitem">
						<dl class="fore1">
							<!-- <dt>
								<a href="#">电子书0</a>
							</dt> -->
							
							<dd>
								<c:forEach items="${businesslist}" var="bs"  varStatus="bstatus">
											<!-- <dt><a href="#">音像</a></dt> -->
											<c:if test="${bs.classid==rec.bclassid}"><em><a href="liguang/information!getInformationlistBybid.do?bid=${bs.bid}&&bname=${bs.bname}">${bs.bname}</a></em></c:if>
											<c:if test="${bstatus.count%4==0&&bs.classid==rec.bclassid}"><br clear=left></c:if>
								</c:forEach>
							</dd>
							
						</dl>
						
					</div>
					<div class="cat-right">
						<dl class="categorys-promotions" clstag="homepage|keycount|home2013|0601c">
							<dd>
								<ul>
									<li><a href="#"><img src="images/rBEhWFJTydgIAAAAAAAiD8_1J3AAAD5mAMC0SYAACIn230.jpg" width="194" height="70" title="特价书满减"></a></li>
									<li><a href="#"><img src="images/rBEhVlJTyt8IAAAAAAAiq1D-0D8AAD7_gIE2KUAACLD102.jpg" width="194" height="70" title="重磅独家"></a></li>
								</ul>
							</dd>
						</dl>
						<dl class="categorys-brands" clstag="homepage|keycount|home2013|0601d">
							<dt>推荐品牌出版商</dt>
							<dd>
								<ul>
									<li><a href="#">中华书局</a></li>
									<li><a href="#">人民邮电出版社</a></li>
									<li><a href="#">上海世纪出版股份有限公司</a></li>
									<li><a href="#">电子工业出版社</a></li>
									<li><a href="#">三联书店</a></li>
									<li><a href="#">浙江少年儿童出版社</a></li>
									<li><a href="#">人民文学出版社</a></li>
									<li><a href="#">外语教学与研究出版社</a></li>
									<li><a href="#">中信出版社</a></li>
									<li><a href="#">化学工业出版社</a></li>
									<li><a href="#">北京大学出版社</a></li>
								</ul>
							</dd>
						</dl>
					</div>
				</div>
			</div>


           </c:forEach>
			
		</div>
		<div class="center" align="center" id ="center">	
		
						<div id="example"class="margin-right: auto; margin-left: auto; ">
					<img src="images/new-ribbon.png" width="112" height="112" alt="New Ribbon" id="ribbon">
					<div id="slides">
						<div class="slides_container">
							<div>
								<a href="http://niutuku.com/" title="145.365 - Happy Bokeh Thursday! | Flickr - Photo Sharing!" target="_blank"><img src="images/slide-1.jpg" width="570" height="270" alt="Slide 1"></a>
								<div class="caption" style="bottom:0">
									<p>Happy Bokeh Thursday!</p>
								</div>
							</div>
							<div>
								<a href="http://niutuku.com/" title="Taxi | Flickr - Photo Sharing!" target="_blank"><img src="images/slide-2.jpg" width="570" height="270" alt="Slide 2"></a>
								<div class="caption">
									<p>Taxi</p>
								</div>
							</div>
							<div>
								<a href="http://niutuku.com/" title="Happy Bokeh raining Day | Flickr - Photo Sharing!" target="_blank"><img src="images/slide-3.jpg" width="570" height="270" alt="Slide 3"></a>
								<div class="caption">
									<p>Happy Bokeh raining Day</p>
								</div>
							</div>
							<div>
								<a href="http://niutuku.com/" title="We Eat Light | Flickr - Photo Sharing!" target="_blank"><img src="images/slide-4.jpg" width="570" height="270" alt="Slide 4"></a>
								<div class="caption">
									<p>We Eat Light</p>
								</div>
							</div>
							<div>
								<a href="http://www.lanrentuku.cn/" title="&ldquo;I must go down to the sea again, to the lonely sea and the sky; and all I ask is a tall ship and a star to steer her by.&rdquo; | Flickr - Photo Sharing!" target="_blank"><img src="images/slide-5.jpg" width="570" height="270" alt="Slide 5"></a>
								<div class="caption">
									<p>&ldquo;I must go down to the sea again, to the lonely sea and the sky...&rdquo;</p>
								</div>
							</div>
							<div>
								<a href="http://niutuku.com/" title="twelve.inch | Flickr - Photo Sharing!" target="_blank"><img src="images/slide-6.jpg" width="570" height="270" alt="Slide 6"></a>
								<div class="caption">
									<p>lanrentuku.com</p>
								</div>
							</div>
							<div>
								<a href="http://niutuku.com/" title="Save my love for loneliness | Flickr - Photo Sharing!" target="_blank"><img src="images/slide-7.jpg" width="570" height="270" alt="Slide 7"></a>
								<div class="caption">
									<p>Save my love for loneliness</p>
								</div>
							</div>
						</div>
						<a href="#" class="prev"><img src="images/arrow-prev.png" width="24" height="43" alt="Arrow Prev"></a>
						<a href="#" class="next"><img src="images/arrow-next.png" width="24" height="43" alt="Arrow Next"></a>
					</div>
				</div>
				<div id="footer">
					 
					<p></p>
				</div>
	
			</div>
		<div class= "right" >右侧</div>
	</div>
	<!--所有分类 End-->
	
	
	
	
	
	<script type="text/javascript">
		$('.all-sort-list > .item').hover(
				function() {
					var eq = $('.all-sort-list > .item').index(this), //获取当前滑过是第几个元素
					h = $('.all-sort-list').offset().top, //获取当前下拉菜单距离窗口多少像素
					s = $(window).scrollTop(), //获取游览器滚动了多少高度
					i = $(this).offset().top, //当前元素滑过距离窗口多少像素
					item = $(this).children('.item-list').height(), //下拉菜单子类内容容器的高度
					sort = $('.all-sort-list').height(); //父类分类列表容器的高度

					if (item < sort) { //如果子类的高度小于父类的高度
						if (eq == 0) {
							$(this).children('.item-list').css('top', (i - h));
						} else {
							$(this).children('.item-list').css('top',
									(i - h) + 1);
						}
					} else {
						if (s > h) { //判断子类的显示位置，如果滚动的高度大于所有分类列表容器的高度
							if (i - s > 0) { //则 继续判断当前滑过容器的位置 是否有一半超出窗口一半在窗口内显示的Bug,
								$(this).children('.item-list').css('top',
										(s - h) + 2);
							} else {
								$(this).children('.item-list').css('top',
										(s - h) - (-(i - s)) + 2);
							}
						} else {
							$(this).children('.item-list').css('top', 3);
						}
					}
					document.getElementById("center").style.display = "none";
					$(this).addClass('hover');
					$(this).children('.item-list').css('display', 'block');
				}, function() {
					document.getElementById("center").style.display = "block";
					$(this).removeClass('hover');
					$(this).children('.item-list').css('display', 'none');
				});

		$('.item > .item-list > .close').click(function() {
			$(this).parent().parent().removeClass('hover');
			$(this).parent().hide();
		});
	</script>

</body>
</html>
