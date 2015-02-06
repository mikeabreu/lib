package abreuit.datastructures.cs304.project4a;

@SuppressWarnings("serial")
public class QueueUnderflowException extends Exception {

	QueueUnderflowException () {
		super();
	}
	
	QueueUnderflowException (String message) {
		super(message);
	}
}
