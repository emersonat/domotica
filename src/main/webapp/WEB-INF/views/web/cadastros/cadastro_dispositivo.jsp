<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script type="text/javascript">
$(document).ready(function(){
	

	$.fn.sortSelect = function() {
	    var op = this.children("option");
	    op.sort(function(a, b) {
	        return a.text > b.text ? -1 : 1;
	    })
	     return this.empty().append(op);
	}

	
	$('#porta').change(function(){
		
		$.ajax({
			url: '/domotica/web/cadastroDispositivo/comandos.html',
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
	            $("#tipo-evento").sortSelect();
	            $("#tipo-evento").val(-1);
	            
			}
		});
		
	});
	
	
	$('#ativo').click(function(){
		
			
		$.ajax({
			url: '/domotica/web/cadastroDispositivo/changeAtivo.html',
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
	            $("#porta").sortSelect();
	            $("#porta").val(-1);
	           
	            $('#tipo-evento')
	            	.children()
	            	.remove()
	            	.end()
		           	.append('<option selected value="-1">'+$("#i18n_selecione").text()+'</option>')
	    	            
			}
		});
		
	});
	
	
	      
	
	
	
});



</script>
	<span id="i18n_selecione" style="display:none" ><spring:message code="selecione"  text="Selecione"/></span>
	
	<section class="grid_4">
			<div class="block-border">
			
			<form:form class="block-content form"  commandName="dispositivo" id="salvarDispositivoForm" method="post" action="/domotica/web/dispositivo/salvar.html">
				<h1><spring:message code="cadastro.dispositivo"  text="Cadastro dispositivos"/></h1>
				
				<fieldset class="grey-bg required">
					<spring:hasBindErrors name="dispositivo">
						<ul class="message error no-margin" style="display:block">
							<spring:message code="verifique.campos"   text="Verifique campos obrigatórios"/>						
						</ul>
					</spring:hasBindErrors>
					
						<p>
							<label for="simple-required"><spring:message code="nome"  text="Nome"/></label>
							<form:input  name="simple-required" id="simple-required"  path="nome" maxlength="50" size="50" value="" class="full-width"/>
						</p>
						
						<p>
						
							    <label for="simple-select"><spring:message code="porta"  text="Porta"/></label>
								<form:select path="numeroPorta"  name="porta" id="porta"  class="full-width">
									 <form:option value="-1" ><spring:message code='selecione'  text='Selecione'/></form:option>
									 <form:options items="${listaPortas}" />
								</form:select>
													
						</p>
												
						<p>
								<label for="simple-select"><spring:message code="tipo.evento"  text="Tipo de evento"/></label>
								<form:select path="tipoComando" name="tipo-evento" id="tipo-evento" class="full-width">
									 <form:option value="-1"><spring:message code="selecione"  text="Selecione"/></form:option>
									 <form:options items="${listaComandosPossiveis}" itemValue="id" itemLabel="i18n"/>
								</form:select>
						</p>
						
						
						
						
						<p class="colx2-left">
							<label for="simple-switch-on"><spring:message code="ligado"  text="Ligado"/></label>
							<form:checkbox  name="ativo"  id="ativo" path="ativo"  class="switch"/>
						</p>
			
				</fieldset>
			
			
				<fieldset class="grey-bg no-margin">
					<p class="input-with-button">
						<button type="submit"><spring:message code="salvar"  text="Salvar"/></button>
					</p>
				</fieldset>
					
			</form:form></div>
		</section>
	
	
	
		
		
			

		
	


