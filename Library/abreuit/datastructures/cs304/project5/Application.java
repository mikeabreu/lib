package abreuit.datastructures.cs304.project5;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import abreuit.datastructures.cs304.project5.QueueUnderflowException;

public class Application {
	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) throws IOException,
			QueueUnderflowException {
		// Instance Variables
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String loadFileResult = "";
		String filename = null;
		String target, operation, order;

		BinarySearchTree<SportsTeam> league = null;
		SportsTeam targetTeam = new SportsTeam();

		boolean keepGoing = true;
		int treeSize;

		// Description of Program.
		System.out.println("Welcome to my Sports League Maker!\n");
		System.out
				.println("This program will keep track of sports teams and their ranks.");
		System.out
				.println("You will have the ability to add/remove teams, "
						+ "view the teams in the league,\nand change the rank of a team. "
						+ "Lets get started!\n");

		// Prompt for loading of ADT
		System.out
				.println("Would you like to load your league from a file? yes or no: ");
		try {
			loadFileResult = in.readLine();

			if (loadFileResult.equalsIgnoreCase("yes")) {
				System.out.println("Enter the name of the file: ");
				filename = in.readLine();
				ObjectInputStream objIn = new ObjectInputStream(
						new FileInputStream(filename));
				league = (BinarySearchTree<SportsTeam>) objIn.readObject();
				objIn.close();
			} else {
				System.out.println("Starting a new league.");
				league = new BinarySearchTree<SportsTeam>();
			}
		} catch (Exception e) {
			System.out
					.println("File was not loaded succesfully.\nStarting a new league.");
		}

		// Main Loop of Program
		while (keepGoing) {
			System.out.println("\nChoose an operation:");
			System.out.println("1: Add a team");
			System.out.println("2: Remove a team");
			System.out.println("3: Display the teams (traversal order)");
			System.out.println("4: Number of teams");
			System.out.println("5: Search for a team");
			System.out.println("6: Save and Quit");
			System.out.println("7: Quit\n");
			System.out.print("Enter choice: ");
			operation = in.readLine();

			switch (operation) {

			case "1": // add a team
				System.out.print("Enter team name to add: ");
				target = in.readLine();
				SportsTeam element = new SportsTeam(target);
				league.add(element);
				break;

			case "2": // remove a team
				System.out.print("Enter a team name to remove: ");
				target = in.readLine();
				targetTeam.setName(target);
				try {
					if (league.remove(targetTeam))
						System.out.println(target
								+ " was removed from the league.");
					else
						System.out.println("Sorry " + target
								+ " is not a team in this league.");
				} catch (NullPointerException e) {
					System.out.println("There are no teams in your league.");
				}
				break;

			case "3": // print tree
				System.out.println("Choose a traversal order:");
				System.out.println("1: Preorder");
				System.out.println("2: Inorder (Alphabetically");
				System.out.println("3: Postorder");
				System.out.print("> ");
				order = in.readLine();

				switch (order) {
				case "1": // Preorder
					try {
						treeSize = league.reset(BinarySearchTree.PREORDER);
						if (treeSize == 0) {
							System.out
									.println("There are no teams in your league.");
							break;
						}
						System.out.println("The tree in Preorder is:");
						for (int count = 1; count <= treeSize; count++) {
							element = league.getNext(BinarySearchTree.PREORDER);
							System.out.println(element);
						}
					} catch (NullPointerException e) {
						System.out
								.println("There are no teams in your league.");
					}
					break;

				case "2": // Inorder
					try {
						treeSize = league.reset(BinarySearchTree.INORDER);
						if (treeSize == 0) {
							System.out
									.println("There are no teams in your league.");
							break;
						}
						System.out.println("The tree in Inorder is:");
						for (int count = 1; count <= treeSize; count++) {
							element = league.getNext(BinarySearchTree.INORDER);
							System.out.println(element);
						}
					} catch (NullPointerException e) {
						System.out
								.println("There are no teams in your league.");
					}
					break;

				case "3": // Postorder
					try {
						treeSize = league.reset(BinarySearchTree.POSTORDER);
						if (treeSize == 0) {
							System.out
									.println("There are no teams in your league.");
							break;
						}
						System.out.println("The tree in Postorder is:");
						for (int count = 1; count <= treeSize; count++) {
							element = league
									.getNext(BinarySearchTree.POSTORDER);
							System.out.println(element);
						}
					} catch (NullPointerException e) {
						System.out
								.println("There are no teams in your league.");
					}
					break;

				default:
					System.out
							.println("Error in order choice. Terminating test.");
					return;
				}
				break;

			case "4": // size of league
				try {
					System.out.println("Number of teams: " + league.size());
				} catch (NullPointerException e) {
					System.out.println("There are no teams in your league.");
				}
				break;

			case "5": // search league
				System.out.print("Enter a team name to search for: ");
				target = in.readLine();
				targetTeam.setName(target);
				try {
					if (league.contains(targetTeam))
						System.out
								.println(target + " is a team in the league.");
					else
						System.out.println("Sorry " + target
								+ " is not a team in this league.");
				} catch (NullPointerException e) {
					System.out.println("There are no teams in your league.");
				}
				break;

			case "6": // quit and save loop
				keepGoing = false;

				// Save the league
				if (filename == null) {
					System.out.println("Enter a filename to save to: ");
					filename = in.readLine();
				}
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(filename));
				out.writeObject(league);
				out.close();
				break;

			case "7": // quit loop (without saving)
				keepGoing = false;
				break;

			default:
				System.out
						.println("Error in operation choice. Re-prompting choices.");
				break;
			}
		}

	}
}
