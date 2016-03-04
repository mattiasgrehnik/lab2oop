package view;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Shape;
import model.Shapes.Circle;

public class PaintView extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private ArrayList<Circle> shapeList;
	
	
	public PaintView(){
		shapeList = new ArrayList<Circle>();

	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("test");
		for(Circle s : shapeList){
			

			System.out.println("---------------------------------------------");
			g.setColor(s.getColor());
			g.fillRect(s.getX(), s.getY(), 100, 100);
			s.draw(g);
		}
	}

	public void addShape(Circle s){
		shapeList.add(s);
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
