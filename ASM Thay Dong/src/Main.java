public class Main {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        StudentStack stack = new StudentStack();

        // Add students
        management.addStudent(new Student("001", "Nguyen Van A", 7.8));
        management.addStudent(new Student("002", "Tran Thi B", 6.4));
        management.addStudent(new Student("003", "Le Van C", 9.1));

        // Print all students
        System.out.println("All Students:");
        management.printAllStudents();

        // Sort by score
        System.out.println("\nSorted by Score:");
        management.sortStudentsByScore();
        management.printAllStudents();

        // Search for a student
        System.out.println("\nSearching for Student ID '002':");
        Student found = management.searchStudent("002");
        System.out.println(found != null ? found : "Not found");

        // Stack operations
        System.out.println("\nStack Operations:");
        stack.push(new Student("004", "Pham Thi D", 8.5));
        stack.push(new Student("005", "Vu Van E", 5.2));

        System.out.println("Top of stack: " + stack.peek());
        System.out.println("Popped from stack: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
