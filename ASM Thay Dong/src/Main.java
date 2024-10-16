public class Main {
    public static void main(String[] args) {
        // Stack demonstration
        StudentStack studentStack = new StudentStack(5);

        // Adding students to the stack
        studentStack.push(new Student(1, "Nguyen Van A", 3.8));
        studentStack.push(new Student(2, "Mai Thi B", 3.2));
        studentStack.push(new Student(3, "Hoang Van C", 3.6));

        // Display the top student
        System.out.println("Top student: " + studentStack.top());

        // Pop a student and display the new top
        studentStack.pop();
        System.out.println("New top student after pop: " + studentStack.top());

        // Management demonstration
        StudentManagement management = new StudentManagement(10);

        // Adding students
        management.addStudent(new Student(1, "Nguyen Van A", 3.8));
        management.addStudent(new Student(2, "Mai Thi B", 3.2));
        management.addStudent(new Student(3, "Hoang Van C", 3.6));

        // Display all students
        management.displayStudents();

        // Update a student's details
        management.updateStudent(2, "Mai Van B", 3.9);
        management.displayStudents();

        // Remove a student
        management.removeStudent(3);
        management.displayStudents();

        // Sort students by GPA
        management.sortStudentsByGpa();
        System.out.println("Students sorted by GPA:");
        management.displayStudents();
    }
}
