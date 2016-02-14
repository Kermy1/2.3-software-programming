package dobbelsteen;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DobbelsteenStatsView extends JPanel implements ActionListener {
	
	private JLabel totaleWorpen = new JLabel("Aantal worpen:");
	private JLabel maalEen = new JLabel("1: 0");
	private JLabel maalTwee = new JLabel("2: 0");
	private JLabel maalDrie = new JLabel("3: 0");
	private JLabel maalVier = new JLabel("4: 0");
	private JLabel maalVijf = new JLabel("5: 0");
	private JLabel maalZes = new JLabel("6: 0");
	
    
    private int waarde;
    private int telTotaalWorpen;
    private int telMaalEen;
    private int telMaalTwee;
    private int telMaalDrie;
    private int telMaalVier;
    private int telMaalVijf;
    private int telMaalZes;
    
	private Color kleur;
    
    DobbelsteenModel model;
    
    public DobbelsteenStatsView()
    {
    	this.setLayout(new GridLayout(7,1));
		this.add(totaleWorpen);
		this.add(maalEen);
		this.add(maalTwee);
		this.add(maalDrie);
		this.add(maalVier);
		this.add(maalVijf);
		this.add(maalZes);
		this.kleur= kleur;
    }
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		telTotaalWorpen++;
	    model = (DobbelsteenModel) event.getSource();
	    waarde = model.getWaarde();
	    
	    totaleWorpen.setText(String.valueOf("Aantal worpen: "+telTotaalWorpen));
	    
	    if(waarde == 1){
	    	telMaalEen++;
	    	maalEen.setText(String.valueOf("1: "+telMaalEen));
	    }else if(waarde == 2){
	    	telMaalTwee++;
	    	maalTwee.setText(String.valueOf("2: "+telMaalTwee));
	    }else if(waarde == 3){
	    	telMaalDrie++;
	    	maalDrie.setText(String.valueOf("3: "+telMaalDrie));
	    }else if(waarde == 4){
	    	telMaalVier++;
	    	maalVier.setText(String.valueOf("4: "+telMaalVier));
	    }else if(waarde == 5){
	    	telMaalVijf++;
	    	maalVijf.setText(String.valueOf("5: "+telMaalVijf));
	    }else if(waarde == 6){
	    	telMaalZes++;
	    	maalZes.setText(String.valueOf("6: "+telMaalZes));
	    }
	}
}
