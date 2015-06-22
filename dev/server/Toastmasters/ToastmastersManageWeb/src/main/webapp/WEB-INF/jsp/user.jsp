<%@ include file="header/header.jsp" %>
<!DOCTYPE html>

<!--[if IEMobile 7]><html class="no-js iem7 oldie"><![endif]-->
<!--[if (IE 7)&!(IEMobile)]><html class="no-js ie7 oldie" lang="en"><![endif]-->
<!--[if (IE 8)&!(IEMobile)]><html class="no-js ie8 oldie" lang="en"><![endif]-->
<!--[if (IE 9)&!(IEMobile)]><html class="no-js ie9" lang="en"><![endif]-->
<!--[if (gt IE 9)|(gt IEMobile 7)]><!--><html class="no-js" lang="en"><!--<![endif]-->

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

	<title>Toastmasters Web</title>
	<meta name="description" content="">
	<meta name="author" content="">

	<meta name="HandheldFriendly" content="True">
	<meta name="MobileOptimized" content="320">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<!-- For all browsers -->
	<link rel="stylesheet" href="<%=WEBPATH %>/css/reset.css?v=1">
	<link rel="stylesheet" href="<%=WEBPATH %>/css/style.css?v=1">
	<link rel="stylesheet" href="<%=WEBPATH %>/css/colors.css?v=1">
	<link rel="stylesheet" href="<%=WEBPATH %>/css/styles/modal.css?v=1">
	
	<link rel="stylesheet" media="print" href="<%=WEBPATH %>/css/print.css?v=1">
	<!-- For progressively larger displays -->
	<link rel="stylesheet" media="only all and (min-width: 480px)" href="<%=WEBPATH %>/css/480.css?v=1">
	<link rel="stylesheet" media="only all and (min-width: 768px)" href="<%=WEBPATH %>/css/768.css?v=1">
	<link rel="stylesheet" media="only all and (min-width: 992px)" href="<%=WEBPATH %>/css/992.css?v=1">
	<link rel="stylesheet" media="only all and (min-width: 1200px)" href="<%=WEBPATH %>/css/1200.css?v=1">
	<!-- For Retina displays -->
	<link rel="stylesheet" media="only all and (-webkit-min-device-pixel-ratio: 1.5), only screen and (-o-min-device-pixel-ratio: 3/2), only screen and (min-device-pixel-ratio: 1.5)" href="<%=WEBPATH %>/css/2x.css?v=1">

	<!-- Webfonts -->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>

	<!-- Additional styles -->
	<link rel="stylesheet" href="<%=WEBPATH %>/css/styles/form.css?v=1">
	<link rel="stylesheet" href="<%=WEBPATH %>/css/styles/switches.css?v=1">
	<link rel="stylesheet" href="<%=WEBPATH %>/css/styles/table.css?v=1">

	<!-- DataTables -->
	<link rel="stylesheet" href="<%=WEBPATH %>/js/libs/DataTables/jquery.dataTables.css?v=1">

	<!-- JavaScript at bottom except for Modernizr -->
	<script src="<%=WEBPATH %>/js/libs/modernizr.custom.js"></script>

	<!-- For Modern Browsers -->
	<link rel="shortcut icon" href="<%=WEBPATH %>/img/favicons/favicon.png">
	<!-- For everything else -->
	<link rel="shortcut icon" href="<%=WEBPATH %>/img/favicons/favicon.ico">
	<!-- For retina screens -->
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=WEBPATH %>/img/favicons/apple-touch-icon-retina.png">
	<!-- For iPad 1-->
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=WEBPATH %>/img/favicons/apple-touch-icon-ipad.png">
	<!-- For iPhone 3G, iPod Touch and Android -->
	<link rel="apple-touch-icon-precomposed" href="<%=WEBPATH %>/img/favicons/apple-touch-icon.png">

	<!-- iOS web-app metas -->
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<!-- Startup image for web apps -->
	<link rel="apple-touch-startup-image" href="<%=WEBPATH %>/img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
	<link rel="apple-touch-startup-image" href="<%=WEBPATH %>/img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
	<link rel="apple-touch-startup-image" href="<%=WEBPATH %>/img/splash/iphone.png" media="screen and (max-device-width: 320px)">

	<!-- Microsoft clear type rendering -->
	<meta http-equiv="cleartype" content="on">
</head>

