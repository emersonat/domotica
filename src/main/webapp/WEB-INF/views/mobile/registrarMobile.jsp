<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>


<article>
		
	  <section id="login-block">
		<div class="block-border">
			
			<form:form action="${contextPath}/mobile/registra.html" method="post" commandName="formRegistro" cssClass="form block-content">
							
				<h1><spring:message code="registrar.controle" text="Registrar controle"/></h1>
				<span style="color: red;">${erro}</span><br/><br/> 
				 <p>
					<label for="key"><form:errors cssStyle="color:red;" path="key"/> <spring:message code="codigo.arduino" text="Codigo central"/>:</label>
					<form:input path="key" type="password" id="key"  maxlength="32" size="32"  cssClass="full-width" />
				</p>
				<p>
					<label for="nomeDispositivo"><form:errors cssStyle="color:red;" path="nomeDispositivo"/> <spring:message code="nome.controle" text="Nome do controle"/>:</label>
					<form:input path="nomeDispositivo" type="text" id="nomeDispositivo"  maxlength="50" size="50"  cssClass="full-width"  />
				</p>
							
				<p><button type="submit" class="full-width"><spring:message code="registrar" text="Registrar"/></button></p>
				
			</form:form>
			</div>
		</section>
		
</article>
	



