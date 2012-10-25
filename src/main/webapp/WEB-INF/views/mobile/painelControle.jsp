<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>



<html>
<head>
<title>Controle</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.css" />

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/mobile/1.0/jquery.mobile-1.0.min.js"></script>
	
	
<script type="text/javascript"
	src="http://cloud.github.com/downloads/digitalBush/jquery.maskedinput/jquery.maskedinput-1.3.min.js"></script>	


<script type="text/javascript" src="${contextPath}/js/functions.js"></script>


</head>
<body>
	<input type="hidden" id="contextPath" value="${contextPath}" /><!-- for JS scrips -->
	<div data-role="page" id="main">

		<div data-role="header" style="height: 30px;" class="ui-grid-b">
					
			<span class="ui-block-a" >Controle</span>
			
			<span class="ui-block-b" data-role="controlgroup" data-type="horizontal" style="padding-left: 75%;margin-top: -17px;">			
				<a href="${contextPath}" data-role="button" data-ajax="false" data-iconpos="notext" data-icon="home" ></a>
				<a href="${contextPath}/mobile/listarHistorico.html" data-role="button" data-iconpos="notext" data-icon="grid" ></a>
				<a href="${contextPath}/mobile/config/open.html"  data-role="button" data-iconpos="notext" data-icon="gear"></a>
			</span>
			
			
		</div>
		<!-- /header -->

		


			<c:forEach items="${casa.dispositivos}" var="d">
						
							${d.nome}			
							<input data-icon="check" type="button" value="Acionar"
					class="botao_acionar_dispositivo" onclick="acionar('${d.key}')" />

				<br />
				<br />
			</c:forEach>




		</div>
		<!-- /content -->
	


	<div data-role="page" id="historico">

		<div data-role="header">Controle</div>
		<!-- /header -->

		<div data-role="content">pagina historico</div>
		<!-- /content -->
	</div>




</body>
</html>
