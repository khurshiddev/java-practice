package chapter_9;

public class task_4 {
    public static void main(String[] args) {
        AAA ins = new AAA(25,"Abdurohman");
        AAA inst = new AAA(21,"Farrux");
        AAA insta = new AAA(20,"Ozodbek");
    }
}

class AAA {
    private int age;
    private String name;

    public AAA(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
