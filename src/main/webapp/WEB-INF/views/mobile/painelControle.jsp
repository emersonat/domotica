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

<link href="${contextPath}/tema/css/block-lists.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${contextPath}/js/mobile/painelControle.js"></script>

<!-- Internacionalizacao -->
<input type="hidden" id="erroAcionarDispositivo" value="<spring:message code="erro.acionar.disp" text="Erro ao acionar dispositivo" />"/>



	<article class="white-bg" >
		
		<c:if test="${arduinoOn}">						
			<ul class="favorites no-margin">
				<c:forEach items="${casa.dispositivosAtivos}" var="d">
					<li>
						
							<c:if test="${d.ligado}">
								<img style="cursor: pointer;" src="${contextPath}/imagens/dispositivos/${d.imagenOn}" width="48" height="48" onclick="acionar('${d.key}')" >
							</c:if>
													
							<c:if test="${!d.ligado}">
								<img style="cursor: pointer;" src="${contextPath}/imagens/dispositivos/${d.imagenOff}" width="48" height="48" onclick="acionar('${d.key}')" >
							</c:if>
						
								
						<a href="#" style="cursor: default;">${d.nome}<br>
						<small></small></a>
					</li>
				</c:forEach>
			</ul>
		</c:if>
		
		<c:if test="${!arduinoOn}">	
			<div align="center">
				<img src="${contextPath}/imagens/arduino_off.png"  title="<spring:message code="arduino.off" text="Modulo não esta respondendo"/>" >
				<br/>
				<br/>
				<h1><spring:message code="arduino.off" text="Módulo não esta respondendo"/></h1>
			</div>	
		</c:if>
		
	</article>
	

