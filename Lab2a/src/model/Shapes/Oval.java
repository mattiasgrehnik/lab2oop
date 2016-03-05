package model.Shapes;

import java.awt.Graphics2D;

import model.Shape;

public class Oval extends Shape {


	/**
	 * 
	 */
	private static final long serialVersionUID = -219601397697646791L;

	@Override
	protected void drawShape(Graphics2D g) {
		int x1 = super.getX1(), x2 = super.getX2(), y1 = super.getY1(), y2 = super.getY2();

		int tmpX = x1, tmpY = y1;

		if (x2 < x1) {
			x1 = x2;
			x2 = tmpX - x2;
		} else {
			x2 = x2 - tmpX;
		}

		if (y2 < y1) {
			y1 = y2;
			y2 = tmpY - y2;
		} else {
			y2 = y2 - tmpY;
		}

		if (super.isFilled()) {
			g.fillOval(x1, y1, x2, y2);
		} else {
			g.drawOval(x1, y1, x2, y2);
		}
	}

}
