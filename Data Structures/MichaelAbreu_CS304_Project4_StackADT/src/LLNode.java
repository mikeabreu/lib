
public class LLNode<T> 
// Author: Michael Abreu
{
	
	// Instance variables
	// link holds the memory address pointer to the next node.
	// info holds the data.
	private LLNode<T> link;
	private T info;
	
	
	public LLNode (T info)
	// Preconditions: requires you to pass a data of type String
	//
	// Creates a Link List holding data of type String
	{
		this.info = info;
		link = null;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) 
	// Preconditions: requires a String to be passed in.
	//
	// Change the data inside the node.
	{
		this.info = info;
	}

	public LLNode<T> getLink() 
	// Returns the memory address the node is pointing at.
	{
		return link;
	}

	public void setLink(LLNode<T> link) 
	// Preconditions: Must be of type LLNode
	//
	// Sets the memory address the node will point to.
	{
		this.link = link;
	}
}
