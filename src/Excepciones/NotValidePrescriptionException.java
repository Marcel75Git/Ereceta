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
public class NotValidePrescriptionException extends Exception{
    public NotValidePrescriptionException(String message){
        super(message);
    }
}
