package model.undocommands;

import java.util.LinkedList;
import model.Shape;
import model.UndoCommand;

public class UndoAdd implements UndoCommand{
	private Shape shape;
	private LinkedList<Shape> theShapes;
	
	
	public UndoAdd(Shape shape, LinkedList<Shape> theShapes) {
		this.shape = shape;
		this.theShapes = theShapes;
	}
	
	@Override
	public UndoCommand undo() {
		theShapes.remove(shape);
		return new UndoRemove(shape, theShapes);
	}

}
