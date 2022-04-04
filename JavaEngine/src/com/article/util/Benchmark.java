package com.article.util;

/**
 * {@code Benchmark} class helps to measure code or
 * algorithm performance by {@code subtracting} starting nanoTime
 * and the current nanoTime... code / algorithm to be measured must
 * be placed between {@code Benchmark} object initialization and
 * {@link #end()}
 * 
 * @version 1.0
 * @since WIP 1.6
 */
public class Benchmark {
	protected long startBenchMarkTime;
	
	/**
	 * Offsets the starting benchmark time by a given
	 * {@code nanoseconds}
	 * 
	 * @param nanoSecondOffset
	 * - Offset value of {@code nanoSecond}
	 */
	public Benchmark(final long nanoSecondOffset) {
		startBenchMarkTime = System.nanoTime() + nanoSecondOffset;
	}
	
	/**
	 * Creates a new {@code Benchmark} object to measure code
	 * performance, instead of off-setting the {@code nanoTime} by
	 * a value... this just sets {@code starting benchmark time} to
	 * {@code System.nanoTime()}
	 */
	public Benchmark() {
		startBenchMarkTime = System.nanoTime();
	}
	
	/**
	 * Subtracts {@code starting benchmark time} to current
	 * System {@code nanoTime}
	 * 
	 * @return
	 * - {@code Total} code duration
	 */
	public long end() {
		return System.nanoTime() - startBenchMarkTime;
	}
	
	/**
	 * Subtracts {@code nanoTime} to {@code starting benchmark time} of each
	 * Benchmark objects, the two differences will then be subtracted...
	 * <br>
	 * This will return a {@code positive} number if <strong>the code</strong> is slower than
	 * the other one; {@code negative} will be the opposite
	 * 
	 * @param anotherBenchmarkingObject
	 * - {@code Benchmark} to be compared with
	 * 
	 * @return
	 * - {@code Subtracted} output
	 */
	public long compare(final Benchmark anotherBenchmarkingObject) {
		final long currentNanoTime = System.nanoTime();
		
		return (currentNanoTime - startBenchMarkTime) - (currentNanoTime - anotherBenchmarkingObject.startBenchMarkTime);
	}
}