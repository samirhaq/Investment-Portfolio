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
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * JPanel for the main interface
 */
public class MainInterface extends JPanel {
    public static final int SF_NONEMPTY = 0;
    Portfolio portfolio = new Portfolio();
    
    /**
    * Constructs the components of the main interface
     * @param portfolio the portfolio to be used
    */
    public MainInterface(Portfolio portfolio) {
        this.setSize(new Dimension(1500,890));
        this.setLayout(new GridLayout(2,1));
        this.setBackground(Color.WHITE);
        this.portfolio = portfolio;
        
        JTextArea topText = new JTextArea(10, 10);
        topText.setMargin(new Insets(200, 20, 20, 20));
        topText.setLineWrap(true);
        topText.setEditable(false);
        topText.setFont(new Font("Calibri", Font.PLAIN, 40));
        topText.setForeground(Color.DARK_GRAY);
        topText.setText("Welcome to Investment Portfolio.");
        add(topText);
        
        JTextArea bottomText = new JTextArea(10, 10);
        bottomText.setMargin(new Insets(20, 20, 20, 20));
        bottomText.setLineWrap(true);
        bottomText.setWrapStyleWord(true);
        bottomText.setEditable(false);
        bottomText.setForeground(Color.DARK_GRAY);
        bottomText.setText("Choose a command from the “Commands”menu to buy or sell an investment, update prices for all investments, get gain for the portfolio, search for relevant investments, or quit the program.");
        bottomText.setFont(new Font("Calibri", Font.PLAIN, 40));
        add(bottomText);
        
    }
 
}
