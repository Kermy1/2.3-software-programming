package multiformat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorListener {
	
	private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
	
	public void addActionListener( ActionListener l){
		actionListenerList.add( l );
	}
	
	private void processEvent(ActionEvent e){
		// Hieronder gebruiken we het nieuwe Java "foreach" statement. 
		// Lees het als: "for each ActionListener in actionListenerList do ..."
		// Je kunt ook een for-lus of een iterator gebruiken, maar foreach is het elegantste.
		for( ActionListener l : actionListenerList)
			l.actionPerformed( e );
	}
}
