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
			notifyObservers(shapes);
		}
	}
	@Override
	public void notifyObservers() {
		setChanged();
		notifyObservers(shapes);
	};

	@Override
	public String toString() {
		return "PaintModel";
	}
}
