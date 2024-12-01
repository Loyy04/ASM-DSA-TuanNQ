import java.util.EmptyStackException;
class StackArray {
    private int[] stack;
    private int top;

    // Constructor to initialize the stack with a specific size
    public StackArray(int size) {
        stack = new int[size];
        top = -1; // Indicates an empty stack
    }

    // Push operation
    public void push(int value) {
        if (top == stack.length - 1) { // Check if the stack is full
            throw new StackOverflowError("Stack is full");
        }
        stack[++top] = value; // Increment top and add value
    }

    // Pop operation
    public int pop() {
        if (top == -1) { // Check if the stack is empty
            throw new EmptyStackException();
        }
        return stack[top--]; // Return the top value and decrement top
    }

    // Peek operation
    public int peek() {
        if (top == -1) { // Check if the stack is empty
            throw new EmptyStackException();
        }
        return stack[top]; // Return the top value without removing it
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}
