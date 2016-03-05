package model.Shapes;

import java.awt.Graphics2D;

import model.Shape;

public class Line extends Shape {

	@Override
	protected void drawShape(Graphics2D g) {
		int x1, y1, x2 = super.getX() + super.getWidth(), y2 = super.getY() + super.getHeight();
		if (super.getX() < super.getWidth()) {
			x1 = super.getX();
		} else {
			x1 = super.getWidth();
		}

		if (super.getY() < super.getHeight()) {
			y1 = super.getY();
		} else {
			y1 = super.getHeight();
		}
		g.drawLine(x1, y1, x2, y2);
	}

}
