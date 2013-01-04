<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>


<script type="text/javascript" src="${contextPath}/js/mobile/config.js"></script>

 <!-- Internacionalização -->
<span style="display: none" id="conectado"><spring:message code="conectado" text="Conectado"/></span>
<span style="display: none" id="desconectado"><spring:message code="desconectado" text="Desconectado"/></span>
<span style="display: none" id="erroConectar"><spring:message code="erro.conectar" text="Erro ao tentar comunicação"/></span>
		 


<article>
		
	  <section id="login-block">
		<div class="block-border">	
		 <h1><spring:message code="configuracao" text="Configuração"/></h1>
		 Modelo: ${arduino.modelo}
		 
		 <br/>
		  	 
		 <spring:message code="status" text="Status"/>: 
		 	<span id="statusArduino"><spring:message code="tentando.conectar" text="Tentando conectar"/>....</span>
		 		 	
		 <br/>
		  <br/>
		 <form:form action="${contextPath}/mobile/config/salvar.html" method="post"  commandName="formConfig" cssClass="form block-content">
					 	
			<p>
				 <label for="inputIp"><form:errors cssStyle="color:red;" path="ip"/><spring:message code="ip" text="IP"/>:</label>
				 <form:input path="ip" type="text" id="inputIp" />
			</p>
			 
			<p>			
				 <label for="inputPorta"><form:errors cssStyle="color:red;" path="porta"/><spring:message code="porta" text="Porta"/>:</label>
				 <form:input  type="text" path="porta" id="inputPorta"  />
			</p>
			
			<p><button type="submit" class="full-width"><spring:message code="gravar" text="Gravar"/></button></p>			 
			 			 			 
			
			
		
		 </form:form>
		 
		 <br/>
		 <br/>
		 
		 
		 
		<a href="${contextPath}/mobile/config/desconectar.html"><img alt="" src="${contextPath}/imagens/desconectar.png"></a>
			 
		</div> 	
	</section>	
</article>
