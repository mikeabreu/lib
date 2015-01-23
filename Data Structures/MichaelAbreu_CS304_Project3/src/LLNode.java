
public class LLNode 
// Author: Michael Abreu
{
	
	// Instance variables
	// link holds the memory address pointer to the next node.
	// info holds the data.
	private LLNode link;
	private String info;
	
	
	public LLNode (String info)
	// Preconditions: requires you to pass a data of type String
	//
	// Creates a Link List holding data of type String
	{
		this.info = info;
		link = null;
	}

	public String getInfo() 
	// Returns the String inside the node.
	{
		return info;
	}

	public void setInfo(String info) 
	// Preconditions: requires a String to be passed in.
	//
	// Change the data inside the node.
	{
		this.info = info;
	}

	public LLNode getLink() 
	// Returns the memory address the node is pointing at.
	{
		return link;
	}

	public void setLink(LLNode link) 
	// Preconditions: Must be of type LLNode
	//
	// Sets the memory address the node will point to.
	{
		this.link = link;
	}
}
