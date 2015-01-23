
@SuppressWarnings("serial")
public class QueueOverflowException extends Exception {

	QueueOverflowException () {
		super();
	}
	
	QueueOverflowException (String message) {
		super(message);
	}
}
