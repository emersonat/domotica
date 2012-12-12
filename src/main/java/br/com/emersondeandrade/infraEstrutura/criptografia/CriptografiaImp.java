package br.com.emersondeandrade.infraEstrutura.criptografia;

import javassist.expr.NewArray;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.infraEstrutura.propriedadesSistema.PropriedadeSegurancaProducao;
import br.com.emersondeandrade.infraEstrutura.propriedadesSistema.PropriedadesSeguranca;

@Service
public final class CriptografiaImp implements Criptografia{  

     
	private static Logger log = Logger.getLogger(CriptografiaImp.class);
	
   @Autowired
   private PropriedadesSeguranca propSeg;
   
   
   
   public CriptografiaImp(PropriedadesSeguranca propSeg) {
	   this.propSeg = propSeg;
   }
   
  public CriptografiaImp() {
	// TODO Auto-generated constructor stub
  }

  public String cript(int n) {
		return cript(String.valueOf(n));
  }
  
   public String cript(String str){  
      String strCript = str;  
        
      try  
      {  
         Cipher ch = Cipher.getInstance("Blowfish");  
         SecretKey k1 = new SecretKeySpec(propSeg.getSaltCriptografia().getBytes(), "Blowfish");  
           
         //criptografando  
         ch.init( Cipher.ENCRYPT_MODE, k1);  
         byte b[] = ch.doFinal(strCript.getBytes());  
         String s1 = Conversion.byteArrayToBase64String(b);  
         strCript = s1;  
      }  
      catch( Exception e)  
      {  
         System.out.println(e.getMessage());  
         e.printStackTrace();  
      }  
               
      return  new String(new Base64().encode(strCript.getBytes()));
   }  

   
   
   
   public int decriptToInt(String number) {
		String n = decript(number);
		
		try{
			return Integer.parseInt(n);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			log.warn("Erro ao tentar converter " + n + " para numero");
		}
			
		return 0;
	}
     
   
   public String decript(String str)  
   {  
      String strDecript =  new String(new Base64().decode(str.getBytes()));  
              
      try  
      {  
         Cipher ch = Cipher.getInstance("Blowfish");  
         SecretKey k1 = new SecretKeySpec(propSeg.getSaltCriptografia().getBytes(), "Blowfish");  
           
         //decriptografando  
         ch.init( Cipher.DECRYPT_MODE, k1);  
         byte b[] = Conversion.base64StringToByteArray(strDecript);  
         byte b1[] = ch.doFinal(b);  
         String s1 = new String(b1);  
         strDecript = s1;  
      }  
      catch( Exception e)  
      {  
         System.out.println(e.getMessage());  
         e.printStackTrace();  
      }  
      return strDecript;  
   }  
  
   
   
   
   public static  void main(String[] args) {  
     
   }

   
   
   
   
  
   public String encodeMD5(String str) {
	   MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("MD5");
	   String encodePassword = encoder.encodePassword(str, propSeg.getSaltMD5());
	   return encodePassword;
   }






   
   
   
   
}  

