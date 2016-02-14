package dobbelsteen;
import javax.swing.*;
import java.awt.*;

public class DobbelsteenMVC extends JApplet
{
	DobbelsteenModel model;             //het model
	TekstView tekstView;              // view
	DobbelsteenView dobbelsteenView;  // view
	DobbelsteenMyView dobbelsteenMyView;  // view
	DobbelsteenLogView dobbelsteenlogView;
	DobbelsteenController controller;             // Controller
	
	public void init()
	{
		resize(250,200);
        
		// Maak het model
		model = new DobbelsteenModel();
        
        // Maak de controller en geef hem het model
		controller = new DobbelsteenController(model);
        controller.setBackground(Color.cyan);
        getContentPane().add(controller,BorderLayout.NORTH);
        
        // Maak de views
        dobbelsteenlogView = new DobbelsteenLogView(Color.black);
        dobbelsteenlogView.setBackground(Color.white);
        getContentPane().add(dobbelsteenlogView,BorderLayout.EAST);
        
        dobbelsteenView = new DobbelsteenView(Color.red);
        dobbelsteenView.setBackground(Color.black);
        getContentPane().add(dobbelsteenView,BorderLayout.CENTER);
        
        tekstView = new TekstView();
        tekstView.setBackground(Color.green);
        getContentPane().add(tekstView,BorderLayout.SOUTH);
        
        dobbelsteenMyView = new DobbelsteenMyView(Color.black);
        dobbelsteenMyView.setBackground(Color.white);
        getContentPane().add(dobbelsteenMyView,BorderLayout.WEST);
        
        // Registreer de views bij het model
        model.addActionListener(tekstView);
        model.addActionListener(dobbelsteenlogView);
        model.addActionListener(dobbelsteenView);
        model.addActionListener(dobbelsteenMyView);
        
        // Eerste worp
        model.gooi();
	}
}
