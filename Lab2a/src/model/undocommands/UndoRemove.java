package model.undocommands;

import java.util.LinkedList;
import model.Shape;
import model.UndoCommand;

public class UndoRemove implements UndoCommand{
	private Shape shape;
	private LinkedList<Shape> theShapes;
	
	
	public UndoRemove(Shape shape, LinkedList<Shape> theShapes) {
		this.shape = shape;
		this.theShapes = theShapes;
	}
	
	@Override
	public UndoCommand undo() {
		theShapes.add(shape);
		return new UndoAdd(shape, theShapes);
	}

}
