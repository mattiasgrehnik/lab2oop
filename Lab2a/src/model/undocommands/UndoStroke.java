package model.undocommands;

import java.util.LinkedList;
import model.Shape;
import model.UndoCommand;

public class UndoStroke implements UndoCommand {
	private Shape shape;
	private int prevStroke;
	private LinkedList<Shape> theShapes;
	
	
	public UndoStroke(Shape shape, int prevStroke,LinkedList<Shape> theShapes) {
		this.prevStroke = prevStroke;
		this.shape = shape;
		this.theShapes = theShapes;
	}
	
	@Override
	public UndoCommand undo() {
		int index = theShapes.indexOf(shape);
		int newPrev = 0;
		Shape s = null;
		if (index >= 0) {
			s = theShapes.get(index);
			newPrev = s.getStroke();
			s.setStroke(prevStroke);
		}
		return new UndoStroke(shape, newPrev, theShapes);
	}
}
