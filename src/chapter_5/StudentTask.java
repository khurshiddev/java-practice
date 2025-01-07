package chapter_5;

public class StudentTask {
    public static void main(String[] args) {
        Student student = new Student("Jon",25,4);
        student.info();
    }
}

class Student{
    String name;
    int age;
    int course;

    public Student(String name, int age, int course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
    public void info(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course=" + course +
                '}';
    }
}
