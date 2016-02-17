package controller;



import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import multiformat.CalculatorListener;

/**
 * This class it the controller part of the MVC. It adds a textfield that listens for input.
 * @author bonnemaj
 *
 */
public class CalculatorController extends JPanel implements ActionListener {
	
	/**
	 * The display is used to receive commands from the user.
	 */
	private JTextField display = new JTextField();
	
	/**
	 * The controller will notify the model when an action is performed.
	 */
	private CalculatorListener model;
	
	/**
	 * Creates a new calculator object and adds the JTextfield.
	 * @param model
	 * @see #display
	 */
	public CalculatorController(CalculatorListener model){
		this.model = model;
		
		// Add the layout to the JPanel
		this.setLayout(new FlowLayout());
		
		// Set the size of the JTextframe
		Dimension temp = getPreferredSize();
		display.setPreferredSize(temp);
		
		this.add(display);
	    display.addActionListener(this);
	}
	
	/**
	 * When an action is performed this method is triggered.
	 */
	public void actionPerformed(ActionEvent e) {
		model.perform(display.getText());
		display.setText("");
	}
	
	/**
	 * The prefered size of the display.
	 * @see #display
	 */
	public Dimension getPreferredSize()
	{
	    return new Dimension(200,30);
	} 
}
