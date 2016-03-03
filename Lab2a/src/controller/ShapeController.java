package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.PaintModel;
import model.Shape;
import model.ShapeFactory;

public class ShapeController implements MouseListener {
	private PaintModel model;
	public Color color;
	private ShapeFactory sf;
	private Shape shape;
	private Stroke stroke;
	private static ShapeController sc;

	public static ShapeController getInstance() {
		if (sc == null)
			sc = new ShapeController();
		return sc;
	}

	private ShapeController() {
		model = new PaintModel();
		sf = new ShapeFactory();
		color = Color.BLACK;
		stroke = new BasicStroke(1);
	}

	public void clearSettings() {
		shape = null;
		color = Color.BLACK;
		stroke = new BasicStroke(1);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setStroke(int width) {
		this.stroke = new BasicStroke(width);
	}

	public void setShape(String name) {
		shape = sf.getShape(name);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (shape != null) {
			shape.setColor(color);
			shape.setStroke(stroke);
			shape.setX(e.getX());
			shape.setY(e.getY());
			model.addShape(shape);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
