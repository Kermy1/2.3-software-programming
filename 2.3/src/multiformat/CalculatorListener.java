package multiformat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CalculatorListener {
	
	private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
	private Calculator calc;
	
	public CalculatorListener(Calculator calc){
		this.calc = calc;
	}
	
	public void addActionListener( ActionListener l){
		actionListenerList.add( l );
	}
	
	public void perform(String text){
		
		String command = text;
		
		if(command.equals("+")) calc.add();
	      else if(command.equals("-")) calc.subtract();
	      else if(command.equals("*")) calc.multiply();
	      else if(command.equals("/")) calc.divide();
	      else if(command.equals("dec")) calc.setBase(new DecimalBase());
	      else if(command.equals("bin")) calc.setBase(new BinaryBase());
	      else if(command.equals("hex")) calc.setBase(new HexBase());
	      else if(command.equals("oct")) calc.setBase(new OctaalBase());
	      else if(command.equals("rat")) calc.setFormat(new RationalFormat());
	      else if(command.equals("fixed")) calc.setFormat(new FixedPointFormat());
	      else if(command.equals("float")) calc.setFormat(new FloatingPointFormat());
	      else if(command.equals("del")) calc.delete();
	      else if(command.indexOf("op") >= 0) {
	        try{
	        	calc.addOperand(command.substring(2).trim());
	        }catch(FormatException e){
	          System.out.println("Wrong operand: " + e.getMessage());
	        }
	      }else if(command.equals("help")){
	    	  //printHelp();
	      }
	      else{
	    	  System.out.println("Error! Not a valid command");
	      }
	    
		
		processEvent(new ActionEvent( this, ActionEvent.ACTION_PERFORMED, null));
	}
	
	private void processEvent(ActionEvent e){
		// Hieronder gebruiken we het nieuwe Java "foreach" statement. 
		// Lees het als: "for each ActionListener in actionListenerList do ..."
		// Je kunt ook een for-lus of een iterator gebruiken, maar foreach is het elegantste.
		for( ActionListener l : actionListenerList)
			l.actionPerformed( e );
	}
}
