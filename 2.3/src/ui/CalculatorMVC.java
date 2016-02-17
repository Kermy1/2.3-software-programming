package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JApplet;

import controller.CalculatorController;
import dobbelsteen.DobbelsteenController;
import multiformat.*;

public class CalculatorMVC extends JApplet {

	CalculatorListener handler;
	CalculatorController controller;
	
	public void init(){
		Calculator calc = new Calculator();
		
		DisplayView display = new DisplayView(calc);
		display.setText("["+calc.getBase().getName()+","
                            + calc.getFormat().getName()+","
                            + calc.firstOperand() + ", "
                            + calc.secondOperand() + "]");
		
		CalculatorStatView stats = new CalculatorStatView();
		
		handler = new CalculatorListener(calc);
		
        getContentPane().add(controller  = new CalculatorController(handler),BorderLayout.CENTER);
		getContentPane().add(stats,BorderLayout.SOUTH);
		getContentPane().add(display,BorderLayout.NORTH);
		
		
		handler.addActionListener(display);
		handler.addCalculationListener(stats);
		
	}

}
