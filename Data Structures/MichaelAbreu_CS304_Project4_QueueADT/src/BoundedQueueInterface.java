
public interface BoundedQueueInterface<T> extends QueueInterface<T>{
	
	void enqueue(T element) throws QueueOverflowException;
	boolean isFull();
}
