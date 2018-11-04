/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samir_a3;

/**
 *
 * @author samir
 */
abstract class Investment {
    private String symbol;
    private String name;
    private int quantity;
    private double price;
    private double bookValue;
    
    /*
    Non-default constructor for the Stock class
    */
    public Investment(String symbol, String name, int quantity, double price, double bookValue) throws quantityException, priceException, bookException, samir_a3.nameException, samir_a3.symbolException {
        if (symbol == null || symbol.isEmpty()){
            throw new symbolException();
        } else {
            this.symbol = symbol;
        }
        if (name == null || name.isEmpty() ) {
           throw new nameException();
        } else{
            this.name = name;
        }
        
        if (quantity < 0) {
            throw new quantityException();
        }
        else {
            this.quantity = quantity;
        }
        
        if (price < 0) {
            throw new priceException();
        }
        
        else {
            this.price = price;
        }
        
        if (bookValue < 0) {
            throw new bookException();
        }
        else {
            this.bookValue = bookValue;
        }
        
    }
    
    /*
    Default constructor for stock class
    */
    public Investment(){
        this.symbol = "";
        this.name = "";
        this.quantity = 0;
        this.price = 0;
        this.bookValue = 0;
    }
    
/*
    
    */
    @Override
    /**
     * Checks if 2 investments are equal
     * @return Return true if its equal, false otherwise
     */
    public boolean equals(Object o){
        if (!(o == this)) return true;
        if (!(this.getClass().equals(o.getClass()))) return false;
        
            Investment i = (Investment) o;
            if (!(this.getSymbol().equals(i.getSymbol()))) return false;
            if (!(this.getName().equals(i.getName()))) return false;
            if (!(this.getQuantity() == i.getQuantity())) return false;
            if (!(this.getPrice() == i.getPrice())) return false;
            if (!(this.getBookValue() == i.getBookValue())) return false;
            return true;
    }
    
    @Override
    /*
    toString method turns the class into a string
    */
    public String toString(){
        
        return ("Symbol:"+this.symbol+"\nName:"+this.name+"\nQuantity:"+this.quantity+"\nPrice:"+this.price+"\nBookValue:"+this.bookValue +"\n");
        
    }
    /**
    Gets the symbol
    */
    public String getSymbol() {
        return symbol;
    }
    
    /**
    Gets the name
    */
    public String getName() {
        return name;
    }
    
    /**
    Gets the quantity
    */
    public int getQuantity() {
        return quantity;
    }
    
    /**
    Gets the price
    */
    public double getPrice() {
        return price;
    }
    
    /**
    Gets the book value
    */
    public double getBookValue() {
        return bookValue;
    }
    
    /**
    Changes the quantity
     * @param quantity the new quantity of the investment
    */
    public void setQuantity(int quantity) throws quantityException {
        
        if (quantity < 0) {
            throw new quantityException();
        }
        
        else {
            this.quantity = quantity;
        }
    }
    
    
    /**
    Changes the price
    * @param price The new price of the investment
    */
    public void setPrice(double price) throws priceException {
        
        if (price < 0) {
            throw new priceException();
        }
        
        else {
            this.price = price;
        }
    }
    
    /**
    Changes the book value
    * @param bookValue The new book value of the investment
    */
    public void setBookValue(double bookValue) {
        this.bookValue = bookValue;
    }

    private Exception symbolException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Exception nameException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


