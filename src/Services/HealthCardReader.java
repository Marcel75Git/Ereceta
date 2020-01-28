/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Data.HealthCardID;
import Excepciones.HealthCardException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Data.ProductID;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class HealthCardReader {
   public static String hcardIdString = new String();
    public static ProductID productId = new ProductID("1123");
    public HealthCardReader() {
    }
        
    /**
     *
     * @return
     * @throws HealthCardException
     */
    
    public static HealthCardID getHealthCardID() throws HealthCardException {
        List<HealthCardID> listHead = new ArrayList<>();
        HealthCardID hcid1 = new HealthCardID("yves0000");
        HealthCardID hcid2 = new HealthCardID("marcel");
        HealthCardID hcid3 = new HealthCardID("mfoulou");
       
        listHead.add(hcid1);
        listHead.add(hcid2);
        listHead.add(hcid3);
        
        System.out.println("entrer une HealtCardiD");
        Scanner scanner= new Scanner(System.in);
        String valeur = scanner.nextLine();
        
        String healthCardd = null;
        
        
      /*  for (HealthCardID healthCardID : listHead) {
            if(healthCardID.getPersonalID().equals(valeur)){
                System.out.println("existe");
            }
        }*/
      boolean bexiste = false; 
      int contador = 0;
        do {            
            if(listHead.get(contador).getPersonalID().equals(valeur)){
                bexiste=true;
            }else{
                contador++;
            }
        } while (!bexiste && listHead.size() > contador);
        
        if(!bexiste){
            throw new HealthCardException("incorrect identification del paciente : el healthcard id no exist");
        }
        
    
      
        return listHead.get(contador);
        //return null;
    }
}

       //if(healthCardId.equals("")){System.out.println("error");}
       /*for( int n = 0; n<healthCardId.length(); n++) {
        char c = healthCardId.charAt(n);
           if (n<3) {
              if(!Character.isLetter(c)){
                  throw new HealthCardException("doit commencer par une lettre "+healthCardId);
                     }
        //System.out.println(c);
          } else{
               if(!Character.isDigit(c)){
                  throw new HealthCardException("see "+healthCardId);
                     }
               
           }
        //return hcid1;
    }*/
