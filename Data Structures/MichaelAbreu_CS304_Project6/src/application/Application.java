package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import data.Employee;
import data.RefSortedList;

public class Application {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Instance Variables
		Scanner in = new Scanner(System.in);
		RefSortedList<Employee> list = null;
		// End of Instance Variables

		// Read/Write Variables
		String filename = null;

		// Add Method variables
		String name;
		String job;
		double wage;
		int autoID = 0;
		// End of Add Method variables

		// Description of program.
		System.out.println("Welcome.");
		// End of Description.

		// Read from a file.
		System.out.print("Would you like to read from a file, yes/no: ");
		String checkRead = in.nextLine();
		if (checkRead.equalsIgnoreCase("yes")) {
			System.out
					.print("Enter the name of the file you wish to save to: ");
			filename = in.nextLine();
			try (ObjectInputStream inObj = new ObjectInputStream(
					new FileInputStream(filename))) {
				list = (RefSortedList<Employee>) inObj.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (list == null) 
			list = new RefSortedList<Employee>();
		// End of Read.

		// Main Loop of Program. Options Prompt.
		while (true) {
			break;
		}
		// End of Main Loop.

		// Add Method
		System.out.print("\nHow many employee's would you like to add: ");
		int numOfEmployee = Integer.parseInt(in.nextLine());
		Employee[] emp = new Employee[numOfEmployee];

		for (int i = 1; i <= numOfEmployee; i++) {
			System.out.println("Employee #" + i);
			System.out.print("Enter the name of this employee: ");
			name = in.nextLine();

			System.out.print("Enter the job of this employee:  ");
			job = in.nextLine();

			System.out.print("Enter the wage of this employee: ");
			wage = Double.parseDouble(in.nextLine());

			autoID++;
			emp[i - 1] = new Employee(name, job, wage, autoID);
		}

		for (int i = 0; i < emp.length; i++)
			list.add(emp[i]);

		System.out.println(list);
		// End of Add Method

		// Save the list as a data file.
		if (filename == null) {
			System.out
					.print("Enter the name of the file you wish to save to: ");
			filename = in.nextLine();
		} else
			System.out.println("Saving your list to file: " + filename);
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(filename))) {
			out.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// End of Save.

		in.close();

	}
}
