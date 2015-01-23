import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ADT<T> implements UnboundedQueueInterface<T>
// Author: Michael Abreu
{

	// Create instance variable of our LinkedListNode
	protected LLNode<T> front;
	protected LLNode<T> rear;
	protected int size;
	protected String queueName, str;

	// Link-based Queue
	public ADT(String name)
	// Constructs a new Link-based Queue. Sets the front and rear nodes to null.
	{
		queueName = name;
		front = null;
		rear = null;
		size = 0;
	}

	public void enqueue(String element)
	// Adds an element to the queue, in the first position.
	{
		@SuppressWarnings("unchecked")
		LLNode<T> newNode = new LLNode<T>((T) element);
		if (rear == null)
			front = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
		size++;
	}

	public T dequeue() throws QueueUnderflowException
	// Removes the first element from the queue.
	// Returns the information stored in that element.
	{
		if (isEmpty())
			throw new QueueUnderflowException(
					"Dequeue attempted on empty queue.");
		else {
			T element;
			element = front.getInfo();
			front = front.getLink();
			size--;
			return element;
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public boolean loadData(String fileName, ADT queue) {
		File file = new File(fileName);
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		// Try with resources. Auto closes BufferedReader.
		{
			// Read the first line as the size of the file.
			String element;
			String tmp = br.readLine();
			int count = (Integer.parseInt(tmp));

			// Add the data from the file into the queue.
			while (count > 0) {
				element = br.readLine();
				count--;
				queue.enqueue(element);
			}

			System.out.println("File successfully loaded!");
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + file.toString());
			return false;
		} catch (IOException e) {
			System.out.println("Unable to read file: " + file.toString());
			return false;
		}
	}
	
	public boolean saveData(String fileName) {
		File file = new File(fileName);
		
		LLNode<T> tmpNode = front;
		
		try (BufferedWriter br = new BufferedWriter(
				new FileWriter(file))) {
			
			String lines = "" + size;
			br.write(lines);
			br.newLine();
			
			

			while (tmpNode != null) {
				br.write((String) tmpNode.getInfo());
				br.newLine();
				tmpNode = tmpNode.getLink();
			}
			
			return true;
		} catch (IOException e) {
			System.out.println("Unable to write to file: "
					+ file.toString());
			return false;
		}
	}
	
	public void clear()
	// Clears the queue of all objects.
	// Clears all data from memory, and erases the pointers.
	{
		size = 0; // Clear Size
		rear = null; // Set rear to null, so that front will eventually hit rear
						// and become null.
		while (front != null) {
			front.setInfo(null); // Erase the info stored from the memory.
			front = front.getLink(); // Iterate through all linked nodes.
		}

	}

	public boolean isEmpty()
	// Return true if the queue is empty.
	{return (front == null);}

	@Override
	public String toString()
	// Displays the information inside of the queue, in a organized way.
	{
		String str = queueName + "\n---\t----\t----\t----\t----";
		LLNode<T> tmpNode = front;

		while (tmpNode != null) {
			str = str + "\n" + tmpNode.getInfo();
			tmpNode = tmpNode.getLink();
		}
		str = str + "\n---\t----\t----\t----\t----";

		return str;
	}
}
