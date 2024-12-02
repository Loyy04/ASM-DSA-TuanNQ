package queue;
public class ArrayQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int value) {
        if (size == capacity) throw new IllegalStateException("Queue is full");
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
    }

    public int dequeue() {
        if (size == 0) throw new IllegalStateException("Queue is empty");
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException("Queue is empty");
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
