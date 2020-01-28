/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import Data.ProductID;
import Excepciones.DispensingNotAvailableException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class Dispensing {
    
    private byte nOrder;
    private LocalDate initDate, finalDate; 
    private boolean isCompleted;
    String nom;
    private ePresciption patientEprescripcion;
    
    private List<ProductID> listProduct = new ArrayList<ProductID>();
    ProductID productID = new ProductID("");
    
    List<MedicingDispencingLine> listMedicine = new ArrayList<>();
    
    
    public Dispensing() {} 

    public Dispensing(byte nOrder, LocalDate initDate, LocalDate finalDate, boolean isCompleted) {
        this.nOrder = nOrder;
        this.initDate = initDate;
        this.finalDate = finalDate;
        this.isCompleted = isCompleted;
        this.patientEprescripcion = new ePresciption(false);
    }
    
    

    public Dispensing(String nom) {
        this.nom = nom;
    }
    
    public void añadirMedecineLine(MedicingDispencingLine medeDispencingLine){
         listMedicine.add(medeDispencingLine);
    }
    
     @Override
        public String toString() {
        return "Dispensing{" + "Dispensing nOrder='" + nOrder + '\'' + '}';
        } 

    public byte getnOrder() {
        return nOrder;
    }

    public void setnOrder(byte nOrder) {
        this.nOrder = nOrder;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public List<ProductID> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductID> listProduct) {
        this.listProduct = listProduct;
    }

    public ProductID getProductID() {
        return productID;
    }

    public void setProductID(ProductID productID) {
        this.productID = productID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    

    public Dispensing(boolean isCompleted) throws DispensingNotAvailableException{
          if(isCompleted== false){
              throw  new DispensingNotAvailableException("la fecha de entrada es superior a la fecha actual");
          }
        this.isCompleted = isCompleted;
    }
    
    
    
    public boolean dispensingEnable() throws DispensingNotAvailableException{
       boolean a = false;
        
        System.out.println("vais a entrar la feche de inicio..");
        System.out.println("entrar el dia");
        Scanner scanner = new Scanner(System.in);
        int dia = scanner.nextInt();
        
        System.out.println("entrar el mes");
        Scanner scan = new Scanner(System.in);
        int mes = scan.nextInt();
        
        System.out.println("entrar el año");
        Scanner scann = new Scanner(System.in);
        int año = scann.nextInt();
        
        if(dia > 31 && mes > 12){
            System.out.println("verificar el mes y el dia de entrada");
        }else{
            LocalDate MyActualDate = LocalDate.now();
            System.out.println("la fecha actual es : " + MyActualDate);
            
            LocalDate currentTime = LocalDate.now();
            LocalDate date2 = currentTime.withDayOfMonth(dia).withYear(año).withMonth(mes);
            //System.out.println("Date modifiée : " + date2);
               if(MyActualDate.isAfter(date2)){
                   System.out.println("fecha superior : " + date2);
                   return a = true;
               }else{
                 throw new DispensingNotAvailableException("la fecha de entrada es superior a la fecha actual");
               }
        }
        return a;
    }
    public void setProductAsDispensed(ProductID prodID) {
        String idProducto = prodID.getProductId();
          for (MedicingDispencingLine listMedicine :listMedicine) {
             if(idProducto.equals(listMedicine.getProductSpecification().getUPCode())) {
                   listMedicine.setAcquired(true);
             }
          }
    }
    public void setCompleted() { System.out.println("todos los medicamentos dispensados");  }
    public void dateActuelle (){
        LocalDate MyActualDate = LocalDate.now();
            System.out.println("la fecha actual es : " + MyActualDate);
    }
}
