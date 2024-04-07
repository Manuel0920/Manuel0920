/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsertwetter;

import java.util.ArrayList;
import java.util.regex.*;

public class Parser {

    public ArrayList<Twitter> getOkTwitter() {
        return okTwitter;
    }

    public void setOkTwitter(ArrayList<Twitter> okTwitter) {
        this.okTwitter = okTwitter;
    }

    public ArrayList<String> getNoRTwitter() {
        return noRTwitter;
    }

    public void setNoRTwitter(ArrayList<String> noRTwitter) {
        this.noRTwitter = noRTwitter;
    }
       //lista de twitteraceptados 
       private  ArrayList<Twitter> okTwitter=new ArrayList<Twitter>();
       //Lista de twitter no aceptados
       private  ArrayList<String> noRTwitter=new ArrayList<String>();
        
   
       
    public void ParserTwittLote(String listwitt[]){
        //analizamos para cada twitter si es un twitter
        for (int i = 0; i < listwitt.length; i++) {
            if(isTwitter(listwitt[i])){
                //Si es un twitt agregamos a la lista de twitts 
                //utilizamos la funcion parser twitt para analizar sus tokens
                //Parser twitt devulve objetos tipo twiit
               okTwitter.add(ParserTwitt(listwitt[i]));
            }else{
              //No es un twit y agregamos el texto a la lista de no twitts
              noRTwitter.add(listwitt[i]);
            } 
        }
        
        
    }
    
    /*
    Es un twitter si cumple con el tamaño de caracteres solicitado
    */
    private boolean isTwitter(String string) {
        boolean istwitt=false;
         System.out.println("TamaTwitt:"+string.length());
            if(string.length()<=280){
               
                istwitt=true;
            }
        return istwitt;
    }
    
    
    /**
     * 
     * @param twitters
     * @return un objeto twitter con todo su analisis
     */
    public Twitter ParserTwitt(String twitters) {
        
            Twitter twit=new Twitter();
            //Extraer todo y agregamos al objeto el atributo raw
            twit.setRaw( twitters  );
            //Extraer texto y agregamos al objeto el atributo texto
            twit.setText( Gettext(twitters) );
            //Extraer Mencion(s) y agregamos al obj el atributo texto
            twit.setMension( GetMencion(twitters)  );
            //Extraer emojis y agregamos al obj el atributo emoji
            twit.setEmojis( GetEmoji(twitters)  );
            //Extraer hashtag y agregamos al obj el atributo hastag
            twit.setHashTag( GetHashTag(twitters) ); 
            //Extraer enlaces y agregamos al obj el atributo enlace
            twit.setEnlaces( GetEnlaces(twitters) );
            
            return twit;
    }
    
    
  
    
    /**
     * Dividide el twitter en un arreglo de palabras
     * lo divide por espacios
     * @param twitters
     * @return regresa un listado de palabras
     */
    public String[] GetTokens(String twitters){
        String tokens[]=null;  
        tokens=twitters.split("\\s");        
        return tokens;
    }
    
    
    /**
     * Obtenemos solo el texto
     * @param twitters
     * @return 
     */
    private String Gettext(String twitters) {
        String text="";
         String tokens[]=GetTokens(twitters);
         //Para cada token examinamos si no es una mencion,
         //hastag, enlace o emoji, sino es agregamos como palabra
            for (int i = 0; i < tokens.length; i++) {
                if(!isMencion(tokens[i])){
                   if(!isHashTag(tokens[i])){
                       if(!isEnlace(tokens[i])){
                           if(!isEmoji(tokens[i])){
                               text=text+" "+tokens[i];
                           }
                       }
                   }
                }
            }

        return text;
    }
    
    public boolean isPalabra(String token){
        boolean ispalabra=false;
             if(!isMencion(token)){
                   if(!isHashTag(token)){
                       if(!isEnlace(token)){
                           if(!isEmoji(token)){
                               ispalabra=true;
                           }
                       }
                   }
                }
        
        
        
        return ispalabra;
    }
       
    /**
     * Obtenemos las menciones del texto
     * @param twitters
     * @return 
     */
    private ArrayList<String> GetMencion(String twitters) {
        ArrayList<String> mencion=new ArrayList<String>();
            
            String tokens[]=GetTokens(twitters);
            
            //Para cada token analizamos si es una mencion
            //Si es una mencion agregamos a la lista de menciones
            for (int i = 0; i < tokens.length; i++) {
                if(isMencion(tokens[i])){
                    mencion.add(tokens[i]);
                }
            }
         
         
         return mencion;
    }
    
    /**
     * analiza si un token es una mencion, mediante una expresion regular
     * @param token
     * @return 
     */
    public boolean isMencion(String token){
        boolean isMenc=false;
             String regex = "((@[a-zA-z0-9_]+))";
             Pattern pattern = Pattern.compile(regex);
             Matcher matcher = pattern.matcher(token);
         
            if(matcher.find()){
                               
                isMenc=true;
            }
            
        return isMenc;
    }
    
