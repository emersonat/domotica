<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>

<link href="${contextPath}/tema/css/table.css" rel="stylesheet" type="text/css">


	<article>
		
		<section id="login-block">
			<div class="block-border"><div class="block-content">
				
				<h1><spring:message code="historico" text="Histórico"/></h1>
				
				
				
				<div class="no-margin"><table class="table" cellspacing="0" width="100%">
				
					<thead>
						<tr>
							<th scope="col">
								<spring:message code="dispositivo" text="Dispositivo"/>
							</th>
							<th scope="col"><spring:message code="acionado" text="Acionado"/></th>
							
						</tr>
					</thead>
					
					<tfoot>
						
					</tfoot>
					
					<tbody>
						
						<c:forEach items="${historicos}" var="h">
							
							<tr>
								<td>${h.nomeDispositivo}</td>
								<td>
									<strong><fmt:formatDate value='${h.data }' type="both"	pattern="dd/MM-hh:mm" /></strong>
									<fmt:formatDate value='${h.data }' type="both" pattern="a"/>
								</td>
							</tr>
							
						</c:forEach>
					</tbody>
				

				</table></div>
				
			</div></div>
		</section>
		
	</article>
			
			
			
			
			
		

			










	



