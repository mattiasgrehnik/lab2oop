package model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Observable;


public class PaintModel extends Observable implements Serializable {
	private static final long serialVersionUID = -6068929995458965085L;
	private LinkedList<Shape> shapes;

	public PaintModel(){
		shapes = new LinkedList<Shape>();
	}
	
	public void addShape(Shape shape) {
		if (shape != null) {
			shapes.add(shape);
			setChanged();
			notifyObservers();
		}
	}

	public Shape selectShape(int x, int y) {
		for (Shape shape : shapes) {
			if (shape.contains(x, y)) {
				return shape;
			}
		}
		return null;
	}

	public void remove(Shape selectedShape) {
		shapes.remove(selectedShape);
	}

	public LinkedList<Shape> getShapes() {
		return shapes;
	}

	public void myNotifyObservers() {
		setChanged();
		notifyObservers();
	}


}
