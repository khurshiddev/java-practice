package chapter_14;

import java.util.Arrays;

public class GroupTask {
    public static void main(String[] args) {
        Group gr1 = new Group(3, "Gita7");
        Group gr2 = new Group(2, "Gita10");

        Student st1 = new Student(2, "dasdas", "abdulla");
        Student st2 = new Student(3, "dasdas", "abdulla");
        Student st3 = new Student(1, "dasdas", "abdulla");
        Student st4 = new Student(2, "dasdas", "abdulla");
        Student st5 = new Student(3, "dasdas", "abdulla");
        System.out.println(gr1.add(st1));
        System.out.println(gr1.add(st3));
        System.out.println(gr1.add(st4));
        System.out.println(gr1.add(st3));
        System.out.println(gr1.add(st5));
        System.out.println(gr1.add(st2));
        System.out.println(gr1);
        System.out.println(gr2);

    }
}

class Group {
    private int course;
    private String name;
    private Student[] students;
    private int studentCount;

    public Group(int course, String name) {
        this.course = course;
        this.name = name;
        this.students = new Student[20];
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", students=" + Arrays.toString(Arrays.copyOf(students, studentCount)) +
                '}';
    }

    public boolean isFull() {
        return studentCount == 20;
    }

    public boolean isEmpty() {
        return studentCount == 0;
    }

    public boolean add(Student stud) {
        if (isFull()) return false;
        if (course != stud.getCourse()) return false;
        students[studentCount++] = stud;
        return true;
    }
}

class Student {
    private int course;
    private String firstName;
    private String lastName;


    public Student(int course, String firstName, String lastName) {
        this.course = course;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getCourse() {
        return course;
    }
}