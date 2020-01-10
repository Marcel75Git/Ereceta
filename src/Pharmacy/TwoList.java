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
public class TwoList <HealthCardID,Dispensing>{
    public HealthCardID he;
    public Dispensing dis;

    public TwoList(HealthCardID he, Dispensing dis) {
        this.he = he;
        this.dis = dis;
    }

    public HealthCardID getHe() {
        return he;
    }

    public void setHe(HealthCardID he) {
        this.he = he;
    }

    public Dispensing getDis() {
        return dis;
    }

    public void setDis(Dispensing dis) {
        this.dis = dis;
    }
    
    
}
