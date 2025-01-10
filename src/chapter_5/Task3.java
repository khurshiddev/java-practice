package chapter_5;

public class Task3 {
    public static void main(String[] args) {
        AA obj1 = AA.getInstance(20);
        AA obj2 = AA.getInstance(21);
        AA obj3 = AA.getInstance(23);
        System.out.println(obj1.getAge());
        System.out.println(obj2.getAge());
        System.out.println(obj3.getAge());
    }
}

class AA {
    int age;

    public int getAge() {
        return age;
    }

    private AA(int age) {
        this.age = age;
    }

    public static AA getInstance(int age) {
        return new AA(age);
    }
}