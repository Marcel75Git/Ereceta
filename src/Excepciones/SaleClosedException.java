/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author mfoulouyvesmarcel
 */
public class SaleClosedException extends Exception{
    private boolean isclosed;
  public SaleClosedException(String message){
      super(message);
  } 
public void test(boolean isclosed){
    System.out.println("yeah");
}  
}
