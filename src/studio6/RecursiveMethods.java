package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {

		// FIXME compute the geometric sum for the first n terms recursively

		if (n==0) {
			return 0;
		}

		return 1 / Math.pow(2, n) +geometricSum(n-1);		
	}



	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {

		// FIXME

		double bound = 5.0;
		StdDraw.setXscale(-bound, bound);
		StdDraw.setYscale(-bound, bound);

		if (radius < radiusMinimumDrawingThreshold) {
			return;		
			}

		StdDraw.circle(xCenter, yCenter, radius); // original circle

		circlesUponCircles(xCenter+radius,yCenter,radius/3.0,radiusMinimumDrawingThreshold);
		circlesUponCircles(xCenter-radius,yCenter,radius/3.0,radiusMinimumDrawingThreshold);
		circlesUponCircles(xCenter,yCenter+radius,radius/3.0,radiusMinimumDrawingThreshold);
		circlesUponCircles(xCenter,yCenter-radius,radius/3.0,radiusMinimumDrawingThreshold);

	}

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		int[] reversed = new int[array.length];  // Create a new array for the reversed result
		reverseHelper(array, reversed, 0, array.length - 1);
		return reversed;
	}

	// Recursive helper method to reverse the array
	private static void reverseHelper(int[] array, int[] reversed, int start, int end) {
		// Base case: when start index crosses end index, stop recursion
		if (start > end) {
			return;
		}

		// Swap elements
		reversed[start] = array[end];
		reversed[end] = array[start];

		// Recursive call with updated indices (moving towards the center)
		reverseHelper(array, reversed, start + 1, end - 1);
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {

		// FIXME compute the gcd of p and q using recursion

		if (q==0) {
			return p;
		}
		return gcd(q, p%q);


	}

}
