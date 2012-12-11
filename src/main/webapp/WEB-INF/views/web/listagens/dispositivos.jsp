<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
 <%@taglib uri="/WEB-INF/myTagLib.tld" prefix="mytag"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>
<input type="hidden" id="contextPath" value="${contextPath}"><!-- for JS scrips -->
		
	
		
	<section class="grid_12">
			<div class="block-border">
	
			<form class="block-content form" id="table_form" method="post" action="">
				<h1><spring:message code="dispositivos" text="Dispositivos"/>  </h1>
					<display:table cellspacing="0" id="dispositivos" class="table" style="width:100%" sort="external" name="dispositivos"    partialList="false" requestURI="/web/dispositivo/sort.html"   >
					
						<div class="no-margin">
							<display:column title="Nome"  sortName="nome"  sortable="true"> 
								${dispositivos.nome}
							</display:column>	
							
							<display:column title="Numero Porta" sortName="numeroPorta"  sortable="true"> 
								${dispositivos.numeroPorta}
							</display:column>	
							
							<display:column title="Tipo Comando"  sortable="false"> 
								<spring:message code="${dispositivos.tipoComando.i18n}" /> 
							</display:column>	
							
							<display:column title="Ativar/Desativar" style="text-align:center"  sortable="false"> 
								
								<c:if test="${dispositivos.ativo}">
									<a href="${contextPath}/web/dispositivo/desativar/${mytag:cript(dispositivos.id)}.html"><img src="${contextPath}/imagens/button_on.png" height="24px" width="24px" title="<spring:message code="clique.inativar" text="Clique para inativar"/>" ></a> 
								 </c:if>
								 
								 <c:if test="${dispositivos.ativo == false }">
									<a href="${contextPath}/web/dispositivo/ativar/${mytag:cript(dispositivos.id)}.html"><img src="${contextPath}/imagens/button_off.png" height="24px" width="24px" title="<spring:message code="clique.ativar" text="Clique para ativar"/>" ></a> 
								 </c:if>
							
							</display:column>	
							
							
							
						</div>
						
						
						
					</display:table>	
						
					
			</form>			
			</div>	
		</section>
	
		
		
	
		
		
			

		
	


