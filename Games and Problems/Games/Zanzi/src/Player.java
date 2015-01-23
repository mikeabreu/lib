/**
 * Class Player:
 *
 * Zanzi game
 */
import java.util.Random;
import java.util.Scanner;

class Player {
	/**
	 * Attributes
	 */
	// player is an array donating the value of the dice roll
	// winner store which player is the winner
	// need random variable
	private int[] player = new int[3];
	private String name;
	private int num;
	private Scanner input = new Scanner(System.in);
	private Random randomObject = new Random();

	/**
	 * Constructor (could be one of more)
	 */
	Player() {
		this.name = "player x";
		int i;
		for (i = 0; i < 3; i = i + 1)
			rollDie(i);

	}

	Player(String newName) {
		this.name = newName;
		int i;
		for (i = 0; i < 3; i = i + 1)
			rollDie(i);

	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void rollDie(int index) {
		if (index < 4 && index >= 0) {
			// generate random die value
			player[index] = 1 + randomObject.nextInt(6);
		}
		else if (index == 4) {
			player[0] = 1 + randomObject.nextInt(6);
			player[1] = 1 + randomObject.nextInt(6);
			player[2] = 1 + randomObject.nextInt(6);
		}
		else
			System.out.println("Error Index Out of Reach!");
	}

	/**
	 * Set attributes
	 */
	public void setDiceValues(int num1, int num2, int num3) {
		player[0] = num1;
		player[1] = num2;
		player[2] = num3;
	}

	/**
	 * Compute winner
	 */
	public int evalplay(Player player2) {

		int total1 = this.computepoints();
		int total2 = player2.computepoints();
		int winner = 0;

		if (total1 > total2) {
			winner = 1;
			return (winner);
		} else if (total2 > total1) {
			winner = 2;
			return (winner);
		} else {
			winner = 0;
			return (winner);
		}

	}

	/**
	 * Calculate points
	 */
	public int computepoints() {

		int i; // Loop Control Variable
		int numtwo, numthree;
		int points;

		i = 1;
		numtwo = 0;
		numthree = 0;
		points = 0;

		if ((this.getDie(0) == this.getDie(1))
				&& (this.getDie(0) == this.getDie(2))) {
			switch (this.getDie(0)) {
			case 1: {
				points = 1000;
				break;
			}
			case 2: {
				points = 990;
				break;
			}
			case 3: {
				points = 980;
				break;
			}
			case 4: {
				points = 970;
				break;
			}
			case 5: {
				points = 960;
				break;
			}
			case 6: {
				points = 950;
				break;
			}
			}
		} else {
			while (i < 4) {
				if (this.getDie(i - 1) == 2)
					numtwo = numtwo + 1;
				else if (this.getDie(i - 1) == 3)
					numthree = numthree + 1;
				else
					points = points + this.getDie(i - 1);
				i = i + 1;
			}
			points = points + (numtwo * 200) + (numthree * 30);
		}

		return (points);
	}

	/**
	 * Get die
	 * 
	 * @param dice
	 *            value
	 */
	public int getDie(int index) {
		return (player[index]);
	}

	/**
	 * Get name
	 * 
	 * @return player name
	 */
	public String getName() {
		return (this.name);
	}

	public void promptRoll() {
		num = 0;

		System.out.println("Enter How Many Dice to Roll: ");
		num = input.nextInt();

		if (num == 1) {
			System.out.println("Enter the die # to roll: ");
			num = input.nextInt();
			rollDie(num - 1);
		} else if (num == 2) {
			System.out.println("Enter the 1st die # to roll: ");
			num = input.nextInt();
			rollDie(num - 1);
			System.out.println("Enter the 2nd die # to roll: ");
			num = input.nextInt();
			rollDie(num - 1);
		} else if (num == 3) {
			rollDie(4);

		}

	}

	public void displayStats(int index) {
		if (index == 0) {
			System.out.println();
			System.out.println("Player: " + getName());
			System.out.println("Dice #1: " + getDie(0));
			System.out.println("Dice #2: " + getDie(1));
			System.out.println("Dice #3: " + getDie(2));
			System.out.println();
			System.out.println("Score: " + computepoints());
			System.out.println();
		} else if (index == 1) {
			System.out.println();
			System.out.println("Player One");
			System.out.println("Dice #1: " + getDie(0));
			System.out.println("Dice #2: " + getDie(1));
			System.out.println("Dice #3: " + getDie(2));
			System.out.println();
			System.out.println("Score: " + computepoints());
			System.out.println();
		} else if (index == 2) {
			System.out.println();
			System.out.println("Player Two");
			System.out.println("Dice #1: " + getDie(0));
			System.out.println("Dice #2: " + getDie(1));
			System.out.println("Dice #3: " + getDie(2));
			System.out.println();
			System.out.println("Score: " + computepoints());
			System.out.println();
		}
	}

}
