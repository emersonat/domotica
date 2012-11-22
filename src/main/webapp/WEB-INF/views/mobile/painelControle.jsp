<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>

<script type="text/javascript" src="${contextPath}/js/mobile/painelControle.js"></script>




	<input type="text" id="contextPath" value="${contextPath}" /><!-- for JS scrips -->
	<div data-role="page" id="main">

		<div data-role="header" style="height: 30px;" class="ui-grid-b">
					
			<span class="ui-block-a" >Controle</span>
			
			<span class="ui-block-b" data-role="controlgroup" data-type="horizontal" style="padding-left: 75%;margin-top: -17px;">			
				<a href="${contextPath}/mobile/verificaKey.html" data-role="button" data-ajax="false" data-iconpos="notext" data-icon="home" ></a>
				<a href="${contextPath}/mobile/listarHistorico.html" data-role="button" data-iconpos="notext" data-icon="grid" ></a>
				<a href="${contextPath}/mobile/config/open.html"  data-role="button" data-iconpos="notext" data-icon="gear"></a>
			</span>
			
			
		</div>
		<!-- /header -->

			
			

			<c:forEach items="${casa.dispositivosAtivos}" var="d">
						
							${d.nome}
							<c:if test="${d.tipoComando == 'CLICK'}">			
								<input data-icon="check" type="button" value="Acionar" class="botao_acionar_dispositivo" onclick="acionar('${d.key}')" />
							</c:if>
				<br />
				<br />
			</c:forEach>




		</div>
		<!-- /content -->
	


	<div data-role="page" id="historico">

		<div data-role="header">Controle</div>
		<!-- /header -->

		<div data-role="content">pagina historico</div>
		<!-- /content -->
	</div>





