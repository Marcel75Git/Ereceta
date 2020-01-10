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

    public MedicingDispencingLine(boolean acquired) {
        this.acquired = acquired;
    }

    public boolean isAcquired() {
        return acquired;
    }

    public void setAcquired(boolean acquired) {
        this.acquired = acquired;
    }
    
}
