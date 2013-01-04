<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>



<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>

<script type="text/javascript" src="${contextPath}/js/mobile/painelControle.js"></script>



	<article class="white-bg" >
				
			<input type="hidden" id="contextPath" value="${contextPath}"><!-- for JS scrips -->	
					
			<ul class="favorites no-margin">
				<c:forEach items="${casa.dispositivosAtivos}" var="d">
					<li>
						<img style="cursor: pointer;" src="${contextPath}/tema/images/icons/web-app/48/Info.png" width="48" height="48" onclick="acionar('${d.key}')" >
						<a href="#" style="cursor: default;">${d.nome}<br>
						<small></small></a>
					</li>
				</c:forEach>
			</ul>
		
	</article>
	

