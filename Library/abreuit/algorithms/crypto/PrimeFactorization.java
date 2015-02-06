package abreuit.algorithms.crypto;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Prime Factorization
 *
 * Created by Michael Abreu on 1/6/2015.
 */
public class PrimeFactorization {
	
	public static String primeFactorization(long n) {
		if (n <= 1) {
			return null;
		}
		String toStr = "The prime factorization of:\t" + n + " is ";
		long primefactor = 2, numfreq = 0, max = (long) Math.sqrt(n) * 2;
		LocalTime time1 = LocalTime.now();

		for (long i = 2; i <= n; i++) {
			if (i <= 1 || i >= max) {
				break;
			}
			if (primefactor != i) {
				if (numfreq > 0) {
					toStr += "(" + primefactor + "^" + numfreq + ")";
					numfreq = 0;
				}
				primefactor = i;
			}
			if (n % i == 0) {
				numfreq++;
				n /= i;
				primefactor = i;
				i--;
			}
		}
		if (numfreq > 0) {
			toStr += "(" + primefactor + "^" + numfreq + ")";
		}
		if (toStr.equals("The prime factorization of:\t" + n + " is ")) {
			toStr = "The number, " + n + ", is prime.";
		}
		LocalTime time2 = LocalTime.now();
		Duration totalTime = Duration.between(time1, time2);
		toStr += "\nTotal Time Elapsed: "
				+ totalTime.toString().substring(2,
						(totalTime.toString().length() - 1)) + " seconds\n";
		return toStr;
	}

}
