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
	<!-- Microsoft clear type rendering -->
	<meta http-equiv="cleartype" content="on">
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
	<link rel="stylesheet" href="<%=WEBPATH %>/js/libs/formValidator/developr.validationEngine.css?v=1">
	
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

</head>

<body class="clearfix with-menu with-shortcuts" onload="javascript: document.getElementById('loginName').focus();">
	<div class="six-columns twelve-columns-tablet">
		<h3 class="thin underline">Add User</h3>
		<form name="myForm" id="myForm" method="post" action="" class="columns" onsubmit="return false">
			<p class="inline-small-label button-height">
				<label for="loginName" class="label" style="width: 150px; text-align: right; margin-right: 10px;">Login Name</label>
				<input style="margin-bottom: 10px;" type="text" name="loginName" id="loginName" placeholder="Login Name" autocomplete="off" class="input validate[required]" value="" data-tooltip-options="{&quot;position&quot;:&quot;right&quot;}">
				<br />
				<label for="enName" class="label" style="width: 150px; text-align: right; margin-right: 10px;">English Name</label>
				<input style="margin-bottom: 10px;" type="text" name="enName" id="enName" placeholder="English Name" autocomplete="off" class="input validate[required]" value="" data-tooltip-options="{&quot;position&quot;:&quot;right&quot;}">
				<br />
				<label for="chnName" class="label" style="width: 150px; text-align: right; margin-right: 10px;">Chinese Name</label>
				<input style="margin-bottom: 10px;" type="text" name="chnName" id="chnName" placeholder="Chinese Name" autocomplete="off" class="input validate[required]" value="" data-tooltip-options="{&quot;position&quot;:&quot;right&quot;}">
				<br />
				<label for="joinDate" class="label" style="width: 150px; text-align: right; margin-right: 10px;">Join Date</label>
				<input style="margin-bottom: 10px;" type="text" name="joinDate" id="joinDate" placeholder="Join Date" autocomplete="off" class="input validate[required]" value="" data-tooltip-options="{&quot;position&quot;:&quot;right&quot;}">
				<br />
				<label for="wechat" class="label" style="width: 150px; text-align: right; margin-right: 10px;">Wechat</label>
				<input style="margin-bottom: 10px;" type="text" name="wechat" id="wechat" placeholder="Wechat" autocomplete="off" class="input validate[required]" value="" data-tooltip-options="{&quot;position&quot;:&quot;right&quot;}">
				<br />
				<label for="age" class="label" style="width: 150px; text-align: right; margin-right: 10px;">Age</label>
				<span class="number input margin-right" style="margin-bottom: 10px;">
					<button type="button" class="button number-down">-</button>
					<input type="text" name="age" id="age" value="0" size="4" class="input-unstyled validate[required,min[1],max[100]]">
					<button type="button" class="button number-up">+</button>
				</span>
				<br />
				<label for="gender" class="label" style="width: 150px; text-align: right; margin-right: 10px;">Gender</label>
				<select id="gender" name="gender" class="select" style="margin-bottom: 10px;">
					<option value="0" selected="selected">Male</option>
					<option value="1">Female</option>
				</select>
				<br />
				<label for="addr" class="label" style="width: 150px; text-align: right; margin-right: 10px; margin-top: 10px;">Address</label>
				<input style="margin-bottom: 10px; margin-top: 10px; width: 300px;" type="text" name="addr" id="addr" placeholder="Address" autocomplete="off" class="input" value="" data-tooltip-options="{&quot;position&quot;:&quot;right&quot;}">
				<br />
				<label for="email" class="label" style="width: 150px; text-align: right; margin-right: 10px;">Email</label>
				<input style="margin-bottom: 10px; width: 300px;" type="text" name="email" id="email" placeholder="Email" autocomplete="off" class="input validate[required,custom[email]]" value="" data-tooltip-options="{&quot;position&quot;:&quot;right&quot;}">
				<br />
				<label for="tel" class="label" style="width: 150px; text-align: right; margin-right: 10px;">Contact Number</label>
				<input style="margin-bottom: 10px; width: 300px;" type="text" name="tel" id="tel" placeholder="Contact Number" autocomplete="off" class="input validate[required]" value="" data-tooltip-options="{&quot;position&quot;:&quot;right&quot;}">
				<br />
				<label for="roleCode" class="label" style="width: 150px; text-align: right; margin-right: 10px;">Role</label>
				<select id="roleCode" name="roleCode" class="select" style="margin-bottom: 10px;">
					<c:forEach items="${roleList}" var="p">
						<c:choose>
							<c:when test="${p.itemNO == 'RC0002'}">
								<option value="${p.itemNO }" selected="selected">${p.itemName }</option>
							</c:when>
							<c:otherwise>
								<option value="${p.itemNO }">${p.itemName }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<br />
				<label for="officer" class="label" style="width: 150px; text-align: right; margin-right: 10px;">Officer</label>
				<select id="officer" name="officer" class="select" style="margin-bottom: 10px;">
					<c:forEach items="${officerList}" var="p">
						<c:choose>
							<c:when test="${p.itemNO == 'OC9999'}">
								<option value="${p.itemNO }" selected="selected">${p.itemName }</option>
							</c:when>
							<c:otherwise>
								<option value="${p.itemNO }">${p.itemName }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<br />
				<label for="area" class="label" style="width: 150px; text-align: right; margin-right: 10px;">Area</label>
				<select id="area" name="area" class="select" style="margin-bottom: 10px;">
					<c:forEach items="${areaList}" var="p">
						<c:choose>
							<c:when test="${p.itemNO == 'AC0000'}">
								<option value="${p.itemNO }" selected="selected">${p.itemName }</option>
							</c:when>
							<c:otherwise>
								<option value="${p.itemNO }">${p.itemName }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<br />
				<label for="club" class="label" style="width: 150px; text-align: right; margin-right: 10px;">Club</label>
				<select id="club" name="club" class="select" style="margin-bottom: 10px;">
					<c:forEach items="${clubList}" var="p">
						<c:choose>
							<c:when test="${p.clubNO == 'CN000001'}">
								<option value="${p.clubNO }" selected="selected">${p.clubName }</option>
							</c:when>
							<c:otherwise>
								<option value="${p.clubNO }">${p.clubName }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<br />
				<label for="remark" class="label" style="width: 150px; text-align: right; margin-right: 10px; margin-top: 10px;">Remark</label>
				<textarea class="input autoexpanding" rows="10" cols="40" placeholder="Remark" style="margin-top: 10px;"></textarea>
			</p>
		</form>
	</div>
	<!-- Scripts -->
	<script src="<%=WEBPATH %>/js/libs/jquery-1.8.2.min.js"></script>
	<script src="<%=WEBPATH %>/js/setup.js"></script>

	<!-- Template functions -->
	<script src="<%=WEBPATH %>/js/developr.input.js"></script>
	<script src="<%=WEBPATH %>/js/developr.navigable.js"></script>
	<script src="<%=WEBPATH %>/js/developr.notify.js"></script>
	<script src="<%=WEBPATH %>/js/developr.scroll.js"></script>
	<script src="<%=WEBPATH %>/js/developr.tooltip.js"></script>

	<!-- glDatePicker -->
	<script src="<%=WEBPATH %>/js/libs/glDatePicker/glDatePicker.min.js?v=1"></script>

	<!-- jQuery Form Validation -->
	<script src="<%=WEBPATH %>/js/libs/formValidator/jquery.validationEngine.js?v=1"></script>
	<script src="<%=WEBPATH %>/js/libs/formValidator/languages/jquery.validationEngine-en.js?v=1"></script>
	<script type="text/javascript">
		$.template.init();
		// Form validation
		$('form').validationEngine();
		
		function save() {
			$('form').submit();
		}
		
		
	</script>
</body>
</html>