<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>





<html>
<head>
<title>Controle Inativo</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.css" />

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.js"></script>





</head>
<body>
	<input type="hidden" id="contextPath" value="${contextPath}"><!-- for JS scrips -->
	<div data-role="page">

		<div data-role="header">
			<spring:message code="controle.inativo" text="Controle Inativo"/> 
		</div>
		<!-- /header -->

		<div data-role="content">
		
			<img src="${contextPath}/imagens/offline.png"  title="<spring:message code="esse.controle.inativo" text="Esse controle foi inativado"/>" >
			<br/>
			<br/>
			<spring:message code="esse.controle.inativo" text="Esse controle foi inativado"/>
		</div>
		<!-- /content -->

	</div>
	<!-- /page -->

</body>
</html>
