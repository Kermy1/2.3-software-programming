package controller;



import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import multiformat.CalculatorListener;

public class CalculatorController extends JPanel implements ActionListener {
	
	private JTextField display = new JTextField();
	private CalculatorListener model;
	
	public CalculatorController(CalculatorListener model){
		this.model = model;
		
		this.setLayout(new FlowLayout());
		Dimension temp = getPreferredSize();
		display.setPreferredSize(temp);
		
		this.add(display);
	    display.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.perform(display.getText());
		display.setText("");
	}
	
	
	public Dimension getPreferredSize()
	{
	    return new Dimension(200,30);
	} 
}
