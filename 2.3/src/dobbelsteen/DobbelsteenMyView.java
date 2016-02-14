package dobbelsteen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DobbelsteenMyView extends JPanel implements ActionListener {
	private JLabel aantalWorpen = new JLabel("Aantal worpen:");
	private JLabel aantalEen = new JLabel("1: 0");
	private JLabel aantalTwee = new JLabel("2: 0");
	private JLabel aantalDrie = new JLabel("3: 0");
	private JLabel aantalVier = new JLabel("4: 0");
	private JLabel aantalVijf = new JLabel("5: 0");
	private JLabel aantalZes = new JLabel("6: 0");
	
    private Color kleur;
    
    private int waarde;
    private int telaantalWorpen;
    private int telAaantalEen;
    private int telAaantalTwee;
    private int telAaantalDrie;
    private int telAaantalVier;
    private int telAaantalVijf;
    private int telAaantalZes;
    
    DobbelsteenModel d;
    
	public DobbelsteenMyView(Color c){
		this.setLayout(new GridLayout(7,1));
		this.add(aantalWorpen);
		this.add(aantalEen);
		this.add(aantalTwee);
		this.add(aantalDrie);
		this.add(aantalVier);
		this.add(aantalVijf);
		this.add(aantalZes);
		kleur=c;
	}
    
    public void actionPerformed( ActionEvent e )
	{
    	telaantalWorpen++;
	    d = (DobbelsteenModel) e.getSource();
	    waarde = d.getWaarde();
	    
	    aantalWorpen.setText(String.valueOf("Aantal worpen: "+telaantalWorpen));
	    
	    if(waarde == 1){
	    	telAaantalEen++;
	    	aantalEen.setText(String.valueOf("1: "+telAaantalEen));
	    }else if(waarde == 2){
	    	telAaantalTwee++;
	    	aantalTwee.setText(String.valueOf("2: "+telAaantalTwee));
	    }else if(waarde == 3){
	    	telAaantalDrie++;
	    	aantalDrie.setText(String.valueOf("3: "+telAaantalDrie));
	    }else if(waarde == 4){
	    	telAaantalVier++;
	    	aantalVier.setText(String.valueOf("4: "+telAaantalVier));
	    }else if(waarde == 5){
	    	telAaantalVijf++;
	    	aantalVijf.setText(String.valueOf("5: "+telAaantalVijf));
	    }else if(waarde == 6){
	    	telAaantalZes++;
	    	aantalZes.setText(String.valueOf("6: "+telAaantalZes));
	    }
	    
	}

	public Dimension getPreferredSize()
	{
	    return new Dimension(130,80);
	} 
}
