/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samir_a3;

/**
 * Exception for symbol of investment
 */
public class symbolException extends Exception {

    public symbolException() {
        super("Symbol is invalid!");
    }
    
    public symbolException(String message) {
        super(message);
    }
    
}
