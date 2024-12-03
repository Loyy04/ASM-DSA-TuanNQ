package stack;

import java.util.EmptyStackException;

public class StackLinkedList {
    private Node top;

    // Node class for Linked List
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Push operation
    public void push(int value) {
        Node newNode = new Node(value); // Create a new node
        newNode.next = top; // Link the new node to the current top
        top = newNode; // Update the top to the new node
    }

    // Pop operation
    public int pop() {
        if (top == null) { // Check if the stack is empty
            throw new EmptyStackException();
        }
        int value = top.data; // Get the data from the top node
        top = top.next; // Move top to the next node
        return value;
    }

    // Peek operation
    public int peek() {
        if (top == null) { // Check if the stack is empty
            throw new EmptyStackException();
        }
        return top.data; // Return the data from the top node
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}


