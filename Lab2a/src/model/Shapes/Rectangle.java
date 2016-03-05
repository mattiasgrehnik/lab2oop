package model.Shapes;

import java.awt.Graphics2D;

import model.Shape;

public class Rectangle extends Shape {

	@Override
	protected void drawShape(Graphics2D g) {
		if (super.isFilled()) {
			g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());	
		} else {			
			g.drawRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());			
		}
	}



}
