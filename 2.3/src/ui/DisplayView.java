package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import multiformat.Calculator;

public class DisplayView extends JPanel implements ActionListener {
	
	
	private JLabel label = new JLabel();
	private Calculator calc;
	
	public DisplayView(Calculator calc)
	{
	    this.setLayout(new FlowLayout());
	    this.calc = calc;
	    this.add(label);
	    
	}
	
	
	
	public void setText(String text)
	{
		label.setText(text);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String labelText = "["+calc.getBase().getName()+","+calc.getFormat().getName()+","+calc.getOperandsString()+"]";
		label.setText(labelText);
	}

}
