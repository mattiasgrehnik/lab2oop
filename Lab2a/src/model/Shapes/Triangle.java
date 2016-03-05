package model.Shapes;

import java.awt.Graphics2D;

import model.Shape;

public class Triangle extends Shape {

	@Override
	protected void drawShape(Graphics2D g) {
		if (super.isFilled()) {
			g.fillPolygon(
					new int[] { super.getX(), (super.getWidth() + super.getX() * 2) / 2,
							super.getWidth() + super.getX() },
					new int[] { super.getY() + super.getHeight(), super.getY(), super.getY() + super.getHeight() }, 3);
		} else {
			g.drawPolygon(
					new int[] { super.getX(), (super.getWidth() + super.getX() * 2) / 2,
							super.getWidth() + super.getX() },
					new int[] { super.getY() + super.getHeight(), super.getY(), super.getY() + super.getHeight() }, 3);
		}

	}
}
