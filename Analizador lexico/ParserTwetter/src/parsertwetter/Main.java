/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsertwetter;

import java.util.Scanner;


public class Main {
   
    public static void main(String[] args) {
         IOReader IO=new IOReader();
         
         String NombreArchivo="";
         
         Parser parserTwett=new Parser();
         
         System.out.println("******IDENTIFICADOR TWITTER********");
         Scanner leer=new Scanner(System.in);
         
        
                  System.out.println("\n>>Ingresa la ruta del archivo:\n");
                  NombreArchivo=leer.next();                  
                  String twetts[]=IO.LeerArchivo(NombreArchivo);
                  parserTwett.ParserTwittLote(twetts); //Mandamos los twitters leeidos del archivo
                  String twitterResult[]=parserTwett.toStringTwitter(); //Obtenemos el resultado
                  IO.EscribirArchivoBoleto("SalidaTwitter.txt", twitterResult);
                  IO.EscribirArchivoBoleto("NoTwitter.txt", parserTwett.ArrayNOTwitts());
                  System.out.println("LISTO! los resultados estan en el archivo SalidaTwitter.txt\n y los no aceptados en NoTwitter.txt");
                  System.out.println("\n>>Imprimir en consola (S/N):");
                  String imprime=leer.next();
                  if(imprime.equalsIgnoreCase("S")){
                      for (int i = 0; i < twitterResult.length; i++) {
                          System.out.println(twitterResult[i]);
                      }
                  }
                
       //    public static void main(String[] args) {
//        String [] twitters=new String [10];
//        twitters[0]="@united Oh, we are sure it's not planned, but it occurs absolutely consistently, it's usually the only YYJ flight that's Cancelled Flightled daily.";
//        twitters[2]="History exam studying ugh";
//        twitters[3]="@kirstiealley my dentist is great but she's expensive... :(";
//        twitters[4]="#DeflateGate #Ballghazi #BallGate All Tom Brady and Belichick have to do is say they are long time democrats and base …";
//        twitters[5]="Video of the first user of @Google 's self driving car (lost 95% of his vision - well past legally blind) http://t.co/wk6qeQIF #amazing";
//        twitters[6]="Having the old Coca-Cola guy on the GM board is stupid has heck! #tcot #ala";
//        twitters[7]="I have to go to Booz Allen Hamilton for a 2hr meeting :(  But then i get to go home :)";
//        twitters[8]="@kirstiealley Pet Dentist http://www.funnyville.com/fv/pictures/dogdentures.shtml";
//        twitters[9]="@asherroth World Cup 2010 Access?? Damn, that's a good look!";
//        twitters[10]="@FastCoDesign I am so excited for this! Come on self-driving cars.";
//        
//    }
//  
         
         
         
    }
}
