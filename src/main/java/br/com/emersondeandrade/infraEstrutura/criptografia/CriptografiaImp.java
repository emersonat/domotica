package br.com.emersondeandrade.infraEstrutura.criptografia;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersondeandrade.infraEstrutura.propriedadesSistema.PropriedadesSeguranca;

@Service
public final class CriptografiaImp implements Criptografia{  

     
   
   @Autowired
   private PropriedadesSeguranca propSeg;
   
   
   
   public void setPropSeg(PropriedadesSeguranca propSeg) {
	   this.propSeg = propSeg;
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
              
      return strCript;  
   }  
     
   public String decript(String str)  
   {  
      String strDecript = str;  
        
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
      Criptografia s = new CriptografiaImp() ;
      
        
      String cript = s.cript("teste");  
      String decript = s.decript(cript);  
        
      System.out.println("Cripto: " + ">"+cript+"<");  
      System.out.println("Decripto: " + decript);  
      
      
      // MD5
      String key = "xpto";
	  System.out.println(new CriptografiaImp().encodeMD5(key));
      
        
   }

   

   
  
   public String encodeMD5(String str) {
		str += propSeg.getSaltMD5();
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, md.digest(str.getBytes()));
			String s = hash.toString(16);
			if (s.length() % 2 != 0)
				s = "0" + s;
			return s;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
   }
   
   
   
   
}  

