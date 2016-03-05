package model.Shapes;
import java.awt.Graphics2D;

import model.Shape;

public class Oval extends Shape {


	@Override
	protected void drawShape(Graphics2D g) {
		if (super.isFilled()) {
			g.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());	
		} else {			
			g.drawOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());			
		}
	}

}
