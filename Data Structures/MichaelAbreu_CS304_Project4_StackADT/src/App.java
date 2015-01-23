import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App 
//Author: Michael Abreu
{

	public static void main(String[] args) throws StackUnderflowException {
		// Object variables
		Scanner input = new Scanner(System.in);
		LinkedStack stack = new LinkedStack();

		// Local variables
		boolean loop = true;
		String fileName, option, element, numOfEntries, elementTwo;

		System.out
				.println("Welcome to my stack maker! This small program will create stacks, load stacks and save stacks."
						+ "\nPush = Add an element to the stack. When pushing an element enter a first name and a last name."
						+ "\nExample push: 'Enter the name you wish to push: Michael Abreu'"
						+ "\nInitial Options: "
						+ "\n\t1. Create a new stack"
						+ "\n\t2. Load a stack from a file");
		System.out.print(">");
		option = input.nextLine();

		if (option.equals("2"))
		// If the user wishes to load a file
		{
			System.out.print("Enter file name: ");
			fileName = input.nextLine();
			File file = new File(fileName);

			try (BufferedReader br = new BufferedReader(new FileReader(file)))
			// Try with resources. Auto closes BufferedReader.
			{
				// Read the first line as the size of the file.
				String tmp = br.readLine();
				int count = (Integer.parseInt(tmp));

				// Push the data from the file into the stack.
				while (count != 0) {
					element = br.readLine();
					count--;
					elementTwo = br.readLine();
					count--;
					stack.push(element, elementTwo);

				}
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found: " + file.toString());
			} catch (IOException e) {
				System.out.println("Unable to read file: " + file.toString());
			}
		}

		while (loop)
		// Main loop of the program.
		{
			// Display the options to the user.
			System.out.println("Options:" + "\n\t1. Single Push"
					+ "\n\t2. Multiple Push" + "\n\t3. Pop" + "\n\t4. Top"
					+ "\n\t5. Display Stack" + "\n\t6. Clear"
					+ "\n\t7. Quit without saving" + "\n\t8. Save and Quit");
			System.out.print(">");
			option = input.nextLine();

			switch (option) {
			case "1":
			// Single Push
			{
				System.out.print("Enter the name you wish to push: ");
				element = input.next();
				elementTwo = input.next();
				stack.push(element, elementTwo);

				// Clear the input so it won't hang up.
				input.nextLine();
				break;
			}
			case "2":
			// Multiple Push
			{
				System.out.print("How many entries would you like to enter: ");
				numOfEntries = input.nextLine();

				if (Integer.parseInt(numOfEntries) >= 15) {
					System.out.print("Enter a safe word, used to quit early: ");
					String tmpWord = input.nextLine();
					for (int i = 0; i < Integer.parseInt(numOfEntries); i++) {
						System.out.print("Enter the name you wish to push: ");
						element = input.next();
						if (element.equalsIgnoreCase(tmpWord))
						{
							break;
						}
						elementTwo = input.next();
						stack.push(element, elementTwo);

					}
				} else if (Integer.parseInt(numOfEntries) > 0)
				// If numOfEntries is greater than 0
				{
					for (int i = 0; i < Integer.parseInt(numOfEntries); i++) {
						System.out.print("Enter the name you wish to push: ");
						element = input.next();
						elementTwo = input.next();
						stack.push(element, elementTwo);
					}
				} else {
					System.out
							.println("Entry was out of bounds. Try entering a number greater than 1");
				}
				// Clear the input so it won't hang up.
				input.nextLine();
				break;
			}
			case "3":
			// Pop
			{
				try
				// try to remove the top element. If there are no elements,
				// catch the StackUnderflowException error.
				{
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
				try
				// try to return the top element. If there are no elements,
				// catch the StackUnderflowException error.
				{
					System.out.println("The top element in the stack is: "
							+ "\n" + "\t" + stack.top());
				} catch (StackUnderflowException e) {
					System.out.println("There are no elements in this stack.");
				}
				break;
			}
			case "5":
			// Print
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
			// Quit without saving
			{
				System.out.println("Thank you for using my program!");
				loop = false;
				break;
			}
			case "8":
			// Save and Quit (Write to file)
			{
				// Prompt the user what file name to write to.
				System.out.print("Enter file name: ");
				fileName = input.nextLine();
				File file = new File(fileName);

				// Create a new temporary stack.
				// This is used to reverse the order it is saved.
				// This is important because when read from the file the
				// data will be pushed back into the stack in the correct order.
				LinkedStack tmpStack = new LinkedStack();

				// Try to write to the fileName given, if unable to throw
				// exception.
				try (BufferedWriter br = new BufferedWriter(
						new FileWriter(file))) {

					// Inserts all the data from stack into tmpStack. Reverse
					// order.
					while (!(stack.isEmpty())) {
						tmpStack.push(stack.getFirstName(), stack.getLastName());
						stack.pop();
					}

					// Save the size of the data as an integer.
					String size = "" + (tmpStack.getSize() * 2);
					br.write(size);
					br.newLine();

					// While there is something still in tmpStack, write it to
					// the file. Separated by a new line per element.
					while (!(tmpStack.isEmpty())) {
						br.write(tmpStack.getFirstName());
						br.newLine();
						br.write(tmpStack.getLastName());
						br.newLine();
						tmpStack.pop();
					}
				} catch (IOException e) {
					System.out.println("Unable to write to file: "
							+ file.toString());
				} finally {
					System.out.println("Thank you for using my program!");
					loop = false;
				}
				break;
			}
			default: {
				// Prompt the options again.
			}
			}

		}
		// Close the scanner.
		input.close();
	}
}
