/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import java.util.Date;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class Patient {
    private String name,dni,sexe,contribution;
    private Date Birthdate;

    public Patient(String contribution) {
        this.contribution = contribution;
    }

    public Patient(String name, String dni, String sexe, String contribution, Date Birthdate) {
        this.name = name;
        this.dni = dni;
        this.sexe = sexe;
        this.contribution = contribution;
        this.Birthdate = Birthdate;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public Date getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(Date Birthdate) {
        this.Birthdate = Birthdate;
    }
    
}
