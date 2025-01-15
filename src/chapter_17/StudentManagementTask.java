package chapter_17;

import java.util.ArrayList;
import java.util.List;

public class StudentManagementTask {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student("Ali", 1, "A", true));
        manager.addStudent(new Student("Vali", 2, "B", false));
        manager.addStudent(new Student("Doli", 3, "C", true));

        System.out.println("active talabalar:");
        for (Student student : manager.listActiveStudents()) {
            System.out.println(student);
        }
        System.out.println("------");
        System.out.println("Talaba ID=1 ni deactive qilish:");
        manager.deactivateStudent(1);
        System.out.println(manager.findStudent(1));
        System.out.println("------");

        System.out.println("Talaba ID=2 ni active qilish:");
        manager.activateStudent(2);
        System.out.println(manager.findStudent(2));
        System.out.println("------");

        System.out.println("Talaba ID=3 ni o'chirish:");
        manager.removeStudent(3);
        System.out.println("------");

        System.out.println("Yangi active talabalar ro'yxati:");
        for (Student student : manager.listActiveStudents()) {
            System.out.println(student);
        }
    }
}

class Student {
    private String name;
    private int id;
    private String grade;
    private boolean isActive;

    public Student(String name, int id, String grade, boolean isActive) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", grade='" + grade + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    boolean addStudent(Student student) {
        if (student == null) return false;
        students.add(student);
        return true;
    }

    boolean removeStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return true;
            }
        }
        return false;

    }

    Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }

        }
        return null;
    }

    public List<Student> listActiveStudents() {
        List<Student> active = new ArrayList<>();
        for (Student student : students) {
            if (student.isActive()) {
                active.add(student);
            }
        }
        return active;
    }

    public boolean deactivateStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setActive(false);
                return true;
            }
        }
        return false;
    }

    boolean activateStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setActive(true);
                return true;
            }

        }
        return false;
    }
}



