
public class TestDriver {

	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<String>();
		
		// Test if stacks empty.
		System.out.println("isEmpty: " + stack.isEmpty());
		
		// Push 5 items.
		System.out.println("Adding 5 items to stack.");
		stack.push("Item One");
		stack.push("Item Two");
		stack.push("Item Three");
		stack.push("Item Four");
		stack.push("Item Five");
		
		// Print Stack
		System.out.println("\nPrinted Stack: ");
		stack.print();
		
		// Top of Stack
		try {
			System.out.println("Top: " + stack.top());
		} catch (StackUnderflowException e) {
			System.out.println(e.getMessage());
		}
		
		// Pop an item from stack.
		System.out.println("Pop");
		try {
			stack.pop();
		} catch (StackUnderflowException e) {
			System.out.println(e.getMessage());
		}
		
		// Print Stack
		System.out.println("\nPrinted Stack: ");
		stack.print();
		System.out.println("isEmpty: " + stack.isEmpty());
		
		// Top of stack
		try {
			System.out.println("Top: " + stack.top());
		} catch (StackUnderflowException e) {
			System.out.println(e.getMessage());
		}
		
		// Clear Stack
		stack.clear();
		
		// Print Stack
		System.out.println("\nPrinted Stack: ");
		stack.print();
		// Check if its empty.
		System.out.println("isEmpty: " + stack.isEmpty());
		// Top of stack
		try {
			System.out.println("Top: " + stack.top());
		} catch (StackUnderflowException e) {
			System.out.println(e.getMessage());
		}
	}

}
