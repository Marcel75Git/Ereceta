/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Data.HealthCardID;
import Data.PatientContr;
import Data.ProductID;
import Excepciones.ConnectException;
import Excepciones.HealthCardException;
import Excepciones.NotValidePrescriptionException;
import Excepciones.ProductIDException;
import Pharmacy.Dispensing;
import Pharmacy.ProductSpecification;
import java.util.List;
import ereceta.Ereceta;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Pharmacy.ProductSaleLine;
import Pharmacy.Sale;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class SNS extends HealthCardReader implements NationalHealthService{
  
    BigDecimal bigDecimal = new BigDecimal(11);
    BigDecimal bigDecimal1 = new BigDecimal(12);
    BigDecimal somme = new BigDecimal(0);
    BigDecimal productContribution = new BigDecimal(0);
         byte b1 = 4;
         LocalDate currentTime = LocalDate.now();
         LocalDate presDate = currentTime.withDayOfMonth(5).withYear(2007).withMonth(11);
         LocalDate endDate = currentTime.withDayOfMonth(6).withYear(2008).withMonth(11);

     private Dispensing vaDispensing = new Dispensing(b1, presDate, endDate, false);
     private PatientContr patientContr = new PatientContr("controle");
     //private ProductSpecification productSpecification = new ProductSpecification("aspirine", "null", bigDecimal);
     private static HashMap<String,Dispensing> hashMap;
     private static HashMap<String,PatientContr> hashMap1;
    // public HealthCardID healthCardIDs = new HealthCardID("bid");
     HashMap<ProductID, ProductSpecification> mySpecification = new HashMap<>();
     List<ProductID> productIDs = new ArrayList<>();
     ProductID productID = new ProductID("1123");
     ProductID productID1 = new ProductID("1124");
     ProductID productID2 = new ProductID("1125");
    
     ProductSpecification productSpecification1 = new ProductSpecification(productID.getProductId(), "MyDescription ", bigDecimal);
     ProductSpecification productSpecification2 = new ProductSpecification(productID1.getProductId(), "Cap ", bigDecimal1);
     ProductSpecification productSpecification3 = new ProductSpecification(productID2.getProductId(), "descipcion", somme);
     public SNS(){
         // en principe n a pas sa place dans le constructeur besoin d explication
          /*byte b1 = 4;
         LocalDate currentTime = LocalDate.now();
         LocalDate presDate = currentTime.withDayOfMonth(5).withYear(2007).withMonth(11);
         LocalDate endDate = currentTime.withDayOfMonth(6).withYear(2008).withMonth(11);*/
         
        
     //HealthCardID healthCardID = new HealthCardID("yves0000");
     Dispensing dispensing = new Dispensing(b1, presDate, endDate, false);
     Dispensing dispensing1 = new Dispensing(b1, presDate, endDate, false);
     PatientContr patientContr = new PatientContr("controle");
     hashMap = new HashMap<String, Dispensing>();
     hashMap.put("yves0000", dispensing);
     hashMap.put("mfoulou", dispensing1);
     hashMap1 = new HashMap<String,PatientContr>();
     hashMap1.put("yves0000", patientContr);
     mySpecification = new HashMap<ProductID,ProductSpecification>();
     mySpecification.put(productID, productSpecification1);
     mySpecification.put(productID1, productSpecification2);
  
     }
     
    @Override
    public Dispensing getePrescription(HealthCardID healthCardID) throws HealthCardException, NotValidePrescriptionException, ConnectException {
        
        //To change body of generated methods, choose Tools | Templates.
      
         for (Map.Entry<String, Dispensing> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                if (key.equals(healthCardID.getPersonalID())){
                     System.out.println("el dispensing del paciente" + healthCardID + "la date de dispencing" + vaDispensing.getInitDate() + "la date final de dispencing" +vaDispensing.getFinalDate());
                    return entry.getValue();
                   }else{
                    throw new NotValidePrescriptionException("El healtCardid " + healthCardID.getPersonalID()+ "no tiene prescripción");
                }
            }
           return null;
    }
    
    /**
     *
     */
    @Override
    public PatientContr getPatientContr(HealthCardID healthCardID) throws ConnectException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("entrar la contribution del paciente");
        Scanner scanner = new Scanner(System.in);
        BigDecimal b = scanner.nextBigDecimal();
        String contributionOfPatient=b.toString();
        PatientContr patientContr = new PatientContr(contributionOfPatient);
          System.out.println("la contribution del paciente es de " + patientContr.getPatientContr());
        return patientContr;
    }

    @Override
    public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         
          if(pID.equals(null)){
            throw new ConnectException("es nulo");
            }
          //poser question sur le stop
          boolean bexiste = false;
          for (Map.Entry<ProductID, ProductSpecification> entry : mySpecification.entrySet()) {
            ProductID key = entry.getKey();
            ProductSpecification value = entry.getValue();
            
                 if(pID.getProductId().equals(key.getProductId())){
                    System.out.println("el price " + value.getPrice() + " la description " +value.getDescripcion());
                     bexiste =true;
                     return value;
                 }
            }
          if(!bexiste){
              throw new ProductIDException("este producto no existe");
          }
          return null;
    }

    @Override
    public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
