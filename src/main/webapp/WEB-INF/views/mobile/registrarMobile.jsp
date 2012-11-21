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
<title>Registrar dispositivo</title>
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
			Registrar dispositivo
		</div>
		<!-- /header -->

		<div data-role="content">
		
		<span style="color: red;">${erro}</span><br/>	
		<form:form action="${contextPath}/mobile/registra.html" method="post" commandName="formRegistro" >
		
			  					
			 <label for="key"><form:errors cssStyle="color:red;" path="key"/> Codigo Arduino:</label>
			 <form:input path="key" type="password" id="key"  maxlength="32" size="32"  data-mini="true"  />
			
			
			 <label for="nomeDispositivo"><form:errors cssStyle="color:red;" path="nomeDispositivo"/> Nome Dispositivo:</label>
			 <form:input path="nomeDispositivo" type="text" id="nomeDispositivo"  maxlength="50" size="50"  data-mini="true"  />
			
					
			<input type="submit" value="Registrar" />
			
		</form:form>
	
			
		
		</div>
		<!-- /content -->

	</div>
	<!-- /page -->

</body>
</html>
