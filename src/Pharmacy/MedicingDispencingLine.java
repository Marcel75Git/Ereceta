/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class MedicingDispencingLine {
    private boolean acquired;
    private ProductSpecification productSpecification;
    
    public MedicingDispencingLine(boolean acquired, ProductSpecification productSpecification) {
        this.acquired = acquired;
        this.productSpecification= productSpecification;
    }

    public ProductSpecification getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(ProductSpecification productSpecification) {
        this.productSpecification = productSpecification;
    }

    public boolean isAcquired() {
        return acquired;
    }

    public void setAcquired(boolean acquired) {
        this.acquired = acquired;
    }
    
}
