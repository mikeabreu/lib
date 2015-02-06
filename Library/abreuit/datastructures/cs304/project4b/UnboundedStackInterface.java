package abreuit.datastructures.cs304.project4b;

public interface UnboundedStackInterface<T> extends StackInterface<T> 
//Author: Michael Abreu
{

	// Unbounded Stack methods with pop and top from Stack
	
	// Adds an element to the top of the stack.
	void push(T element);
	
	// Returns true if the top element is null.
	boolean isEmpty();
	
}
