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
		
		
		
		
	<c:forEach items="${dispositivos}" var="d">
		
		
		<c:out value="${d.nome}"></c:out>
		
	
	</c:forEach>
	
	
	<display:table id="dispositivos" name="dispositivos" sort="external" size="size" pagesize="10" partialList="true"  requestURI="teste.html" >
		
		<display:column title="Nome" sortName="nome"  sortable="true"> 
				${dispositivos.nome}
		</display:column>	
			
	
	</display:table>
	
	
		
		
	
		
		
			

		
	


