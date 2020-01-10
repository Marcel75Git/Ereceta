/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class PatientContr {
    
   private final String contr;
   public PatientContr(String contr) { this. contr = contr; } 
   
   public String getPatientContr() { return contr; }

     @Override
     public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false; PatientContr MyContr = (PatientContr) o;
     return contr.equals(MyContr.contr);
       }
        
       @Override
        public int hashCode() { return contr.hashCode(); }
        
        @Override
        public String toString() {
        return "PatientContr{" + "Patient contr='" + contr + '\'' + '}';
        } 
}
