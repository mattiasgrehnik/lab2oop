package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.PaintView;
import model.PaintModel;
import model.Shape;
import model.ShapeFactory;
import model.Shapes.Circle;

public class ShapeController implements MouseListener {
	private PaintModel model;
	private PaintView view;
	public Color color;
	private ShapeFactory sf;
	private Shape shape;
	private Stroke stroke;
	private static ShapeController sc;

	public static ShapeController getInstance() {
		if (sc == null)
			sc = new ShapeController();
		return sc;
	}

	public ShapeController() {
		model = new PaintModel();
		sf = new ShapeFactory();
		color = Color.BLACK;
		stroke = new BasicStroke(1);
		view = new PaintView();
	}

	public void clearSettings() {
		shape = null;
		color = Color.BLACK;
		stroke = new BasicStroke(1);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setStroke(int width) {
		this.stroke = new BasicStroke(width);
	}

	public void setShape(String name) {
		shape = sf.getShape(name);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Circle c = new Circle();
		c.setX(x);
		c.setY(y);
		c.setFilled(true);
		c.setColor(color);
		System.out.println(c.getX() +  " " + c.getY());
		view.addShape(c);
		model.addShape(c);
		view.repaint();
		
		//		if (shape != null) {
//			shape.setColor(color);
//			shape.setStroke(stroke);
//			shape.setX(e.getX());
//			shape.setY(e.getY());
//			model.addShape(shape);
//		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
