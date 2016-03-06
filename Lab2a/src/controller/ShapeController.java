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
	private Shape shape, selectedShape;
	private boolean selectMode;
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

	public void addModelObserver(Observer o) {
		model.addObserver(o);
	}

	public void clearShape() {
		shapeType = null;
	}

	public void setColor(Color color) {
		if (selectMode && selectedShape != null) {
			selectedShape.setColor(color); // width * 2 = stroke in px
			notifyModelObservers();
		} else
			this.color = color;
	}

	public void setStroke(int width) {
		if (selectMode && selectedShape != null) {
			selectedShape.setStroke(width * 2); // width * 2 = stroke in px
			notifyModelObservers();
		} else
			this.stroke = width * 2;
	}

	public void setShape(String name) {
		shapeType = name;
	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}

	public void setFilled(boolean b){
		if (selectMode && selectedShape != null) {
			selectedShape.setFilled(b);
			notifyModelObservers();
		} else
			filled = b;
	}
	
	public boolean isFilled() {
		return filled;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (selectMode) {
			selectedShape = model.selectShape(e.getX(), e.getY());
			if (selectedShape != null) {
				color = selectedShape.getColor();
				stroke = selectedShape.getStroke();
				filled = selectedShape.isFilled();
			}
		} else {
			if (shapeType != null) {
				shape = sf.getShape(shapeType);
				shape.setColor(color);
				shape.setStroke(stroke);
				shape.setFilled(filled);
				shape.setX1(e.getX());
				shape.setY1(e.getY());
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!selectMode && shape != null) {
			shape.setX2(e.getX());
			shape.setY2(e.getY());
			model.addShape(shape);
			shape = null;
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

	public void notifyModelObservers() {
		model.notifyObservers();
	}

	public void setSelect(boolean b) {
		selectedShape = null;
		selectMode = b;
	}



	public void removeSelected() {
		if (selectMode && selectedShape != null) {
			model.remove(selectedShape);
			selectedShape = null;
			notifyModelObservers();
		} 
		
	}

}
