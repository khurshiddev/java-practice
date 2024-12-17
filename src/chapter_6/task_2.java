package chapter_6;

public class task_2 {
    public static void main(String[] args) {
    Student s = new Student("Alisa", 18);
    Room r = new Room(4);
    r.add(s);
    r.isEmpty();
    r.isFull();
    r.show();
    }
}
class Student{
        private String name;
        private int age;
    Student(String name,int age ){
        this.name = name;
        this.age = age;


    }
}

class Room{
    private int size;
    private Student[] personSize;
    private int temp;
    Room(int size){
        this.size = size;
        this.temp = 0;
        this.personSize = new Student[size];
    }
    boolean add(Student st){
            if(temp < size){
                personSize[temp] = st;
                temp++;
                return true;
            }
            return false;

    }

    boolean isFull(){
        return temp == size;
    }

    boolean isEmpty(){
        return temp == 0;
    }

    void show(){
        if(isEmpty()){
            System.out.println("is empty");
        }else {
            for (int i = 0; i < temp; i++) {
                System.out.println("students = " + personSize[i]);
            }
        }
    }
}
