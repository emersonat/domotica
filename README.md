# Domotica

**Automa��oo residencial com JAVA e Arduino**

------------------------------------------------------------------------
** Instru��es para configuracao **

-------------------------------------------------------------------------
**Implementar a Interface: PropriedadesSeguranca.java**

Essa interface possui metodos que retornam strings com algumas propriedades
de seguran�a usadas pelo sistema como por exemplo chaves para os met�dos de 
criptografia.

--------------------------------------------------------------------------

**Configurando Banco de Dados:**

Criar arquivo:  *Context.xml* na pasta META-INF ou colocar no arquivo *Context.xml* do Tomcat

Exemplo de configura��o:

`<Context path="/domotica" reloadable="true">    

    <Resource name="jdbc/domoticaDB"  
			  auth="Container"  
	          type="javax.sql.DataSource"  
			  maxActive="70"  
			  maxIdle="5"  
	          maxWait="10000"  
			  username="domotica"  
			  password="SENHA_BANCO"  
		      driverClassName="org.postgresql.Driver"  
		      url="jdbc:postgresql://localhost:5432/domoticaDB?autoReconnect=true;charSet=LATIN1" 
		     validationQuery="Select 1" />  
</Context>`   

-----------------------------------------------------------------------------------------------
**Key Arduino:**

No Arquivo: *source01* na pasta resources temos o codigo que ser�  execultado no arduino.

Para usar esse codigo deve-se setar a chave do Arduino (essa chave ser� utilizada para identificar o ARDUINO).

tamanho maximo da chave 32 caracteres.

-------------------------------------------------------------------------------------------------

**Esta sendo utilizado nesse projeto:**
 
Banco: Postgres 

Servidor de Aplica��o: Tomcat 

Framework:Spring 

--------------------------------------------------------------------------------
[Blog do Autor](http://emersondeandrade.com.br/ "Blog do Autor")

