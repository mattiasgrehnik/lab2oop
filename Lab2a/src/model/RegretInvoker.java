package model;

import java.util.Stack;

public class RegretInvoker {
	private static RegretInvoker thisObj;
	private Stack<UndoCommand> undoStack,redoStack;

	public static RegretInvoker getInstance() {
		if (thisObj == null) {
			thisObj = new RegretInvoker();
		}
		return thisObj;
	}
	
	private RegretInvoker(){
		undoStack = new Stack<UndoCommand>();
		redoStack = new Stack<UndoCommand>();
	}
	
	public void addToUndo(UndoCommand regret){
		undoStack.push(regret);
	}
	
	public void undoLatest(){
		if (!undoStack.isEmpty()) {
			redoStack.push(undoStack.pop().undo());
		}
	}

	public void redoLatest() {
		if (!redoStack.isEmpty()) {
			undoStack.push(redoStack.pop().undo());
		}
	}
	
}
