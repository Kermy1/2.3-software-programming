package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisplayView extends JPanel {
	
	private JTextField display = new JTextField();
	private JLabel label = new JLabel();
	
	public DisplayView()
	{
	    this.setLayout(new FlowLayout());
	    
	    Dimension temp = getPreferredSize();
	    display.setPreferredSize(temp);
	    
	    this.add(label);
	    this.add(display);
	}
	
	public Dimension getPreferredSize()
	{
	    return new Dimension(200,30);
	} 
	
	public void setText(String text)
	{
		label.setText(text);
	}
}
