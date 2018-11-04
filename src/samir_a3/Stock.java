/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samir_a3;

/**
The Stock class keeps all the variables for stocks and has appropriate accesors and mutators.
*/
public class Stock extends Investment{
    
    private String symbol;
    private String name;
    private int quantity;
    private double price;
    private double bookValue;
    
    /**
    Non-default constructor for the Stock class
    */
    public Stock(String symbol, String name, int quantity, double price, double bookValue) throws quantityException, priceException, bookException, samir_a3.nameException, samir_a3.symbolException {
        super(symbol, name, quantity, price, bookValue);
        
    }
    
    /**
    Default constructor for stock class
    */
    public Stock() throws quantityException, priceException, bookException, samir_a3.nameException, samir_a3.symbolException{
        super("", "", 0, 0, 0);
    }
    
/*
    
    */
    @Override
    /**
     * Checks if two stocks are equal
     * @return true if equal, false if not
     */
    public boolean equals(Object o){
        if (!(o instanceof Stock)) return false;
        else{
            Stock m = (Stock) o;
            if (!(this.getSymbol().equals(m.getSymbol()))) return false;
            if (!(this.getName().equals(m.getName()))) return false;
            if (!(this.getQuantity() == m.getQuantity())) return false;
            if (!(this.getPrice() == m.getPrice())) return false;
            if (!(this.getBookValue() == m.getBookValue())) return false;
            return true;
        }
    }
    
    @Override
    /**
    toString method turns the class into a string
    */
    public String toString(){
        
        return super.toString();
    }
    
    /**
    * Calculates the book value for a stock
     * @param quantity quantity of stock
     * @param price price of stock
     * @return bookValue of stock
    */
    public double calculateBookValue(int quantity, double price) {
        return (quantity * price) + 9.99;
    }
    
    /**
    * Calculates the payment for a stock
     * @param quantity quantity of stock
     * @param price price of stock
     * @return payment of stock
    */
    public double calculatePayment(int quantity, double price) {
        return (quantity * price) - 9.99;
    }
    
    /**
    * Calculates the gain for a stock
     * @param quantity quantity of stock
     * @param price price of stock
     * @return gain of stock
    */
    public double calculateGain(int quantity, double price, double bookValue) {
        return calculatePayment(quantity, price) - bookValue;
    }

}
    

