/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samir_a3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * JFrame for the GUI
 */
public class GUI extends JFrame implements ActionListener {
    
    public static final int SF_NONEMPTY = 0;
    Portfolio portfolio;
    private JTextField symbolField;
    private JTextField quantityField;
    private JTextField priceField;
    private JTextField nameField;
     private JTextField keyWordField;
    private JTextField lowPriceField;
    private JTextField highPriceField;
    private JTextArea messages;
    JComboBox investmentChoice;
    UpdateInterface updateInterface;
    getGainInterface getGainInterface;
    SellInterface sellInterface;
    MainInterface mainInterface;
    BuyInterface buyInterface;
    SearchInterface searchInterface;
    /**
     * Constructs the components for the main GUI
     */
    public GUI() {
        super("Investmet Portfolio");
        this.portfolio = new Portfolio();
        this.setSize(new Dimension(1500,1000));
        this.setResizable(false);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuItem buyMenuButton = new JMenuItem("Buy");
        buyMenuButton.setFont(new Font("Calibri", Font.BOLD, 30));
        buyMenuButton.addActionListener(this);
                
        JMenuItem sellButton = new JMenuItem("Sell");
        sellButton.setFont(new Font("Calibri", Font.BOLD, 30));
        sellButton.addActionListener(this);
                
        JMenuItem getGainButton = new JMenuItem("getGain");
        getGainButton.setFont(new Font("Calibri", Font.BOLD, 30));
        getGainButton.addActionListener(this);
        
        JMenuItem searchMenuButton = new JMenuItem("Search");
        searchMenuButton.setFont(new Font("Calibri", Font.BOLD, 30));
        searchMenuButton.addActionListener(this);
        
        JMenuItem updateButton = new JMenuItem("Update");
        updateButton.setFont(new Font("Calibri", Font.BOLD, 30));
        updateButton.addActionListener(this);
        
        JMenuItem quitButton = new JMenuItem("Quit");
        quitButton.setFont(new Font("Calibri", Font.BOLD, 30));
        quitButton.addActionListener(this);
        
        JMenu menu = new JMenu("Commands");
        menu.setFont(new Font("Calibri", Font.BOLD, 30));
        menu.add(buyMenuButton);
        menu.add(sellButton);
        menu.add(updateButton);
        menu.add(getGainButton);
        menu.add(searchMenuButton);
        menu.add(quitButton);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        menuBar.setPreferredSize(new Dimension(50, 50));
        setJMenuBar(menuBar);
        
        updateInterface = new UpdateInterface(portfolio);
        add(updateInterface);
        updateInterface.setVisible(false);
        
        getGainInterface = new getGainInterface(portfolio);
        add(getGainInterface);
        getGainInterface.setVisible(false);
        
        
        mainInterface = new MainInterface(portfolio);
        add(mainInterface);
        mainInterface.setVisible(true);
        
        sellInterface = new SellInterface(portfolio);
        add(sellInterface);
        sellInterface.setVisible(false);
        
        buyInterface = new BuyInterface(portfolio);
        add(buyInterface);
        buyInterface.setVisible(false);
        
        searchInterface = new SearchInterface(portfolio);
        add(searchInterface);
        searchInterface.setVisible(false);
        
        portfolio.loadFile();

    }

    @Override
    /**
    * Action performer for the main GUI
    * @param ae The action event
    */
    public void actionPerformed(ActionEvent ae) {
        
        String buttonString = ae.getActionCommand();
        
        if (buttonString.equals("Buy")) {
            buyInterface.clear();
            updateInterface.setVisible(false);
            getGainInterface.setVisible(false);
            mainInterface.setVisible(false);
            sellInterface.setVisible(false);
            buyInterface.setVisible(true);
            searchInterface.setVisible(false);
        
        }
        
        else if (buttonString.equals("Sell")) {
            sellInterface.clear();
            updateInterface.setVisible(false);
            getGainInterface.setVisible(false);
            mainInterface.setVisible(false);
            sellInterface.setVisible(true);
            buyInterface.setVisible(false);
            searchInterface.setVisible(false);
        }
        
        else if (buttonString.equals("Search")) {
            searchInterface.clear();
            updateInterface.setVisible(false);
            getGainInterface.setVisible(false);
            mainInterface.setVisible(false);
            sellInterface.setVisible(false);
            buyInterface.setVisible(false);
            searchInterface.setVisible(true);
        }
        
        else if (buttonString.equals("Update")) {
            updateInterface.setVisible(true);
            updateInterface.setInvestment();
            getGainInterface.setVisible(false);
            mainInterface.setVisible(false);
            sellInterface.setVisible(false);
            buyInterface.setVisible(false);
            searchInterface.setVisible(false);
        }
        
        else if (buttonString.equals("getGain")) {
            updateInterface.setVisible(false);
            getGainInterface.setVisible(true);
            mainInterface.setVisible(false);
            sellInterface.setVisible(false);
            buyInterface.setVisible(false);
            searchInterface.setVisible(false);
            getGainInterface.actionPerformed(ae);
        }
        
        else if (buttonString.equals("Quit")) {
            portfolio.saveFile();
            System.exit(0);
        }
        
        else {
            System.out.println("ERROR");
        }
    }
    
}
