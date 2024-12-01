import java.util.ArrayList;
import java.util.Comparator;

public class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getStudentId().equals(student.getStudentId())) {
                throw new IllegalArgumentException("Student ID already exists.");
            }
        }
        students.add(student);
    }

    public void updateStudent(String studentId, String newName, Double newScore) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                if (newName != null) s.setName(newName);
                if (newScore != null) s.setScore(newScore);
                return;
            }
        }
        throw new IllegalArgumentException("Student ID not found.");
    }

    public void deleteStudent(String studentId) {
        students.removeIf(s -> s.getStudentId().equals(studentId));
    }

    public Student searchStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) return s;
        }
        return null;
    }

    public void sortStudentsByScore() {
        students.sort(Comparator.comparingDouble(Student::getScore).reversed());
    }

    public void printAllStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
