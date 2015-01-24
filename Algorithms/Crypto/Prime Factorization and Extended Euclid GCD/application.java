package assignment1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *  Assignment #1
 *
 * Created by Michael Abreu on 1/6/2015.
 */
public class Application {

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input, input2, output2;
        BigInteger input3, input4;
        long[] xy = new long[2];
        BigInteger[] xy2 = new BigInteger[2];
        BigInteger bigInput, bigInput2;
        boolean loop = true;
        String factors;

        System.out.print("Testing Problem 1a--primeFactorization:\n\n");
        while (loop) {
            // Sample Output Code:  Prime Factorization
            System.out.print("\nEnter a long integer: ");
            input = sc.nextLong();
            factors = primeFactorization(input);
            if (factors == null)
                loop = false;
            else
                System.out.println(factors);
        }

        loop = true;

        System.out.print("\nTesting Problem 1b--extendedEuclidGCD:\n\n");
        while (loop) {
            // Sample Output Code:  Prime Factorization
            System.out.print("\nEnter a: ");
            input = sc.nextLong();
            System.out.print("Enter b: ");
            input2 = sc.nextLong();
            long gcd = extendedEuclidGCD(input, input2, xy);
            if (gcd == 0)
                loop = false;
            else
                System.out.println("\ngcd(" + input + ", " + input2 + ") = " + gcd + ", and " + gcd + " = (" + xy[0] + ")(" + input + ") + (" + xy[1] + ")(" + input2 + ").");
        }

        loop = true;

        System.out.print("\nTesting Problem 1c--BigInteger Euclid GCD:\n\n");
        while (loop) {
            // Sample Output Code:  Prime Factorization
            System.out.print("\nEnter a: ");
            input3 = sc.nextBigInteger();
            System.out.print("Enter b: ");
            input4 = sc.nextBigInteger();
            BigInteger gcd2 = extendedEuclidGCD(input3, input4, xy2);
            if (gcd2 == BigInteger.ZERO)
                loop = false;
            else
                System.out.println("\ngcd(" + input3 + ", " + input4 + ") = " + gcd2 + ", and " + gcd2 + " = (" + xy2[0] + ")(" + input3 + ") + (" + xy2[1] + ")(" + input4 + ").");
        }

        sc.close();
    }

    /*
        Prime Factorization
     */
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
            toStr = "The number, " +n+ ", is prime.";
        }
        LocalTime time2 = LocalTime.now();
        Duration totalTime = Duration.between(time1, time2);
        toStr += "\nTotal Time Elapsed: " + totalTime.toString().substring(2, (totalTime.toString().length() - 1)) + " seconds\n";
        return toStr;
    }

    /*
        Extended Euclid GCD     (long)
     */
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
        // if b is greater than a, switch them and add a negative sign at the end.
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

        for(int k=1; k <= max; k++) {
            if (r[k] == 0) {
                gcd = r[k-1];
                xy[0] = x[k-1];
                xy[1] = y[k-1];
                break;
            }
            r[k+1] = r[k-1] % r[k];
            q[k] = quotient(r[k-1], r[k]);
            x[k+1] = x[k-1] - (x[k] * q[k]);
            y[k+1] = y[k-1] - (y[k] * q[k]);
        }

        if (switched) {
            long temp = xy[0];
            xy[0] = xy[1];
            xy[1] = temp;
        }

        return gcd;
    }

    /*
        Extended Euclid GCD     (BigInteger)
     */
    public static BigInteger extendedEuclidGCD(BigInteger a, BigInteger b, BigInteger[] xy) {
        if (a.compareTo(BigInteger.ZERO) == 0 || b.compareTo(BigInteger.ZERO) == 0) {
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
        // if b is greater than a, switch them and add a negative sign at the end.
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

        for(int k=1; k <= max; k++) {
            if (r[k].compareTo(BigInteger.ZERO) == 0) {
                gcd = r[k-1];
                xy[0] = x[k-1];
                xy[1] = y[k-1];
                break;
            }
            r[k+1] = r[k-1].mod(r[k]);
            q[k] = quotient(r[k-1], r[k]);
            x[k+1] = x[k-1].subtract(x[k].multiply(q[k]));
            y[k+1] = y[k-1].subtract(y[k].multiply(q[k]));
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
