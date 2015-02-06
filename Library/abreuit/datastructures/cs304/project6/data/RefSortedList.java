
package abreuit.datastructures.cs304.project6.data;

import java.io.Serializable;

public class RefSortedList<T extends Comparable<T>> extends RefUnsortedList<T>
		implements ListInterface<T>, Serializable

{
	// Generated Serial Code (used for saving objects to file)
	private static final long serialVersionUID = 5868052538764922699L;

	public RefSortedList() {
		super();
	}

	public void add(T element)
	// Adds element to this list.
	{
		LLNode<T> prevLoc; // trailing reference
		LLNode<T> location; // traveling reference
		T listElement; // current list element being compared

		// Set up search for insertion point.
		location = list;
		prevLoc = null;

		// Find insertion point.
		while (location != null) {
			listElement = location.getInfo();
			if (listElement.compareTo(element) < 0) // list element < add
													// element
			{
				prevLoc = location;
				location = location.getLink();
			} else
				break;
		}

		// Prepare node for insertion.
		LLNode<T> newNode = new LLNode<T>(element);

		// Insert node into list.
		if (prevLoc == null) {
			// Insert as first node.
			newNode.setLink(list);
			list = newNode;
		} else {
			// Insert elsewhere.
			newNode.setLink(location);
			prevLoc.setLink(newNode);
		}
		numElements++;
	}

}
