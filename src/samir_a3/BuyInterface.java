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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * JPanel for the buy interface
 */
public class BuyInterface extends JPanel implements ActionListener {
    public static final int SF_NONEMPTY = 0;
    private JTextField symbolField;
    private JTextField quantityField;
    private JTextField priceField;
    private JTextField nameField;
    private JTextArea messages;
    JComboBox investmentChoice;
    Portfolio portfolio;
    
    /**
    * Constructs the components for the buy interface
     * @param portfolio the portfolio to be used
    */
    public BuyInterface(Portfolio portfolio) {
        this.setSize(new Dimension(1500,890));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
        this.portfolio = portfolio;
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1));
        panel1.setBackground(Color.white);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setBackground(Color.white);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.setBackground(Color.white);
        
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1, 2));
        top.setBackground(Color.white);
        
        JLabel buyLabel = new JLabel("Buying an Investment");
        buyLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        panel1.add(buyLabel);
        
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayout(5, 2, 0, 10));
        textFieldPanel.setBackground(Color.white);
        
        JLabel typeLabel = new JLabel("Type");
        typeLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(typeLabel);
        
        String[] investments = {"Stock", "Mutual Fund"};
        investmentChoice = new JComboBox(investments);
        investmentChoice.setSelectedIndex(0);
        investmentChoice.setFont(new Font("Calibri", Font.PLAIN, 40));
        investmentChoice.setBackground(Color.WHITE);
        textFieldPanel.add(investmentChoice);
        
        JLabel symbolLabel = new JLabel("Symbol");
        symbolField = new JTextField(25);
        symbolField.setFont(new Font("Calibri", Font.PLAIN, 40));
        symbolLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(symbolLabel);
        textFieldPanel.add(symbolField);
        
        JLabel nameLabel = new JLabel("Name");
        nameField = new JTextField(25);
        nameField.setFont(new Font("Calibri", Font.PLAIN, 40));
        nameLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(nameLabel);
        textFieldPanel.add(nameField);
        
        JLabel quantityLabel = new JLabel("Quantity");
        quantityField = new JTextField(25);
        quantityField.setFont(new Font("Calibri", Font.PLAIN, 40));
        quantityLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(quantityLabel);
        textFieldPanel.add(quantityField);
        
        JLabel priceLabel = new JLabel("Price");
        priceField = new JTextField(25);
        priceField.setFont(new Font("Calibri", Font.PLAIN, 40));
        priceLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(priceLabel);
        textFieldPanel.add(priceField);
        
        panel1.add(textFieldPanel);
        top.add(panel1);
        
        panel2.add(Box.createVerticalStrut(300));
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Calibri", Font.PLAIN, 40));
        resetButton.setSize(new Dimension(200,300));
        resetButton.addActionListener(this);
        panel2.add(resetButton);
        resetButton.setAlignmentX(panel2.CENTER_ALIGNMENT);
        
        panel2.add(Box.createVerticalStrut(75));
        
        JButton buyButton = new JButton("Buy");
        buyButton.setFont(new Font("Calibri", Font.PLAIN, 40));
        buyButton.setSize(new Dimension(200,300));
        buyButton.addActionListener(this);
        panel2.add(buyButton);
        top.add(panel2);
        buyButton.setAlignmentX(panel2.CENTER_ALIGNMENT);
        
        panel3.add(Box.createVerticalStrut(50));
        
        JLabel messagesLabel = new JLabel("Messages");
        messagesLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        panel3.add(messagesLabel);
        
        messages = new JTextArea(50, 50);
        messages.setEditable(false);
        messages.setLineWrap(true);
        messages.setFont(new Font("Calibri", Font.PLAIN, 40));;
        JScrollPane pane = new JScrollPane(messages);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel3.add(pane);
        
        add(top);
        add(panel3);
        
    }
    
    /**
     * Empties the message textArea
     */
    public void clear() {
        messages.setText("");
    }

    @Override
    /**
    * Action performer for the Buy Interface
    * @param ae The action event
    */
    public void actionPerformed(ActionEvent ae) {
        messages.setText("");
        String name = null;
        String price = null;
        String quantity = null;
        String symbol = null;
        double bookValue = 0;
        
        String buttonString = ae.getActionCommand();
        
        if (buttonString.equals("Buy")) {
            name = nameField.getText();
            price = priceField.getText();
            quantity = quantityField.getText();
            symbol = symbolField.getText();
            
            if (investmentChoice.getSelectedItem().equals("Stock")) {
                messages.setText(portfolio.buyStock(symbol, name, quantity, price));
                nameField.setText("");
                priceField.setText("");
                quantityField.setText("");
                symbolField.setText("");
            }
            
            else {
                messages.setText(portfolio.buyMutualFund(symbol, name, quantity, price));
                nameField.setText("");
                priceField.setText("");
                quantityField.setText("");
                symbolField.setText("");
            }
        }
        
        else if (buttonString.equals("Reset")) {
            nameField.setText("");
            priceField.setText("");
            quantityField.setText("");
            symbolField.setText("");
        }
        
        else {
            System.out.println("ERROR");
        }
        
    }
        

    
}