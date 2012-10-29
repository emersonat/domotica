<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>





	<div data-role="page" id="main">
		<script type="text/javascript" src="${contextPath}/js/mobile/config.js"></script>
		
		<div data-role="header" style="height: 30px;" class="ui-grid-b">
					
			<span class="ui-block-a" >Configurações</span>
			
			<span class="ui-block-b" data-role="controlgroup" data-type="horizontal" style="padding-left: 75%;margin-top: -17px;">			
				<a href="${contextPath}/mobile/verificaKey.html" data-role="button" data-ajax="false" data-iconpos="notext" data-icon="home" ></a>
				<a href="${contextPath}/mobile/listarHistorico.html" data-role="button" data-iconpos="notext" data-icon="grid" ></a>
				<a href="${contextPath}/mobile/config/open.html"  data-role="button" data-iconpos="notext" data-icon="gear"></a>
			</span>
		</div>	

		<div data-role="content">
		
		 
		 Modelo: ${arduino.modelo}
		 
		 <br/>
		  
		 <!-- Internacionalização -->
		 <span style="display: none" id="conectado"><spring:message code="conectado" text="Conectado"/></span>
		 <span style="display: none" id="desconectado"><spring:message code="desconectado" text="Desconectado"/></span>
		 <span style="display: none" id="erroConectar"><spring:message code="erro.conectar" text="Erro ao tentar comunicação"/></span>
		 
		 
		 <spring:message code="status" text="Status"/>: 
		 	<span id="statusArduino"><spring:message code="tentando.conectar" text="Tentando conectar"/>....</span>
		 	
		 	
		 	
		 <br/>
		  <br/>
		 <form:form action="${contextPath}/mobile/config/salvar.html" method="post"  commandName="formConfig">
					 	
			 
			 <label for="inputIp"><form:errors cssStyle="color:red;" path="ip"/> Numero IP:</label>
			 <form:input path="ip" type="text" id="inputIp" data-mini="true" />
			
			 
						
			 <label for="inputPorta"><form:errors cssStyle="color:red;" path="porta"/> Porta:</label>
			 <form:input  type="text" path="porta" id="inputPorta"  data-mini="true" />
			
					 
			 			 			 
			
			 <input type="submit" value="Gravar"/>
		
		 </form:form>
		 
		 <br/>
		 <br/>
		 
		 
		 
		<a href="${contextPath}/mobile/config/desconectar.html" data-inline="true" data-theme="e" data-role="button" data-icon="delete">Desconectar</a>
			 
		 	
		</div>
		<!-- /content -->
	</div>



