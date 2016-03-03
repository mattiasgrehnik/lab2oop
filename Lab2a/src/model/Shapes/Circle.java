package model.Shapes;

import java.awt.Graphics2D;

import model.Shape;

public class Circle extends Shape {

	@Override
	protected void drawShape(Graphics2D g) {
		g.drawOval(300, 300, 300, 300);
		
	}

}
