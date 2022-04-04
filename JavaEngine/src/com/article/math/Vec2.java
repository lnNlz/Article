package com.article.math;

/**
 * {@code Vector 2D} class holds 2 integers, being <em>x</em> and <em>y</em>
 * <hr>
 * This class could be treated as a coordinate or a {@code math vector} having no coordinates
 * 
 * @version 1.5
 * @since 1.0
 */
public class Vec2 {
	protected int x;
	protected int y;
	
	/**
	 * @param x
	 * - {@code X} value
	 * 
	 * @param y
	 * - {@code Y} value
	 */
	public Vec2(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @param value
	 * - Value for both {@code x} and {@code y}
	 * 
	 * @see #Vec2(int, int)
	 */
	public Vec2(final int value) {
		this(value, value);
	}
	
	/**
	 * Sets {@code x and y} to {@code 0}
	 * 
	 * @see #Vec2(int)
	 * @see #Vec2(int, int)
	 */
	public Vec2() {
		this(0);
	}
	
	/**
	 * @return
	 * the {@code length} or {@code magnitude} of this vector,
	 * this is achieved through Pythagoras theorem
	 */
	public final int length() {
		return (int)Math.sqrt(x * x + y * y);
	}
	
	/**
	 * Normalizes this {@code vector 2D}
	 * 
	 * @return
	 * Normalized vector
	 * 
	 * @see #fastNormalize()
	 */
	public final Vec2 normalize() {
		// Hypoteneuse_
		final int length = length();
		
		// Vector 2D to return
		final Vec2 newVec2 = new Vec2();
		
		// Prevents division by zero
		if(length == 0) return newVec2;
		
		// Normalize
		newVec2.x = x / length;
		newVec2.y = y / length;
		
		return newVec2;
	}
	
	/**
	 * Normalizes this {@code vector 2D}
	 * 
	 * @return
	 * Normalized vector
	 * 
	 * @see #normalize()
	 */
	public final Vec2 fastNormalize() {
		// Vector 2D to return
		final Vec2 newVec2 = new Vec2();
		
		// Get the inverse square root of length
		final float inverseSquareRoot = Mathf.fastInverseSqrt(x * x + y * y);
		
		// Sets the value
		newVec2.x = (int)(x * inverseSquareRoot);
		newVec2.y = (int)(y * inverseSquareRoot);
		
		return newVec2;
	}
	
	/**
	 * Returns the {@code sine} of this vector by dividing {@code x}[Adjacent] over
	 * {@code length}[Hypotenuse]
	 * 
	 * @return
	 * Adjacent {@code over} Hypotenuse
	 */
	public final int sin() {
		return x / length();
	}
	
	/**
	 * Returns the {@code cosine} of this vector by dividing {@code y}[Opposite] over
	 * {@code length}[Hypotenuse]
	 * 
	 * @return
	 * Opposite {@code over} Hypotenuse
	 */
	public final int cos() {
		return y / length();
	}
	
	/**
	 * Returns the {@code tangent} of this vector by dividing {@code y}[Opposite] over
	 * {@code x}[Adjacent]
	 * 
	 * @return
	 * Opposite {@code over} Adjacent
	 * 
	 * @see #slope()
	 */
	public final int tan() {
		return y / x;
	}
	
	/**
	 * Swaps {@code x} and {@code y} values
	 * 
	 * @return
	 * - {@code Swapped} vector
	 */
	public final Vec2 swap() {
		return new Vec2(y, x);
	}
	
	/**
	 * Adds {@code every value} of this vector to all the value of the {@code given vector}
	 *  
	 * @param anotherVec2
	 * - {@code vector} to add 
	 * 
	 * @return
	 * {@code Added} Vec2
	 * 
	 * @see #add(int)
	 */
	public Vec2 add(final Vec2 anotherVec2) {
		return new Vec2(anotherVec2.x + x, anotherVec2.y + y);
	}
	
	/**
	 * Adds {@code every value} of this vector to the value given
	 *  
	 * @param value
	 * - {@code value} to add
	 * 
	 * @return
	 * {@code Added} value
	 * 
	 * @see #add(Vec2)
	 */
	public Vec2 add(final int value) {
		return add(new Vec2(value));
	}
	
	/**
	 * Subtracts {@code every value} of this vector to all the value of the {@code given vector}
	 *  
	 * @param anotherVec2
	 * - {@code vector} to subtract 
	 * 
	 * @return
	 * {@code Subtracted} Vec2
	 */
	public Vec2 subtract(final Vec2 anotherVec2) {
		return new Vec2(x - anotherVec2.x, y - anotherVec2.y);
	}
	
	/**
	 * Multiplies {@code every value} of this vector to the scalar given
	 * 
	 * @param scalar
	 * - {@code Scalar} value to multiply
	 * 
	 * @return
	 * {@code Multiplied} Vector2
	 * 
	 * @see #multiply(Vec2)
	 */
	public Vec2 multiply(final int scalar) {
		return new Vec2(x * scalar, y * scalar);
	}
	
	/**
	 * Multiplies {@code every value} of this vector to every value of the {@code vector} given
	 * 
	 * @param anotherVec2
	 * - {@code Vector2} value to multiply
	 * 
	 * @return
	 * {@code Multiplied} Vector2
	 * 
	 * @see #multiply(int)
	 */
	public Vec2 multiply(final Vec2 anotherVec2) {
		return new Vec2(x * anotherVec2.x, y * anotherVec2.y);
	}
	
	/**
	 * Divides {@code every value} of this vector to every value of the {@code vector} given
	 * 
	 * @param anotherVec2
	 * - Another {@code vector} to divide
	 * 
	 * @return
	 * {@code Output} vector
	 * 
	 * @see #divide(int)
	 */
	public Vec2 divide(final Vec2 anotherVec2) {
		return new Vec2(x / anotherVec2.x,
						y / anotherVec2.y);
	}
	
	/**
	 * Divides {@code every value} of this vector to the {@code value} given
	 * 
	 * @param value
	 * - {@code value} to divide
	 * 
	 * @return
	 * {@code Output} vector
	 */
	public Vec2 divide(final int value) {
		return divide(new Vec2(value));
	}
	
	/**
	 * @return
	 * {@code Half} of every value of this {@code vector}
	 */
	public Vec2 half() {
		return new Vec2( x >> 1, y >> 1 );
	}
	
	/**
	 * @return
	 * {@code slope} of this vector
	 * <br>
	 * calculation:
	 * <br>
	 * <br>
	 * {@code y / x}
	 * 
	 * @see #tan()
	 */
	public final int slope() {
		return y / x;
	}
	
	/**
	 * Sets this' {@code x} and {@code y} value
	 * 
	 * @param newValue
	 * - {@code Vector 2D} that contains the new value
	 * 
	 * @return
	 * {@code this} vector
	 */
	public Vec2 set(final Vec2 newValue) {
		x = newValue.x;
		y = newValue.y;
		
		return this;
	}
	
	@Override
	public Vec2 clone() {
		return new Vec2(x, y);
	}
	
	
	@Override
	public String toString() {
		return "[x  : " + x + ", y : " + y + "]";
	}
	
	/**
	 * @return
	 * {@code Vector 2D} with this' {@code x}, {@code y} and {@code z} value
	 */
	public Vec3 toVector3D() {
		return new Vec3(x, y, 0);
	}
	
	/**
	 * Returns whether {@code this} and {@code another Vector 2D} has the same {@code x} and {@code y} value
	 * 
	 * @param anotherVec2
	 * - Another Vector 2D to examine
	 * 
	 * @return
	 * {@code true} if values are equal; {@code false} otherwise
	 */
	public boolean equals(final Vec2 anotherVec2) {
		return x == anotherVec2.x && y == anotherVec2.y;
	}
	
	/**
	 * @return
	 * {@code true} if values are zero; {@code false} otherwise
	 */
	public boolean isZero() {
		return x == 0 && y == 0;
	}
	
	/**
	 * @return
	 * {@code x} value
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets new {@code x} value
	 * 
	 * @param x
	 * - new Value for {@code x}
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * @return
	 * {@code y} value
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets new {@code y} value
	 * 
	 * @param y
	 * - new Value for {@code y}
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	// ***************************************************************************
	// STATIC METHODS
	// ***************************************************************************
	
	/**
	 * Swaps the value of two given vectors
	 * 
	 * @param vector1
	 * - {@code first} vector
	 * 
	 * @param vector2
	 * - {@code second} vector
	 * 
	 * @since WIP 1.3
	 */
	public static final void swapVector(final Vec2 vector1, final Vec2 vector2) {
		final Vec2 storedVector1 = vector1.clone();
		
		vector1.set( vector2 );
		vector2.set( storedVector1 );
	}
}