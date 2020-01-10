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
public class ProductSpecification {
    private String UPCode;
    private String Descripcion;
    private BigDecimal price;

    public ProductSpecification(String UPCode, String Descripcion, BigDecimal price) {
        this.UPCode = UPCode;
        this.Descripcion = Descripcion;
        this.price = price;
    }

    public String getUPCode() {
        return UPCode;
    }

    public void setUPCode(String UPCode) {
        this.UPCode = UPCode;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
}
