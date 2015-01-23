public class StudentList {

	//
	protected LLNode list;
	protected String name;

	public StudentList(String name) 
	//
	{
		list = null;
		this.name = name;
	}

	public void insert(String info) 
	//
	{
		LLNode newNode = new LLNode(info);
		newNode.setLink(list);
		list = newNode;

	}

	public void remove(String element) 
	//
	{
		boolean removed = false;
		LLNode currNode = list;
		while (currNode != null) {
			System.out.println(currNode.getInfo());
			currNode = currNode.getLink();
		}
		if (removed)
			System.out.println("Successfully removed: " + element);
		else
			System.out.println("Operation was unsuccessful. Try again.");
	}

	public void clear() 
	//
	{
		System.out.println("\nList has been cleared.");
		list = null;
	}

	public void print() 
	//
	{
		LLNode currNode = list;
		System.out.println(name + ":");
		while (currNode != null) {
			System.out.println(currNode.getInfo());
			currNode = currNode.getLink();
		}

	}

	public boolean contains(String element) 
	//
	{
		boolean found = false;
		LLNode currNode = list;
		while (currNode != null) {
			if (currNode.getInfo().equalsIgnoreCase(element))
				found = true;
			currNode = currNode.getLink();
		}
		return found;
	}

	public void search(String element) 
	//
	{
		boolean found = false;
		LLNode currNode = list;
		System.out.println("\nSearching. . .");
		while (currNode != null) {
			if (currNode.getInfo().equalsIgnoreCase(element))
				found = true;
			currNode = currNode.getLink();
		}
		if (found)
			System.out.println("Item found: " + element);
		else
			System.out.println("No items were found matching: " + element);

	}

	public int size()
	//
	{
		LLNode currNode = list;
		int count = 0;

		while (currNode != null) {
			count++;
			currNode = currNode.getLink();
		}

		return count;
	}

	public boolean isFull()
	//
	{
		return false;
	}

	public String getName()
	//
	{
		return name;
	}

	@Override
	public String toString()
	//
	{
		String str = "Student List: " + name + "\n\n";
		LLNode node;
		node = list;
		int count = 0;

		while (node != null) {
			count++;
			str = str + count + ". ";
			node = node.getLink();
		}

		return str;
	}
}
