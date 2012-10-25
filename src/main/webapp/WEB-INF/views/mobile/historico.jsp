<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>


<html>
<head>

</head>
<body>
	<input type="hidden" id="contextPath" value="${contextPath}"><!-- for JS scrips -->
	<div data-role="page" id="main">

		<div data-role="header" style="height: 30px;" class="ui-grid-b">
					
			<span class="ui-block-a" >Historico</span>
			
			<span class="ui-block-b" data-role="controlgroup" data-type="horizontal" style="padding-left: 75%;margin-top: -17px;">			
				<a href="${contextPath}" data-role="button" data-ajax="false" data-iconpos="notext" data-icon="home" ></a>
				<a href="${contextPath}/mobile/listarHistorico.html" data-role="button" data-iconpos="notext" data-icon="grid" ></a>
				<a href="${contextPath}/mobile/config/open.html"  data-role="button" data-iconpos="notext" data-icon="gear"></a>
			</span>
		</div>	

		<div data-role="content">


			<ul data-role="listview" data-theme="c">
				<c:forEach items="${historicos}" var="h">
					<li>${h.dispositivo.nome}
						<p class="ui-li-aside">
							<strong><fmt:formatDate value='${h.data }' type="both"	pattern="dd/MM-hh:mm" /></strong>
							<fmt:formatDate value='${h.data }' type="both" pattern="a"/>
						</p> 
						
					</li>
				</c:forEach>
			</ul>











		</div>
		<!-- /content -->
	</div>


</body>
</html>
