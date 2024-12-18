package chapter_6;

public class task_2 {
    public static void main(String[] args) {
    Student s = new Student("Alisa", 18);
    }
}
class Student {
   String name;
   int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return " Name " + name + " Age = " + age;

    }


    class Room {
        private int size;
        private Student[] personSize;
        private int temp;

        Room(int size) {
            this.size = size;
            this.temp = 0;
            this.personSize = new Student[size];
        }

        void add(Student st) {
            if (temp < size) {
                personSize[temp] = st;
                temp++;
            }
        }

        boolean isFull() {
            return temp == size;
        }

        boolean isEmpty() {
            return temp == 0;
        }

        void show() {
            if (isEmpty()) {
                System.out.println("is empty");
            } else {
                for (int i = 0; i < temp; i++) {
                    System.out.println("students = " + personSize[i]);
                }
            }
        }
    }
}
