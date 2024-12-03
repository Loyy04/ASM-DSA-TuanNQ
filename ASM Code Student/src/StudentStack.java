public class StudentStack {
    private static final int INITIAL_CAPACITY = 10;
    private Student[] stack;
    private int top;

    public StudentStack() {
        stack = new Student[INITIAL_CAPACITY];
        top = -1;
    }

    public void push(Student student) {
        if (top == stack.length - 1) {
            expandStack();
        }
        stack[++top] = student;
    }

    public Student pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    public Student peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void expandStack() {
        Student[] newStack = new Student[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public int size() {
        return top + 1;
    }
}
