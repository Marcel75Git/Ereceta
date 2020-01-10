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
public class HealthCardID {
   private final String personalID;
   public HealthCardID(String hcid) { this. personalID = hcid; } 

   
   public String getPersonalID() { return personalID; }

     @Override
     public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false; HealthCardID hcardID = (HealthCardID) o;
     return personalID.equals(hcardID.personalID);
       }
        
       @Override
        public int hashCode() { return personalID.hashCode(); }
        
        @Override
        public String toString() {
        return "HealthCardID{" + "healthCardId hcid='" + personalID + '\'' + '}';
        } 
        
}