<body class="clearfix with-menu with-shortcuts">

	<!-- Prompt IE 6 users to install Chrome Frame -->
	<!--[if lt IE 7]><p class="message red-gradient simpler">Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->

	<!-- Title bar -->
	<header role="banner" id="title-bar">
		<h2>Toastmasters Web -- ${userInfo.enName }(${userInfo.chnName })</h2>
	</header>

	<!-- Button to open/hide menu -->
	<a href="#" id="open-menu"><span>Menu</span></a>

	<!-- Button to open/hide shortcuts -->
	<a href="#" id="open-shortcuts"><span class="icon-thumbs"></span></a>

	<!-- Main content -->
	<section role="main" id="main">

		<noscript class="message black-gradient simpler">Your browser does not support JavaScript! Some features won't work as expected...</noscript>

		<hgroup id="main-title" class="thin">
			<h1>User Contract</h1>
		</hgroup>

		<div class="with-padding">

			<p class="wrapped left-icon icon-info-round">
				User Contract is added by admin and super admin!
			</p>

			<div class="widget-box table-responsive">
				<div class="tab_con mtop1">
					<div style="width: 100%" id="myTable"></div>
				</div>
			</div>
		</div>

	</section>
	<!-- End main content -->

	<!-- Side tabs shortcuts -->
	<ul id="shortcuts" role="complementary" class="children-tooltip tooltip-right">
		<c:forEach items="${menuList}" var="p">
			<c:choose>
				<c:when test="${p.menuName == 'Users'}">
					<li class="current">
				</c:when>
				<c:otherwise>
					<li>
				</c:otherwise>
			</c:choose>
			<a href="<%=WEBPATH %>${p.menuURL }" class="${p.menucss }" title="${p.menuTitle }">${p.menuName }</a>
			</li>
		</c:forEach>
	</ul>

	<!-- Sidebar/drop-down menu -->
	<section id="menu" role="complementary">

		<!-- This wrapper is used by several responsive layouts -->
		<div id="menu-content">

			<header>
				${userInfo.enName }(${userInfo.chnName })
			</header>
			
			<div id="profile">
				<img src="<%=WEBPATH %>/img/user.png" width="64" height="64" alt="User name" class="user-icon">
				Hello
				<span class="name"><b>Admin</b></span>
			</div>

			<ul id="access" class="children-tooltip">
				<li><a href="javascript:void(0);" title="Profile"><span class="icon-user"></span></a></li>
				<li class="disabled"><span class="icon-gear"></span></li>
			</ul>

			<ul class="unstyled-list">
				<li class="title-menu">Today's event</li>
				<li>
					<ul class="calendar-menu">
						<li>
							<a href="#" title="See event">
								<time datetime="2011-02-24"><b>24</b> Feb</time>
								<small class="green">10:30</small>
								Event's description
							</a>
						</li>
					</ul>
				</li>
				<li class="title-menu">New messages</li>
				<li>
					<ul class="message-menu">
						<li>
							<span class="message-status">
								<a href="#" class="starred" title="Starred">Starred</a>
								<a href="#" class="new-message" title="Mark as read">New</a>
							</span>
							<span class="message-info">
								<span class="blue">17:12</span>
								<a href="#" class="attach" title="Download attachment">Attachment</a>
							</span>
							<a href="#" title="Read message">
								<strong class="blue">Admin</strong><br>
								<strong>Mail subject</strong>
							</a>
						</li>
						<li>
							<a href="#" title="Read message">
								<span class="message-status">
									<span class="unstarred">Not starred</span>
									<span class="new-message">New</span>
								</span>
								<span class="message-info">
									<span class="blue">15:47</span>
								</span>
								<strong class="blue">May Starck</strong><br>
								<strong>Mail subject a bit longer</strong>
							</a>
						</li>
						<li>
							<span class="message-status">
								<span class="unstarred">Not starred</span>
							</span>
							<span class="message-info">
								<span class="blue">15:12</span>
							</span>
							<strong class="blue">May Starck</strong><br>
							Read message
						</li>
					</ul>
				</li>
			</ul>

		</div>
		<!-- End content wrapper -->
	</section>
	<!-- End sidebar/drop-down menu -->

	<!-- JavaScript at the bottom for fast page loading -->

	<!-- Scripts -->
	<script src="<%=WEBPATH %>/js/libs/jquery-1.8.2.min.js"></script>
	<script src="<%=WEBPATH %>/js/setup.js"></script>

	<!-- Template functions -->
	<script src="<%=WEBPATH %>/js/developr.input.js"></script>
	<script src="<%=WEBPATH %>/js/developr.navigable.js"></script>
	<script src="<%=WEBPATH %>/js/developr.notify.js"></script>
	<script src="<%=WEBPATH %>/js/developr.scroll.js"></script>
	<script src="<%=WEBPATH %>/js/developr.tooltip.js"></script>
	<script src="<%=WEBPATH %>/js/developr.table.js"></script>
	<script src="<%=WEBPATH %>/js/developr.message.js"></script>
	<script src="<%=WEBPATH %>/js/developr.progress-slider.js"></script>
	<script src="<%=WEBPATH %>/js/developr.modal.js"></script>
	<script src="<%=WEBPATH %>/js/developr.tabs.js"></script>
	<!-- Plugins -->
	<script src="<%=WEBPATH %>/js/table.js"></script>
	<script src="<%=WEBPATH %>/js/libs/jquery.tablesorter.min.js"></script>
	<script src="<%=WEBPATH %>/js/libs/DataTables/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
	$.template.init();
	
	function init() {
		initTableNow("myTable", "<%=WEBPATH %>/tmw/userlist", null, 
				[ "<input type=\"checkbox\" name=\"checkAll\" id=\"checkAll\" />", "<div style='text-align: left;'>User Name</div>", "<div style='text-align: left;'>Join Date</div>", "<div style='text-align: left;'>Status</div>", "<div style='text-align: left;'>Tags</div>", "<div style='text-align: left;'>Actions</div>"],
				[ "", "", "15%", "15%", "15%", "100"], 
				[ "check", "enName", "joinDate", "status", "tags", "actions"]
		);
	}
	
	function check(json) {
		
		var tmp = "<input type=\"checkbox\" name=\"cb\" id=\"check" + json.id + "\" title=\"check" + json.id + "\" />";
		return tmp;
	}
	
	function enName(json) {
		
		var tmp = json.enName + "(" + json.chnName + ")";
		return tmp;
	}
	
	function status(json) {
		
		var tmp = "";
		var status = json.status;
		if (status == 0) {
			tmp = "Regular";
		} else if (status == -1) {
			tmp = "Forbidden";
		} else {
			tmp = "Unknown";
		}
		return tmp;
	}
	
	function tags(json) {
		
		var tmp = "<small class=\"tag\">" + json.roleName + "</small>";
		return tmp;
	}
	
	function actions(json) {
		
		var tmp = "<span class=\"select compact full-width\" tabindex=\"0\">" 
			+ "<a href=\"javascript:void(0);\" class=\"select-value\">Edit</a><span class=\"select-arrow\">" 
			+ "</span><span class=\"drop-down\"><a href=\"javascript:void(0);\">Put offline</a>" 
			+ "<a href=\"javascript:void(0);\">Review</a><a href=\"#\">Put to trash</a>" 
			+ "<a href=\"javascript:void(0);\">Delete</a></span></span>";
		return tmp;
	}
	
	function queryData() {
		var searchCondition = $("#searchCondition").val();
		var str = {"searchCondition": searchCondition};
		setParmAndSelect(str); 
	}
	
	$(document).ready(function () {
		$("#myTable").hide;
	  	$("#query").click(function(){
			$("#myTable").show();
		});

		init();
	});
	
	$(function() { 
		$(document).keydown(function(event) { 
			if(event.keyCode == 13 && document.activeElement.id == "searchCondition") {
				queryData();
			} 
		});
	}); 
	
	function openUserFrame() {
		
		<%-- $.modal({
			title: 'Add User',
			url: '<%=WEBPATH %>/tmw/userinfo',
			useIframe: true,
			width: 600,
			height: 400
		}); --%>
		$.modal({
			id: "UserInfo",
			name: "UserInfo",
			title: 'Add User',
			url: '<%=WEBPATH %>/tmw/userinfo',
			useIframe: true,
			width: 700,
			height: 400,
			buttons: {
				"Save" : {
					classes : 'button-icon',
					click : function () {
						window.frames['UserInfo'].save();
					}
				},
				"Close" : {
					classes : 'green-gradient',
					click : function (win) {
						win.closeModal();
					}
				}
			}
		});
	}
	</script>
</body>
</html>