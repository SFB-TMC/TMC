<%@ include file="header/header.jsp" %>
<!DOCTYPE html>

<!--[if IEMobile 7]><html class="no-js iem7 oldie linen"><![endif]-->
<!--[if (IE 7)&!(IEMobile)]><html class="no-js ie7 oldie linen" lang="en"><![endif]-->
<!--[if (IE 8)&!(IEMobile)]><html class="no-js ie8 oldie linen" lang="en"><![endif]-->
<!--[if (IE 9)&!(IEMobile)]><html class="no-js ie9 linen" lang="en"><![endif]-->
<!--[if (gt IE 9)|(gt IEMobile 7)]><!--><html class="no-js linen" lang="en"><!--<![endif]-->

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

	<title>Toastmasters Web</title>
	<meta name="description" content="">
	<meta name="author" content="">

	<!-- http://davidbcalhoun.com/2010/viewport-metatag -->
	<meta name="HandheldFriendly" content="True">
	<meta name="MobileOptimized" content="320">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<!-- For all browsers -->
	<link rel="stylesheet" href="<%=WEBPATH %>/css/reset.css?v=1">
	<link rel="stylesheet" href="<%=WEBPATH %>/css/style.css?v=1">
	<link rel="stylesheet" href="<%=WEBPATH %>/css/colors.css?v=1">
	<link rel="stylesheet" media="print" href="<%=WEBPATH %>/css/print.css?v=1">
	<!-- For progressively larger displays -->
	<link rel="stylesheet" media="only all and (min-width: 480px)" href="<%=WEBPATH %>/css/480.css?v=1">
	<link rel="stylesheet" media="only all and (min-width: 768px)" href="<%=WEBPATH %>/css/768.css?v=1">
	<link rel="stylesheet" media="only all and (min-width: 992px)" href="<%=WEBPATH %>/css/992.css?v=1">
	<link rel="stylesheet" media="only all and (min-width: 1200px)" href="<%=WEBPATH %>/css/1200.css?v=1">
	<!-- For Retina displays -->
	<link rel="stylesheet" media="only all and (-webkit-min-device-pixel-ratio: 1.5), only screen and (-o-min-device-pixel-ratio: 3/2), only screen and (min-device-pixel-ratio: 1.5)" href="<%=WEBPATH %>/css/2x.css?v=1">

	<!-- Additional styles -->
	<link rel="stylesheet" href="<%=WEBPATH %>/css/styles/form.css?v=1">
	<link rel="stylesheet" href="<%=WEBPATH %>/css/styles/switches.css?v=1">

	<!-- Login pages styles -->
	<link rel="stylesheet" media="screen" href="<%=WEBPATH %>/css/login.css?v=1">

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

	<!-- IE9 Pinned Sites: http://msdn.microsoft.com/en-us/library/gg131029.aspx -->
	<meta name="application-name" content="Developr Admin Skin">
	<meta name="msapplication-tooltip" content="Cross-platform admin template.">
	<meta name="msapplication-starturl" content="http://www.display-inline.fr/demo/developr">
	<!-- These custom tasks are examples, you need to edit them to show actual pages -->
	<meta name="msapplication-task" content="name=Agenda;action-uri=http://www.display-inline.fr/demo/developr/agenda.html;icon-uri=http://www.display-inline.fr/demo/developr/img/favicons/favicon.ico">
	<meta name="msapplication-task" content="name=My profile;action-uri=http://www.display-inline.fr/demo/developr/profile.html;icon-uri=http://www.display-inline.fr/demo/developr/img/favicons/favicon.ico">
</head>

