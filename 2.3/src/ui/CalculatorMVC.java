package ui;

import java.awt.BorderLayout;

import javax.swing.JApplet;

import multiformat.Calculator;

public class CalculatorMVC extends JApplet {

	public void init(){
		Calculator calc = new Calculator();
		
		DisplayView display = new DisplayView();
		display.setText("["+calc.getBase().getName()+","
                            + calc.getFormat().getName()+","
                            + calc.firstOperand() + ", "
                            + calc.secondOperand() + "]");
		getContentPane().add(display,BorderLayout.CENTER);
		
	}

}
