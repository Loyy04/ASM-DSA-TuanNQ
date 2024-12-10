class StudentStack {
    private Student[] stackArray;
    private int top;
    private static final int INITIAL_CAPACITY = 100; // Kích thước mặc định của stack

    public StudentStack() {
        this.stackArray = new Student[INITIAL_CAPACITY];
        this.top = -1;
    }

    // Phương thức đẩy sinh viên vào stack
    public void push(Student student) {
        if (top == stackArray.length - 1) {
            resizeStack(); // Mở rộng mảng nếu cần
        }
        stackArray[++top] = student;
    }

    // Phương thức lấy sinh viên khỏi stack
    public Student pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stackArray[top--];
    }

    // Phương thức xem sinh viên ở đầu stack
    public Student peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stackArray[top];
    }

    // Kiểm tra xem stack có rỗng không
    public boolean isEmpty() {
        return top == -1;
    }

    // Hiển thị toàn bộ stack
    public void displayStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

    // Phương thức mở rộng kích thước mảng khi đầy
    private void resizeStack() {
        int newCapacity = stackArray.length * 2; // Tăng gấp đôi kích thước
        Student[] newStackArray = new Student[newCapacity];
        System.arraycopy(stackArray, 0, newStackArray, 0, stackArray.length);
        stackArray = newStackArray;
    }
}




