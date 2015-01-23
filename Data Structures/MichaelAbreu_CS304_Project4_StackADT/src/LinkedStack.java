public class LinkedStack<T> implements UnboundedStackInterface<T> 
//Author: Michael Abreu
{

	// Create instance variable of our LinkedListNode
	protected LLNode<T> top;

	// Link-based Stack
	public LinkedStack()
	// Preconditions: requires a String for the name of the stack.
	//
	// Constructs a new Link-based Stack. Sets the top element to null.
	{
		top = null;
	}

	public void push(T element)
	// Preconditions: data must be of type String
	//
	// Adds a new element on the top of the stack.
	{
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
	}

	public void pop() throws StackUnderflowException
	// Removes the top element from the stack.
	{
		if (!isEmpty()) {
			top = top.getLink();
		} else
			throw new StackUnderflowException(
					"Pop attempted on an empty stack.");
	}

	public T top() throws StackUnderflowException
	// Returns the top element of the stack.
	{
		if (isEmpty()) {
			throw new StackUnderflowException(
					"Pop attempted on an empty stack.");
		} else
			return top.getInfo();
	}

	public void print()
	//
	{
		int count = 0;
		LLNode<T> currNode = top;
		System.out.println("---\t----\t----\t----\t----");
		System.out.println("Stack: \n");
		while (currNode != null) {
			count++;
			System.out.println(count+":\t"+currNode.getInfo());
			currNode = currNode.getLink();
		}
		System.out.println("---\t----\t----\t----\t----");
	}

	public void clear() 
	// Sets the stack to null, clearing it of all data.
	{
		top = null;
	}
	
	public int getSize() {
		int size = 0;
		LLNode<T> tmp = top;
		
		while(tmp != null)
		{
			size++;
			tmp = tmp.getLink();
		}
		return size;
	}
	
	public boolean isEmpty()
	// Returns true if the stack is empty.
	{
		if (top == null)
			return true;
		else
			return false;
	}
}
