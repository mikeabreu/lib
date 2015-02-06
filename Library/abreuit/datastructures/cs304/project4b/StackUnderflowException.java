package abreuit.datastructures.cs304.project4b;

@SuppressWarnings("serial")
public class StackUnderflowException extends Exception 
//Author: Michael Abreu
{

	// Exception used to handle NullPointerException
	
	public StackUnderflowException() 
	{
		super();
	}
	
	public StackUnderflowException(String message) 
	{
		super(message);
	}
}
