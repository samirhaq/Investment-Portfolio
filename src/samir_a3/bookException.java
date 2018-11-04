/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samir_a3;

/**
 * Exception for the bookValue of an investment
 */
public class bookException extends Exception {

    public bookException() {
        super("BookValue is invalid!");
    }
    
    public bookException(String message) {
        super(message);
    }
    
}
