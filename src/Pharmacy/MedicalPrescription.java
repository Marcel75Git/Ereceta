/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class MedicalPrescription {
    private String presCode;
    private LocalDate endDate, prescDate;

    public MedicalPrescription(String presCode, LocalDate endDate, LocalDate prescDate) {
        this.presCode = presCode;
        this.endDate = endDate;
        this.prescDate = prescDate;
    }

    public MedicalPrescription(String presCode) {
        this.presCode = presCode;
    }
    
    
     @Override
        public String toString() {
        return "MedicalPrescription{" + "Medical name precode ='" + presCode + " prescDate =" + prescDate+ " end Date"+endDate+'\'' + '}';
        } 

    public String getPresCode() {
        return presCode;
    }

    public void setPresCode(String presCode) {
        this.presCode = presCode;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getPrescDate() {
        return prescDate;
    }

    public void setPrescDate(LocalDate prescDate) {
        this.prescDate = prescDate;
    }
    
    
}
