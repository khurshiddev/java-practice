package chapter_6;

public class StudentRoom {
    public static void main(String[] args) {

        Student student1 = new Student("Ali",20);
        Student student2 = new Student("Jon",23);
        Student student3 = new Student("Tom",25);
        Student student4 = new Student("Jonson",22);
        Room room = new Room(3);
        room.add(student1);
        room.add(student2);
        room.add(student3);
        System.out.println("room is full = " + room.isFull());
        System.out.println("room is empty = " + room.isEmpty());
        room.show();
    }
}

class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Room{
    int size;
    int temp;
    Student[] count;

    public Room(int size) {
        this.size = size;
        count = new Student[size];
    }

    public void add(Student student) {
        if (size > temp) {
            count[temp++] = student;
        } else {
            System.out.println("Room is full");
        }
    }

    public boolean isFull() {
        return temp == size;
    }
    public boolean isEmpty() {
        return temp == 0;
    }

    public void show() {
        for (int i = 0; i < temp; i++) {
            System.out.println("-------");
            System.out.println("name = " + count[i].name);
            System.out.println("age = " + count[i].age);
        }
    }
}