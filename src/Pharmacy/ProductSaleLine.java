/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import java.math.BigDecimal;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class ProductSaleLine {
    private BigDecimal subTotal;
    private ProductSpecification productSpecification;
    MedicingDispencingLine medicingDispencingLine;

    public MedicingDispencingLine getMedicingDispencingLine() {
        return medicingDispencingLine;
    }

    public void setMedicingDispencingLine(MedicingDispencingLine medicingDispencingLine) {
        this.medicingDispencingLine = medicingDispencingLine;
    }
    
    public ProductSaleLine(BigDecimal subTotal, String UPCcode, String descripcion, BigDecimal price) {
        this.subTotal = subTotal;
        productSpecification = new ProductSpecification(UPCcode, descripcion, price);
        medicingDispencingLine= new MedicingDispencingLine(false, productSpecification);
        
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
    
}
