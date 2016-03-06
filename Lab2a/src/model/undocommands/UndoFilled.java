package model.undocommands;

import java.util.LinkedList;

import model.Shape;
import model.UndoCommand;

public class UndoFilled implements UndoCommand {
	private Shape shape;
	private boolean prevFill;
	private LinkedList<Shape> theShapes;
	
	
	public UndoFilled(Shape shape, boolean prevFill,LinkedList<Shape> theShapes) {
		this.prevFill = prevFill;
		this.shape = shape;
		this.theShapes = theShapes;
	}
	
	@Override
	public UndoCommand undo() {
		int index = theShapes.indexOf(shape);
		boolean newPrev = false;
		Shape s = null;
		if (index >= 0) {
			s = theShapes.get(index);
			newPrev = s.isFilled();
			s.setFilled(prevFill);
		}
		return new UndoFilled(shape, newPrev, theShapes);
	}
}
