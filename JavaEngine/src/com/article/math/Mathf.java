package com.article.math;

public final class Mathf {
	private Mathf() {}
	
	/**
	 * Checks whether {@code value} is {@code greater than} maximum value or
	 * {@code less than} minimum value
	 * 
	 * @param minimumValue
	 * - Minimum value for {@code value} given
	 * 
	 * @param maximumValue
	 * - Maximum value for {@code value} given
	 * 
	 * @param value
	 * - Value to {@code examine}
	 * 
	 * @return
	 * {@code value} if it is somewhere in the middle
	 */
	public static int lock(final int minimumValue, final int maximumValue, final int value) {
		return value > maximumValue ? maximumValue : (value < minimumValue ? minimumValue : value);
	}
	
	/**
	 * Checks whether {@code value} is {@code greater than} maximum value or
	 * {@code less than} minimum value
	 * 
	 * @param minimumValue
	 * - Minimum value for {@code value} given
	 * 
	 * @param maximumValue
	 * - Maximum value for {@code value} given
	 * 
	 * @param value
	 * - Value to {@code examine}
	 * 
	 * @return
	 * {@code value} if it is somewhere in the middle
	 */
	public static float lock(final float minimumValue, final float maximumValue, final float value) {
		return value > maximumValue ? maximumValue : (value < minimumValue ? minimumValue : value);
	}
	
	/**
	 * Checks whether {@code value} is {@code greater than} maximum value or
	 * {@code less than} minimum value
	 * 
	 * @param minimumValue
	 * - Minimum value for {@code value} given
	 * 
	 * @param maximumValue
	 * - Maximum value for {@code value} given
	 * 
	 * @param value
	 * - Value to {@code examine}
	 * 
	 * @return
	 * {@code value} if it is somewhere in the middle
	 */
	public static double lock(final double minimumValue, final double maximumValue, final double value) {
		return value > maximumValue ? maximumValue : (value < minimumValue ? minimumValue : value);
	}
	
	/**
	 * <strong>LERP</strong> {@code [Linear Interpolation]}
	 * <br>
	 * <br>
	 * Returns a {@code float} based on the values given
	 * <hr>
	 * <em>FORMULA:</em> <br>
	 * <p style="font-size: 1.5em">	Start + Percentage * (End - Start) </p>
	 * This returns a value between {@code START} and {@code END} if {@code PERCENTAGE}
	 * is between {@code 0} and {@code 1}
	 * 
	 * @param start
	 * - Beginning {@code number}
	 * 
	 * @param end
	 * - Ending {@code number}
	 * 
	 * @param percentage
	 * - {@code LERP} percentage
	 * 
	 * @return
	 * - {@code Output} value
	 * 
	 * @since WIP 1.2
	 */
	public static float lerp(final float start, final float end, final float percentage) {
		return start + percentage * (end - start);
	}
	
	/**
	 * <strong>LERP</strong> {@code [Linear Interpolation]}
	 * <br>
	 * <br>
	 * Returns a {@code double} based on the values given
	 * <hr>
	 * <em>FORMULA:</em> <br>
	 * <p style="font-size: 1.5em">	Start + Percentage * (End - Start) </p>
	 * This returns a value between {@code START} and {@code END} if {@code PERCENTAGE}
	 * is between {@code 0} and {@code 1}
	 * 
	 * @param start
	 * - Beginning {@code number}
	 * 
	 * @param end
	 * - Ending {@code number}
	 * 
	 * @param percentage
	 * - {@code LERP} percentage
	 * 
	 * @return
	 * - {@code Output} value
	 * 
	 * @since WIP 1.2
	 */
	public static double lerp(final double start, final double end, final double percentage) {
		return start + percentage * (end - start);
	}
	
	/**
	 * Perform {@code matrix multiplication} between two matrices
	 * 
	 * @param matrix1
	 * - {@code Matrix} to multiply
	 * 
	 * @param matrix2
	 * - {@code Matrix} to multiply
	 * 
	 * @return
	 * {@code Output} if operation is successful; {@code null} if not
	 */
	public static Matrix multiplyMatrix(final Matrix matrix1, final Matrix matrix2) {
		// Invalid size
		if(matrix1.size() != matrix2.size()) return null;
		
		// Size of the matrix
		final int size = matrix1.size();
		
		// Matrix to return
		final Matrix outputMatrix = new Matrix(size);
		
		// Perform Matrix multiplication
		for(int i = 0; i < size; i++)   
			for(int j = 0; j < size; j++)
				for(int k = 0; k < size; k++)  
					outputMatrix.set(i, j, outputMatrix.get(i, j) + matrix1.get(i, k) * matrix2.get(k, j));
		
		return outputMatrix;
	}
	
	/**
	 * Fast Inverse Square root - <strong>Java implementation of</strong> {@code Q_rsqrt()}
	 * <hr>
	 * This method returns the {@code inverse} of the square root of a number
	 * <p style="font-size: 2em">1 / squareRootOf->X</p>
	 * 
	 * @param number
	 * - Number to get the {@code inverse square root} of
	 * 
	 * @return
	 * - Inverse square root of the given {@code number}
	 */
	public static float fastInverseSqrt(float number) {
		// Evil floating point bit level hacking
	    int i = Float.floatToIntBits(number);
	    
	    // What the
	    i = 0x5f3759df - (i >> 1);
	    number = Float.intBitsToFloat(i);
	    
	    // 1st iteration
	    number *= (1.5f - (number * 0.5F) * number * number);
	    return number;
	}
}