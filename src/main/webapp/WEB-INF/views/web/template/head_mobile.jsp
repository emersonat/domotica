
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>
<html>

<head>
	<title>DOMOTICA | <spring:message code="automacao.residencial" text="Automação Residencial" /></title>
	<meta charset="utf-8">
	
	<!-- Mobile metas -->
	<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
	
	<!-- Those meta will turn your website into an app on the iPhone -->
	<meta name="apple-mobile-web-app-capable" content="yes">
	<link rel="apple-touch-startup-image" href="${contextPath}/tema/images/iphone_startup.png">
	
	<!-- Global stylesheets -->
	<link href="${contextPath}/css/principal.css" rel="stylesheet" type="text/css">
	<link href="${contextPath}/tema/css/reset.css" rel="stylesheet" type="text/css">
	<link href="${contextPath}/tema/css/common.css" rel="stylesheet" type="text/css">
	<link href="${contextPath}/tema/css/form.css" rel="stylesheet" type="text/css">
	<link href="${contextPath}/tema/css/mobile.css" rel="stylesheet" type="text/css">
	
	<!-- Custom styles -->
	<link href="${contextPath}/tema/css/block-lists.css" rel="stylesheet" type="text/css">
	
	
	<!-- Favicon -->
	<link rel="shortcut icon" type="image/x-icon" href="${contextPath}/tema/favicon.ico">
	<link rel="icon" type="image/png" href="${contextPath}/tema/favicon-large.png">
	<link rel="apple-touch-icon" href="${contextPath}/tema/apple-touch-icon.png"/>
	
	<!-- Generic libs -->
	<script type="text/javascript" src="${contextPath}/tema/js/jquery-1.4.2.min.js"></script>
	
	<!-- Template core functions -->
	<script type="text/javascript" src="${contextPath}/tema/js/common.js"></script>
	<script type="text/javascript" src="${contextPath}/tema/js/mobile.js"></script>
	<script type="text/javascript" src="${contextPath}/tema/js/jquery.tip.js"></script>
	 
	<script type="text/javascript" src="${contextPath}/js/principal.js"></script>
	
	
</head>	


<c:set var="showControls"><tiles:getAsString  name="showControls"/></c:set>  
		


<body class="dark">
	
	<header>
		<h1><spring:message code="domotica" text="Domotica"/></h1>
	</header>
	
	<c:if test="${showControls}">
		<a href="${contextPath}/mobile/verificaKey.html" id="back">Home</a>
			
		<div id="menu">
			<a href="#">Menu</a>
			
			<ul>
				<li>
					<a href="${contextPath}/mobile/listarHistorico.html"><spring:message code="historico" text="Histórico"/></a>
				</li>
				
				<li>
					<a href="${contextPath}/mobile/config/open.html"><spring:message code="configuracao" text="Configuração"/></a>
				</li>
				
			</ul>
		</div>
	</c:if>
	
	<div id="header-shadow"></div>
	
	
	 
	<div id="loading" >	</div>	
	<tiles:insertAttribute name="body"/>
	
	
		
	
	
</body>


	
</html>		


