package model.Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.Shape;

public class Circle extends Shape {

	private Color color;
	private int thickness;
	private boolean isFilled;
	private int x,y;

	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public int getThickness() {
		return thickness;
	}


	public void setThickness(int thickness) {
		this.thickness = thickness;
	}


	public boolean isFilled() {
		return isFilled;
	}


	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	@Override
	protected void drawShape(Graphics g) {
		System.out.println("circle");
		g.drawOval(300, 300, 300, 300);
		g.fillOval(x, y, 100, 100);
	}

}
