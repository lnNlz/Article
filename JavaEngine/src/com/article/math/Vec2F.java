package com.article.math;

/**
 * {@code Vector 2D Float} class holds 2 floats, being <em>x</em> and <em>y</em>
 * <hr>
 * This class could be treated as a coordinate or a {@code math vector} having no coordinates
 * 
 * @version 1.5
 * @since 1.0
 */
public class Vec2F {
	protected float x;
	protected float y;
	
	/**
	 * @param x
	 * - {@code X} value
	 * 
	 * @param y
	 * - {@code Y} value
	 */
	public Vec2F(final float x, final float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @param value
	 * - Value for both {@code x} and {@code y}
	 * 
	 * @see #Vec2(float, float)
	 */
	public Vec2F(final float value) {
		this(value, value);
	}
	
	/**
	 * Sets {@code x and y} to {@code 0.0}
	 * 
	 * @see #Vec2(float)
	 * @see #Vec2(float, float)
	 */
	public Vec2F() {
		this(0);
	}
	
	/**
	 * @return
	 * the {@code length} or {@code magnitude} of this vector,
	 * this is achieved through Pythagoras theorem
	 */
	public final float length() {
		return (float)Math.sqrt(x * x + y * y);
	}
	
	/**
	 * Normalizes this {@code vector 2D Float}
	 * 
	 * @return
	 * Normalized vector
	 * 
	 * @see #fastNormalize()
	 */
	public final Vec2F normalize() {
		// Hypoteneuse_
		final float length = length();
		
		// Vector 2D to return
		final Vec2F newVec2F = new Vec2F();
		
		// Prevents division by zero
		if(length == 0) return newVec2F;
		
		// Normalize
		newVec2F.x = x / length;
		newVec2F.y = y / length;
		
		return newVec2F;
	}
	
	/**
	 * Normalizes this {@code vector 2D Float}
	 * 
	 * @return
	 * Normalized vector
	 * 
	 * @see #normalize()
	 */
	public final Vec2F fastNormalize() {
		// Vector 2D Float to return
		final Vec2F newVec2F = new Vec2F();
		
		// Get the inverse square root of length
		final float inverseSquareRoot = Mathf.fastInverseSqrt(x * x + y * y);
		
		// Sets the value
		newVec2F.x = x * inverseSquareRoot;
		newVec2F.y = y * inverseSquareRoot;
		
		return newVec2F;
	}
	
	/**
	 * Returns the {@code sine} of this vector by dividing {@code x}[Adjacent] over
	 * {@code length}[Hypotenuse]
	 * 
	 * @return
	 * Adjacent {@code over} Hypotenuse
	 */
	public final float sin() {
		return x / length();
	}
	
	/**
	 * Returns the {@code cosine} of this vector by dividing {@code y}[Opposite] over
	 * {@code length}[Hypotenuse]
	 * 
	 * @return
	 * Opposite {@code over} Hypotenuse
	 */
	public final float cos() {
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
	public final float tan() {
		return y / x;
	}
	
	/**
	 * Swaps {@code x} and {@code y} values
	 * 
	 * @return
	 * - {@code Swapped} vector
	 */
	public final Vec2F swap() {
		return new Vec2F(y, x);
	}
	
	/**
	 * Adds {@code every value} of this vector to all the value of the {@code given vector}
	 *  
	 * @param anotherVec2F
	 * - {@code vector} to add 
	 * 
	 * @return
	 * {@code Added} Vec2F
	 * 
	 * @see #add(int)
	 */
	public Vec2F add(final Vec2F anotherVec2F) {
		return new Vec2F(anotherVec2F.x + x, anotherVec2F.y + y);
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
	 * @see #add(Vec2F)
	 */
	public Vec2F add(final float value) {
		return add(new Vec2F(value));
	}
	
	/**
	 * Subtracts {@code every value} of this vector to all the value of the {@code given vector}
	 *  
	 * @param anotherVec2F
	 * - {@code vector} to subtract 
	 * 
	 * @return
	 * {@code Subtracted} Vec2F
	 */
	public Vec2F subtract(final Vec2F anotherVec2F) {
		return new Vec2F(x - anotherVec2F.x, y - anotherVec2F.y);
	}
	
	/**
	 * Multiplies {@code every value} of this vector to the scalar given
	 * 
	 * @param scalar
	 * - {@code Scalar} value to multiply
	 * 
	 * @return
	 * {@code Multiplied} Vector2F
	 * 
	 * @see #multiply(Vec2F)
	 */
	public Vec2F multiply(final float scalar) {
		return new Vec2F(x * scalar, y * scalar);
	}
	
	/**
	 * Multiplies {@code every value} of this vector to every value of the {@code vector} given
	 * 
	 * @param anotherVec2F
	 * - {@code Vector2} value to multiply
	 * 
	 * @return
	 * {@code Multiplied} Vector2F
	 * 
	 * @see #multiply(float)
	 */
	public Vec2F multiply(final Vec2F anotherVec2F) {
		return new Vec2F(x * anotherVec2F.x, y * anotherVec2F.y);
	}
	
	/**
	 * Divides {@code every value} of this vector to every value of the {@code vector} given
	 * 
	 * @param anotherVec2F
	 * - Another {@code vector} to divide
	 * 
	 * @return
	 * {@code Output} vector
	 * 
	 * @see #divide(float)
	 */
	public Vec2F divide(final Vec2F anotherVec2F) {
		return new Vec2F(x / anotherVec2F.x,
						 y / anotherVec2F.y);
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
	public Vec2F divide(final float value) {
		return divide(new Vec2F(value));
	}
	
	/**
	 * @return
	 * {@code Half} of every value of this {@code vector}
	 */
	public Vec2F half() {
		return new Vec2F( (int)x >> 1, (int)y >> 1 );
	}
	
	/**
	 * @return
	 * {@code slope} of this vector
	 * <br>
	 * calculation:
	 * <br>
	 * <br>
	 * {@code y / x}
	 */
	public final float slope() {
		return y / x;
	}
	
	/**
	 * Sets this' {@code x} and {@code y} value
	 * 
	 * @param newValue
	 * - {@code Vector 2D Float} that contains the new value
	 * 
	 * @return
	 * {@code this} vector
	 */
	public Vec2F set(final Vec2F newValue) {
		x = newValue.x;
		y = newValue.y;
		
		return this;
	}
	
	@Override
	public Vec2F clone() {
		return new Vec2F(x, y);
	}
	
	
	@Override
	public String toString() {
		return "[x  : " + x + ", y : " + y + "]";
	}
	
	/**
	 * Returns whether {@code this} and {@code another Vector 2D Float} has the same {@code x} and {@code y} value
	 * 
	 * @param anotherVec2
	 * - Another Vector 2D Float to examine
	 * 
	 * @return
	 * {@code true} if values are equal; {@code false} otherwise
	 */
	public boolean equals(final Vec2 anotherVec2F) {
		return x == anotherVec2F.x && y == anotherVec2F.y;
	}
	
	/**
	 * Returns whether {@code this} and {@code another Vector 2D Float} has the same {@code x} and {@code y} value by rounding them
	 * 
	 * @param anotherVec2
	 * - Another Vector 2D Float to examine
	 * 
	 * @return
	 * {@code true} if rounded values are equal; {@code false} otherwise
	 */
	public boolean equalsRounded(final Vec2 anotherVec2F) {
		return (int)x == (int)anotherVec2F.x && (int)y == (int)anotherVec2F.y;
	}
	
	/**
	 * @return
	 * {@code true} if values are zero; {@code false} otherwise
	 */
	public boolean isZero() {
		return x == 0.0 && y == 0.0;
	}
	
	/**
	 * @return
	 * {@code x} value
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets new {@code x} value
	 * 
	 * @param x
	 * - new Value for {@code x}
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * @return
	 * {@code y} value
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Sets new {@code y} value
	 * 
	 * @param y
	 * - new Value for {@code y}
	 */
	public void setY(float y) {
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
	public static final void swapVector(final Vec2F vector1, final Vec2F vector2) {
		final Vec2F storedVector1 = vector1.clone();
		
		vector1.set( vector2 );
		vector2.set( storedVector1 );
	}
}