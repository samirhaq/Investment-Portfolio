/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samir_a3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
/**
 *Class deals with arrayLists of Stock and MutualFund classes and also runs the main program
 * @author samir
 */
public class Portfolio {
    
    private ArrayList<Investment> investmentList;
    private HashMap<String, ArrayList<Integer>> index;
    
    public Portfolio() {
        this.investmentList = new ArrayList<>();
        this.index = new HashMap<String, ArrayList<Integer>>();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);
        
    }
    /**
    *Method lets the user buy a stock and adds it to the investment array list
     * @param symbol symbol of investment
     * @param name name of investment
     * @param inputQuantity number of quantity to buy
     * @param inputPrice price the investment is being bought at
     * @return a message to be displayed to the GUI
    **/
    public String buyStock(String symbol, String name, String inputQuantity, String inputPrice) {
        
        Stock tempStock;
        Investment investment;
        double bookValue = 0;
        double price = 0;
        int quantity = 0;
        
        for(int i = 0; i < investmentList.size(); ++i) {
            investment = investmentList.get(i);
            if (symbol.equals(investment.getSymbol())) {
                
                if (this.investmentList.get(i).getClass().getCanonicalName().equals("samir_a3.Stock")){
                    tempStock = (Stock) investment;

                    try {
                        quantity = Integer.parseInt(inputQuantity);
                    }

                    catch(NumberFormatException e) {
                        return "Invalid Quantity!";
                    }

                    
                }
                
                else {
                    return "The investment already exists as a mutual fund.";
                }
                
                price = tempStock.getPrice();
                name = tempStock.getName();
                bookValue += tempStock.calculateBookValue(quantity, price);
                quantity += tempStock.getQuantity();
                
                try {
                    tempStock = new Stock(symbol, name, quantity, price, bookValue);
                }
                
                catch (symbolException e) {
                    return e.getMessage();
                }
                
                catch (nameException e) {
                    return e.getMessage();
                }
                
                catch (quantityException e) {
                    return e.getMessage();
                }
                
                catch (priceException e) {
                    return e.getMessage();
                }
                
                catch (bookException e) {
                    return e.getMessage();
                }
                
                investmentList.set(i, tempStock);
                return "More stock added!";
            }
            
        }
            
        try {
            
            quantity = Integer.parseInt(inputQuantity);
        }

        catch(NumberFormatException e) {
            return "Invalid Quantity!";
        }
            
        try {
            price = Double.parseDouble(inputPrice);
        }

        catch(NumberFormatException e) {
            return "Invalid Price!";
        }
        
        
        bookValue = 0;
        try {
                tempStock = new Stock(symbol, name, quantity, price, bookValue);
            }

        catch (symbolException e) {
                return e.getMessage();
        }

        catch (nameException e) {
            return e.getMessage();
        }

        catch (quantityException e) {
            return e.getMessage();
        }

        catch (priceException e) {
            return e.getMessage();
        }

        catch (bookException e) {
            return e.getMessage();
        }
        
        bookValue = tempStock.calculateBookValue(quantity, price);
        tempStock.setBookValue(bookValue);
        investmentList.add(tempStock);
        addToHashMap(tempStock, investmentList.size() - 1);
        
        return "Stock Added!";
    }
    
    /**
    Method lets the user buy a mutual fund and adds it to the investment array list.
     * @param symbol symbol of investment
     * @param name name of investment
     * @param inputQuantity number of quantity to buy
     * @param inputPrice price the investment is being bought at
     * @return a message to be displayed to the GUI
    */
    public String buyMutualFund(String symbol, String name, String inputQuantity, String inputPrice) {
        
        MutualFund tempMutualFund;
        Investment investment;
        double bookValue = 0;
        double price = 0;
        int quantity = 0;
        
        for(int i = 0; i < investmentList.size(); ++i) {
            investment = investmentList.get(i);
            if (symbol.equals(investment.getSymbol())) {
                
                if (this.investmentList.get(i).getClass().getCanonicalName().equals("samir_a3.MutualFund")){
                    tempMutualFund = (MutualFund) investment;

                    try {
                        quantity = Integer.parseInt(inputQuantity);
                    }

                    catch(NumberFormatException e) {
                        return "Invalid Quantity!";
                    }

                    
                }
                
                else {
                    return "The investment already exists as a stock.";
                }
                
                price = tempMutualFund.getPrice();
                name = tempMutualFund.getName();
                bookValue += tempMutualFund.calculateBookValue(quantity, price);
                quantity += tempMutualFund.getQuantity();
                
                try {
                    tempMutualFund = new MutualFund(symbol, name, quantity, price, bookValue);
                }
                
                catch (symbolException e) {
                    return e.getMessage();
                }
                
                catch (nameException e) {
                    return e.getMessage();
                }
                
                catch (quantityException e) {
                    return e.getMessage();
                }
                
                catch (priceException e) {
                    return e.getMessage();
                }
                
                catch (bookException e) {
                    return e.getMessage();
                }
                investmentList.set(i, tempMutualFund);
                return "More mutual fund added!";
            }
            
        }
            
        try {
            
            quantity = Integer.parseInt(inputQuantity);
        }

        catch(NumberFormatException e) {
            return "Invalid Qunatity!";
        }
            
        try {
            price = Double.parseDouble(inputPrice);
        }

        catch(NumberFormatException e) {
            return "Invalid Price!";
        }
        
        
        bookValue = 0;
        try {
            tempMutualFund = new MutualFund(symbol, name, quantity, price, bookValue);
        }
        
        catch (symbolException e) {
            return e.getMessage();
        }

        catch (nameException e) {
            return e.getMessage();
        }

        catch (quantityException e) {
            return e.getMessage();
        }

        catch (priceException e) {
            return e.getMessage();
        }

        catch (bookException e) {
            return e.getMessage();
        }
        bookValue = tempMutualFund.calculateBookValue(quantity, price);
        tempMutualFund.setBookValue(bookValue);
        investmentList.add(tempMutualFund);
        addToHashMap(tempMutualFund, investmentList.size() - 1);
        
        return "Mutal Fund Added!";
    }
    
    /**
    Method lets the user sell stocks and decreases the quantity and adjusts the bookValue accordingly.
     * @param symbol symbol of investment
     * @param inputQuantity number of quantity to buy
     * @param inputPrice price the investment is being bought at
     * @return an arrayList of messages to return to the GUI
    */
    public ArrayList<String> sellInvestment(String symbol, String inputPrice, String inputQuantity) {
        
        ArrayList<String> output = new ArrayList<String>();
        Investment investment = null;
        double bookValue = 0;
        int index = 0;
        boolean match = false;
        Stock stock = null;
        MutualFund mutualFund = null;
        double price = 0;
        int quantity = 0;
        
        for(int i = 0; i < investmentList.size(); ++i) {
            investment = investmentList.get(i);
            if (symbol.equals(investment.getSymbol())) {
                match = true;
                index = i;
                break;
            }
        }
        
        if (!match) {
            output.add("No match found!");
            return output;
        }
        
            
            try {
                price = Double.parseDouble(inputPrice);
                if (price < 0) {
                    output.add("Invalid Price!");
                    return output;
                }
            }

            catch(NumberFormatException e) {
                output.add("Inavlid Price!");
                return output;
            }
            
            try {
                quantity = Integer.parseInt(inputQuantity);
                if ((quantity < 0) || (quantity > investment.getQuantity())) {
                    output.add("Invalid Quantity (Make sure the quantity is 0 or greater and less than the current quantity for the investment)");
                    return output;
                }
            }
            
            catch(NumberFormatException e) {
                output.add("Invalid Quantity!");
                return output;
            }       
        
        bookValue = investment.getBookValue();
        int newQuantity = investment.getQuantity() - quantity;
        double payment = 0;
        
        double gain = 0;
        
        if (investment.getClass().getCanonicalName().equals("samir_a3.Stock")){
            Stock tempStock = (Stock) investment;
            payment = tempStock.calculatePayment(quantity, price);
            if (newQuantity > 0) {
                String name = investment.getName();
                gain = payment - bookValue;
                bookValue = bookValue * ((newQuantity)/(quantity + newQuantity));
                
                try {
                    stock = new Stock(symbol, name, quantity, price, bookValue);
                }
                
                catch (symbolException e) {
                    output.add(e.getMessage());
                    return output;
                }
                
                catch (nameException e) {
                    output.add(e.getMessage());
                    return output;
                }
                
                catch (quantityException e) {
                    output.add(e.getMessage());
                    return output;
                }
                
                catch (priceException e) {
                    output.add(e.getMessage());
                    return output;
                }
                
                catch (bookException e) {
                    output.add(e.getMessage());
                    return output;
                }
                
                investmentList.set(index, stock);
            }

            else {
                investmentList.remove(index);
                deleteFromHashMap(investment, index);
            }
        }
        
        else {
            MutualFund tempMutualFund = (MutualFund) investment;
            payment = tempMutualFund.calculatePayment(quantity, price);
            if (newQuantity > 0) {
                String name = investment.getName();
                gain = payment - bookValue;
                bookValue = bookValue * ((newQuantity)/(quantity + newQuantity));
                try {
                    mutualFund = new MutualFund(symbol, name, quantity, price, bookValue);
                }
                
                catch (symbolException e) {
                    output.add(e.getMessage());
                    return output;
                }
                
                catch (nameException e) {
                    output.add(e.getMessage());
                    return output;
                }
                
                catch (quantityException e) {
                    output.add(e.getMessage());
                    return output;
                }
                
                catch (priceException e) {
                    output.add(e.getMessage());
                    return output;
                }
                
                catch (bookException e) {
                    output.add(e.getMessage());
                    return output;
                }
                investmentList.set(index, stock);
            }

            else {
                investmentList.remove(index);
                deleteFromHashMap(investment, index);
            }
        }
        
        payment = Math.round((payment) * 100.0 / 100.0);
        gain = Math.round((gain) * 100.0 / 100.0);
        output.add("Payment: $");
        output.add(Double.toString(payment));
        output.add("Net Gain: $");
        output.add(Double.toString(gain));
        return output;
    }
    
