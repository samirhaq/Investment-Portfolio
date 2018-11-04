/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samir_a3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * JPanel for the Sell interface
 */
public class SellInterface extends JPanel implements ActionListener {
    public static final int SF_NONEMPTY = 0;
    Portfolio portfolio;
    private JTextField symbolField;
    private JTextField quantityField;
    private JTextField priceField;
    private JTextArea messages;
    
    /**
    * Constructs the components for the Sell interface
     * @param portfolio the portfolio to be used
    */
    public SellInterface(Portfolio portfolio) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
        this.portfolio = portfolio;
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.white);
        panel1.setLayout(new GridLayout(2, 1));
        
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.white);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        
        JPanel top = new JPanel();
        top.setBackground(Color.white);
        top.setLayout(new GridLayout(1, 2));
        
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setBackground(Color.white);
        textFieldPanel.setLayout(new GridLayout(3, 2, 0, 10));
        
        JLabel sellLabel = new JLabel("Selling an Investment");
        sellLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        panel1.add(sellLabel);
        
        JLabel symbolLabel = new JLabel("Symbol");
        symbolField = new JTextField(25);
        symbolField.setFont(new Font("Calibri", Font.PLAIN, 40));
        symbolLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(symbolLabel);
        textFieldPanel.add(symbolField);
        
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
        
        panel2.add(Box.createVerticalStrut(200));
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Calibri", Font.PLAIN, 40));
        resetButton.setSize(new Dimension(200,300));
        resetButton.addActionListener(this);
        panel2.add(resetButton);
        resetButton.setAlignmentX(panel2.CENTER_ALIGNMENT);
        
        panel2.add(Box.createVerticalStrut(75));
        
        JButton sellButton = new JButton("Sell");
        sellButton.setFont(new Font("Calibri", Font.PLAIN, 40));
        sellButton.setSize(new Dimension(200,300));
        sellButton.addActionListener(this);
        panel2.add(sellButton);
        top.add(panel2);
        sellButton.setAlignmentX(panel2.CENTER_ALIGNMENT);
        
        panel3.add(Box.createVerticalStrut(50));
        
        JLabel messagesLabel = new JLabel("Messages");
        messagesLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        panel3.add(messagesLabel);
        
        messages = new JTextArea(50, 50);
        messages.setEditable(false);
        messages.setLineWrap(true);
        messages.setFont(new Font("Calibri", Font.PLAIN, 40));
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
    * Action performer for the Sell Interface
    * @param ae The action event
    */
    public void actionPerformed(ActionEvent ae) {
        messages.setText("");
        
        ArrayList<String> output = new ArrayList<String>();
        String name = null;
        String price = null;
        String quantity = null;
        String symbol = null;
        double bookValue = 0;
        
        String buttonString = ae.getActionCommand();
        
        if (buttonString.equals("Sell")) {
            price = priceField.getText();
            quantity = quantityField.getText();
            symbol = symbolField.getText();
            output = portfolio.sellInvestment(symbol, price, quantity);
            priceField.setText("");
            quantityField.setText("");
            symbolField.setText("");
            
            if (output.size() == 4) {
                messages.setText(output.get(0));
                messages.setText(messages.getText().concat(output.get(1) + "\n"));
                messages.setText(messages.getText().concat(output.get(2)));
                messages.setText(messages.getText().concat(output.get(3) + "\n"));
            }
            
            else {
                messages.setText(output.get(0));
            }
        }
        
        else if (buttonString.equals("Reset")) {
            priceField.setText("");
            quantityField.setText("");
            symbolField.setText("");
        }
        
        else {
            System.out.println("ERROR");
        }
        
        
    }
        

    
}
