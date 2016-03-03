package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.PaintModel;

public class PieceController implements ActionListener{
	private PaintModel model;
	
	public PieceController(PaintModel model){
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button =  (JButton) e.getSource();
		// DO STUFF HERE ON ACTION
	}

}
