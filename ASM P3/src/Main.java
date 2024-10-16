public class Main {
    private int maxSize; // Size of the stack
    private int[] stackArray; // Array to store stack elements
    private int top; // Index of the top element

    // Constructor to initialize the stack
    public Main(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // Stack is empty initially
    }

    // Push method to add an element to the stack
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full. Cannot push " + value);
        } else {
            top++; // Increment the top pointer
            stackArray[top] = value; // Add the element to the top of the stack
            System.out.println(value + " pushed to the stack");
        }
    }

    // Pop method to remove and return the top element of the stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop");
            return -1; // Return an invalid value
        } else {
            int poppedValue = stackArray[top]; // Get the top element
            top--; // Decrement the top pointer
            return poppedValue;
        }
    }

    // Peek method to return the top element of the stack without removing it
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty. No element to peek");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // isEmpty method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    public static void main(String[] args) {
        Main stack = new Main(5); // Create a stack with size 5

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek());

        stack.pop();
        System.out.println("Top element after pop: " + stack.peek());

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}