public class Main {
    public static void main(String[] args) {
        // Array-based stack
        StackArray stackArray = new StackArray(5);
        System.out.println("Testing Array-Based Stack:");
        stackArray.push(10);
        stackArray.push(20);
        stackArray.push(30);
        System.out.println("Peek: " + stackArray.peek());
        System.out.println("Pop: " + stackArray.pop());
        System.out.println("Is Empty: " + stackArray.isEmpty());

        // Linked List-based stack
        StackLinkedList stackLinkedList = new StackLinkedList();
        System.out.println("\nTesting Linked List-Based Stack:");
        stackLinkedList.push(100);
        stackLinkedList.push(200);
        stackLinkedList.push(300);
        System.out.println("Peek: " + stackLinkedList.peek());
        System.out.println("Pop: " + stackLinkedList.pop());
        System.out.println("Is Empty: " + stackLinkedList.isEmpty());
    }
}
