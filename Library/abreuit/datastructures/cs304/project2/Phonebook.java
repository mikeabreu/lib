package abreuit.datastructures.cs304.project2;

import java.util.Scanner;

public class Phonebook {
	// Author: 	Michael Abreu
	// Date: 	2/5/14

	// Attributes
	private Contact contacts;
	private boolean mainLoop;

	public Phonebook()
	// Preconditions: none
	//
	// Instantiates the instance variables.
	{
		contacts = new Contact();
		mainLoop = false;
	}

	public void run()
	// Preconditions: none
	//
	// Only method you are allowed to call.
	// Runs the program in a loop.
	{
		try
		// Try with resource (used to auto close scanners and catch all
		// exceptions)
		(Scanner in = new Scanner(System.in);
				Scanner optionIn = new Scanner(System.in);)
		//
		{
			// reset variables if needed.
			mainLoop = false;
			int option = 0;
			String[] tmp = new String[3];

			System.out.println("Welcome to my phonebook maker!");

			// Main Loop of program execution.
			while (!mainLoop) {
				in.reset();
				optionIn.reset();

				// Prompt user with options of program.
				System.out.println("\nOptions: " + "\n\t'1' - Add data."
						+ "\n\t'2' - Clear data." + "\n\t'3' - Display data."
						+ "\n\t'4' - Remove data." + "\n\t'5' - Search data."
						+ "\n\t'6' - Sort data."
						+ "\n\t'7' - Quit the program.");
				System.out.print(">");
				option = optionIn.nextInt();

				// Main Switchboard
				switch (option) {
				// Add data
				case 1: {
					System.out.print("Enter the entry name: ");
					tmp[0] = in.nextLine();
					System.out.print("Enter the entry address: ");
					tmp[1] = in.nextLine();
					System.out.print("Enter the entry number: ");
					tmp[2] = in.nextLine();
					add(tmp[0], tmp[1], tmp[2]);
					break;
				}
				// Clear data
				case 2: {
					clear();
					break;
				}
				// Display data
				case 3: {
					System.out.println(contacts);
					break;
				}
				// Remove data
				case 4: {
					tmp[0] = "";
					System.out
							.print("Enter the name of the entry you wish to remove: ");
					tmp[0] = in.nextLine();
					remove(tmp[0]);
					break;
				}
				// Search data
				case 5: {
					tmp[0] = "";
					System.out
							.print("Enter the name, number, or address you wish to search for: ");
					tmp[0] = in.nextLine();
					search(tmp[0]);
					break;
				}
				// Sort data
				case 6: {
					sort();
					break;
				}
				// Exit program
				case 7: {
					mainLoop = true;
					break;
				}
				default:
					break;
				}
			}
		} catch (Exception e)
		// Catch all exceptions, display a user friendly error message.
		{
			System.out
					.println("\nAn error has occured resulting in the program to halt. Sorry!");
		} finally
		// Regardless of errors or completion of program, display a thank you!
		{
			System.out.println("\nThank you for using my program!");
		}
	}

	private void add(String name, String address, String number)
	// Preconditions: Must enter name and address at the same time.
	// The name and address arrays can't be full.
	//
	// This method will add a name, address, and number to the Contacts data
	// type.
	{
		contacts.add(name, address, number);
	}

	private void remove(String element)
	// Preconditions: for successful removal, element must be within contacts
	// data.
	//
	// Remove an entry from contacts, determined by element.
	{
		System.out.println("\nRemoving entry: " + element);
		int check = contacts.remove(element);
		if (check == 1)
			System.out.println("Successfully deleted the entry.");
		else
			System.out.println("An error occured, unable to remove entry.");
	}

	private void sort()
	// Preconditions: none
	//
	// Sort the data alphabetically by name.
	{
		contacts.sort();
		System.out.println("Sort completed successfully.");
		System.out.println(contacts);
	}

	private void search(String element)
	// Preconditions: element must be a string within contacts.
	//
	// Search within contacts data for element entry.
	{
		System.out.println("\nSearching for " + element + "...");
		boolean found = contacts.search(element);
		int index = contacts.getSearchIndex();
		if (found)
		// Successful Search
		{
			System.out.println("Search finished, 1 item found: ");
			System.out.println("\nName: \t\t" + "Number: \t\t" + "Address: ");
			System.out.println(contacts.getName(index) + " \t\t"
					+ contacts.getNumber(index) + " \t\t"
					+ contacts.getAddress(index));
		} else
		// Unsuccessful Search
		{
			System.out.println("Search finished, 0 items found.");
		}
	}

	private void clear()
	// Preconditions: none
	//
	// Removes all entries from contacts data.
	{
		contacts.clear();
		System.out.println("\nAll data has been erased from your phonebook.");
	}

}
