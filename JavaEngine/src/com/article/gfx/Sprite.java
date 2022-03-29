package com.article.gfx;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	protected BufferedImage image;
	
	/**
	 * @param imagePath
	 * - File path of the image
	 */
	public Sprite(final String imagePath) {
		try {
			image = ImageIO.read(Sprite.class.getResourceAsStream(imagePath));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param image
	 * - Image of this {@code sprite}
	 */
	public Sprite(final BufferedImage image) {
		this.image = image;
	}
	
	/**
	 * @param sprite
	 * - Sprite that contains the {@code image} to set
	 */
	public Sprite(final Sprite sprite) {
		this.image = sprite.image;
	}
	
	// TODO: Add more features to this class
	/**
	 * Crops this' {@code image} and returns a new Sprite
	 * 
	 * @param beginningX
	 * - Beginning cropping point : {@code X}
	 * 
	 * @param beginningY
	 * - Beginning cropping point : {@code Y}
	 * 
	 * @param endingX
	 * - Ending cropping point : {@code X}
	 * 
	 * @param endingY
	 * - Ending cropping point : {@code Y}
	 * 
	 * @return
	 * - Cropped Sprite
	 */
	public Sprite crop(final int beginningX, final int beginningY, final int endingX, final int endingY) {
		return new Sprite(image.getSubimage(beginningX, beginningY, endingX, endingY));
	}
	
	/**
	 * Renders the image stored in this {@code sprite}
	 * 
	 * @param graphics
	 * - Graphics to {@code render} the image
	 * 
	 * @param x
	 * - X position where to render the {@code image}
	 * 
	 * @param y
	 * - Y position where to render the {@code image}
	 * 
	 * @param observer
	 * - Image Observer to observer {@code image} behavior
	 * 
	 * @see #renderImage(Graphics2D, int, int)
	 */
	public void renderImage(final Graphics2D graphics, final int x, final int y, final ImageObserver observer) {
		graphics.drawImage(image, x, y, observer);
	}
	
	/**
	 * Renders the image stored in this {@code sprite}
	 * 
	 * @param graphics
	 * - Graphics to {@code render} the image
	 * 
	 * @param x
	 * - X position where to render the {@code image}
	 * 
	 * @param y
	 * - Y position where to render the {@code image}
	 * 
	 * @see #renderImage(Graphics2D, int, int, ImageObserver)
	 */
	public void renderImage(final Graphics2D graphics, final int x, final int y) {
		graphics.drawImage(image, x, y, null);
	}
	
	/**
	 * @return
	 * {@code Width} of the image
	 */
	public int getWidth() {
		return image.getWidth();
	}
	
	/**
	 * @return
	 * {@code Height} of the image
	 * @return
	 */
	public int getHeight() {
		return image.getHeight();
	}
	
	/**
	 * @return
	 * {@code Image} of this Sprite
	 */
	public BufferedImage getImage() {
		final BufferedImage cloneImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		
		// Copy image's pixels to a new image
		for(int i = 0; i < image.getWidth(); i++)
			for(int j = 0; j < image.getHeight(); j++)
				cloneImage.setRGB(i, j, image.getRGB(i, j));
		
		return cloneImage;
	}
}