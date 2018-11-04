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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * JPanel for the getGain Interface
 */
public class getGainInterface extends JPanel implements ActionListener {
    public static final int SF_NONEMPTY = 0;
    Portfolio portfolio;
    private JTextField totalGainField;
    private JTextArea messages;
    
  /**
 * Constructs the components for the getGain Interface
 * @param portfolio the portfolio to be used
 */
    public getGainInterface(Portfolio portfolio) {
        this.setSize(new Dimension(1500,890));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
        this.portfolio = portfolio;
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.white);
        panel1.setLayout(new GridLayout(2, 1, 0, 100));
        
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setBackground(Color.white);
        textFieldPanel.setLayout(new GridLayout(1, 2, 0, 10));
        
        JLabel gainLabel = new JLabel("Getting Total Gain");
        gainLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        panel1.add(gainLabel);
        
        JLabel totalGainLabel = new JLabel("Total Gain");
        totalGainField = new JTextField(25);
        totalGainField.setFont(new Font("Calibri", Font.PLAIN, 40));
        totalGainField.setEditable(false);
        totalGainLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        textFieldPanel.add(totalGainLabel);
        textFieldPanel.add(totalGainField);
        
        panel1.add(textFieldPanel);
        
        panel2.add(Box.createVerticalStrut(50));
        
        JLabel messagesLabel = new JLabel("Individual Gain");
        messagesLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
        panel2.add(messagesLabel);
        
        messages = new JTextArea(50, 50);
        messages.setEditable(false);
        messages.setLineWrap(true);
        messages.setFont(new Font("Calibri", Font.PLAIN, 40));
        JScrollPane pane = new JScrollPane(messages);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel2.add(pane);
        
        add(panel1);
        add(panel2);
        
    }

    @Override
    /**
    * Action performer for the getGainInterface
    * @param ae The action event
    */
    public void actionPerformed(ActionEvent ae) {
        messages.setText("");
        HashMap<String, Double> output = portfolio.getGain();
        totalGainField.setText("$" + Double.toString(output.get("Total")));
        
        Set<HashMap.Entry<String, Double>> entries = output.entrySet();
        Iterator<HashMap.Entry<String, Double>> iter = entries.iterator();
        while (iter.hasNext()) {
            HashMap.Entry<String, Double> entry = iter.next();
            Double value = entry.getValue();
            String symbol = entry.getKey();
                
            if (!symbol.equals("Total")) {
                messages.setText(messages.getText().concat(symbol + ": $" + value + "\n"));
            }
        
        }
        
    }

}

