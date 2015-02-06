package abreuit.algorithms.crypto;

import java.math.BigInteger;

/**
 * Extended Euclid GCD (two versions, long and BigInteger)
 *
 * Created by Michael Abreu on 1/6/2015.
 */
public class ExtendedEuclid {
	
	public static long extendedEuclidGCD(long a, long b, long[] xy) {
		long gcd = 0;
		if (a == 0 || b == 0) {
			return 0;
		}
		// Set the max iteration and size of arrays
		int max;
		if (a > b) {
			max = (int) Math.ceil(Math.log(a)) * 2;
		} else {
			max = (int) Math.ceil(Math.log(b)) * 2;
		}
		if (max <= 5) {
			max = 5;
		}
		long[] r = new long[max], q = new long[max], x = new long[max], y = new long[max];

		boolean switched = false;
		// Setup the array with the right numbers.
		// if b is greater than a, switch them and add a negative sign at the
		// end.
		if (b > a) {
			r[0] = b;
			r[1] = a;
			switched = true;
		} else {
			r[0] = a;
			r[1] = b;
		}
		x[0] = 1;
		x[1] = 0;
		y[0] = 0;
		y[1] = 1;

		for (int k = 1; k <= max; k++) {
			if (r[k] == 0) {
				gcd = r[k - 1];
				xy[0] = x[k - 1];
				xy[1] = y[k - 1];
				break;
			}
			r[k + 1] = r[k - 1] % r[k];
			q[k] = quotient(r[k - 1], r[k]);
			x[k + 1] = x[k - 1] - (x[k] * q[k]);
			y[k + 1] = y[k - 1] - (y[k] * q[k]);
		}

		if (switched) {
			long temp = xy[0];
			xy[0] = xy[1];
			xy[1] = temp;
		}

		return gcd;
	}

	/*
	 * Extended Euclid GCD (BigInteger)
	 */
	public static BigInteger extendedEuclidGCD(BigInteger a, BigInteger b,
			BigInteger[] xy) {
		if (a.compareTo(BigInteger.ZERO) == 0
				|| b.compareTo(BigInteger.ZERO) == 0) {
			return BigInteger.ZERO;
		}
		BigInteger gcd = new BigInteger("0");

		// Set the max iteration and size of arrays
		int max = 5;
		if (a.compareTo(b) == 1) {
			max = (int) Math.ceil(Math.log(a.doubleValue())) * 2;
		} else if (a.compareTo(b) == -1) {
			max = (int) Math.ceil(Math.log(b.doubleValue())) * 2;
		}
		if (max <= 5) {
			max = 5;
		}
		BigInteger[] r = new BigInteger[max], q = new BigInteger[max], x = new BigInteger[max], y = new BigInteger[max];

		boolean switched = false;
		// Setup the array with the right numbers.
		// if b is greater than a, switch them and add a negative sign at the
		// end.
		if (a.compareTo(b) == -1) {
			r[0] = b;
			r[1] = a;
			switched = true;
		} else {
			r[0] = a;
			r[1] = b;
		}
		x[0] = BigInteger.ONE;
		x[1] = BigInteger.ZERO;
		y[0] = BigInteger.ZERO;
		y[1] = BigInteger.ONE;

		for (int k = 1; k <= max; k++) {
			if (r[k].compareTo(BigInteger.ZERO) == 0) {
				gcd = r[k - 1];
				xy[0] = x[k - 1];
				xy[1] = y[k - 1];
				break;
			}
			r[k + 1] = r[k - 1].mod(r[k]);
			q[k] = quotient(r[k - 1], r[k]);
			x[k + 1] = x[k - 1].subtract(x[k].multiply(q[k]));
			y[k + 1] = y[k - 1].subtract(y[k].multiply(q[k]));
		}

		if (switched) {
			BigInteger temp = xy[0];
			xy[0] = xy[1];
			xy[1] = temp;
		}

		return gcd;
	}

	// Quotient function (long)
	public static int quotient(long a, long b) {
		if (b == 0 || a == 0) {
			return 0;
		}
		int quotient = (int) (a / b);
		return quotient;
	}

	// Quotient function (BigInteger)
	public static BigInteger quotient(BigInteger a, BigInteger b) {
		if (b == BigInteger.ZERO || a == BigInteger.ZERO) {
			return BigInteger.ZERO;
		}
		BigInteger quotient = (a.divide(b));
		return quotient;
	}
}
