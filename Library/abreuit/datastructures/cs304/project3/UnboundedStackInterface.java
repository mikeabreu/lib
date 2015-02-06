package abreuit.datastructures.cs304.project3;

public interface UnboundedStackInterface extends StackInterface 
// Author: Michael Abreu
{

	// Unbounded Stack methods with pop and top from Stack
	
	// Adds an element to the top of the stack.
	void push(String element);
	
	// Returns true if the top element is null.
	boolean isEmpty();
	
}
