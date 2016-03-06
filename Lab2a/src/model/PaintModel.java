package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Observable;

public class PaintModel extends Observable implements Serializable {
	private static final long serialVersionUID = -6068929995458965085L;
	private Set<Shape> shapes = new HashSet<Shape>();

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

	@Override
	public void notifyObservers() {
		setChanged();
		notifyObservers();
	};


	public void remove(Shape selectedShape) {
		shapes.remove(selectedShape);
		
	}

	public Set<Shape> getShapes() {
		return shapes;
	}


}
