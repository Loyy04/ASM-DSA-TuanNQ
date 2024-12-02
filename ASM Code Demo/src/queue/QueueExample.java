package queue;
public class QueueExample {
    public static void main(String[] args) {
        // Test ArrayQueue
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        System.out.println("ArrayQueue Operations:");
        System.out.println("Dequeue: " + arrayQueue.dequeue());
        System.out.println("Peek: " + arrayQueue.peek());
        System.out.println("Is Empty: " + arrayQueue.isEmpty());

        // Test LinkedListQueue
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.enqueue(100);
        linkedListQueue.enqueue(200);
        linkedListQueue.enqueue(300);
        System.out.println("\nLinkedListQueue Operations:");
        System.out.println("Dequeue: " + linkedListQueue.dequeue());
        System.out.println("Peek: " + linkedListQueue.peek());
        System.out.println("Is Empty: " + linkedListQueue.isEmpty());
    }
}
