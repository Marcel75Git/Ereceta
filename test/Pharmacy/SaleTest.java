/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import Data.PatientContr;
import Data.ProductID;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class SaleTest {
    
    public SaleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addLines method, of class Sale.
     */
  

    /**
     * Test of addLine method, of class Sale.
     */
    @Test
    public void testAddLine() {
        
        System.out.println("addLine");
        
        BigDecimal price = null;
        PatientContr contr = null;
        BigDecimal cantidad  = new BigDecimal(0);
        Sale instance = null;
          Dispensing dispensing = new Dispensing();
         // ProductSaleLine productSaleLine = new ProductSaleLine(cantidad.multiply(price), prodId.getDescipcion(), prodId.getDescipcion(), price);
          
    }

    
}
