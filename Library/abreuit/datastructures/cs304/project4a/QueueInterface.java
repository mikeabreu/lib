package abreuit.datastructures.cs304.project4a;

public interface QueueInterface<T> {
	
	T dequeue() throws QueueUnderflowException;
	boolean isEmpty();
}
