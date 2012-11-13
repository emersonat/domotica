<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>
<input type="hidden" id="contextPath" value="${contextPath}"><!-- for JS scrips -->
		
	
		
	<section class="grid_12">
			<div class="block-border">
	
			<form class="block-content form" id="table_form" method="post" action="">
				<h1><spring:message code="dispositivos" text="Dispositivos"/>  </h1>
					<display:table cellspacing="0" id="dispositivos" class="table" style="width:100%" sort="internal" name="dispositivos"    partialList="false"   >
					
						<div class="no-margin">
							<display:column title="Nome"  sortName="nome"  sortable="true"> 
								${dispositivos.nome}
							</display:column>	
							
							<display:column title="Numero Porta" sortName="numeroPorta"  sortable="true"> 
								${dispositivos.numeroPorta}
							</display:column>	
							
							<display:column title="Tipo Comando" sortName="tipoComando"  sortable="false"> 
								<spring:message code="${dispositivos.tipoComando.i18n}" /> 
							</display:column>	
							
							<display:column title="Ativo"  sortName="ativo"  sortable="false"> 
								
								<c:if test="${dispositivos.ativo}">
									<spring:message code="sim" text="Sim"/> 
								 </c:if>
								 
								 <c:if test="${dispositivos.ativo == false }">
									<spring:message code="nao" text="Não"/> 
								 </c:if>
								
							</display:column>	
							
							
							
						</div>
						
						
						
					</display:table>	
						
					
			</form>			
			</div>	
		</section>
	
		
		
	
		
		
			

		
	


