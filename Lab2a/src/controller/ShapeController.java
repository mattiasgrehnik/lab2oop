package controller;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observer;

import model.PaintModel;
import model.Shape;
import model.ShapeFactory;

public class ShapeController implements MouseListener {
	private PaintModel model;
	private Color color;
	private ShapeFactory sf;
	private String shapeType;
	private int stroke;
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
		stroke = 1;
	}

	public void addObserver(Observer o) {
		model.addObserver(o);
	}

	public void clearShape() {
		shapeType = null;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setStroke(int width) {
		this.stroke = width * 2; // width * 2 = stroke in px
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
		if (shapeType != null) {
			shape = sf.getShape(shapeType);
			shape.setColor(color);
			shape.setStroke(stroke);
			shape.setFilled(filled);
			shape.setX1(e.getX());
			shape.setY1(e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (shape != null) {
			shape.setX2(e.getX());
			shape.setY2(e.getY());
			model.addShape(shape);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public void setPainting(Object fileData) {
		this.model = (PaintModel) fileData;
	}

	public PaintModel getPainting() {
		return model;
	}

	public void notifyObservers() {
		model.notifyObservers();
		
	}

}
