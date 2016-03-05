package model.Shapes;

import java.awt.Graphics2D;

import model.Shape;

public class Line extends Shape {

	@Override
	protected void drawShape(Graphics2D g) {
		g.drawLine(super.getX(), super.getY(), super.getX() + super.getWidth(), super.getY() + super.getHeight());
	}

}
