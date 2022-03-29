package com.article.geom;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import com.article.math.Vec4F;

/**
 * A {@code Triangle} object that could be projected in a 3D space,
 * this {@code Triangle} holds {@link Vec4F} instead of {@link Vec3F}
 */
public class Triangle4D {
	// Vertices
	public final Vec4F pointA;
	public final Vec4F pointB;
	public final Vec4F pointC;
	
	// Color of this rectangle
	public Color color;
	
	/**
	 * @param pointA
	 * - {@code Point A}
	 * 
	 * @param pointB
	 * - {@code Point B}
	 * 
	 * @param pointC
	 * - {@code Point C}
	 */
	public Triangle4D(final Vec4F pointA, final Vec4F pointB, final Vec4F pointC) {
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		
		// Default Color
		color = Color.WHITE;
	}
	
	/**
	 * Draws the {@code triangle} by drawing its {@code 3 sides}
	 * 
	 * @param g
	 * - {@code Graphics2D} to draw
	 */
	public void drawLine(final Graphics2D g) {
		g.setColor(color);
		
		g.drawLine((int)pointA.getX(), (int)pointA.getY(), 
				   (int)pointB.getX(), (int)pointB.getY());
		
		g.drawLine((int)pointB.getX(), (int)pointB.getY(), 
				   (int)pointC.getX(), (int)pointC.getY());
		
		g.drawLine((int)pointC.getX(), (int)pointC.getY(), 
				   (int)pointA.getX(), (int)pointA.getY());
	}
	
	/**
	 * Draws the {@code triangle} by drawing its {@code 3 sides}
	 * 
	 * @param g
	 * - {@code Graphics2D} to draw
	 */
	public void fill(final Graphics2D g) {
		g.setColor(color);
		
		g.fill(new Polygon(
					new int[] { (int)pointA.getX(), (int)pointB.getX(), (int)pointC.getX() },
					new int[] { (int)pointA.getY(), (int)pointB.getY(), (int)pointC.getY() },
					3
				));
	}
	
	/**
	 * Adds the vector given to all the points
	 * 
	 * @param toAdd
	 * - {@code Vector 4D float} to add
	 */
	public void add(final Vec4F toAdd) {
		pointA.set(pointA.add(toAdd));
		pointB.set(pointB.add(toAdd));
		pointC.set(pointC.add(toAdd));
	}
	
	/**
	 * Multiplies the vector given to all the points
	 * 
	 * @param toAdd
	 * - {@code Vector 4D float} to multiply
	 */
	public void multiply(final Vec4F toMultiply) {
		pointA.set(pointA.multiply(toMultiply));
		pointB.set(pointB.multiply(toMultiply));
		pointC.set(pointC.multiply(toMultiply));
	}
	
	/**
	 * @return
	 * - Triangle 3D with this' points
	 */
	public Triangle3D toTriangle3D() {
		return new Triangle3D(pointA.toVector3DFloat(), pointB.toVector3DFloat(), pointC.toVector3DFloat());
	}
	
	@Override
	public Triangle4D clone() {
		return new Triangle4D(pointA, pointB, pointC);
	}
	
	@Override
	public String toString() {
		return pointA + " , " + pointB + " , " + pointC;
	}
}