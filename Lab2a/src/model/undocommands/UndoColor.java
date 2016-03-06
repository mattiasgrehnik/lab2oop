package model.undocommands;

import java.awt.Color;
import java.util.LinkedList;

import model.Shape;
import model.UndoCommand;

public class UndoColor implements UndoCommand {
	private Shape shape;
	private Color prevColor;
	private LinkedList<Shape> theShapes;
	
	
	public UndoColor(Shape shape, Color prevColor,LinkedList<Shape> theShapes) {
		this.prevColor = prevColor;
		this.shape = shape;
		this.theShapes = theShapes;
	}
	
	@Override
	public UndoCommand undo() {
		int index = theShapes.indexOf(shape);
		Color newPrev = null;
		Shape s = null;
		if (index >= 0) {
			s = theShapes.get(index);
			newPrev = s.getColor();
			s.setColor(prevColor);
		}
		return new UndoColor(shape, newPrev, theShapes);
	}
}
