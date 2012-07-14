<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script type="text/javascript">
$(document).ready(function(){
	
	$('#porta').change(function(){
		
		$.ajax({
			url: '/domotica/web/dispositivo/comandos.html',
			dataType: 'json',
			type: 'GET',
			data: {numeroPorta: $('#porta').val()  },
			success: function(data)
			{
				var options = "";
	            $.each(data, function(key, value){
	               options += '<option value="' + key + '">' + value + '</option>';
	            });
	            $("#tipo-evento").html(options);
	            alert(options)
			}
		});
		
	});
	
	
	
});
</script>

	<section class="grid_4">
			<div class="block-border"><form class="block-content form" id="simple_form" method="post" action="">
				<h1><spring:message code="cadastro.dispositivo"  text="Cadastro dispositivos"/></h1>
				
				<fieldset class="grey-bg required">
					<ul class="message error no-margin" style="display:none">
						<li>This is an <strong>error message</strong>, inside a form</li>
					</ul>
					
					
						<p>
							<label for="simple-required"><spring:message code="nome"  text="Nome"/></label>
							<input type="text" name="simple-required" id="simple-required"  maxlength="50" size="50" value="" class="full-width">
						</p>
						
						<p>
								<label for="simple-select"><spring:message code="porta"  text="Porta"/></label>
								<select name="porta" id="porta" class="full-width" onchange="">
									<option value="-1"><spring:message code="selecione"  text="Selecione"/></option>
									<c:forEach items="${casa.arduino.portasDisponiveis}" var="porta">
										<option value="${porta}">${porta}</option>
									</c:forEach>
								</select>
						</p>
												
						<p>
								<label for="simple-select"><spring:message code="tipo.evento"  text="Tipo de evento"/></label>
								<select name="tipo-evento" id="tipo-evento" class="full-width">
									<option value="-1"><spring:message code="selecione"  text="Selecione"/></option>
								</select>
						</p>
						
						
						
						
						<p class="colx2-left">
							<label for="simple-switch-on"><spring:message code="ligado"  text="Ligado"/></label>
							<input type="checkbox" name="simple-switch-on" id="simple-switch-on" value="1" checked="checked" class="switch">
						</p>
			
				</fieldset>
			
			
				<fieldset class="grey-bg no-margin">
					<p class="input-with-button">
						<button type="button">Create</button>
					</p>
				</fieldset>
					
			</form></div>
		</section>
	
	
	
		
		
			

		
	


