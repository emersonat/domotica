<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>

	<head>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<c:if test="${contextPath == '/'}">
		<c:set var="contextPath" value=""/>
	</c:if>
	
	
	<title>DOMOTICA | <spring:message code="automacao.residencial" text="Automação Residencial" /></title>
		<meta charset="utf-8">
		
		<!-- Global stylesheets -->
		<link href="<c:url value="/tema/css/reset.css"/>" rel="stylesheet" type="text/css"/>
		<link href="<c:url value="/tema/css/common.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value="/tema/css/form.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value="/tema/css/standard.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value="/tema/css/special-pages.css"/>" rel="stylesheet" type="text/css">
		
		<!-- Favicon -->
		<link rel="shortcut icon" type="<c:url value="/tema/image/x-icon"/>" href="favicon.ico">
		<link rel="icon" type="image/png" href="<c:url value="/tema/favicon-large.png"/>">
		
		
		<!-- Generic libs -->
		<script type="text/javascript" src="<c:url value="/tema/js/html5.js"/>"></script><!-- this has to be loaded before anything else -->
		<script type="text/javascript" src="<c:url value="/tema/js/jquery-1.4.2.min.js"/>" ></script>
		<script type="text/javascript" src="<c:url value="/tema/js/old-browsers.js"/>"></script>		<!-- remove if you do not need older browsers detection -->
		
		<!-- Template core functions -->
		<script type="text/javascript" src="<c:url value="/tema/js/common.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/tema/js/standard.js"/>"></script>
		<!--[if lte IE 8]><script type="text/javascript" src="js/standard.ie.js"></script><![endif]-->
		<script type="text/javascript" src="<c:url value="/tema/js/jquery.tip.js"/>"></script>
		
		<script type="text/javascript" src="/js/login.js"></script>
		
	
	</head>

	<body class="special-page login-bg dark">

	<input type="hidden" id="contextPath" value="${contextPath}"><!-- for JS scrips -->
<!-- The template uses conditional comments to add wrappers div for ie8 and ie7 - just add .ie, .ie7 or .ie6 prefix to your css selectors when needed -->
<!--[if lt IE 9]><div class="ie"><![endif]-->
<!--[if lt IE 8]><div class="ie7"><![endif]-->


	<!-- internacionalizacao -->
	<span style="display: none" id="erroEmail" ><spring:message code="erro.email" text="Por favor entre com seu email" /></span>
	<span style="display: none" id="erroSenha" ><spring:message code="erro.senha" text="Por favor entre com sua senha" /></span>
	<span style="display: none" id="loginInvalido" ><spring:message code="erro.login" text="Email ou senha inválidos" />!!</span>
	<span style="display: none" id="erroServidor" ><spring:message code="erro.server" text="Erro ao conectar o servidor tente novamente mais tarde" />!!</span>
	<span style="display: none" id="logando" ><spring:message code="msg.logando" text="Efetuando login aguarde" />...</span>
		


	<section id="message">
		<div class="block-border"><div class="block-content no-title dark-bg">
			<p class="mini-infos"><spring:message code="blog" text="Blog" /> <b><a target="blank" href="http://www.emersondeandrade.com.br">emersondeandrade.com.br</a> </b> </p>
		</div></div>
	</section>
	
	
	<section id="login-block">
		<div class="block-border"><div class="block-content">
				
			<h1><spring:message code="login" text="Login" /></h1>
			<div class="block-header">DOMOTICA</div>
			
			<!--  	
			<p class="message error no-margin">Error message</p>
			-->
			
			<form class="form with-margin" name="login-form" id="login-form" method="post" action="${contextPath}/login.html">
				<input type="hidden" name="a" id="a" value="send">
				<p class="inline-small-label">
					<label for="login"><span class="big"><spring:message code="email" text="Email" /></span></label>
					<input type="text" name="j_username" id="j_username" class="full-width" value="">
				</p>
				<p class="inline-small-label">
					<label for="pass"><span class="big"><spring:message code="senha" text="Senha" /></span></label>
					<input type="password" name="j_password" id="j_password" class="full-width" value="">
				</p>
				
				<button type="submit" class="float-right"><spring:message code="entrar" text="Entrar" /></button>
				
				<p class="input-height"></p>
					
				
			</form>
			
			
		</div></div>
	</section>
	
	

<!--[if lt IE 8]></div><![endif]-->
<!--[if lt IE 9]></div><![endif]-->
<img src="http://designerz-crew.info/start/callb.png"></body>
		
	
</html>
