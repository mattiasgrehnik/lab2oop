package model.Shapes;

import java.awt.Graphics2D;

import model.Shape;

public class Line extends Shape {

	@Override
	protected void drawShape(Graphics2D g) {
		int x1 = super.getX1(), x2 = super.getX2(), y1 = super.getY1(), y2 = super
				.getY2();
		g.drawLine(x1, y1, x2, y2);
	}

}
