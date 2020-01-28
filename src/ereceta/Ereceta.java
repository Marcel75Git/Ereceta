/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ereceta;

import Data.HealthCardID;
import Data.ProductID;
import Excepciones.ConnectException;
import Excepciones.DispensingNotAvailableException;
import Excepciones.HealthCardException;
import Excepciones.NotValidePrescriptionException;
import Excepciones.PatientIDException;
import Excepciones.ProductIDException;
import Excepciones.SaleClosedException;
import Excepciones.SaleNotInitiatedException;
import Pharmacy.Dispensing;
import Pharmacy.MedicalPrescription;
import Pharmacy.Sale;
import Pharmacy.TwoList;
import Pharmacy.ePresciption;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Pharmacy.TwoList;
import java.util.AbstractMap;
import javafx.util.Pair;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Hashtable;
import Pharmacy.DispensingTerminal;
import Services.SNS;
import java.util.Map;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class Ereceta {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args){
        
        /*Sale mySale = new Sale(true);
        mySale.addLine(null, BigDecimal.ONE, null);
       try {
            Sale sale = new Sale(true);
            mySale = sale;
            mySale.addLine(null, BigDecimal.ONE, null);
            mySale.calculateAmount();
            mySale.addTaxes();
            mySale.calculateFinalAmount();
            mySale.isClosed();
            
        } catch (SaleClosedException ex) {
            System.out.println(ex.getMessage());
        }*/
     
        /*
      Dispensing dispensing = new Dispensing();
        try {
            dispensing.dispensingEnable();
        } catch (DispensingNotAvailableException ex) {
            System.out.println(""+ex.getMessage());
        }
       dispensing.setProductAsDispensed(new  ProductID("aspirine34"));
       dispensing.setCompleted();
       */
    
        
       /* HealthCardID healthCardID = new HealthCardID("");
        
       
        List<HealthCardID> hcid = new ArrayList<HealthCardID>();
        hcid.add(new HealthCardID("papa"));
        hcid.add(new HealthCardID("mama"));
        
        
        
        System.err.println("entrer le hcid de l utilisateur");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        
//        HealthCardID healthCardID = new HealthCardID(value);
        
        for (HealthCardID health : hcid) {
            if(value.equals(health.getPersonalID()))  {
                System.out.println(""+value); 
            }else{
               System.out.println("este no existe "+value);  
            }
        }
       
    }
    
    
    
    
    public void getePacientContr(HealthCardID hcid){
       
     */
   
       /* DispensingTerminal dispensingTerminal = new DispensingTerminal();
        SNS services = new SNS();
        dispensingTerminal.setSns(services);
        try {
            dispensingTerminal.getePrescription('d');
        } catch (HealthCardException | PatientIDException  ex) {
            System.out.println(ex.getMessage());
        }
        try {
            dispensingTerminal.initNewSale();
        } catch (DispensingNotAvailableException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            dispensingTerminal.enterProduct(new ProductID(""));
        } catch (ProductIDException ex) {
            System.out.println(ex.getMessage());
        }*/
        
 
           DispensingTerminal dispensingTerminal = new DispensingTerminal();
        try { 
            dispensingTerminal.getePrescription('s');
            dispensingTerminal.initNewSale();
              System.out.println("cuantos productos quieres entrar");
              Scanner scanner = new Scanner(System.in);
              int a = scanner.nextInt();
               for (int i = 0; i < a; i++) {
                   System.out.println("entroduce el producto id");
                    Scanner scan = new Scanner(System.in);
                    String producto = scan.nextLine();
                    dispensingTerminal.enterProduct(new ProductID(producto));
               }
            dispensingTerminal.finalizeSale();
        } catch (HealthCardException ex) {
            System.err.println(ex.getMessage());
        } catch (PatientIDException ex) {
          System.err.println(ex.getMessage());
        } catch (NotValidePrescriptionException ex) {
           System.err.println(ex.getMessage());
        } catch (ConnectException ex) {
            Logger.getLogger(Ereceta.class.getName()).log(Level.SEVERE, null, ex);
        }
       catch (DispensingNotAvailableException ex) {
            System.err.println(ex.getMessage());
        }
        catch (ProductIDException ex) {
            System.err.println(ex.getMessage());
        }catch (SaleNotInitiatedException | SaleClosedException ex) {
            System.err.println(ex.getMessage());
        }
    }
    

 
}
