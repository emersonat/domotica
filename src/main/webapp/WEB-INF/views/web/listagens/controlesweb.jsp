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
				<h1><spring:message code="controleweb" text="Controles Web"/>  </h1>
					<display:table cellspacing="0" id="controles" class="table" style="width:100%" sort="external" name="controles"    partialList="false" requestURI="/web/controleweb/sort.html"   >
					
						<div class="no-margin">
							<display:column title="Data Registro"  sortName="data"  sortable="true"> 
								<fmt:formatDate value="${controles.data}" pattern="dd/MM/yyyy - HH:mm:ss" />
							</display:column>	
							
							<display:column title="Nome" sortName="nome"  sortable="true"> 
								${controles.nome} 
							</display:column>	
							
														
							<display:column title="Ativar/Desativar" style="text-align:center" sortName="ativo"  sortable="false"> 
								
								<c:if test="${controles.ativo}">
									<a href="${contextPath}/web/controleweb/desativar/${mytag:cript(controles.id)}.html"  >
										<img src="${contextPath}/imagens/button_on.png"  height="24px" width="24px" title="<spring:message code="clique.inativar" text="Clique para inativar"/>" ></a> 
								 </c:if>
								 
								 <c:if test="${controles.ativo == false }">
									<a href="${contextPath}/web/controleweb/ativar/${mytag:cript(controles.id)}.html"><img src="${contextPath}/imagens/button_off.png" height="24px" width="24px" title="<spring:message code="clique.ativar" text="Clique para ativar"/>" ></a> 
								 </c:if>
								
							</display:column>	
							
							<display:column title="Excluir" style="text-align:center" sortable="false"> 
								
								<a href="${contextPath}/web/controleweb/deletar/${mytag:cript(controles.id)}.html" onclick="return confirm('<spring:message code="confirm.excuir.controle" text="Confirma excluir esse controle"/>?')"><img src="${contextPath}/imagens/delete.png" height="24px" width="24px" ></a>
								
								
								
							</display:column>	
							
							
						</div>
						
						
						
					</display:table>	
						
					
			</form>			
			</div>	
		</section>
	
	
	
	
		
		
	
		
		
			

		
	


