/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsertwetter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class IOReader {
    
    
    
    public String[] LeerArchivo(String nombreArchivo){
        File archivo=null;
	FileReader fr=null;
	BufferedReader br=null;
        String[] lineas=null;

        
	 try{
	   archivo= new File (nombreArchivo);
	   fr= new FileReader(archivo);
	   br= new BufferedReader(fr);
	   String linea;

           
	   while((linea=br.readLine())!= null){
             // System.out.println(linea);
             if(lineas==null){
             lineas=new String[1];
             lineas[0]=linea;
            }else{
             String copia[]=new String[lineas.length+1];
             System.arraycopy(lineas, 0, copia, 0, lineas.length);
             copia[lineas.length]=linea;
             lineas=copia;
            }
              
            }
          
 	   } catch(Exception e){
 	      e.printStackTrace();
 	   }finally{
 	        try{
 	          if(null != fr){
 	             fr.close();
 	          }

 	        }catch (Exception e2){
 	         e2.printStackTrace();
 	        }

 	   }
         
         return lineas;
    }
    

  
    public void EscribirArchivoBoleto(String nombreArchivo, String lineas[]){
        FileWriter fichero=null;
        PrintWriter pw=null;

        try{
                fichero=new FileWriter(nombreArchivo);
                pw=new PrintWriter (fichero);

                for(int i=0; i<lineas.length; i++){
//                   
                        pw.println(lineas[i]);
                }


        }catch (Exception e){
                e.printStackTrace();
        }finally{
                try{
                        if(null != fichero){
                                fichero.close();
                        }
                }catch (Exception e2){
                        e2.printStackTrace();
                }
        }
    }
       


    
    
}