<body onload="javascript: document.getElementById('username').focus();">

	<div id="container">

		<hgroup id="login-title" class="large-margin-bottom">
			<h1 class="login-title-image">&nbsp;</h1>
			<h5>&copy; Toastmaster</h5>
		</hgroup>

		<form method="post" action="" id="form-login">
			<ul class="inputs black-input large">
				<li><span class="icon-user mid-margin-right"></span><input type="text" name="username" id="username" value="" class="input-unstyled" placeholder="Username" autocomplete="off"></li>
				<li><span class="icon-lock mid-margin-right"></span><input type="password" name="password" id="password" value="" class="input-unstyled" placeholder="Password" autocomplete="off"></li>
			</ul>

			<button type="submit" class="button glossy full-width huge">Login</button>
		</form>

	</div>

	<!-- JavaScript at the bottom for fast page loading -->

	<!-- Scripts -->
	<script src="<%=WEBPATH %>/js/libs/jquery-1.8.2.min.js"></script>
	<script src="<%=WEBPATH %>/js/setup.js"></script>

	<!-- Template functions -->
	<script src="<%=WEBPATH %>/js/developr.input.js"></script>
	<script src="<%=WEBPATH %>/js/developr.message.js"></script>
	<script src="<%=WEBPATH %>/js/developr.notify.js"></script>
	<script src="<%=WEBPATH %>/js/developr.tooltip.js"></script>

	<script>

		$(document).ready(function() {
			/*
			 * JS login effect
			 * This script will enable effects for the login page
			 */
				// Elements
			var doc = $('html').addClass('js-login'),
				container = $('#container'),
				formLogin = $('#form-login'),

				// If layout is centered
				centered;

			/******* EDIT THIS SECTION *******/
			formLogin.submit(function(event) {
				// Values
				var login = $.trim($('#username').val());
				var pass = $.trim($('#password').val());

				// Check inputs
				if (login.length === 0) {
					// Display message
					displayError('Please fill in your login');
					return false;
				} else if (pass.length === 0) {
					// Remove empty login message if displayed
					formLogin.clearMessages('Please fill in your login');

					// Display message
					displayError('Please fill in your password');
					return false;
				} else {
					// Remove previous messages
					formLogin.clearMessages();

					// Show progress
					displayLoading('Checking credentials...');
					event.preventDefault();

					// Stop normal behavior
					event.preventDefault();

					// Login
					var url = "<%=WEBPATH %>/tmw/login";
					
					$.ajax(url, {
							data: {
								"username": login,
								"password": pass
							},
							type: "POST",
							dataType: "json",  
							async: false,
							success: function(data) {
								if (data.res) {
									document.location.href = '<%=WEBPATH %>/tmw/menu/home';
								} else {
									formLogin.clearMessages();
									displayError('Error Login Information, please try again');
								}
							},
							error: function() {
								formLogin.clearMessages();
								displayError('Error while contacting server, please try again');
							}
					});


					// Simulate server-side check
					/* setTimeout(function() {
						document.location.href = './'
					}, 2000); */
				}
			});

			/******* END OF EDIT SECTION *******/

			// Handle resizing (mostly for debugging)
			function handleLoginResize() {
				// Detect mode
				centered = (container.css('position') === 'absolute');

				// Set min-height for mobile layout
				if (!centered) {
					container.css('margin-top', '');
				} else {
					if (parseInt(container.css('margin-top'), 10) === 0) {
						centerForm(false);
					}
				}
			};

			// Register and first call
			$(window).bind('normalized-resize', handleLoginResize);
			handleLoginResize();

			/*
			 * Center function
			 * @param boolean animate whether or not to animate the position change
			 * @param string|element|array any jQuery selector, DOM element or set of DOM elements which should be ignored
			 * @return void
			 */
			function centerForm(animate, ignore) {
				// If layout is centered
				if (centered) {
					var siblings = formLogin.siblings(),
						finalSize = formLogin.outerHeight();

					// Ignored elements
					if (ignore) {
						siblings = siblings.not(ignore);
					}

					// Get other elements height
					siblings.each(function(i) {
						finalSize += $(this).outerHeight(true);
					});

					// Setup
					container[animate ? 'animate' : 'css']({ marginTop: -Math.round(finalSize/2)+'px' });
				}
			};

			// Initial vertical adjust
			centerForm(false);

			/**
			 * Function to display error messages
			 * @param string message the error to display
			 */
			function displayError(message) {
				// Show message
				var message = formLogin.message(message, {
					append: false,
					arrow: 'bottom',
					classes: ['red-gradient'],
					animate: false					// We'll do animation later, we need to know the message height first
				});

				// Vertical centering (where we need the message height)
				centerForm(true, 'fast');

				// Watch for closing and show with effect
				message.bind('endfade', function(event) {
					// This will be called once the message has faded away and is removed
					centerForm(true, message.get(0));

				}).hide().slideDown('fast');
			}

			/**
			 * Function to display loading messages
			 * @param string message the message to display
			 */
			function displayLoading(message) {
				// Show message
				var message = formLogin.message('<strong>'+message+'</strong>', {
					append: false,
					arrow: 'bottom',
					classes: ['blue-gradient', 'align-center'],
					stripes: true,
					darkStripes: false,
					closable: false,
					animate: false					// We'll do animation later, we need to know the message height first
				});

				// Vertical centering (where we need the message height)
				centerForm(true, 'fast');

				// Watch for closing and show with effect
				message.bind('endfade', function(event) {
					// This will be called once the message has faded away and is removed
					centerForm(true, message.get(0));

				}).hide().slideDown('fast');
			}
		});

		<%-- // What about a notification?
		notify('Alternate login', 'Want to see another login page style? Try the <a href="login-box.html"><b>box version</b></a> or the <a href="login-full.html"><b>full version</b></a>.', {
			autoClose: false,
			delay: 2500,
			icon: '<%=WEBPATH %>/img/demo/icon.png'
		}); --%>

	</script>

</body>
</html>