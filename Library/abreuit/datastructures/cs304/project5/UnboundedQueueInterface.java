package abreuit.datastructures.cs304.project5;

import abreuit.datastructures.cs304.project5.QueueUnderflowException;


public interface UnboundedQueueInterface<T> {

	T dequeue() throws QueueUnderflowException;
	boolean isEmpty();
	void enqueue(T element);
	
}
