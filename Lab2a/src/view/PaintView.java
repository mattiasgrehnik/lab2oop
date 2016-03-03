package view;

import javax.swing.JPanel;
import controller.PieceController;
import model.PaintModel;

public class PaintView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public PaintView(PaintModel model){
		PieceController con = new PieceController(model);
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				model.getBoard().getPiece(i, j).getButton().addActionListener(con);
//				model.getBoard().getPiece(i, j).getButton().setPreferredSize(new Dimension(60, 61));
//				add(model.getBoard().getPiece(i, j).getButton());
//			}
//		}
	}
}
