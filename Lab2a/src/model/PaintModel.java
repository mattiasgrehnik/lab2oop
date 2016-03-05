package model;

import java.util.HashSet;
import java.util.Set;
import java.util.Observable;
public class PaintModel extends Observable {
	private Set<Shape> shapes = new HashSet<Shape>();

	
	public void addShape(Shape shape) {
		shapes.add(shape);
		setChanged();
		notifyObservers(shape);
	}
	
	
	
}
