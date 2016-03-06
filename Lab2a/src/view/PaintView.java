package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import controller.ShapeController;
import model.Shape;

public class PaintView extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private LinkedList<Shape> shapes;
	private ShapeController sc;

	public PaintView() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1024, 768));
		sc = ShapeController.getInstance();
		shapes = sc.getModelShapes();
		sc.addModelObserver(this);
		addMouseListener(sc);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Shape shape : shapes) {
			shape.draw(g);
		}
	}

}
