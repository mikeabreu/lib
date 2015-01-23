import java.util.Scanner;

public class App 
// Author: Michael Abreu
{

	public static void main(String[] args) throws StackUnderflowException {
		// Object variables		
		Scanner input = new Scanner(System.in);
		LinkedStack stack = new LinkedStack("Stack");

		// Instance Variables
		boolean loop = true;
		String option, element, numOfEntries;

		System.out.println("Welcome to my stack maker!" 
				+ "\nHow to use this program:"
				+ "\n\tTo add an element to the stack, use 'Single Push'. Push takes 1 word or 1 number per push."
				+ "\n\tExample Push: "
				+ "\n\t\tEnter what you would like to push: Michael"
				+ "\n\tUse 'Multiple Push' to push many items easily."
				+ "\n\tTo remove the top element, use 'Pop'."
				+ "\n\tTo display the top element, use 'Top'."
				+ "\n\tTo display the whole stack, use 'Display Stack'."
				+ "\n\tTo remove everything from the stack, use 'Clear'.");

		while (loop)
		// Main loop of the program.
		{
			// Prompt the user with options.
			System.out.println("Options:" + "\n\t1. Single Push"
					+ "\n\t2. Multiple Push" + "\n\t3. Pop" + "\n\t4. Top"
					+ "\n\t5. Display Stack" + "\n\t6. Clear" + "\n\t7. Quit");
			System.out.print(">");
			option = input.nextLine();

			switch (option) {
			case "1":
			// Single Push
			{
				System.out.print("Enter what you would like to push: ");
				element = input.nextLine();
				stack.push(element);
				break;
			}
			case "2":
			// Multiple Push
			{
				System.out.print("How many entries would you like to enter: ");
				numOfEntries = input.nextLine();
				if (Integer.parseInt(numOfEntries) > 0
						&& Integer.parseInt(numOfEntries) <= 1000) {
					for (int i = 0; i < Integer.parseInt(numOfEntries); i++) {
						System.out.print("Enter what you would like to push: ");
						element = input.nextLine();
						stack.push(element);
					}
				} else
					System.out
							.println("Entry was out of bounds. Try entering a number between 1 and 1000");
				break;
			}
			case "3":
			// Pop
			{
				try {
					stack.pop();
					System.out.println("The top element was deleted.");
				} catch (StackUnderflowException e) {
					System.out.println("There are no elements in this stack.");
				}
				break;
			}
			case "4":
			// Top
			{
				try {
					System.out.println("The top element in the stack is: "
							+ "\n" + "\t" + stack.top());
				} catch (StackUnderflowException e) {
					System.out.println("There are no elements in this stack.");
				}
				break;
			}
			case "5":
			// Display the stack
			{
				stack.print();
				break;
			}
			case "6":
			// Clear
			{
				stack.clear();
				System.out.println("The stack was cleared.");
				break;
			}
			case "7":
			// Quit
			{
				System.out.println("Thank you for using my program!");
				loop = false;
				break;
			}
			default:
			}

		}

		// Close the scanner.
		input.close();
	}
}