/**
 * Lets the user update the price of the stock or mutual fund.
     * @param i the index of the investment in the arrayList
     * @param investment the investment to be updated
     * @param inputPrice the new price of the investment
     * @return a message to be displayed to the GUI
 */ 
    public String update(int i, Investment investment, String inputPrice) {
        
        Stock stock = null;
        MutualFund mutualFund = null;
        
        double price = 0;

        try {
            price = Double.parseDouble(inputPrice);
            while (price < 0) {
                return "Enter a valid price!";
                
            }
        }

        catch(NumberFormatException e) {
            return "Enter a valid price!";
        }

        
        if (investment.getClass().getCanonicalName().equals("samir_a3.Stock")){
            try {
                stock = new Stock(investment.getSymbol(), investment.getName(), investment.getQuantity(), price, investment.getBookValue());
            }
            
            catch (symbolException e) {
                return e.getMessage();
            }

            catch (nameException e) {
                return e.getMessage();
            }

            catch (quantityException e) {
                return e.getMessage();
            }
            
            catch (priceException e) {
                return e.getMessage();
            }
            
            catch (bookException e) {
                return e.getMessage();
            }
            
            investmentList.set(i, stock);
        }

        else {
            try {
                mutualFund = new MutualFund(investment.getSymbol(), investment.getName(), investment.getQuantity(), price, investment.getBookValue());
            }
            
            catch (symbolException e) {
                return e.getMessage();
            }

            catch (nameException e) {
                return e.getMessage();
            }
            
            catch (quantityException e) {
                return e.getMessage();
            }
            
            catch (priceException e) {
                return e.getMessage();
            }
            
            catch (bookException e) {
                return e.getMessage();
            }
            
            investmentList.set(i, mutualFund);
        }
        
        return "Investment Updated!";
        
    }
    
    /**
    *Calculates the current gain of the user.
     * @return a hash map of the symbol and individual gains of each investment along with the total gain
    */
    public HashMap<String, Double> getGain() {
        
        Investment investment = null;
        double gain = 0;
        HashMap<String, Double> output = new HashMap<String, Double>();
        
        for(int i = 0; i < investmentList.size(); ++i) {
            investment = investmentList.get(i);
            if (this.investmentList.get(i).getClass().getCanonicalName().equals("samir_a3.Stock")){
                Stock stock = (Stock) investment;
                double investmentGain = stock.calculateGain(stock.getQuantity(), stock.getPrice(), stock.getBookValue());
                gain += investmentGain;
                investmentGain = Math.round((investmentGain) * 100 / 100);
                output.put(investment.getSymbol(), investmentGain);
            }
            
            else {
                MutualFund mutualFund = (MutualFund) investment;
                double investmentGain = mutualFund.calculateGain(mutualFund.getQuantity(), mutualFund.getPrice(), mutualFund.getBookValue());
                gain += investmentGain;
                investmentGain = Math.round((investmentGain) * 100 / 100);
                output.put(investment.getSymbol(), investmentGain);
            }
        }
        
        gain = Math.round((gain) * 100 / 100);
        output.put("Total", gain);
        
        return output;
    }
    
    /**
    * Lets the user search for a stock or mutual fund.
     * @param symbol symbol to be searched
     * @param keyword keyword to be searched
     * @param lowRange the minimum range
     * @param highRange the maximum range
     * @return an arrayList of the investments that matched the search
    */
    public  ArrayList<Investment> search(String symbol, String keyword, String lowRange, String highRange) {
        double minRange = 0;
        double maxRange = 0;
        Investment investment = null;
        boolean match = false;
        String word;
        int numWords = 0;
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        ArrayList<Investment> investments = new ArrayList<Investment>();
        
        
        
        if ((symbol.isEmpty()) && (keyword.isEmpty()) && (lowRange.isEmpty() && highRange.isEmpty())) {
            for(int i = 0; i < investmentList.size(); ++i) {
                investment = investmentList.get(i);
                investments.add(investment);
            }
        }
        
        if (!symbol.isEmpty()) {
            for(int i = 0; i < investmentList.size(); ++i) {
                investment = investmentList.get(i);
                if (symbol.equalsIgnoreCase(investment.getSymbol())) {
                    match = true;
                    if ((highRange.isEmpty() && lowRange.isEmpty()) && (keyword.isEmpty())) {
                        investments.add(investment);
                        return investments;
                    }
                    
                    else {
                        break;
                    }
                }
            }        
        }
        
        if ((!symbol.isEmpty()) && (!match)) {
            return investments;
        }
        
        if (!keyword.isEmpty()) {
            
            StringTokenizer keywords = new StringTokenizer(keyword);
            
            numWords = keywords.countTokens();
            while (keywords.countTokens() != 0) {
                
                word = keywords.nextToken();
                if (index.containsKey(word.toLowerCase())) {
                    integerList.addAll(index.get(word.toLowerCase()));
                }
            }
            for (int i = 0; i < integerList.size(); i++) {
                if (Collections.frequency(integerList, integerList.get(i)) == numWords) {
                    if (Collections.frequency(indexList, integerList.get(i)) == 0) {
                        indexList.add(integerList.get(i));
                    }
                }
            }
            for (int i = 0; i < indexList.size(); i++) {
                investment = investmentList.get(indexList.get(i));
                
                if ((highRange.isEmpty() && lowRange.isEmpty()) && (symbol.isEmpty())) {
                    investments.add(investment);
                }
                
                else if ((highRange.isEmpty() && lowRange.isEmpty()) && (match)) {
                    
                    if (investment.getSymbol().equals(symbol)) {
                        investments.add(investment);
                        return investments;
                    }
                    
                    else {
                        continue;
                    }
                }

                else {

                    if (lowRange.isEmpty()) {
                    try {
                        maxRange = Double.parseDouble(highRange);
                        if (maxRange < 0) {
                            return null;
                        }
                    }
                    catch (NumberFormatException e) {
                        return null;
                    }

                        if (investment.getPrice() <= maxRange) {
                            
                            if (match) {
                                if (investment.getSymbol().equals(symbol)) {
                                    investments.add(investment);
                                    return investments;
                                }
                                
                                else {
                                    return investments;
                                }
                            }
                            
                            else {
                                investments.add(investment);
                            }
                        }


                        else {
                            return investments;
                        }
                    }

                    else if (highRange.isEmpty()) {
                        try {
                            minRange = Double.parseDouble(lowRange);
                            if (minRange < 0) {
                                return null;
                            }
                        }
                        
                        catch (NumberFormatException e) {
                            return null;
                        }
                        if (investment.getPrice() >= minRange) {
                            if (match) {
                                if (investment.getSymbol().equals(symbol)) {
                                    investments.add(investment);
                                    return investments;
                                }
                                
                                else {
                                    return investments;
                                }
                            }
                            
                            else {
                                investments.add(investment);
                            }
                        }

                        else {
                            investments.add(investment);
                            return investments;
                        }

                    }


                    else {
                        
                        try {
                            minRange = Double.parseDouble(lowRange);
                            maxRange = Double.parseDouble(highRange);
                            if ((minRange < 0) || (maxRange < 0) || (minRange > maxRange)) {
                                return null;
                            }
                        }
                        
                        catch (NumberFormatException e) {
                            return null;
                        }
                        if ((investment.getPrice() >= minRange) && (investment.getPrice() <= maxRange)) {
                            if (match) {
                                if (investment.getSymbol().equals(symbol)) {
                                    investments.add(investment);
                                    return investments;
                                }
                                
                                else {
                                    investments.add(investment);
                                    return investments;
                                }
                            }
                            
                            else {
                                investments.add(investment);
                            }
                        }

                        else {
                            investments.add(investment);
                            return investments;
                        }
                    }
                }
            }
            return investments;
        }
        
        if ((!highRange.isEmpty()) || (!lowRange.isEmpty())) {
        
            if (lowRange.isEmpty()) {
                
                try {
                    maxRange = Double.parseDouble(highRange);
                    if (maxRange < 0) {
                        return null;
                    }
                }
                
                catch (NumberFormatException e) {
                    return null;
                }
                
                for(int i = 0; i < investmentList.size(); ++i) {
                    investment = investmentList.get(i);
                    if (investment.getPrice() <= maxRange) {
                        investments.add(investment);
                    }
                }   
            }
            
            else if (highRange.isEmpty()) {
                
                try{
                    minRange = Double.parseDouble(lowRange);
                    if (minRange < 0) {
                        return null;
                    }
                }
                
                catch (NumberFormatException e) {
                    return null;
                }
                for(int i = 0; i < investmentList.size(); ++i) {
                    investment = investmentList.get(i);
                    if (investment.getPrice() >= minRange) {
                        if (match) {
                                if (investment.getSymbol().equals(symbol)) {
                                    investments.add(investment);
                                    return investments;
                                }
                                
                                else {
                                    investments.add(investment);
                                    return investments;
                                }
                            }
                            
                            else {
                                investments.add(investment);
                            }
                    }
                }  
            }
            
            else {
                
                try {
                    minRange = Double.parseDouble(lowRange);
                    maxRange = Double.parseDouble(highRange);
                    if ((minRange < 0) || (maxRange < 0) || (minRange > maxRange)) {
                        return null;
                    }
                }
                
                catch (NumberFormatException e) {
                    return null;
                }
                
                for(int i = 0; i < investmentList.size(); ++i) {
                    investment = investmentList.get(i);
                    if ((investment.getPrice() >= minRange) && (investment.getPrice() <= maxRange)) {
                        if (match) {
                                if (investment.getSymbol().equals(symbol)) {
                                    investments.add(investment);
                                    return investments;
                                }
                                
                                else {
                                    investments.add(investment);
                                    return investments;
                                }
                            }
                            
                            else {
                                investments.add(investment);
                            }
                    }
                }
            }
 
        }
    return investments;
    }
    
    /**
     * Adds a key to the Hash Map
     * @param investment The investment being added
     * @param numIndex The index of the investment in the list
     */
    public void addToHashMap(Investment investment, int numIndex) {
        String name = null;
        name = investment.getName();
        StringTokenizer keys = new StringTokenizer(name);
        while (keys.countTokens() != 0) {
            ArrayList<Integer> integerList = new ArrayList<Integer>();
            String key = keys.nextToken();
            if (index.containsKey(key.toLowerCase())) {
                index.get(key.toLowerCase()).add(numIndex);
            }
            
            else {
                
                index.put(key.toLowerCase(), integerList);
                index.get(key.toLowerCase()).add(numIndex);
            }
        }
        
    }
    
    /**
     * Deletes a key from the Hash Map
     * @param investment the investment to be deleted
     * @param numIndex the index of the investment in the list
     */
    public void deleteFromHashMap(Investment investment, int numIndex) {
        
        String name = null;
        name = investment.getName();
        StringTokenizer keys = new StringTokenizer(name);
        while (keys.countTokens() != 0) {
            String key = keys.nextToken();
            if (index.containsKey(key.toLowerCase())) {
                index.get(key.toLowerCase()).remove((Object)numIndex);
                 if (index.get(key.toLowerCase()).isEmpty()) {
                     index.remove(key.toLowerCase());
                 }
            } 
        }
        
        Set<HashMap.Entry<String, ArrayList<Integer>>> entries = index.entrySet();
        Iterator<HashMap.Entry<String, ArrayList<Integer>>> iter = entries.iterator();
        while (iter.hasNext()) {
            HashMap.Entry<String, ArrayList<Integer>> entry = iter.next();
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (numIndex < entry.getValue().get(i)) {
                    entry.getValue().set(i, (entry.getValue().get(i) - 1));
                }
            }
        }
    }
    /**
     * Gets an investment at an index
     * @param i the index of the investment being retrieved
     * @return the investment at the index
     */
    public Investment getInvestment(int i) {
        
        Investment investment;
        if (i >= investmentList.size()) {
            investment = null;
        }
        
        else {
            investment = investmentList.get(i);
        }
        
        return investment;
    }
    
    /**
     * Gets the number of investments
     * @return the number of investments
     */
    public int getNumInvestments() {
        return investmentList.size();
    }
    
    /**
     * Lets the user save the inventory to a file
     */
    public void saveFile() {
        String fileName = "output.txt";
        BufferedWriter writer;
        
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < investmentList.size(); i += 1) {
                if (this.investmentList.get(i).getClass().getCanonicalName().equals("samir_a3.Stock")) {
                    Stock stock = (Stock) investmentList.get(i);
                    writer.write("type: stock\n");
                    writer.write(stock.toString());
                }
                
                else {
                    MutualFund mutualFund = (MutualFund) investmentList.get(i);
                    writer.write("type: mutualfund\n");
                    writer.write(mutualFund.toString());
                }
            }

            writer.close();
        }
        
        catch (IOException e){
            System.out.println("File not found.");
        }
        
    }
    
    /**
     * Lets the user load the inventory from a file
     */
    public boolean loadFile() {
        
        String fileName = "output.txt";
        BufferedReader reader;
        String[] dataList = new String[5];
        String buffer;
        String symbol;
        String name;
        String investment = null;
        int quantity;
        double price;
        double bookValue;
        Stock stock = null;
        MutualFund mutualFund = null;
        
        try{
            reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while (line != null){
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                line = line.replace("\n", "");
                investment = line;
                
                for (int i = 0; i < 5; ++i) {
                    line = reader.readLine();
                    StringTokenizer toParse = new StringTokenizer(line, ":");
                    buffer = toParse.nextToken();
                    dataList[i] = toParse.nextToken();
                }
                symbol = dataList[0];
                name = dataList[1];
                quantity = Integer.parseInt(dataList[2]);
                price = Double.parseDouble(dataList[3]);
                bookValue = Double.parseDouble(dataList[4]);
                
                if (investment.equals("type: stock")) {
                
                    try {
                    stock = new Stock(symbol, name, quantity, price, bookValue);
                    }
                    
                    catch (symbolException e) {
                        return false;
                    }

                    catch (nameException e) {
                        return false;
                    }

                    catch (quantityException e) {
                        return false;
                    }

                    catch (priceException e) {
                        return false;
                    }

                    catch (bookException e) {
                        return false;
                    }
                    investmentList.add(stock);
                    addToHashMap(stock, investmentList.size() - 1);
                }
                
                if (investment.equals("type: mutualfund")) {
                    try {
                        mutualFund = new MutualFund(symbol, name, quantity, price, bookValue);
                    }
                    
                    catch (symbolException e) {
                        return false;
                    }

                    catch (nameException e) {
                        return false;
                    }

                    catch (quantityException e) {
                        return false;
                    }

                    catch (priceException e) {
                        return false;
                    }

                    catch (bookException e) {
                        return false;
                    }
                    investmentList.add(mutualFund);
                    addToHashMap(mutualFund, investmentList.size() - 1);
                }
                    
                 
            }
            reader.close();
            return true;
            
        }
        catch(IOException e){
            return false;
        }
    }
    
}