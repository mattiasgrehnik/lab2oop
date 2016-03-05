package model;

import java.util.ArrayList;

import model.Shapes.Oval;
import model.Shapes.Line;
import model.Shapes.Rectangle;
import model.Shapes.Triangle;

public class ShapeFactory {

	public String[] getAvailableShapes(){
		ArrayList<String> shapes = new ArrayList<String>();
		shapes.add("Line");
		shapes.add("Oval");
		shapes.add("Triangle");
		shapes.add("Rectangle");
		return shapes.toArray(new String[shapes.size()]);
	}
	
	public Shape getShape(String shape) {
		if (shape == null) {
			return null;
		}
		if (shape.equalsIgnoreCase("Line")) {
			return new Line();
		} else if (shape.equalsIgnoreCase("Oval")) {
			return new Oval();
		} else if (shape.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		} else if (shape.equalsIgnoreCase("Triangle")) {
			return new Triangle();
		}

		return null;
	}
}
