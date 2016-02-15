package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisplayView extends JPanel implements ActionListener {
	
	private JTextField display = new JTextField();
	private JLabel label = new JLabel();
	
	public DisplayView()
	{
	    this.setLayout(new FlowLayout());
	    
	    Dimension temp = getPreferredSize();
	    display.setPreferredSize(temp);
	    
	    this.add(label);
	    this.add(display);
	    display.addActionListener(this);
	}
	
	public Dimension getPreferredSize()
	{
	    return new Dimension(200,30);
	} 
	
	public void setText(String text)
	{
		label.setText(text);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(display.getText());
		
	}
}
