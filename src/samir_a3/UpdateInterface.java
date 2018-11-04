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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * JPanel for the Update interface
 */
public class UpdateInterface extends JPanel implements ActionListener {
    public static final int SF_NONEMPTY = 0;
    Portfolio portfolio = new Portfolio();
    private JTextField symbolField;
    private JTextField nameField;
    private JTextField priceField;
    private JButton prevButton;
    private JButton nextButton;
    private JButton saveButton;
    private JTextArea messages;
    private Investment investment = null;
    private int index = 0;
    
    /**
    * Constructs the components for the Update interface
    * @param portfolio the portfolio to be used
    */
    public UpdateInterface(Portfolio portfolio) {
        this.portfolio = portfolio;
        this.setSize(new Dimension(1500,890));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
        
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
        
        JLabel updateLabel = new JLabel("Updating Investments");
        updateLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        panel1.add(updateLabel);
        
        JLabel symbolLabel = new JLabel("Symbol");
        symbolField = new JTextField(25);
        symbolField.setEditable(false);
        symbolField.setFont(new Font("Calibri", Font.PLAIN, 40));
        symbolLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(symbolLabel);
        textFieldPanel.add(symbolField);
        
        JLabel nameLabel = new JLabel("Name");
        nameField = new JTextField(25);
        nameField.setEditable(false);
        nameField.setFont(new Font("Calibri", Font.PLAIN, 40));
        nameLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(nameLabel);
        textFieldPanel.add(nameField);
        
        JLabel priceLabel = new JLabel("Price");
        priceField = new JTextField(25);
        priceField.setFont(new Font("Calibri", Font.PLAIN, 40));
        priceLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(priceLabel);
        textFieldPanel.add(priceField);
        
        panel1.add(textFieldPanel);
        top.add(panel1);
        
        panel2.add(Box.createVerticalStrut(230));
        prevButton = new JButton("Prev");
        prevButton.setFont(new Font("Calibri", Font.PLAIN, 40));
        prevButton.setSize(new Dimension(200,300));
        prevButton.addActionListener(this);
        panel2.add(prevButton);
        prevButton.setAlignmentX(panel2.CENTER_ALIGNMENT);
        
        panel2.add(Box.createVerticalStrut(40));
        
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Calibri", Font.PLAIN, 40));
        nextButton.setSize(new Dimension(200,300));
        nextButton.addActionListener(this);
        panel2.add(nextButton);
        top.add(panel2);
        nextButton.setAlignmentX(panel2.CENTER_ALIGNMENT);
        
        panel2.add(Box.createVerticalStrut(40));
        
        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Calibri", Font.PLAIN, 40));
        saveButton.setSize(new Dimension(200,300));
        saveButton.addActionListener(this);
        panel2.add(saveButton);
        top.add(panel2);
        saveButton.setAlignmentX(panel2.CENTER_ALIGNMENT);

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
    * sets the first investment in the textfields if it exists
    */
    public void setInvestment() {
        messages.setText("");
        int maxindex = portfolio.getNumInvestments() - 1;
        if (portfolio.getInvestment(0) != null) {
            symbolField.setText(portfolio.getInvestment(0).getSymbol());
            nameField.setText(portfolio.getInvestment(0).getName());
        }
        prevButton.setEnabled(false);
        investment = portfolio.getInvestment(0);
        
        index = 0;
        
        if (maxindex <= 0) {
            nextButton.setEnabled(false);
            if (maxindex < 0) {
                saveButton.setEnabled(false);
            }
            
            else {
                saveButton.setEnabled(true);
            }
        }
        else {
            nextButton.setEnabled(true);
        }
    }

    @Override
    /**
    * Action performer for the Update Interface
    * @param ae The action event
    */
    public void actionPerformed(ActionEvent ae) {

       int maxindex = portfolio.getNumInvestments() - 1;
        
        String buttonString = ae.getActionCommand();
        if (buttonString.equals("Next")) {
            prevButton.setEnabled(true);
            priceField.setText("");
            index += 1;
            investment = portfolio.getInvestment(index);
            symbolField.setText(investment.getSymbol());
            nameField.setText(investment.getName());
            
            if (index == maxindex) {
                nextButton.setEnabled(false);
            }
 
        }
        
        else if (buttonString.equals("Prev")) {
            index -= 1;
            investment = portfolio.getInvestment(index);
            symbolField.setText(investment.getSymbol());
            nameField.setText(investment.getName());
            nextButton.setEnabled(true);
            priceField.setText("");
            
            if (index == 0) {
                prevButton.setEnabled(false);
            }
            
        }
        
        else if (buttonString.equals("Save")) {
            messages.setText(portfolio.update(index, investment, priceField.getText()));
            priceField.setText("");
        }
        
        else {
            System.out.println("ERROR");
        }
        
    }
        

    
}
