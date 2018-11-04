/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samir_a3;

/**
 * Exception for the name of an investment
 */
public class nameException extends Exception {

    public nameException() {
        super("Name is invalid!");
    }
    
    public nameException(String message) {
        super(message);
    }
}
