
public interface UnboundedQueueInterface<T> {

	T dequeue() throws QueueUnderflowException;
	boolean isEmpty();
	void enqueue(T element);
	
}
