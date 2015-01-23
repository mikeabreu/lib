
public interface StackInterface<T> 
//Author: Michael Abreu
{

	// Removes the top element from the stack.
	void pop() throws StackUnderflowException;
	
	// Returns the element on the top of the stack.
	T top() throws StackUnderflowException;
	
	// Clears the data from the stack.
	void clear();
}
