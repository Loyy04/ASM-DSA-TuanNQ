class StudentManagement {
    private Student[] students;  // Array to hold Student objects
    private int count;           // Current number of students

    public StudentManagement(int size) {
        students = new Student[size];  // Initialize array with specified size
        count = 0;                     // Start with zero students
    }

    // Add a new student to the array
    public void addStudent(Student student) {
        if (count == students.length) {
            System.out.println("Cannot add more students. Management full.");
            return;
        }
        students[count++] = student;  // Add student and increment count
    }

    // Remove a student by ID
    public void removeStudent(int id) {
        int index = findStudentIndex(id);  // Find index of student to remove
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }
        for (int i = index; i < count - 1; i++) {  // Shift students left
            students[i] = students[i + 1];
        }
        students[--count] = null;  // Clear the last position
    }

    // Update student details by ID
    public void updateStudent(int id, String newName, double newGpa) {
        Student student = findStudent(id);  // Find the student
        if (student != null) {
            student.setName(newName);  // Update name
            student.setGpa(newGpa);    // Update GPA
        } else {
            System.out.println("Student not found.");
        }
    }

    // Search for a student by ID
    public Student findStudent(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                return students[i];  // Return student if found
            }
        }
        return null;  // Return null if not found
    }

    // Find index of a student by ID
    private int findStudentIndex(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                return i;  // Return index if found
            }
        }
        return -1;  // Return -1 if not found
    }

    // Sort students by GPA using bubble sort
    public void sortStudentsByGpa() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].getGpa() > students[j + 1].getGpa()) {
                    // Swap if students are out of order
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    // Display all students
    public void displayStudents() {
        if (count == 0) {
            System.out.println("No students to display.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);  // Print each student
        }
    }
}
