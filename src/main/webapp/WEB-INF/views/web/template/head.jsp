<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<html>

	<head>
	
		<title>DOMOTICA | <spring:message code="automacao.residencial" text="Automação Residencial" /></title>
		<meta charset="utf-8">
		
		<!-- Global stylesheets -->
		<link href="/domotica/tema/css/reset.css" rel="stylesheet" type="text/css">
		<link href="/domotica/tema/css/common.css" rel="stylesheet" type="text/css">
		<link href="/domotica/tema/css/form.css" rel="stylesheet" type="text/css">
		<link href="/domotica/tema/css/standard.css" rel="stylesheet" type="text/css">
		
		<!-- Comment/uncomment one of these files to toggle between fixed and fluid layout -->
		<!--<link href="css/960.gs.css" rel="stylesheet" type="text/css">-->
		<link href="/domotica/tema/css/960.gs.fluid.css" rel="stylesheet" type="text/css">
		
		<!-- Custom styles -->
		<link href="/domotica/tema/css/simple-lists.css" rel="stylesheet" type="text/css">
		<link href="/domotica/tema/css/block-lists.css" rel="stylesheet" type="text/css">
		<link href="/domotica/tema/css/planning.css" rel="stylesheet" type="text/css">
		<link href="/domotica/tema/css/table.css" rel="stylesheet" type="text/css">
		<link href="/domotica/tema/css/calendars.css" rel="stylesheet" type="text/css">
		<link href="/domotica/tema/css/wizard.css" rel="stylesheet" type="text/css">
		<link href="/domotica/tema/css/gallery.css" rel="stylesheet" type="text/css">
		
		<!-- Favicon -->
		<link rel="shortcut icon" type="image/x-icon" href="/domotica/tema/favicon.ico">
		<link rel="icon" type="image/png" href="/domotica/tema/favicon-large.png">
		
		<!-- Generic libs -->
		<script type="text/javascript" src="/domotica/tema/js/html5.js"></script>				<!-- this has to be loaded before anything else -->
		<script type="text/javascript" src="/domotica/tema/js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="/domotica/tema/js/old-browsers.js"></script>		<!-- remove if you do not need older browsers detection -->
		
		<!-- Template libs -->
		<script type="text/javascript" src="/domotica/tema/js/jquery.accessibleList.js"></script>
		<script type="text/javascript" src="/domotica/tema/js/searchField.js"></script>
		<script type="text/javascript" src="/domotica/tema/js/common.js"></script>
		<script type="text/javascript" src="/domotica/tema/js/standard.js"></script>
		<!--[if lte IE 8]><script type="text/javascript" src="js/standard.ie.js"></script><![endif]-->
		<script type="text/javascript" src="/domotica/tema/js/jquery.tip.js"></script>
		<script type="text/javascript" src="/domotica/tema/js/jquery.hashchange.js"></script>
		<script type="text/javascript" src="/domotica/tema/js/jquery.contextMenu.js"></script>
		
		<!-- Custom styles lib -->
		<script type="text/javascript" src="/domotica/tema/js/list.js"></script>
		
		<!-- Charts library -->
		<!--Load the AJAX API-->
		<script type="text/javascript" src="http://www.google.com/jsapi"></script>
		<script type="text/javascript">
		
			// Load the Visualization API and the piechart package.
			google.load('visualization', '1', {'packages':['corechart']});
			
		</script>
		
		
	</head>
	
	
	<body> 
	
	
	<!-- Main nav -->
	<nav id="main-nav">
		
		<ul class="container_12">
			<li class="home current"><a href="#" title="Home">Home</a>
				<ul>
					<li class="with-menu"><a href="#" title="<spring:message code="trocar.casa" text="Trocar de casa"/>">${user.casaDefault.nome}</a>
						<div class="menu">
							<img src="/domotica/tema/images/menu-open-arrow.png" width="16" height="16">
							<ul>
							
							<c:forEach items="${user.casas}" var="casa">								
								<li class="icon_refresh"><a href="#">${casa.nome}</a></li>
							</c:forEach>	
								
							</ul>
						</div>
					</li>
				</ul>
			</li>
			
		</ul>
	</nav>
	<!-- End main nav -->
	
	
	<!-- Sub nav -->
	<div id="sub-nav">
		<div class="container_12">
		
		
		</div>
	</div>
	<!-- End sub nav -->
		
	
		<!-- Status bar -->
		<div id="status-bar">
			<div class="container_12">
				<ul id="status-infos">
					<li class="spaced"><spring:message code="usuario" text="Usuario"/>: <strong>${user.nome}</strong></li>
					<li><a href="login.html" class="button red" title="Logout"><span class="smaller">LOGOUT</span></a></li>
				</ul>
			</div>
		</div>
	
		
	
		<tiles:insertAttribute name="body"/>
		
		
			
	</body>
		
	
</html>

