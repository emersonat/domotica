

------ criando autoincremente 
ALTER TABLE public.arduino
  ALTER COLUMN id_arduino SET DEFAULT nextval('arduino_seq'::text::regclass);
  
 ALTER TABLE public.casa
 	 ALTER COLUMN id_casa SET DEFAULT nextval('casa_seq'::text::regclass);
  
  
 ALTER TABLE public.dispositivo
  	ALTER COLUMN id_dispositivo SET DEFAULT nextval('dispositivo_seq'::text::regclass);
  	
ALTER TABLE public.registromobile
  ALTER COLUMN id_registro_mobile SET DEFAULT nextval('registro_mobile_seq'::text::regclass);
  
  
  
  ALTER TABLE public.usuario
 	 ALTER COLUMN id_usuario SET DEFAULT nextval('usuario_seq'::text::regclass);
  
 
  
  
  	
 	
  	
  	
 ------ Carga dados iniciais 
  	
 insert into arduino (modelo,ip,key,porta) values (1,'192.168.0.177','xpto','80');
 insert into casa (id_arduino) values (2);
  
 INSERT INTO  public.dispositivo(key,nome, numeroporta, tipocomando, id_casa)  VALUES ('d1', 'Portão Garagem Frente', 6, 0, 1);
 
 INSERT INTO  public.tipos_eventos(dispositivo_id_dispositivo,tiposeventos) VALUES (1,0);
 
 
 
 /* Data for the 'public.propriedadeSistema' table  (Records 1 - 7) */

INSERT INTO public.propriedadeSistema ("key", "value", "descricao","cript")
VALUES (E'EMAIL_HOST', E'smtp.ig.com.br', NULL,false);

INSERT INTO public.propriedadeSistema ("key", "value", "descricao","cript")
VALUES (E'EMAIL_AUTH', E'true', NULL,false);

INSERT INTO public.propriedadeSistema ("key", "value", "descricao","cript")
VALUES (E'EMAIL_PASSWORD', E'SMkq2pgFNo5cKs/cThRhKw==', NULL,true);

INSERT INTO public.propriedadeSistema ("key", "value", "descricao","cript")
VALUES (E'EMAIL_USENAME', E'emersonat@ig.com.br', NULL,false);

INSERT INTO public.propriedadeSistema ("key", "value", "descricao","cript")
VALUES (E'EMAIL_PROTOCOLO', E'smtps', NULL,false);

INSERT INTO public.propriedadeSistema ("key", "value", "descricao","cript")
VALUES (E'EMAIL_PORTA', E'465', NULL,false);

INSERT INTO public.propriedadeSistema ("key", "value", "descricao","cript")
VALUES (E'EMAIL_TTLS', E'true', NULL,false);

INSERT INTO public.propriedadeSistema ("key", "value", "descricao","cript")
VALUES (E'ENVIAR_EMAILS', E'true', NULL,false)

 