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
import Excepciones.ConnectException;
import Excepciones.DispensingNotAvailableException;
import Excepciones.HealthCardException;
import Excepciones.NotValidePrescriptionException;
import Excepciones.PatientIDException;
import Excepciones.ProductIDException;
import Excepciones.SaleClosedException;
import Services.HealthCardReader;
import Services.SNS;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import Pharmacy.Dispensing;
import jdk.nashorn.internal.ir.Symbol;
import Pharmacy.ProductSpecification;
import Excepciones.SaleNotInitiatedException;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class DispensingTerminal extends SNS{
     private String val;
     private  HealthCardID healthCardID;
     private  SNS sns = new SNS();
    
     
    public SNS getSns() {
        return sns;
    }

    public void setSns(SNS sns) {
        this.sns = sns;
    }
    
    
    
     List<HealthCardID> healthCardIDs = new ArrayList<>();
     List<MedicalPrescription> listMedicalPrescripcion = new ArrayList<MedicalPrescription>();
    HashMap<HealthCardID,MedicalPrescription> hashMap = new HashMap<HealthCardID,MedicalPrescription>();
    
   Dispensing vaDispensing ;
   PatientContr patientContr;
   ProductSpecification productSpecification;
   Sale sale;
       // MedicalPrescription medicalPrescription = new MedicalPrescription(null, null, null);
        
         LocalDate currentTime = LocalDate.now();
         LocalDate endDate = currentTime.withDayOfMonth(5).withYear(2007).withMonth(11);
         LocalDate presDate = currentTime.withDayOfMonth(6).withYear(2008).withMonth(11);
         MedicalPrescription medicalPrescription = new MedicalPrescription("1123",presDate, endDate);
          MedicalPrescription medicalPrescriptions = new MedicalPrescription("1123",presDate, endDate);
         
         String value;
         
      

    public DispensingTerminal() {
       
    }

    
    
    
  
public void getePrescription(char option) throws HealthCardException, PatientIDException, NotValidePrescriptionException, ConnectException{ 
    
      try {
         healthCardID = HealthCardReader.getHealthCardID();
         vaDispensing = sns.getePrescription(healthCardID);
         patientContr = sns.getPatientContr(healthCardID);
         } catch ( HealthCardException | NotValidePrescriptionException ex) {
             //System.err.println(ex.getMessage());
             throw ex;
         }//vaDispensing = sns.myDispencing(nom);
    
   
} 
public void initNewSale() throws DispensingNotAvailableException, ProductIDException{
   sale = new Sale(vaDispensing);
  // ProductSpecification productSpecification = new ProductSpecification();
       
}  
public void enterProduct(ProductID pID) throws ProductIDException, ConnectException{ 
    
        try {
            productSpecification= sns.getProductSpecific(pID);
            sale.addLine(pID, productSpecification.getPrice(), patientContr);
            vaDispensing.setProductAsDispensed(pID);
        } catch (ProductIDException ex) {
              throw ex;
        }
    
}
 public void finalizeSale() throws SaleNotInitiatedException , SaleClosedException{
         try {
             sale.calculateFinalAmount();
         } catch (SaleClosedException   ex) {
             throw ex;
         }
}
public void realizePayment(BigDecimal quantity) { }
public void realizePayment() { }
public void printNextDispensingSheet() {System.out.println("print dispensacion"); }

public void createmethodeSaleLine(ProductID pId, BigDecimal prive, Patient patient){
  
    
}

} 
