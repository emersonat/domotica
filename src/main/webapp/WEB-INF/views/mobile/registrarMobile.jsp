<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>

<html lang="en">
<head>

	<title>Constellation Admin Skin</title>
	<meta charset="utf-8">
	
	<!-- Mobile metas -->
	<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
	
	<!-- Those meta will turn your website into an app on the iPhone -->
	<meta name="apple-mobile-web-app-capable" content="yes">
	<link rel="apple-touch-startup-image" href="${contextPath}/tema/images/iphone_startup.png">
	
	<!-- Global stylesheets -->
	<link href="${contextPath}/tema/css/reset.css" rel="stylesheet" type="text/css">
	<link href="${contextPath}/tema/css/common.css" rel="stylesheet" type="text/css">
	<link href="${contextPath}/tema/css/form.css" rel="stylesheet" type="text/css">
	<link href="${contextPath}/tema/css/mobile.css" rel="stylesheet" type="text/css">
	
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
	
</head>

<body class="dark">
	
	<header>
		<h1><spring:message code="domotica" text="Domotica"/></h1>
	</header>
		
	<div id="header-shadow"></div>
	
	<article>
		
	  <section id="login-block">
		<div class="block-border">
			
			<form:form action="${contextPath}/mobile/registra.html" method="post" commandName="formRegistro" cssClass="form block-content">
							
				<h1><spring:message code="registrar.controle" text="Registrar controle"/></h1>
				<span style="color: red;">${erro}</span><br/><br/> 
				 <p>
					<label for="key"><form:errors cssStyle="color:red;" path="key"/> <spring:message code="codigo.arduino" text="Codigo central"/>:</label>
					<form:input path="key" type="password" id="key"  maxlength="32" size="32"  cssClass="full-width" />
				</p>
				<p>
					<label for="nomeDispositivo"><form:errors cssStyle="color:red;" path="nomeDispositivo"/> <spring:message code="nome.controle" text="Nome do controle"/>:</label>
					<form:input path="nomeDispositivo" type="text" id="nomeDispositivo"  maxlength="50" size="50"  cssClass="full-width"  />
				</p>
							
				<p><button type="submit" class="full-width"><spring:message code="registrar" text="Registrar"/></button></p>
				
			</form:form>
			</div>
		</section>
		
	</article>
	

</html>

