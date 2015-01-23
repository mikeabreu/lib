import java.util.Scanner;

public class MainApp
{

	public static void main(String[] args) {
		// Object variables
		Scanner input = new Scanner(System.in);
		ADT<ItemType> queue = new ADT<ItemType>("String Builder");
		
		// Local variables
		boolean loop = true;
		String fileName, option, element;

		System.out
				.println("Welcome to my String Builder!"
						+ "\nThis small program will create a series of strings,\nwith each new string being added to the end."
						+ "\n\tEnqueue = Add a string."
						+ "\n\tDequeue = Remove the beginning string. Display which string was removed."
						+ "\nInitial Options: "
						+ "\n\t1. Start from scratch"
						+ "\n\t2. Load from a file");
		System.out.print(">");
		option = input.nextLine();

		if (option.equals("2"))
		// If the user wishes to load a file
		{
			System.out.print("Enter file name: ");
			fileName = input.nextLine();
			queue.loadData(fileName, queue);

			
		}

		while (loop)
		// Main loop of the program.
		{
			// Display the options to the user.
			System.out.println("Options:" + "\n\t1. Enqueue" + "\n\t2. Dequeue"
					+ "\n\t3. Display Strings"
					+ "\n\t4. Clear" + "\n\t5. Quit without saving"
					+ "\n\t6. Save and Quit");
			System.out.print(">");
			option = input.nextLine();

			switch (option) {
			case "1":
			// Enqueue
			{
				System.out.print("Enter the string you wish to enqueue: ");
				element = input.nextLine();
				queue.enqueue(element);
				break;
			}
			case "2":
			// Dequeue
			{
				try {
					System.out.println("String being removed.");
					System.out.println("---\t----\t----\t----\t----");
					System.out.println(queue.dequeue());
				} catch (QueueUnderflowException e) {
					System.out.println(e.getMessage());
				} finally {
					System.out.println("---\t----\t----\t----\t----");
				}
				break;
			}
			case "3":
			// Display Queue
			{
				System.out.println(queue);
				break;
			}
			case "4":
			// Clear
			{
				System.out.println("---\t----\t----\t----\t----");
				System.out.println("Queue was cleared.");
				queue.clear();
				System.out.println("---\t----\t----\t----\t----");
				break;
			}
			case "5":
			// Quit without Saving
			{
				System.out.println("Thank you for using my program!");
				loop = false;
				break;
			}
			case "6":
			// Save and Quit (Write to file)
			{
				System.out.print("Enter file name: ");
				fileName = input.nextLine();
				if (queue.saveData(fileName))
					System.out.println("Your save to file: " + fileName
							+ " was successful.");
				else {
					System.out
							.println("An error occured while trying to save to file: "
									+ fileName);
					System.out
							.println("Exiting back to options, try again with a different file name.");
					break;
				}
				System.out.println("Thank you for using my program!");
				loop = false;
				break;
			}
			default:
				// Prompt the options again.
			}

		}
		// Close the scanner.
		input.close();
	}
}
