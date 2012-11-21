
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
	<title>DOMOTICA - Controle</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.css" />
	
	<script type="text/javascript"	src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
	<script type="text/javascript"	src="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.js"></script>
		
		
	<script type="text/javascript" src="http://cloud.github.com/downloads/digitalBush/jquery.maskedinput/jquery.maskedinput-1.3.min.js"></script>	
		
	
</head>	

<body>
	
	<input type="hidden" id="contextPath" value="${contextPath}"><!-- for JS scrips -->	
	<tiles:insertAttribute name="body"/>
		
</body>	
	
</html>		