    /**
      * Para cada token, analiza si es un hashtag
      * @param twitters
      * @return 
      */
    private ArrayList<String>  GetHashTag(String twitters) {
         ArrayList<String> hasTag=new ArrayList<String>();
            
            String tokens[]=GetTokens(twitters);
            
            for (int i = 0; i < tokens.length; i++) {
                if(isHashTag(tokens[i])){
                    hasTag.add(tokens[i]);
                }
            }
         
         
         return hasTag;
        
    }
    
    /**
     * Analiza si un token es un hastag, mediante expresion regular
     * @param token
     * @return 
     */
    public boolean isHashTag(String token){
        boolean isHashTag=false;
             String regex = "((#[a-zA-z0-9_]+))";
             Pattern pattern = Pattern.compile(regex);
             Matcher matcher = pattern.matcher(token);
         
            if(matcher.find()){
                               
                isHashTag=true;
            }
            
        return isHashTag;
    }

    /**
     * Obtiene todos los enlaces en un twitter
     * @param twitters
     * @return 
     */
    private ArrayList<String> GetEnlaces(String twitters) {
        ArrayList<String> enlace=new ArrayList<String>();
            
            String tokens[]=GetTokens(twitters);
            
            for (int i = 0; i < tokens.length; i++) {
                if(isEnlace(tokens[i])){
                    enlace.add(tokens[i]);
                }
            }
         
        return enlace;
    }
    
    /**
     * Identifica si es un enlace mediante una expresion regular
     * @param token
     * @return 
     */
    public boolean isEnlace(String token){
        boolean isEnlace=false;
             String regex = "(http.+|https.+|Http.+)";
             Pattern pattern = Pattern.compile(regex);
             Matcher matcher = pattern.matcher(token);
         
            if(matcher.find()){
                               
                isEnlace=true;
            }
            
        return isEnlace;
    }
    
    /**
     * Obtiene todos los emojis de un twitter
     * @param twitters
     * @return 
     */
    private ArrayList<String> GetEmoji(String twitters) {
        ArrayList<String> emojis=new ArrayList<String>();
            
            String tokens[]=GetTokens(twitters);
            
            for (int i = 0; i < tokens.length; i++) {
                if(isEmoji(tokens[i])){
                    emojis.add(tokens[i]);
                }
            }
         
        return emojis;
        
    }

    /**
     * Identidica un emoji mediante expresiones regulares
     * la primera expresion regular identifica emojis en codificacion UNICODE
     * La segunda expresion regular idenficia de una lista de emojis analizada
     * @param token
     * @return 
     */
    public boolean isDigito(String token){
        boolean isdigito=false;
        String regex = "([0-9]+)";
             Pattern pattern = Pattern.compile(regex);
             Matcher matcher = pattern.matcher(token);
         
            if(matcher.find()){
                               
                isdigito=true;
            }
            
            return isdigito;
    }
    
    public boolean isEmoji(String token) {
       boolean isEmoji=false;
         String regex = "[^\\p{L}\\p{N}\\p{P}\\p{Z}]";
         Pattern pattern = Pattern.compile(regex,Pattern.UNICODE_CHARACTER_CLASS);
         Matcher matcher = pattern.matcher(token);
         
            if(matcher.find()){
                               
                isEmoji=true;
            }
            
           
          String regex2 = "b\\)|\\:0|\\<3|\\:v|\\:\\*|\\:\\)|\\:\\(|B\\)|\\;\\)";   
          Pattern pattern2 = Pattern.compile(regex2);
          Matcher matcher2 = pattern2.matcher(token);
          
          if(matcher2.matches()){
                               
                isEmoji=true;
            }
          
       return isEmoji;
    }
    
    
    public String[] toStringTwitter(){
        String [] formattwitt=new String[okTwitter.size()];
             String cadtwitt="";
         for (int i = 0; i <formattwitt.length; i++) {
            
             cadtwitt="TWITTER "+i+" \nRAW:"+okTwitter.get(i).getRaw()+
                     "\nTEXT:"+okTwitter.get(i).getText()+
                     "\nMENCIONES:"+getStringArrayList(okTwitter.get(i).getMension())+
                     "\nHASHTAG:"+getStringArrayList(okTwitter.get(i).getHashTag())+
                     "\nEMOJIS:"+getStringArrayList(okTwitter.get(i).getEmojis())+
                     "\nENLACES:"+getStringArrayList(okTwitter.get(i).getEnlaces())+"\n\n";
            formattwitt[i]=cadtwitt;
        }
        
        return formattwitt;
    }
   

   public String getStringArrayList(ArrayList<String> list){
        String text="";
              for (int i = 0; i <list.size() ; i++) {
                   text=text+"\n"+list.get(i);
               }
        return text;
    }
   
   
   public String[] ArrayNOTwitts(){
       String notwitts[]=new String[noRTwitter.size()];
             for (int i = 0; i < notwitts.length; i++) {
                notwitts[i]=noRTwitter.get(i);
             }
       return notwitts;
   }
    
    
}
