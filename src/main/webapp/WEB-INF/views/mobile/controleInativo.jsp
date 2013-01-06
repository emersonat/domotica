<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>

	<br/>
	
	<div align="center">
		<img src="${contextPath}/imagens/offline.png"  title="<spring:message code="esse.controle.inativo" text="Esse controle foi desligado"/>" >
		<br/>
		<br/>
		<h1><spring:message code="esse.controle.inativo" text="Esse controle esta desligado"/></h1>
	</div>	