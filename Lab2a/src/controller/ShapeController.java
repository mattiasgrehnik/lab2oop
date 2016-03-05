package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observer;

import view.PaintView;
import model.PaintModel;
import model.Shape;
import model.ShapeFactory;

public class ShapeController implements MouseListener {
	private PaintModel model;
	public Color color;
	private ShapeFactory sf;
	private String shapeType;
	private Stroke stroke;
	private boolean filled;
	private Shape shape;
	private static ShapeController sc;

	public static ShapeController getInstance() {
		if (sc == null)
			sc = new ShapeController();
		return sc;
	}

	private ShapeController() {
		model = new PaintModel();
		sf = new ShapeFactory();
		color = Color.BLACK;
		stroke = new BasicStroke(1);
	}

	public void addObserver(Observer o) {
		model.addObserver(o);
	}

	public void clearSettings() {
		shapeType = null;
		color = Color.BLACK;
		stroke = new BasicStroke(1);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setStroke(int width) {
		this.stroke = new BasicStroke(width * 2);
	}

	public void setShape(String name) {
		shapeType = name;
	}

	public void toggleFilled() {
		filled = !filled;
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e.getX() + " " + e.getY());
		if (shapeType != null) {
			shape = sf.getShape(shapeType);
			shape.setColor(color);
			shape.setStroke(stroke);
			shape.setFilled(filled);
			shape.setX(e.getX());
			shape.setY(e.getY());

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (shape != null) {
			int tmpX = shape.getX(), tmpY = shape.getY();
			if (e.getX() < shape.getX()) {
				shape.setX(e.getX());
				shape.setWidth(tmpX - e.getX());
			} else {
				shape.setWidth(e.getX() - tmpX);
			}
//			if (e.getY() < shape.getY()) {
//				shape.setY(e.getY());
//				shape.setWidth(tmpY - e.getY());
//			} else {
				shape.setHeight(e.getY() - tmpY);
//			}
			model.addShape(shape);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
