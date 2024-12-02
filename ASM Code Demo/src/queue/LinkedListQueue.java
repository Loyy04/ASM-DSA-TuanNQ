package queue;
public class LinkedListQueue {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;

    public LinkedListQueue() {
        this.front = this.rear = null;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (front == null) throw new IllegalStateException("Queue is empty");
        int value = front.data;
        front = front.next;
        if (front == null) rear = null;
        return value;
    }

    public int peek() {
        if (front == null) throw new IllegalStateException("Queue is empty");
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
