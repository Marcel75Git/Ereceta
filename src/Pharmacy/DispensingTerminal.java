/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import Data.HealthCardID;
import Data.ProductID;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import Data.ProductID;
import Data.PatientContr;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class DispensingTerminal {
     List<HealthCardID> healthCardIDs = new ArrayList<>();
     List<MedicalPrescription> listMedicalPrescripcion = new ArrayList<MedicalPrescription>();
    HashMap<HealthCardID,MedicalPrescription> hashMap = new HashMap<HealthCardID,MedicalPrescription>();
        HealthCardID hcid1 = new HealthCardID("yves");
        HealthCardID hcid12 = new HealthCardID("marcel");
        HealthCardID hcid3 = new HealthCardID("mfoulou");
        
       // MedicalPrescription medicalPrescription = new MedicalPrescription(null, null, null);
        
         LocalDate currentTime = LocalDate.now();
         LocalDate endDate = currentTime.withDayOfMonth(5).withYear(2007).withMonth(11);
         LocalDate presDate = currentTime.withDayOfMonth(6).withYear(2008).withMonth(11);
         
         String value;
         
         //ProductSpecification productSpecification = new ProductSpecification(null, null, null);
         List<ProductSpecification> listProductSpecifications = new ArrayList<ProductSpecification>();
         
         HashMap<ProductID, ProductSpecification> hashMap1 = new HashMap<>();
         
         
         BigDecimal price  = new BigDecimal(12);
         
    ProductSpecification productSpecification = new ProductSpecification("aspirine", "mal de cap", price);
    ProductSpecification productSpecification1 = new ProductSpecification("paracetamol", "sentir frio", price);
    ProductSpecification productSpecification2 = new ProductSpecification("bicarbonate", "plancha", price);
  
public void getePrescription(char option) { 
      
        System.out.println("entrer votre code");
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextLine();
        
        healthCardIDs.add(hcid1);
        healthCardIDs.add(hcid12);
        healthCardIDs.add(hcid3);
      
      hashMap.put(hcid1, new MedicalPrescription("321gr",presDate , endDate));
      hashMap.put(hcid12, new MedicalPrescription("31gr",presDate , endDate));
      hashMap.put(hcid3, new MedicalPrescription("1gr",presDate , endDate));
        
         switch (value){
               case "yves": System.out.println(hashMap.get(hcid1));
               break;
               case "marcel" : System.out.println(hashMap.get(hcid12));
               break;
               case  "mfoulou":System.out.println(hashMap.get(hcid3));
               break;
               default:
                   System.out.println("no hemos encontrado nada");
           }
} 
public void initNewSale() {
    for (HealthCardID healthCardID : healthCardIDs) {
          if(value.equals(healthCardID.getPersonalID())){
              System.out.println("iniciacion del processo de venta");
          }
    }
}  
public void enterProduct(ProductID pID) { 
    hashMap1.put(new ProductID("1123"), productSpecification);
    hashMap1.put(new ProductID("1124"), productSpecification1);
    hashMap1.put(new ProductID("1125"), productSpecification2);
    int a =1;
 if(pID.getProductId().equals("")){
     System.out.println("Cuantos productos quieres entrar");
     Scanner scanner = new Scanner(System.in);
     int o = scanner.nextInt();
     
     do {         
     System.out.println("entrar l identificacion del producto");
     Scanner scanne = new Scanner(System.in);
     String producto = scanne.nextLine(); 
     
      switch(producto){
        case "1123":
            System.out.println("descipcion "+ productSpecification.getDescripcion() + " price " + productSpecification.getPrice());
            break;
             case "1124":
            System.out.println("descipcion "+ productSpecification1.getDescripcion() + " price " + productSpecification1.getPrice());
            break;
             case "1125":
            System.out.println("descipcion "+ productSpecification2.getDescripcion() + " price " + productSpecification2.getPrice());
            break;
            default:
                System.out.println("el producto no existe");
    }
     } while (a++<o);
     
 }
    
}
public void finalizeSale() {}
public void realizePayment(BigDecimal quantity) { }
public void realizePayment() { }
public void printNextDispensingSheet() {System.out.println("print dispensacion"); }

public void createmethodeSaleLine(ProductID pId, BigDecimal prive, PatientContr patientContr){
    
}

} 
