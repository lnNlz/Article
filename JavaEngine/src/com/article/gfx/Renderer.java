package com.article.gfx;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import com.article.geom.Triangle3D;
import com.article.math.Vec2;

/**
 * {@code Renderer} class handles the rendering,
 * this manipulates individual pixels of an {@code image}
 * with a specified size
 * 
 * @since WIP 1.3
 * @version 1.0
 */
public final class Renderer {
	private final BufferedImage screen;
	private final int[] pixels;
	
	// Colors
	private int clearColor = 0xffffffff; // White as default
	private int color 	   = 0xff000000; // Black as default
	
	public Renderer(final int width, final int height) {
		screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		pixels = ((DataBufferInt)screen.getRaster().getDataBuffer()).getData();
		
		// Fill with black
		fillScreen();
	}
	
	/**
	 * Fills the {@code screen} with this' {@code color} value
	 * 
	 * @see #fillScreen(Color)
	 * @see #fillScreen(int)
	 */
	public void fillScreen() {
		for(int i = 0; i < pixels.length; i++)
			pixels[i] = clearColor;
	}
	
	/**
	 * Fills the {@code screen} with the {@code color} specified
	 * 
	 * @param color
	 * - {@code Fill} color
	 * 
	 * @see #fillScreen()
	 * @see #fillScreen(Color)
	 */
	public void fillScreen(final int color) {
		for(int i = 0; i < pixels.length; i++)
			pixels[i] = color;
	}
	
	/**
	 * Fills the {@code screen} with the {@code color} specified
	 * 
	 * @param color
	 * - {@code Fill} color
	 * 
	 * @see #fillScreen()
	 * @see #fillScreen(int)
	 */
	public void fillScreen(final Color color) {
		for(int i = 0; i < pixels.length; i++)
			pixels[i] = color.getRGB();
	}

	/**
	 * Renders the {@code screen} image to the screen
	 * 
	 * @param graphics
	 * - {@code Graphics}, to render the image
	 */
	public void render(final Graphics2D graphics) {
		graphics.drawImage(screen, 0, 0, null);
	}
	
	/**
	 * Draws a line that goes from {@code line point A} to {@code line point B},
	 * if the goes out of the {@code screen scale}... it will be <i>clipped</i> out
	 * 
	 * @param linePointA
	 * - Starting {@code point}
	 * 
	 * @param linePointB
	 * - Ending {@code point}
	 * 
	 * @param color
	 * - {@code Color} of the line
	 * 
	 * @see #drawLine(Vec2, Vec2)
	 * @see #drawLine(int, int, int, int, int)
	 * @see #drawLine(int, int, int, int)
	 */
	public void drawLine(final Vec2 linePointA, final Vec2 linePointB, final int color) {
		// Checks whether linePointA is greater than linePointB
		final Vec2 pointA = linePointA.getX() < linePointB.getX() ? linePointA : linePointB;
		final Vec2 pointB = pointA == linePointA ? linePointB : linePointA;
		
		// Delta positions (Change in axis)
		final int deltaX = Math.abs(pointB.getX() - pointA.getX());	// Adjacent side
		final int deltaY = Math.abs(pointB.getY() - pointA.getY());	// Opposite side
		
		// Current y - axis
		// Set it to first point Y
		int y = pointA.getY() < pointB.getY() ? pointA.getY() : pointB.getY();
		
		// Pixel per row value
		int yIndex = 0;
		
		// Loop through intersected pixels
		for(int x = pointA.getX(); x < pointB.getX(); x++) {
			// Render the line
			// Where is the targeted pixel located in our array
			final int drawIndex = x + y * screen.getWidth();
			
			// Index, out of bounds
			if(drawIndex >= pixels.length) break;
			
			// Increment pixel per row value
			yIndex += deltaY;
			
			// Check whether y index is over or equals the width
			if(yIndex << 1 >= deltaX) {
				// Decrement y index
				yIndex -= deltaX;
				
				// Increment to the next pixel row
				y++;
			}
					
			// Set the pixel
			pixels[drawIndex] = color;
		}
	}
	
	/**
	 * Draws a line that goes from {@code line point A} to {@code line point B},
	 * if the goes out of the {@code screen scale}... it will be <i>clipped</i> out
	 * 
	 * @param linePointA
	 * - Starting {@code point}
	 * 
	 * @param linePointB
	 * - Ending {@code point}
	 * 
	 * @see #drawLine(Vec2, Vec2, int)
	 * @see #drawLine(int, int, int, int, int)
	 * @see #drawLine(int, int, int, int)
	 */
	public void drawLine(final Vec2 linePointA, final Vec2 linePointB) {
		drawLine(linePointA, linePointB, color);
	}
	
