package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

public abstract class Shape implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1129963998868953765L;
	private Color color;
	private int strokeWidth;
	private int x1, x2, y1, y2;
	private boolean filled;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getStroke() {
		return strokeWidth;
	}

	public void setStroke(int stroke) {
		this.strokeWidth = stroke;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public void setFilled(boolean b) {
		filled = b;
	}

	public boolean isFilled() {
		return filled;
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(strokeWidth));
		drawShape(g2);
	}

	public boolean contains(int x, int y) {
		if ((x > x1 && x < x2 && y > y1 && y < y2) ^ (x < x1 && x > x2 && y < y1 && y > y2)
				^ (x > x1 && x < x2 && y < y1 && y > y2) ^ (x < x1 && x > x2 && y > y1 && y < y2)) {
			return true;
		}
		return false;
	}

	abstract protected void drawShape(Graphics2D g);

}
