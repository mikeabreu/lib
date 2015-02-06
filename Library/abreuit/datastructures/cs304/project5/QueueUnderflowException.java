package abreuit.datastructures.cs304.project5;

@SuppressWarnings("serial")
public class QueueUnderflowException extends Exception {

	QueueUnderflowException () {
		super();
	}
	
	QueueUnderflowException (String message) {
		super(message);
	}
}
