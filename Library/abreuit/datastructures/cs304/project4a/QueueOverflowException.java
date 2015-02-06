package abreuit.datastructures.cs304.project4a;

@SuppressWarnings("serial")
public class QueueOverflowException extends Exception {

	QueueOverflowException () {
		super();
	}
	
	QueueOverflowException (String message) {
		super(message);
	}
}
