package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Converter implements ActionListener{

	private JFrame frame;
	private JPanel panel;
	private JRadioButton fButton;
	private JRadioButton cButton;
	private JRadioButton kButton;
	private ButtonGroup buttonGroup;
	private JLabel label;
	private JTextField txt;
	private JTextField resulttxt;
	
	
	public Converter() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel("Fahrenheit, Celcius, Kelvin converter");
		txt = new JTextField("Enter your number here..");
		resulttxt = new JTextField("Result");
		buttonGroup = new ButtonGroup();
		
		fButton = new JRadioButton("Fahrenheit");
		fButton.addActionListener(this);
		
		cButton = new JRadioButton("Celcius");
		cButton.addActionListener(this);
		
		kButton = new JRadioButton("Kelvin");
		kButton.addActionListener(this);
		
		buttonGroup.add(fButton);
		buttonGroup.add(cButton);
		buttonGroup.add(kButton);
		
		panel.setBorder(BorderFactory.createEmptyBorder(60, 30, 60, 90));
		panel.setLayout(new GridLayout(6,1));
		panel.add(label);
		panel.add(txt);
		panel.add(fButton);
		panel.add(cButton);
		panel.add(kButton);
		panel.add(resulttxt);
		
		frame.add(panel, BorderLayout.LINE_START);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Converter");
		frame.pack();
		frame.setVisible(true);	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource() == fButton) {
				double fahr = Double.parseDouble(txt.getText());
				double cel = (fahr - 32)/(1.8);
				double kel = (fahr + 459)*5/9;
				resulttxt.setText("C: "+ cel + " Kelvin: "+ kel);
		}
		
		if(e.getSource() == cButton) {
			double cel = Double.parseDouble(txt.getText());
			double kel = cel + 273.15;
			double fahr = (cel * 1.8) + 32;
			resulttxt.setText("Fahrenheit: "+ fahr + " Kelvin: "+ kel);
		}
		
		if(e.getSource() == kButton) {
			double kel = Double.parseDouble(txt.getText());
			double cel = kel - 273;
			double fahr = (kel * 9/5) - 459;
			resulttxt.setText("C: "+ cel + " Fahrenheit: "+ fahr);
		}
	}
	
	public static void main(String[] args) {
		new Converter();
	}

}
