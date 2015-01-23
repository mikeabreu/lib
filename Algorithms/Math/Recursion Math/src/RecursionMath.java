import java.io.BufferedReader;
import java.io.InputStreamReader;

class Recursion {

	Recursion() {

	}

	public static int factorial(int n) {
		if (n > 0) {
			if (n == 1)
				return 1;
			else
				return (n * factorial(n - 1));
		} else
			return -1;
	}
	
	public static int sumation(int n) {
		if (n > 0) {
			if (n == 1)
				return 1;
			else
				return (n + sumation(n - 1));
		} else
			return -1;
	}
	
	public static int biPower(int n) {
		if (n > 0) {
			if (n == 1)
				return 1;
			else
				return (2 * biPower(n - 1));
		} else
			return -1;
	}
	
	public static int timesFive(int n) {
		if (n > 0) {
			if (n == 1)
				return 1;
			else
				return (5 + timesFive(n - 1));
		} else
			return -1;
	}
	
	public static int puzzle(int base, int limit) {
		if (base > limit) {
			return -1;
		} else {
			if (base == limit)
				return 1;
			else
				return base * puzzle(base + 1, limit);
		}
	}
	
	// Returns number of digits in the number n
	public static int recur(int n) {
		if (n < 0) {
			return -1;
		} else if (n < 10) {
			return 1;
		} else
				return (1 + recur(n /10));
	}
	
	// Returns number of digits in the number n
		public static int recur2(int n) {
			if (n < 0) {
				return -1;
			} else if (n < 10) {
				return 1;
			} else
					return ((n % 10) + recur2(n /10));
		}
}

public class RecursionMath {
	public static void main(String args[]) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;

		System.out.println("Enter a number: ");
		try {
			num = Integer.parseInt(in.readLine());

			num = Recursion.sumation(num);

			System.out.println(num);
		} catch (Exception e) {
			System.out.println("Sorry invalid number.");
		}

		
	}
}