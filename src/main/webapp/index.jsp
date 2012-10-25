<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${contextPath == '/'}">
	<c:set var="contextPath" value=""/>
</c:if>


<script type="text/javascript" src="${contextPath}/tema/js/jquery-1.4.2.min.js"></script>

<html>
<body>
<input type="hidden" id="contextPath" value="${contextPath}"><!-- for JS scrips -->

<script type="text/javascript">
	
	  var index = navigator.appVersion.indexOf("Mobile");

		if( index > -1 ){

			window.location = $('#contextPath').val() +   "/mobile/verificaKey.html";

		} else {
			
			window.location = "login.jsp";
				
		} 	 	 

</script>




</body>
</html>