package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controller.ShapeController;
import model.Shape;

public class PaintView extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private HashSet<Shape> shapes;
	private ShapeController sc;

	public PaintView() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1024, 768));
		shapes = new HashSet<>();
		sc = ShapeController.getInstance();
		sc.addModelObserver(this);
		addMouseListener(sc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		if ((o.toString() == "PaintModel") && arg != null) {
			shapes = (HashSet<Shape>) arg;
		}
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
