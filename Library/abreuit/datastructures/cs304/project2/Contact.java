package abreuit.datastructures.cs304.project2;

import java.util.Collections;
import java.util.LinkedList;

public class Contact
// Author: 	Michael Abreu
// Date: 	2/5/14
//
// Data type that holds 3 lists of information.
// Names, addresses, and numbers.
{

	// Attributes
	protected LinkedList<String> name;
	protected LinkedList<String> address;
	protected LinkedList<String> number;
	protected int searchResultIndex;

	protected Contact()
	// Preconditions: none
	//
	// Initialize the lists for this data type.
	{
		name = new LinkedList<String>();
		address = new LinkedList<String>();
		number = new LinkedList<String>();
		searchResultIndex = 0;
	}

	protected void add(String name, String address, String number)
	// Preconditions: all three strings must be passed through at the same time
	// for the creation of an entry.
	//
	// Add an entry into the contact data type.
	{
		this.name.add(name);
		this.address.add(address);
		this.number.add(number);
	}

	protected int remove(String element)
	// Preconditions: For a successful deletion of an entry, element must be
	// the same string name as either name, address, or number.
	//
	// Remove an entry out of the list determined by name, address, or number.
	{
		boolean deleted = false;
		int count = 0;

		while (!deleted && count < 4) {
			// Search name for element desired to remove.
			for (int i = 0; i < name.size(); i++) {
				if (element.equalsIgnoreCase(name.get(i))) {
					name.remove(i);
					address.remove(i);
					number.remove(i);
					deleted = true;
				}
			}
			// Search address for element desired to remove.
			for (int i = 0; i < address.size(); i++) {
				if (element.equalsIgnoreCase(address.get(i))) {
					name.remove(i);
					address.remove(i);
					number.remove(i);
					deleted = true;
				}
			}
			// Search number for element desired to remove.
			for (int i = 0; i < number.size(); i++) {
				if (element.equalsIgnoreCase(number.get(i))) {
					name.remove(i);
					address.remove(i);
					number.remove(i);
					deleted = true;
				}
			}
			count++;
		}
		if (deleted)
			return 1;
		else
			return -1;
	}

	protected void sort()
	// Preconditions: none
	//
	// Sort the data alphabetically by name.
	{
		Object[][] nameClone1 = new Object[name.size()][name.size()];
		Object[][] nameClone2 = new Object[name.size()][name.size()];
		Object[][] numberClone = new Object[name.size()][name.size()];
		Object[][] addressClone = new Object[name.size()][name.size()];

		int[] shiftAmount = new int[name.size()];
		for (int i = 0; i < name.size(); i++)
		//
		{
			nameClone1[i][0] = name.get(i);
			nameClone1[i][1] = i;

			numberClone[i][0] = number.get(i);
			numberClone[i][1] = i;

			addressClone[i][0] = address.get(i);
			addressClone[i][1] = i;
		}

		// Sort the data alphabetically by name.
		Collections.sort(name);

		for (int i = 0; i < name.size(); i++)
		//
		{
			nameClone2[i][0] = name.get(i);
			nameClone2[i][1] = i;
		}

		for (int i = 0; i < name.size(); i++)
		//
		{
			for (int j = 0; j < name.size(); j++) {
				if (nameClone2[i][0].equals(nameClone1[j][0])) {
					shiftAmount[i] = (int) nameClone1[j][1];
				}
			}
		}

		for (int i = 0; i < name.size(); i++)
		//
		{
			for (int j = 0; j < name.size(); j++) {
				if (shiftAmount[i] == (int) numberClone[j][1]) {
					number.set(i, (String) numberClone[j][0]);
				}
				if (shiftAmount[i] == (int) addressClone[j][1]) {
					address.set(i, (String) addressClone[j][0]);
				}
			}
		}
	}

	protected boolean search(String element)
	// Preconditions: element must be a string within contacts data.
	//
	// Search for an entry by name, number, or address.
	{
		boolean found = false;
		searchResultIndex = 0;

		// Main search loop
		while (!found && (searchResultIndex < name.size())) {
			// Check if element is found in name list
			if (this.name.get(searchResultIndex).equalsIgnoreCase(element)) {
				found = true;
				return found;
			}
			// Check if element is found in address list
			else if (address.get(searchResultIndex).equalsIgnoreCase(element)) {
				found = true;
				return found;
			}
			// Check if element is found in number list
			else if (number.get(searchResultIndex).equalsIgnoreCase(element)) {
				found = true;
				return found;
			}
			searchResultIndex++;
		}
		return found;
	}

	protected void clear()
	// Preconditions: none
	//
	// Clear all entries from all lists.
	{
		name.clear();
		address.clear();
		number.clear();
	}

	protected String getName(int index)
	// Preconditions: index must be a valid position inside the list.
	//
	// Return the string at index from list name.
	{
		return name.get(index);
	}

	protected String getAddress(int index)
	// Preconditions: index must be a valid position inside the list.
	//
	// Return the string at index from list address.
	{
		return address.get(index);
	}

	protected String getNumber(int index)
	// Preconditions: index must be a valid position inside the list.
	//
	// Return the string at index from list number.
	{
		return number.get(index);
	}

	protected int getSearchIndex()
	// Preconditions: none
	//
	// Return the index search was attached to.
	{
		return searchResultIndex;
	}

	@Override
	public String toString()
	// Preconditions: none
	//
	// Automatic string built to display all list information.
	{
		String str = "\nName: " + "\t\t\tNumber: " + "\t\t\tAddress: ";
		for (int i = 0; i < name.size(); i++) {
			str = str + "\n" + name.get(i) + "\t\t\t" + number.get(i)
					+ "\t\t\t" + address.get(i);
		}
		return str;
	}

}
