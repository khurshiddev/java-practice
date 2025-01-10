package chapter_14;

public class UniversityTask {
    public static void main(String[] args) {
        University univ = new University("Seoul", "Seoul city");
        University.Student student = univ.new Student ("ASadbel", "Asadbekov", 2);
        University.Student studen2 = univ.new Student("ASadbel", "Asadbekov", 2);
        University.Student studen3 = univ.new Student("ASadbel", "Asadbekov", 2);
        University.Student studen4 = univ.new Student("ASadbel", "Asadbekov", 2);
        student.showInfo();
        studen2.showInfo();
        studen3.showInfo();
        studen4.showInfo();
    }
}

class University {
    private String name;
    private String location;

    public University(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    class Student {
        private String firstName;
        private String lastName;
        private int course;

        public Student(String firstName, String lastName, int course) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.course = course;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", course=" + course +
                    '}';
        }

        public void showInfo() {
            System.out.println(University.this + "\n" + this);
        }
    }
}
