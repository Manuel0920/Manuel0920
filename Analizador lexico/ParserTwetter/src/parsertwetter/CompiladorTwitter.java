/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsertwetter;

import java.util.ArrayList;

/**
 *
 * @author Saki
 */
public class CompiladorTwitter {
      Parser pt=new Parser();
      
//      public static void main(String[] args) {
//        String twitt="@united Oh, we are sure it's not planned, :) Cancelled htpp://google.com Flightled #sunday daily.";
//    }
//      
      
      public String ALexico(String twitter){
          String lexico="";
                
          String []token=pt.GetTokens(twitter);
          
          for (int i = 0; i <token.length; i++) {
              
              if(pt.isMencion(token[i])){
                  lexico=lexico+"Símbolo valido: @ \n";
                  lexico=lexico+"Cadena valido: "+token[i].replaceAll("@","")+" \n";
              }
              
              if(pt.isHashTag(token[i])){
                  lexico=lexico+"Símbolo valido: # \n";
                  lexico=lexico+"Cadena valida: "+token[i].replaceAll("#","")+" \n";
              }
              
              if(pt.isEmoji(token[i])){
                  lexico=lexico+"Símbolos validos: "+token[i]+" \n";
              }
              
              if(pt.isEnlace(token[i])){
                  lexico=lexico+"Cadena valida: http \n";
                  lexico=lexico+"Símbolo valido: : \n";
                  lexico=lexico+"Símbolo valido: / \n";
                  lexico=lexico+"Símbolo valido: / \n";
                  lexico=lexico+"Cadena valido: "+token[i].replaceAll("http://","")+" \n";
              }
              
              if(pt.isPalabra(token[i])){
                  lexico=lexico+"Cadena valida: "+token[i]+" \n";
              }
              
              
              lexico=lexico+"Símbolo valido: : _\n";
              
          }
          
          
          return lexico;
      }
      
      
      public String ASintactico(String twitter){
          String sintactico="";
          
             Twitter twit=pt.ParserTwitt(twitter);
             
             sintactico=sintactico+"PALABRAS -> [a-zA-z0-9_]+ : \n";
             String tokens[]=pt.GetTokens(twit.getText());
             for (int i = 0; i <tokens.length; i++) {
                 if(pt.isDigito(tokens[i])){
                     sintactico=sintactico+"Secuencia incorrecta -> "+ tokens[i]+" \n"; 
                 }else{
                     sintactico=sintactico+"Secuencia correcta -> "+ tokens[i]+" \n"; 
                 }
             }
             
             sintactico=sintactico+"\n\n";
             sintactico=sintactico+"MENCIONES -> (@[a-zA-z0-9_]+): \n"; 
             ArrayList<String> menc=twit.getMension();
             
             for (int i = 0; i <menc.size() ; i++) {
                 sintactico=sintactico+"Secuencia correcta -> "+ menc.get(i)+" \n";
             }
             sintactico=sintactico+"\n\n";
             sintactico=sintactico+"EMOJIS -> [^\\p{L}\\p{N}\\p{P}\\p{Z}]   ,   b\\)|\\:0|\\<3|\\:v|\\:\\*|\\:\\)|\\:\\(|B\\)|\\;\\) : \n";
             ArrayList<String> emo=twit.getEmojis();
             
             for (int i = 0; i <emo.size() ; i++) {
                 sintactico=sintactico+"Secuencia correcta -> "+ emo.get(i)+" \n";
             }
             sintactico=sintactico+"\n\n";
             sintactico=sintactico+"HASHTAGS -> (#[a-zA-z0-9_]+): \n";
             ArrayList<String> hash=twit.getHashTag();
             
             for (int i = 0; i <hash.size() ; i++) {
                 sintactico=sintactico+"Secuencia correcta -> "+ hash.get(i)+" \n";
             }
             
             sintactico=sintactico+"\n\n";
             sintactico=sintactico+"ENLACES: \n";
             ArrayList<String> enlace=twit.getEnlaces();
             
             for (int i = 0; i <enlace.size() ; i++) {
                 sintactico=sintactico+"Secuencia correcta -> "+ enlace.get(i)+" \n";
             }
          
          return sintactico;
      }
      
      
      public String Asemantico(String twitter){
          String seman="";
          seman=seman+"TWITTER "+(twitter.length()>280?"NO ACEPTADO":"ACEPTADO")+"\n\n";
          
          String []token=pt.GetTokens(twitter);
          
          
          
          for (int i = 0; i <token.length; i++) {
              
              if(pt.isMencion(token[i])){
                  seman=seman+"@  -> CHAR\n";
                  seman=seman+token[i].replaceAll("@","")+" -> STRING \n";
              }
              
              if(pt.isHashTag(token[i])){
                  seman=seman+"# -> CHAR \n";
                  seman=seman+token[i].replaceAll("#","")+" -> STRING \n";
              }
              
              if(pt.isEmoji(token[i])){
                  seman=seman+token[i]+" -> STRING \n";
              }
              
              if(pt.isEnlace(token[i])){
                  seman=seman+"http -> STRING\n";
                  seman=seman+":  -> CHAR\n";
                  seman=seman+"/ -> CHAR\n";
                  seman=seman+"/ -> CHAR\n";
                  seman=seman+token[i].replaceAll("http://","")+" -> STRING\n";
              }
              
              if(pt.isPalabra(token[i])){
                  seman=seman+token[i]+" -> STRING\n";
              }
              
              
              seman=seman+"_  -> CHAR\n";
              
          }
          
          
          return seman;
      }
      
      
}


