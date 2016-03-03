package view;

import javax.swing.JPanel;
import controller.PieceController;
import model.PaintModel;

public class PaintView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public PaintView(PaintModel model){
		PieceController con = new PieceController(model);
	}
}
