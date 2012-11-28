$(document).ready(function()
			{
				// We'll catch form submission to do it in AJAX, but this works also with JS disabled
				$('#login-form').submit(function(event)
				{
					// Stop full page load
					event.preventDefault();
					
					// Check fields
					var login = $('#j_username').val();
					var pass = $('#j_password').val();
					
					if (!login || login.length == 0)
					{
						$('#login-block').removeBlockMessages().blockMessage( $("#erroEmail").text()  , {type: 'warning'});
					}
					else if (!pass || pass.length == 0)
					{
						$('#login-block').removeBlockMessages().blockMessage($("#erroSenha").text()   , {type: 'warning'});
					}
					else
					{
						var submitBt = $(this).find('button[type=submit]');
						submitBt.disableBt();
						
						// Target url
						var target = $(this).attr('action');
						if (!target || target == '')
						{
							// Page url without hash
							target = document.location.href.match(/^([^#]+)/)[1];
						}
						
						// Request
						var data = {
							a: $('#a').val(),
							login: login,
							pass: pass
						};
						var redirect = $('#redirect');
						if (redirect.length > 0)
						{
							data.redirect = redirect.val();
						}
						
						// Start timer
						var sendTimer = new Date().getTime();
						
						// Send
						$.ajax({
							url: target,
							dataType: 'json',
							type: 'POST',
							data: data,
							success: function(data, textStatus, XMLHttpRequest)
							{
								if (data.valid)
								{
									// Small timer to allow the 'cheking login' message to show when server is too fast
									var receiveTimer = new Date().getTime();
									if (receiveTimer-sendTimer < 500)
									{
										setTimeout(function()
										{
											document.location.href = data.redirect;
											
										}, 500-(receiveTimer-sendTimer));
									}
									else
									{
										document.location.href = data.redirect;
									}
								}
								else
								{
									// login invalido
									$('#login-block').removeBlockMessages().blockMessage(data.error || $("#loginInvalido").text() , {type: 'error'});
									
									submitBt.enableBt();
								}
							},
							error: function(XMLHttpRequest, textStatus, errorThrown)
							{
								// Message
								$('#login-block').removeBlockMessages().blockMessage($("#erroServidor"), {type: 'error'});
								
								submitBt.enableBt();
							}
						});
						
						// Message
						$('#login-block').removeBlockMessages().blockMessage($("#logando"), {type: 'loading'});
					}
				});
			});