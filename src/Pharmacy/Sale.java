/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import Data.PatientContr;
import Data.ProductID;
import Excepciones.SaleClosedException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class Sale {
    private int saleCode;
    private Date date; 
    private BigDecimal  amount;
    private boolean isClosed; 
    
    private List<ProductID> productID = new ArrayList<ProductID>();
    private List<BigDecimal> tab = new ArrayList<BigDecimal>();
    private List<PatientContr> patientControle = new ArrayList<PatientContr>();
    
    private BigDecimal somme = new BigDecimal(0);
    private BigDecimal MaTaxes = new BigDecimal(0);
    private BigDecimal calculFinal = new BigDecimal(0);
    private BigDecimal calculFinalAmou = new BigDecimal(0);
    
    public Sale () { } 

    public Sale(int saleCode, Date date, BigDecimal amount, boolean isClosed) {
        this.saleCode = saleCode;
        this.date = date;
        this.amount = amount;
        this.isClosed = isClosed;
    }

    public Sale(boolean isClosed) throws SaleClosedException{
        if(isClosed == false){
            throw new SaleClosedException("la venta esta cerada");
        }
        this.isClosed = isClosed;
    }
    
    public Sale(BigDecimal somme){
        this.somme = somme;
    }
    
    
    
    
    
    public void addLine(ProductID prodId, BigDecimal price, PatientContr contr){ 
        System.out.println("bingo");
        int i = 1;
        System.out.println("cuantas lineas quieres añadir ?");
        Scanner scanner = new Scanner(System.in);
        int entrada = scanner.nextInt();
        
        do {      
            
            List<ProductID> productID = new ArrayList<>();
            List<PatientContr> contrs = new ArrayList<>();
            BigDecimal bigDecimal = new BigDecimal(0);
            
            System.out.println("Entrar el product Id");
            Scanner scan = new Scanner(System.in);
            String value = scan.nextLine();
            
            prodId = new ProductID(value);
            productID.add(prodId);
            
            System.out.println("Entrar el product precio");
            Scanner scanne = new Scanner(System.in);
            price = scan.nextBigDecimal();
            
            tab.add(price);
            
            System.out.println("Entrar el contr");
            Scanner scann = new Scanner(System.in);
            String val = scann.nextLine();
            
            contr = new PatientContr(val);
            contrs.add(contr);
              // teste les valeurs
             /* for (PatientContr contr1 : contrs) {
                  System.out.println(""+contr1.getPatientContr());
            }
              
              for (ProductID contr1 : this.productID) {
                  System.out.println(""+contr1.getProductId());
            }*/
            
              
              System.out.println("your addLine is: prodId " + prodId+ "your price is" + price+ "your patientContr is"+ contr);
            
        } while (i++ < entrada);
    }
    // debe ser privada
    public void calculateAmount() {
       for(int i = 0; i < tab.size(); i++){
           somme = somme.add(tab.get(i));
       }
        System.out.println("calcul Amount " + somme);
    }
    // debe ser privada
    public void addTaxes() throws SaleClosedException { 
         BigDecimal iv  = new BigDecimal(0.21);
         MaTaxes = somme.multiply(iv);
         System.out.println("montant avec taxe est" + MaTaxes.toString());
    }
    public void calculateFinalAmount() throws SaleClosedException {
        calculFinalAmou = somme.add(MaTaxes);
        System.out.println("final somme is " + somme.toString());
        System.out.println("final taxes is " + MaTaxes);
        System.out.println("final amount is " + calculFinalAmou);
    }
    public BigDecimal getAmount() {return calculFinalAmou;}
    private void setClosed() {System.out.println("cerrar la venta"); }
    public boolean isClosed() {System.out.println("la venta esta cerada "+isClosed); return isClosed = false;
    
    
 }

    public int getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(int saleCode) {
        this.saleCode = saleCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }
}
