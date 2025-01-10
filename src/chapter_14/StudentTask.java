package chapter_14;

public class StudentTask {
    public static void main(String[] args) {
       Students student = new Students();
       student.setAge(20)
               .setCourse(2)
               .setFirstName("sadas")
               .setLastName("222222");
    }
}

class Students{
    private String firstName;
    private String lastName;
    private int age;
    private int course;

    public Students setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Students setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Students setAge(int age) {
        this.age = age;
        return this;
    }

    public Students setCourse(int course) {
        this.course = course;
        return this;
    }
}

