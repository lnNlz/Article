package com.article.math;

/**
 * {@code Vector 3D Float} class holds 3 floats, being <em>x</em>, <em>y</em> and <em>z</em>
 * <hr>
 * This class could be treated as a coordinate or a {@code math vector} having no coordinates
 * 
 * @version 1.8
 * @since 1.0
 */
public class Vec3 {
	protected int x;
	protected int y;
	protected int z;
	
	/**
	 * @param x
	 * - {@code X} value
	 * 
	 * @param y
	 * - {@code Y} value
	 * 
	 * @param z
	 * - {@code Z} value
	 */
	public Vec3(final int x, final int y, final int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * @param value
	 * - Value for {@code x}, {@code y} and {@code z}
	 * 
	 * @see #Vec3(int, int, int)
	 */
	public Vec3(final int value) {
		this(value, value, value);
	}
	
	/**
	 * Sets {@code x, y and z} to {@code 0}
	 * 
	 * @see #Vec3(int)
	 * @see #Vec3(int, int, int)
	 */
	public Vec3() {
		this(0);
	}
	
	/**
	 * Sets {@code all the value} of this vector to {@code all the value} of the given vector
	 * 
	 * @param vector
	 * - {@code Vector} values
	 */
	public Vec3(final Vec3 vector) {
		x = vector.x;
		y = vector.y;
		z = vector.z;
	}
	
	/**
	 * @return
	 * the {@code length} or {@code magnitude} of this 3D vector,
	 * this is achieved through Pythagoras theorem
	 */
	public final int length() {
		return (int)Math.sqrt(x * x + y * y + z * z);
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
	 * Normalizes this {@code vector 3D}
	 * 
	 * @return
	 * Normalized vector
	 * 
	 * @see #fastNormalize()
	 */
	public final Vec3 normalize() {
		// Hypoteneuse_
		final int length = length();
		
		// Vector 2D to return
		final Vec3 newVec3 = new Vec3();
		
		// Prevents division by zero
		if(length == 0) return newVec3;
		
		// Normalize
		newVec3.x = x / length;
		newVec3.y = y / length;
		newVec3.z = z / length;
		
		return newVec3;
	}
	
	/**
	 * Normalizes this {@code vector 3D}
	 * 
	 * @return
	 * Normalized vector
	 * 
	 * @see #normalize()
	 */
	public final Vec3 fastNormalize() {
		// Vector 3D to return
		final Vec3 newVec3 = new Vec3();
		
		// Get the inverse square root of length
		final float inverseSquareRoot = Mathf.fastInverseSqrt(x * x + y * y + z * z);
		
		// Sets the value
		newVec3.x = (int)(x * inverseSquareRoot);
		newVec3.y = (int)(y * inverseSquareRoot);
		newVec3.z = (int)(z * inverseSquareRoot);
		
		return newVec3;
	}
	
	/**
	 * Performs {@code cross product} multiplication between this vector
	 * and {@code another vector specified}
	 * 
	 * @param anotherVec3
	 * - {@code Another vector} to multiply
	 * 
	 * @return
	 * {@code result or output} of the operation
	 */
	public Vec3 crossProduct(final Vec3 anotherVec3) {
		// Vector to return
		final Vec3 outputVector = new Vec3();
		
		// Perform cross product multiplication
		outputVector.x = y * anotherVec3.z - z * anotherVec3.y;
		outputVector.y = z * anotherVec3.x - x * anotherVec3.z;
		outputVector.z = x * anotherVec3.y - y * anotherVec3.x;
		
		return outputVector;
	}
	
	/**
	 * Perform {@code dot product} multiplication between this vector
	 * and {@code another vector specified}
	 * 
	 * @param anotherVec3
	 * - {@code Another vector} to multiply
	 * 
	 * @return
	 * {@code result of output} of the operation
	 */
	public int dotProduct(final Vec3 anotherVec3) {
		// Value to return
		int outputValue = 0;
		
		// Perform dot product multiplication
		outputValue = x * anotherVec3.x;
		outputValue += y * anotherVec3.y;
		outputValue += z * anotherVec3.z;
		
		return outputValue;
	}
	
	/**
	 * Adds {@code every value} of this vector to all the value of the {@code given vector}
	 *  
	 * @param anotherVec3
	 * - {@code vector} to add 
	 * 
	 * @return
	 * {@code Added} Vec3
	 * 
	 * @see #add(int)
	 */
	public Vec3 add(final Vec3 anotherVec3) {
		return new Vec3(anotherVec3.x + x, anotherVec3.y + y, anotherVec3.z + z);
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
	 * @see #add(Vec3)
	 */
	public Vec3 add(final int value) {
		return add(new Vec3(value));
	}
	
	/**
	 * Subtracts {@code every value} of this vector to all the value of the {@code given vector}
	 *  
	 * @param anotherVec3
	 * - {@code vector} to subtract 
	 * 
	 * @return
	 * {@code Subtracted} Vec3
	 */
	public Vec3 subtract(final Vec3 anotherVec3) {
		return new Vec3(x - anotherVec3.x, y - anotherVec3.y, z - anotherVec3.z);
	}
	
	/**
	 * Multiplies {@code every value} of this vector to the scalar given
	 * 
	 * @param scalar
	 * - {@code Scalar} value to multiply
	 * 
	 * @return
	 * {@code Multiplied} Vector3
	 * 
	 * @see #multiply(Vec3)
	 */
	public Vec3 multiply(final int scalar) {
		return new Vec3(x * scalar, y * scalar, z * scalar);
	}
	
	/**
	 * Multiplies {@code every value} of this vector to every value of the {@code vector} given
	 * 
	 * @param anotherVec3
	 * - {@code Vector3} value to multiply
	 * 
	 * @return
	 * {@code Multiplied} Vector3
	 * 
	 * @see #multiply(int)
	 */
	public Vec3 multiply(final Vec3 anotherVec3) {
		return new Vec3(x * anotherVec3.x, y * anotherVec3.y, z * anotherVec3.z);
	}
	
	/**
	 * Divides {@code every value} of this vector to every value of the {@code vector} given
	 * 
	 * @param anotherVec3
	 * - Another {@code vector} to divide
	 * 
	 * @return
	 * {@code Output} vector
	 * 
	 * @see #divide(int)
	 */
	public Vec3 divide(final Vec3 anotherVec3) {
		return new Vec3(x / anotherVec3.x,
						y / anotherVec3.y,
						z / anotherVec3.z);
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
	public Vec3 divide(final int value) {
		return divide(new Vec3(value));
	}
	
	/**
	 * @return
	 * {@code Half} of every value of this {@code vector}
	 */
	public Vec3 half() {
		return new Vec3( x >> 1, y >> 1, z >> 1 );
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
	public final int slope() {
		return y / x;
	}
	
	/**
	 * Sets this' {@code x}, {@code y} and {@code z} value
	 * 
	 * @param newValue
	 * - {@code Vector 3D} that contains the new value
	 * 
	 * @return
	 * {@code this} vector
	 */
	public Vec3 set(final Vec3 newValue) {
		x = newValue.x;
		y = newValue.y;
		z = newValue.z;
		
		return this;
	}
	
	@Override
	public Vec3 clone() {
		return new Vec3(x, y, z);
	}
	
	@Override
	public String toString() {
		return "[x  : " + x + ", y : " + y + ", z  : " + z + "]";
	}
	
	/**
	 * @return
	 * - {@code 3D matrix} representation of this {@code vector}
	 */
	public Matrix toMatrix3D() {
		// 3D matrix
		final Matrix matrix = new Matrix(3);
		
		matrix.set(0, 0, x);
		matrix.set(1, 1, y);
		matrix.set(2, 2, z);
		
		return matrix;
	}
	
	/**
	 * @return
	 * - {@code 4D matrix} representation of this {@code vector}
	 */
	public Matrix toMatrix4D() {
		// 4D matrix
		final Matrix matrix = new Matrix(4);
		
		matrix.set(0, 0, x);
		matrix.set(1, 1, y);
		matrix.set(2, 2, z);
		matrix.set(3, 3, 1); // w
		
		return matrix;
	}
	
	/**
	 * @return
	 * {@code Vector 4D} equivalence of this {@code vector} containing
	 * this' {@code x, y} and {@code z} components having {@code w} set to 1.0F
	 */
	public Vec4F toVector4DFloat() {
		return new Vec4F(x, y, z, 1.0F);
	}
	
	/**
	 * @return
	 * {@code Vector 3D Float} with this' {@code x}, {@code y} and {@code z} value
	 */
	public Vec3F toVector3DF() {
		return new Vec3F(x, y, z);
	}
	
	/**
	 * Returns whether {@code this} and {@code another Vector 3D} has the same {@code x}, {@code y} and {@code z} value
	 * 
	 * @param anotherVec3
	 * - Another Vector 3D to examine
	 * 
	 * @return
	 * {@code true} if values are equal; {@code false} otherwise
	 */
	public boolean equals(final Vec3 anotherVec3) {
		return x == anotherVec3.x && y == anotherVec3.y && z == anotherVec3.z;
	}
	
	/**
	 * @return
	 * {@code true} if values are zero; {@code false} otherwise
	 */
	public boolean isZero() {
		return x == 0 && y == 0 && z == 0;
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
	
	/**
	 * @return
	 * {@code z} value
	 */
	public int getZ() {
		return z;
	}
	
	/**
	 * Sets new {@code z} value
	 * 
	 * @param z
	 * - new Value for {@code z}
	 */
	public void setZ(int z) {
		this.z = z;
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
	public static final void swapVector(final Vec3 vector1, final Vec3 vector2) {
		final Vec3 storedVector1 = vector1.clone();
		
		vector1.set( vector2 );
		vector2.set( storedVector1 );
	}
}