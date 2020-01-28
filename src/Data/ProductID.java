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
public class ProductID {
    
   private final String productId;
   private String descipcion;
   public ProductID(String code) { this. productId = code; } 

    public ProductID(String productId, String descipcion) {
        this.productId = productId;
        this.descipcion = descipcion;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }
   
   
   
   public String getProductId() { return productId; }

     @Override
     public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false; ProductID prodId = (ProductID) o;
     return productId.equals(prodId.productId);
       }
        
       @Override
        public int hashCode() { return productId.hashCode(); }
        
        @Override
        public String toString() {
        return "ProductID{" + "personal productId='" + productId + '\'' + '}';
        } 
}
