/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samir_a3;

/**
Class keeps all the values for the Mutual Fund class and has appropriate accessor and mutator methods
*/
public class MutualFund extends Investment{
    
    private String symbol;
    private String name;
    private int quantity;
    private double price;
    private double bookValue;
    
    /**
    Non-default constructor for the MutualFund class
    */
    public MutualFund(String symbol, String name, int quantity, double price, double bookValue) throws quantityException, priceException, bookException, samir_a3.nameException, samir_a3.symbolException {
        super(symbol, name, quantity, price, bookValue);
    }
    
    /**
    Default constructor for the MutualFund class
    */
    public MutualFund() throws quantityException, priceException, bookException, samir_a3.nameException, samir_a3.symbolException{
        super("", "", 0, 0, 0);
    }
    

    @Override
    /**
     * Checks to see if 2 mutual funds are equal
     * @return true if equal false if not
     */
    public boolean equals(Object o){
        if (!(o instanceof MutualFund)) return false;
        else{
            MutualFund m = (MutualFund) o;
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
    toString method creates a string for the MutualFund class
    */
    public String toString(){
        
        return super.toString();
        
    }
    
    /**
    * Calculates the book value for a mutual fund
     * @param quantity quantity of mutual fund
     * @param price price of mutual fund
     * @return bookValue of mutual fund
    */
    public double calculateBookValue(int quantity, double price) {
        return (quantity * price);
    }
    
    /**
    * Calculates the payment for a mutual fund
     * @param quantity quantity of mutual fund
     * @param price price of mutual fund
     * @return gain of mutual fund
    */
    public double calculatePayment(int quantity, double price) {
        return (quantity * price) - 45;
    }
    
    /**
    * Calculates the gain for a mutual fund
     * @param quantity quantity of mutual fund
     * @param price price of mutual fund
     * @return gain of mutual fund
    */
    public double calculateGain(int quantity, double price, double bookValue) {
        return calculatePayment(quantity, price) - bookValue;
    }
    
}

    
