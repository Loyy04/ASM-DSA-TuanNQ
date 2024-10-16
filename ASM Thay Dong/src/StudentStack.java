class StudentStack {
    private Student[] stack;
    private int top;
    private int maxSize;

    public StudentStack(int size) {
        this.maxSize = size;
        this.stack = new Student[maxSize];
        this.top = -1;
    }

    public void push(Student student) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full. Cannot push more students.");
            return;
        }
        stack[++top] = student;
    }

    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        return stack[top--];
    }

    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return null;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public Student top() {
        return peek();
    }
}