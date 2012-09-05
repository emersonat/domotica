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
	            
			}
		});
		
	});
	
	
	$('#ativo').click(function(){
		
			
		$.ajax({
			url: '/domotica/web/dispositivo/changeAtivo.html',
			dataType: 'json',
			type: 'GET',
			data: {ativo: !$('input[name=ativo]').is(':checked')   },
			success: function(data)
			{
				
				var options = "";
	            $.each(data, function(key, value){
	               	options += '<option value="' + key + '">' + value + '</option>';
	            });
	            $("#porta").html(options);
	           
	            
	            
			}
		});
		
	});
	
	
	
});
</script>

	<section class="grid_4">
			<div class="block-border"><form:form class="block-content form" commandName="disp" id="salvarDispositivoForm" method="post" action="/domotica/web/dispositivo/salvar.html">
				<h1><spring:message code="cadastro.dispositivo"  text="Cadastro dispositivos"/></h1>
				
				<fieldset class="grey-bg required">
					<ul class="message error no-margin" style="display:none">
						<li>This is an <strong>error message</strong>, inside a form</li>
					</ul>
					
					
						<p>
							<label for="simple-required"><spring:message code="nome"  text="Nome"/></label>
							<form:input  name="simple-required" id="simple-required"  path="nome" maxlength="50" size="50" value="" class="full-width"/>
						</p>
						
						<p>
								<label for="simple-select"><spring:message code="porta"  text="Porta"/></label>
								<form:select path="numeroPorta" name="porta" id="porta" class="full-width" onchange="">
									<option value="-1"><spring:message code="selecione"  text="Selecione"/></option>
									<c:forEach items="${listaPortas}" var="porta">
										<option value="${porta}">${porta}</option>
									</c:forEach>
								</form:select>
						</p>
												
						<p>
								<label for="simple-select"><spring:message code="tipo.evento"  text="Tipo de evento"/></label>
								<form:select path="tipoComando"  name="tipo-evento" id="tipo-evento" class="full-width">
									<option value="-1"><spring:message code="selecione"  text="Selecione"/></option>
								</form:select>
						</p>
						
						
						
						
						<p class="colx2-left">
							<label for="simple-switch-on"><spring:message code="ligado"  text="Ligado"/></label>
							<form:checkbox  name="ativo"  id="ativo" path="ativo"  class="switch"/>
						</p>
			
				</fieldset>
			
			
				<fieldset class="grey-bg no-margin">
					<p class="input-with-button">
						<button type="submit">Salvar</button>
					</p>
				</fieldset>
					
			</form:form></div>
		</section>
	
	
	
		
		
			

		
	


