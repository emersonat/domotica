<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>
<input type="hidden" id="contextPath" value="${contextPath}"><!-- for JS scrips -->
		
		<section class="grid_6">
			<div class="block-border"><div class="block-content">
				<h1><spring:message code="painel.controle"  text="Painel controle"/> </h1>
				
				
				<ul class="shortcuts-list">
					
					<li>

						<!--  <a href="${contextPath}/web/dispositivo/open.html">  -->
						
						<a href="${contextPath}/web/dispositivo/listar.html"> 

							<img src="${contextPath}/tema/images/icons/web-app/48/Bar-Chart.png" width="48" height="48"><spring:message code="dispositivos"  text="Dispositivos"/>
						</a>
				
					</li>
				
					
				</ul>
				
				
				
				
			</div></div>
		</section>
		
		
			

		
	


