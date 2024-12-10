import java.util.Scanner;
import java.util.Random;

public class StudentManagement {
    private StudentStack studentStack;

    public StudentManagement() {
        studentStack = new StudentStack();
    }

    public void addStudent(String id, String name, double marks) {
        Student student = new Student(id, name, marks);
        studentStack.push(student);
    }
    public void searchStudent(String keyword) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        System.out.println("\nSearch results for keyword: \"" + keyword + "\":");
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equalsIgnoreCase(keyword) || student.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(student);
                found = true;
            }
            tempStack.push(student);
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("No students found with the given keyword.");
        }
    }

    public void deleteStudent() {
        if (!studentStack.isEmpty()) {
            studentStack.pop();
            System.out.println("Student removed from the stack.");
        } else {
            System.out.println("Stack is empty, nothing to delete.");
        }
    }

    public void editStudent(String id, String newName, double newMarks) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                found = true;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayStudents() {
        System.out.println("Students in the stack:");
        studentStack.displayStack();
    }

    public void sortStudentsBubble() {
        Student[] studentsArray = toArray();
        int n = studentsArray.length;

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (studentsArray[j].getMarks() < studentsArray[j + 1].getMarks()) {
                    Student temp = studentsArray[j];
                    studentsArray[j] = studentsArray[j + 1];
                    studentsArray[j + 1] = temp;
                }
            }
        }

        rebuildStack(studentsArray);
        System.out.println("Bubble Sort completed.");
    }

    public void quickSortStudents(Student[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSortStudents(array, low, pivotIndex - 1);
            quickSortStudents(array, pivotIndex + 1, high);
        }
    }

    private int partition(Student[] array, int low, int high) {
        Student pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].getMarks() >= pivot.getMarks()) { // Sort descending
                i++;
                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        Student temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public void compareSortingAlgorithms() {
        Student[] studentsArray = toArray();

        // Bubble Sort
        Student[] bubbleArray = studentsArray.clone();
        long bubbleStart = System.nanoTime();
        sortStudentsBubble();
        long bubbleEnd = System.nanoTime();
        long bubbleTime = bubbleEnd - bubbleStart;

        // Quick Sort
        Student[] quickArray = studentsArray.clone();
        long quickStart = System.nanoTime();
        quickSortStudents(quickArray, 0, quickArray.length - 1);
        long quickEnd = System.nanoTime();
        long quickTime = quickEnd - quickStart;

        // Display comparison
        System.out.println("\nSorting Algorithm Comparison:");
        System.out.println("Bubble Sort Time: " + bubbleTime + " nanoseconds");
        System.out.println("Quick Sort Time: " + quickTime + " nanoseconds");

        if (bubbleTime < quickTime) {
            System.out.println("Bubble Sort is faster by " + (quickTime - bubbleTime) + " nanoseconds.");
        } else if (quickTime < bubbleTime) {
            System.out.println("Quick Sort is faster by " + (bubbleTime - quickTime) + " nanoseconds.");
        } else {
            System.out.println("Both algorithms took the same time.");
        }
    }

    private Student[] toArray() {
        StudentStack tempStack = new StudentStack();
        int count = 0;

        while (!studentStack.isEmpty()) {
            tempStack.push(studentStack.pop());
            count++;
        }

        Student[] studentsArray = new Student[count];
        for (int i = 0; i < count; i++) {
            studentsArray[i] = tempStack.pop();
            studentStack.push(studentsArray[i]);
        }

        return studentsArray;
    }

    private void rebuildStack(Student[] studentsArray) {
        studentStack = new StudentStack();
        for (Student student : studentsArray) {
            studentStack.push(student);
        }
    }

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Display Students");
            System.out.println("5. Compare Sorting Algorithms");
            System.out.println("6. Generate Random Students");
            System.out.println("7. Sort using Bubble Sort");
            System.out.println("8. Sort using Quick Sort");
            System.out.println("9. Search Student");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    sm.addStudent(id, name, marks);
                    break;
                case 2:
                    sm.deleteStudent();
                    break;
                case 3:
                    System.out.print("Enter ID to edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();
                    sm.editStudent(editId, newName, newMarks);
                    break;
                case 4:
                    sm.displayStudents();
                    break;
                case 5:
                    sm.compareSortingAlgorithms();
                    break;
                case 6:
                    System.out.print("Enter the number of random students to generate: ");
                    int numStudents = scanner.nextInt();
                    for (int i = 1; i <= numStudents; i++) {
                        String randomId = "ID" + (random.nextInt(1000) + 1); // Random ID
                        String randomName = "Student" + (random.nextInt(100) + 1); // Random Name
                        double randomMarks = 1.0 + (random.nextDouble() * 9.0); // Random Marks
                        sm.addStudent(randomId, randomName, randomMarks);
                    }
                    System.out.println(numStudents + " random students generated successfully!");
                    break;
                case 7:
                    long bubbleStart = System.nanoTime();
                    sm.sortStudentsBubble();
                    long bubbleEnd = System.nanoTime();
                    System.out.println("Bubble Sort completed in " + (bubbleEnd - bubbleStart) + " nanoseconds.");
//                    sm.displayStudents(); // Display sorted students
                    break;
                case 8:
                    Student[] quickSortArray = sm.toArray();
                    long quickStart = System.nanoTime();
                    sm.quickSortStudents(quickSortArray, 0, quickSortArray.length - 1);
                    long quickEnd = System.nanoTime();
                    sm.rebuildStack(quickSortArray);
                    System.out.println("Quick Sort completed in " + (quickEnd - quickStart) + " nanoseconds.");
//                    sm.displayStudents(); // Display sorted students
                    break;
                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                case 9:
                    System.out.print("Enter ID or Name to search: ");
                    String keyword = scanner.nextLine();
                    sm.searchStudent(keyword);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}