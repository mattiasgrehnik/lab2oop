package model;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class PaintModel {
	Set<Shape> shapes = new HashSet<Shape>();

	public void addShape(Shape shape) {
		shapes.add(shape);
		System.out.println(shapes.toString());
	}
	
}
