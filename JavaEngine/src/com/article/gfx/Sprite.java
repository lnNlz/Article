package com.article.gfx;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * {@code Sprite} class holds an image that could be used as
 * texture and more
 * <br>
 * This class contains several methods including {@code crop()} to crop
 * the image and {@code render()} to render the image
 * 
 * @version 1.0
 * @since WIP 1.1
 */
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
	
	public BufferedImage resize(int newWidth, int newHeight) {
		BufferedImage outputImage = new BufferedImage(image.getWidth() * newWidth, image.getHeight() * newHeight, image.getType());
		final AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(newWidth, newHeight), AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
//		final AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(newWidth, newHeight), scaleType);
		outputImage = ato.filter(image, outputImage);
		
		return outputImage;
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
	 * Sets the pixel color at a given coordinate
	 * 
	 * @param x
	 * - {@code X} pixel
	 * 
	 * @param y
	 * - {@code Y} pixel
	 * 
	 * @param color
	 * - {@code Color} of the target pixel
	 */
	public void setRGB(final int x, final int y, final int color) {
		image.setRGB(x, y, color);
	}
	
	/**
	 * Returns the RGB value of the pixel at a given coordinate
	 * 
	 * @param x
	 * - {@code X} pixel
	 * 
	 * @param y
	 * - {@code Y} pixel
	 * 
	 * @return
	 * {@code RGB} value at x and y coordinate
	 */
	public int getRGB(final int x, final int y) {
		return image.getRGB(x, y);
	}
	
	/**
	 * Sets {@code this}' image to the image stored in the sprite specified
	 * 
	 * @param anotherSprite
	 * - {@code Sprite} that contains the image to be copied
	 */
	public void set(final Sprite anotherSprite) {
		if(anotherSprite == null || anotherSprite.image == null) throw new IllegalArgumentException("Null sprite!");
		
		image = anotherSprite.getImage();
	}
	
	/**
	 * Sets {@code this}' image to the image specified
	 * 
	 * @param anotherSprite
	 * - {@code Image} to be copied
	 */
	public void set(final BufferedImage anotherImage) {
		set(new Sprite(anotherImage));
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