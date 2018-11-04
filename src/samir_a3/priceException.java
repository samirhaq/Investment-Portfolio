/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samir_a3;

/**
 * Exception  for the price of the investment
 */
public class priceException extends Exception {

    public priceException() {
        super("Price is Invalid!");
    }
    
    public priceException(String message) {
        super(message);
    }
    
}
