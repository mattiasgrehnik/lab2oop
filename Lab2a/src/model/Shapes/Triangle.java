package model.Shapes;

import java.awt.Graphics2D;

import model.Shape;

public class Triangle extends Shape {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8588662646272623529L;

	@Override
	protected void drawShape(Graphics2D g) {

		int x1 = super.getX1(), x2 = super.getX2(), y1 = super.getY1(), y2 = super.getY2();

		if (super.isFilled()) {
			g.fillPolygon(new int[] { x1, (x2 + x1) / 2, x2 }, new int[] { y2, y1, y2 }, 3);
		} else {
			g.drawPolygon(new int[] { x1, (x2 + x1) / 2, x2 }, new int[] { y2, y1, y2 }, 3);
		}

	}
}
