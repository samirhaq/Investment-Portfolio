/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samir_a3;

/**
 * Exception for quantity of investment
 */
public class quantityException extends Exception {

    public quantityException() {
        super("Quantity is invalid!");
    }
    
    public quantityException(String message) {
        super(message);
    }
    
}
