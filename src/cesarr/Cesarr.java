/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cesarr;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.Scanner;

/**
 *
 * @author toufik
 */
public class Cesarr {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static String crypt(String clairTxt,int cle){
        if(cle>26){
            cle=cle%26;
        }else if(cle<0){
            cle=(cle%26)+26;
        }
        String cryptTxt="";
       // System.out.println("longueur: "+clairTxt.length());
        for(int i=0;i<clairTxt.length();i++){
            
          char ch=clairTxt.charAt(i);
          //System.out.println("old cracter"+i+": "+ch);
          if(Character.isLetter(ch)){
              
              if(Character.isLowerCase(ch)){
                  
                  char c=(char)(ch+cle);
                 // System.out.println("new cracter"+i+": "+c);
                  if(c>'z'){
                   cryptTxt+=(char)(ch-(26-cle));   
                  }else{
                      cryptTxt+=c;
                  }
              }else if(Character.isUpperCase(ch)){
                  char c=(char)(ch+cle);
                  if(c>'Z'){
                    cryptTxt+=(char )(ch-(26-cle));  
                  }else{
                      cryptTxt+=c;
                  }
              }
          }else{
              cryptTxt+=ch;
          }
        }
        
        return cryptTxt;
        
    }
    
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
          File fichier = new File("C:\\Users\\toufik\\Documents\\testClair.txt");
          Path chemin = Paths.get("C:\\Users\\toufik\\Documents\\testClair.txt");
          File fichier1 = new File("C:\\Users\\toufik\\Documents\\testCody.txt");
          Path chemin1 = Paths.get("C:\\Users\\toufik\\Documents\\testCody.txt");
    // if (fichier.createNewFile())
        //System.out.println("Le fichier a été créé");
      //else
        //System.out.println("Erreur, Impossible de créer ce fichier");
     
        
        Scanner x =new Scanner (System.in);
        System.out.println("donner votre message:");
           String msgClair=x.nextLine();
           
           //ecrire a fichier testClair.txt
            // convertit String en un tableau d'octets
        byte[] data = msgClair.getBytes();
 
        OutputStream output = null;
        try {
            // Un objet BufferedOutputStream est affecté à la référence OutputStream.
            output = new BufferedOutputStream(Files.newOutputStream(chemin, CREATE));
            // Ecrire dans le fichier
            output.write(data);
 
            // vider le tampon
            output.flush();
 
            // fermer le fichier
            output.close();
 
        } catch (Exception e) {
            System.out.println("Message " + e);
        }
           
           
            System.out.println("donner la clé:");
           int cle=x.nextInt();
          System.out.print(" message coder: "); 
          String crpt=crypt(msgClair,cle);
          System.out.println(crpt);
          
          
          
        // convertit String en un tableau d'octets
        byte[] data1 = crpt.getBytes();
 
        OutputStream output1 = null;
        try {
            // Un objet BufferedOutputStream est affecté à la référence OutputStream.
            output1 = new BufferedOutputStream(Files.newOutputStream(chemin1, CREATE));
            // Ecrire dans le fichier
            output1.write(data1);
 
            // vider le tampon
            output1.flush();
 
            // fermer le fichier
            output1.close();
 
        } catch (Exception e) {
            System.out.println("Message " + e);
        }
    }
    
}
