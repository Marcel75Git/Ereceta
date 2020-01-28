/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import Data.PatientContr;
import Data.ProductID;
import Excepciones.SaleClosedException;
import Excepciones.SaleNotInitiatedException;
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
    private BigDecimal  amount = new BigDecimal(0);
    private boolean isClosed; 
    
    private List<ProductID> productID = new ArrayList<ProductID>();
    private List<BigDecimal> tab = new ArrayList<BigDecimal>();
    private List<PatientContr> patientControle = new ArrayList<PatientContr>();
    
    private BigDecimal somme = new BigDecimal(0);
    private BigDecimal MaTaxes = new BigDecimal(0);
    private BigDecimal calculFinal = new BigDecimal(0);
    private BigDecimal calculFinalAmou = new BigDecimal(0);
    
    private Dispensing dispensing;
    private List<ProductSaleLine> productSaleLines =new ArrayList<>();
    
    
    public Sale (Dispensing dispensing) {
       this.dispensing = dispensing;
    } 

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
    
    
   /* public void addLines(ProductID prodId, BigDecimal price, PatientContr contr){
        System.out.println("entrar patient Control");
        Scanner scanner = new Scanner(System.in);
        String contribution = scanner.nextLine();
        
        contr = new PatientContr(contribution);
        int valuePar = Integer.parseInt(contribution);
        System.out.println("mypRODUCT" +prodId + "el precio " + price + " el pacient Control " + valuePar);
         return ;
         
    }*/
    
    
    public void addLine(ProductID prodId, BigDecimal price, PatientContr contr){ 
        System.out.println("que cantidad quieres??");
        Scanner scanner = new Scanner(System.in);
        BigDecimal cantidad  = scanner.nextBigDecimal();
      ProductSaleLine productSaleLine = new ProductSaleLine(cantidad.multiply(price), prodId.getProductId(),prodId.getDescipcion(),price);
      productSaleLines.add(productSaleLine);
      dispensing.añadirMedecineLine(productSaleLine.getMedicingDispencingLine());
 
    }
    
    
    // debe ser privada
    public void calculateAmount() {
         for (ProductSaleLine productSaleLine : productSaleLines) {
             amount = amount.add(productSaleLine.getSubTotal());
        }
        System.out.println("calcul Amount " + amount);
    }
    // debe ser privada
    public void addTaxes() throws SaleClosedException { 
         BigDecimal iv  = new BigDecimal(0.21);
         amount = amount.add(amount.multiply(iv));
         System.out.println("cantidad finale"+ amount);
    }
    public void calculateFinalAmount() throws SaleClosedException , SaleNotInitiatedException{
     calculateAmount();
     addTaxes();
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

    public Dispensing getDispensing() {
        return dispensing;
    }

    public void setDispensing(Dispensing dispensing) {
        this.dispensing = dispensing;
    }
    
    
}
