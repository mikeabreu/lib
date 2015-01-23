import java.util.Scanner;


/**
 * Class PlayerMain:
 * 
 * Program to test class Player
 */
class PlayerMain {
	/**
	 * Main Method
	 */
	public static void main(String[] args) {
		
		/**
		 * Declare Variables
		 */
		
		// Declarations of variables
		Scanner reader = new Scanner(System.in);
		int result;
		int wins1 = 0; // Player 1's Win Count
		int wins2 = 0; // Player 2's Win Count.
		boolean testRun = false; // If true, program will hard code dice for
									// testing
		boolean keepPlaying = false; // If true, program will continue to play
		boolean gameSetup = false; // Sets up players
		String progRun, playing;

		// Declarations of objects
		Player ply1 = new Player();
		Player ply2 = new Player();

		/**
		 * Prompt for which loop to run
		 */
		
		System.out
				.println("Would you like to play Zanzi or Test the program? 'play' or 'test': ");
		progRun = reader.nextLine();
		if (progRun.equalsIgnoreCase("play")) {
			testRun = false;
			keepPlaying = true;
		} else if (progRun.equalsIgnoreCase("test")) {
			testRun = true;
			keepPlaying = false;
		}

		/**
		 * Test Program Loop
		 */
		
		if (testRun) {
			/**
			 * Section 1
			 */

			// Hard Code values for player 1 and 2
			ply1.setDiceValues(3, 2, 3);
			ply2.setDiceValues(1, 1, 1);

			// Output each players dice
			ply1.displayStats(1);
			ply2.displayStats(2);

			// Calculate and output the winner
			result = ply1.evalplay(ply2);
			if (result == 1)
				System.out.println("Winner is player one! \n");
			else if (result == 2)
				System.out.println("Winner is player two! \n");
			else
				System.out.println("Tie Game! ");

			/**
			 * Section 2
			 */

			// Hard Code values for player 1 and 2
			ply1.setDiceValues(4, 4, 4);
			ply2.setDiceValues(5, 5, 5);

			// Output each players dice
			ply1.displayStats(1);
			ply2.displayStats(2);

			// Calculate and output the winner
			result = ply1.evalplay(ply2);
			if (result == 1)
				System.out.println("Winner is player one! \n");
			else if (result == 2)
				System.out.println("Winner is player two! \n");
			else
				System.out.println("Tie Game! ");

			/**
			 * Section 3
			 */

			// Hard Code values for player 1 and 2
			ply1.setDiceValues(4, 1, 3);
			ply2.setDiceValues(3, 1, 4);

			// Output each players dice
			ply1.displayStats(1);
			ply2.displayStats(2);

			// Calculate and output the winner
			result = ply1.evalplay(ply2);
			if (result == 1)
				System.out.println("Winner is player one! \n");
			else if (result == 2)
				System.out.println("Winner is player two! \n");
			else
				System.out.println("Tie Game! ");

			/**
			 * Section 4
			 */

			// Hard Code values for player 1 and 2
			ply1.setDiceValues(4, 5, 6);
			ply2.setDiceValues(2, 2, 1);

			// Output each players dice
			ply1.displayStats(1);
			ply2.displayStats(2);

			// Calculate and output the winner
			result = ply1.evalplay(ply2);
			if (result == 1)
				System.out.println("Winner is player one! \n");
			else if (result == 2)
				System.out.println("Winner is player two! \n");
			else
				System.out.println("Tie Game! ");

		}

		/**
		 * Main Game Loop
		 */

		while (keepPlaying) {
			
			/**
			 * Game Setup
			 */
			
			if (gameSetup == false) {
				System.out.println("\nWelcome to the game of Zanzi!");
				System.out
						.println("How to Play: Each player get 3 dice. There are 2 rounds (rolls) per player."
								+ "\n\tPlayer one begins by looking at his 3 dice. Round 1 will ask him how many and which dice to re-roll, if any."
								+ "\n\tHis dice are displayed again and then he begins Rounds 2 where he may re-roll again."
								+ "\n\tPlayer two does the same. The score is evaluated and the highest score wins."
								+ "\nScoring: Zanzi is 3 of a kind (I.E. 1,1,1). The lower the Zanzi the higher the score."
								+ "\n\tThe only two special numbers are 2 and 3. 2 is equal to 200 points and 3 is equal to 30 points."
								+ "\n\tAll other dice rolls are just the face value of the dice. (I.E. 4 = 4 points.)");

				System.out.println("\nWhat is your name player one: ");
				ply1.setName(reader.nextLine());

				System.out.println("\nWhat is your name player two: ");
				ply2.setName(reader.nextLine());

				gameSetup = true;
			}

			// Randomize dice for next game
			ply1.rollDie(4);
			ply2.rollDie(4);
			
			/**
			 * Player One Section
			 */
			
			// Output player one stats
			ply1.displayStats(0);

			// Prompt round one
			ply1.promptRoll();

			// Output player one stats
			ply1.displayStats(0);

			// Prompt round two
			ply1.promptRoll();
			
			// Output player one stats
			ply1.displayStats(0);

			/**
			 * Player Two Section
			 */
			
			// Output player two stats
			ply2.displayStats(0);

			// Prompt round one
			ply2.promptRoll();

			// Output player two stats
			ply2.displayStats(0);

			// Prompt round two
			ply2.promptRoll();

			/**
			 * Result Section
			 */
			
			// Display Both Players Stats
			ply1.displayStats(0);
			ply2.displayStats(0);

			// Calculate and output the winner
			result = ply1.evalplay(ply2);
			if (result == 1) {
				System.out.println("\nWinner is, " + ply1.getName() + "!\n");
				wins1 = wins1 + 1;
			} else if (result == 2) {
				System.out.println("\nWinner is, " + ply2.getName() + "!\n");
				wins2 = wins2 + 1;
			} else
				System.out.println("Tie Game! ");

			/**
			 * Exit Loop
			 */
			
			// Exit Loop Prompt
			System.out.println("\nDo you wish to continue playing? 'y' 'n': ");
			playing = reader.nextLine();
			if (playing.equalsIgnoreCase("n"))
				keepPlaying = false;

			if (!keepPlaying) {
				if (wins1 > wins2) {
					System.out.println("\nThe winner of the day is, "
							+ ply1.getName());
					System.out.println("\t" + ply1.getName() + ": " + wins1);
					System.out.println("\t" + ply2.getName() + ": " + wins2);
				} else if (wins2 > wins1) {
					System.out.println("\nThe winner of the day is, "
							+ ply2.getName());
					System.out.println("\t" + ply1.getName() + ": " + wins1);
					System.out.println("\t" + ply2.getName() + ": " + wins2);
				}

				System.out.println("\nThank you for playing my game of Zanzi!"
						+ "\nCode Written by: Michael Abreu");
			}
		}

		reader.close();
	}
}
