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
 * JPanel for the Search interface
 */
public class SearchInterface extends JPanel implements ActionListener {
    public static final int SF_NONEMPTY = 0;
    Portfolio portfolio;
    private JTextField symbolField;
    private JTextField keyWordField;
    private JTextField lowPriceField;
    private JTextField highPriceField;
    private JTextArea messages;
    
    /**
    * Constructs the components in the search interface
     * @param portfolio the portfolio to be used
    */
    public SearchInterface(Portfolio portfolio) {
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
        
        JLabel searchLabel = new JLabel("Searching Investments");
        searchLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        panel1.add(searchLabel);
        
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayout(4, 2, 0, 10));
        textFieldPanel.setBackground(Color.white);
        
        JLabel symbolLabel = new JLabel("Symbol");
        symbolField = new JTextField(25);
        symbolField.setFont(new Font("Calibri", Font.PLAIN, 40));
        symbolLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(symbolLabel);
        textFieldPanel.add(symbolField);
        
        JLabel keyWordLabel = new JLabel("Name Keywords");
        keyWordField = new JTextField(50);
        keyWordField.setFont(new Font("Calibri", Font.PLAIN, 40));
        keyWordLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(keyWordLabel);
        textFieldPanel.add(keyWordField);
        
        JLabel lowPriceLabel = new JLabel("Low Price");
        lowPriceField = new JTextField(25);
        lowPriceField.setFont(new Font("Calibri", Font.PLAIN, 40));
        lowPriceLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(lowPriceLabel);
        textFieldPanel.add(lowPriceField);
        
        JLabel highPriceLabel = new JLabel("High Price");
        highPriceField = new JTextField(25);
        highPriceField.setFont(new Font("Calibri", Font.PLAIN, 40));
        highPriceLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(highPriceLabel);
        textFieldPanel.add(highPriceField);
        
        panel1.add(textFieldPanel);
        top.add(panel1);
        
        panel2.add(Box.createVerticalStrut(245));
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Calibri", Font.PLAIN, 40));
        resetButton.setSize(new Dimension(200,300));
        resetButton.addActionListener(this);
        panel2.add(resetButton);
        resetButton.setAlignmentX(panel2.CENTER_ALIGNMENT);
        
        panel2.add(Box.createVerticalStrut(50));
        
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Calibri", Font.PLAIN, 40));
        searchButton.setSize(new Dimension(200,300));
        searchButton.addActionListener(this);
        panel2.add(searchButton);
        top.add(panel2);
        searchButton.setAlignmentX(panel2.CENTER_ALIGNMENT);
        
        panel3.add(Box.createVerticalStrut(50));
        
        JLabel messagesLabel = new JLabel("Search Results");
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
    * Action performer for the Search Interface
    * @param ae The action event
    */
    public void actionPerformed(ActionEvent ae) {
        messages.setText("");
        String highRange = null;
        String lowRange = null;
        String symbol = null;
        String keywords = null;
        ArrayList<Investment> investments = new ArrayList<Investment>();
        String buttonString = ae.getActionCommand();
        
        if (buttonString.equals("Search")) {
            highRange = highPriceField.getText();
            lowRange = lowPriceField.getText();
            symbol = symbolField.getText();
            keywords = keyWordField.getText();
            investments = portfolio.search(symbol, keywords, lowRange, highRange);
            
            if (investments == null) {
                messages.setText("Enter a valid price range!");
            }
            
            else {
                for (int i = 0; i < investments.size(); i++) {
                    messages.setText(messages.getText().concat(investments.get(i).toString() + "\n"));
                }
            }
            
            highPriceField.setText("");
            lowPriceField.setText("");
            symbolField.setText("");
            keyWordField.setText("");
        }
        
        else if (buttonString.equals("Reset")) {
            highPriceField.setText("");
            lowPriceField.setText("");
            symbolField.setText("");
            keyWordField.setText("");
        }
        
        else {
            System.out.println("ERROR");
        }    
    }
        

    
}
