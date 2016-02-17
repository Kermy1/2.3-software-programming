package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class shows the total amount of calculations done by the user.
 * @author bonnemaj
 *
 */
public class CalculatorStatView extends JPanel implements ActionListener{

	/**
	 * The total amount of calculation done by the program.
	 */
	private int calculations;
	
	/**
	 * The label that show the total amount of calculations to the user.
	 */
	private JLabel representation;
	
	/**
	 * Creates a new CalculatorStatView object.
	 */
	public CalculatorStatView()
	{
		calculations = 0;
		this.setLayout(new FlowLayout());
		
		representation = new JLabel();
		this.add(representation);
		setText(0);
	}
	
	/**
	 * Sets the text of the representation JLabel
	 * @param text
	 * @see #representation
	 */
	public void setText(int text)
	{
		representation.setText("Calculations: "+text);
	}
	
	/**
	 * This method is triggered when a calculation action takes place.
	 */
	public void actionPerformed(ActionEvent e) {
		calculations++;
		setText(calculations);
	}

	
}