	/**
	 * Draws a line that goes from {@code x1 and y1} to {@code x2 and y2},
	 * if the goes out of the {@code screen scale}... it will be <i>clipped</i> out
	 * 
	 * @param x1
	 * - Starting {@code x}
	 * 
	 * @param y1
	 * - Starting {@code y}
	 * 
	 * @param x2
	 *  Ending {@code x}
	 * 
	 * @param y2
	 * - Ending {@code y}
	 * 
	 * @see #drawLine(Vec2, Vec2, int)
	 * @see #drawLine(Vec2, Vec2)
	 * @see #drawLine(int, int, int, int)
	 */
	public void drawLine(final int x1, final int y1, final int x2, final int y2, final int color) {
		drawLine(new Vec2(x1, y1), new Vec2(x2, y2), color);
	}
	
	/**
	 * Draws a line that goes from {@code x1 and y1} to {@code x2 and y2},
	 * if the goes out of the {@code screen scale}... it will be <i>clipped</i> out
	 * 
	 * @param x1
	 * - Starting {@code x}
	 * 
	 * @param y1
	 * - Starting {@code y}
	 * 
	 * @param x2
	 *  Ending {@code x}
	 * 
	 * @param y2
	 * - Ending {@code y}
	 * 
	 * @see #drawLine(Vec2, Vec2, int)
	 * @see #drawLine(Vec2, Vec2)
	 * @see #drawLine(int, int, int, int, int)
	 */
	public void drawLine(final int x1, final int y1, final int x2, final int y2) {
		drawLine(new Vec2(x1, y1), new Vec2(x2, y2));
	}
	
	/**
	 * Draws a triangle by calling 3 {@code drawLine} method
	 * 
	 * @param pointA
	 * - {@code First} point
	 * 
	 * @param pointB
	 * - {@code Second} point
	 * 
	 * @param pointC
	 * - {@code Third} point
	 * 
	 * @param color1
	 * - {@code First} line color
	 * 
	 * @param color2
	 * - {@code Second} line color
	 * 
	 * @param color3
	 * - {@code Third} line color
	 */
	public void drawTriangle(final Vec2 pointA, final Vec2 pointB, final Vec2 pointC, final int color1, final int color2, final int color3) {
		drawLine(pointA, pointB, color1);
		drawLine(pointB, pointC, color2);
		drawLine(pointC, pointA, color3);
	}
	
	/**
	 * Draws a triangle by calling 3 {@code drawLine} method
	 * 
	 * @param pointA
	 * - {@code First} point
	 * 
	 * @param pointB
	 * - {@code Second} point
	 * 
	 * @param pointC
	 * - {@code Third} point
	 * 
	 * @param color
	 * - {@code Triangle} color
	 */
	public void drawTriangle(final Vec2 pointA, final Vec2 pointB, final Vec2 pointC, final int color) {
		drawTriangle(pointA, pointB, pointC, color, color, color);
	}
	
	/**
	 * Draws a triangle into the screen
	 * 
	 * @param triangle
	 * - {@code Triangle 3D} to render
	 * 
	 * @param color1
	 * - {@code First} line color
	 * 
	 * @param color2
	 * - {@code Second} line color
	 * 
	 * @param color3
	 * - {@code Third} line color
	 */
	public void drawTriangle(final Triangle3D triangle, final int color1, final int color2, final int color3) {
		drawTriangle(triangle.pointA.toVector2D(), triangle.pointB.toVector2D(), triangle.pointC.toVector2D(), color1, color2, color3);
	}
	
	// *****************************************************************************************************
	// GETTERS AND SETTERS
	// *****************************************************************************************************
	
	/**
	 * @return
	 * - Current {@code renderer} color
	 */
	public int getColor() {
		return color;
	}
	
	/**
	 * Sets a new value to this' {@code color}
	 * 
	 * @param newColor
	 * - {@code Renderer} new color
	 */
	public void setColor(final int newColor) {
		color = newColor;
	}
	
	/**
	 * Sets a new value to this' {@code color}
	 * 
	 * @param newColor
	 * - {@code Renderer} new color
	 */
	public void setColor(final Color newColor) {
		color = newColor.getRGB();
	}
	
	/**
	 * @return
	 * - Current {@code renderer} clear color
	 */
	public int getClearColor() {
		return clearColor;
	}
	
	/**
	 * Sets a new value to this' {@code clear color}
	 * 
	 * @param newColor
	 * - {@code Renderer} new color
	 */
	public void setClearColor(final int newColor) {
		clearColor = newColor;
	}
	
	/**
	 * Sets a new value to this' {@code clear color}
	 * 
	 * @param newColor
	 * - {@code Renderer} new color
	 */
	public void setClearColor(final Color newColor) {
		clearColor = newColor.getRGB();
	}
}